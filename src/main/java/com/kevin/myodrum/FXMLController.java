package com.kevin.myodrum;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;

public class FXMLController implements Initializable {

    @FXML
    Cylinder cylLeft;

    @FXML
    Cylinder cylRight;

    @FXML
    Cylinder snare;

    @FXML
    Ellipse crash;

    @FXML
    Ellipse ride;

    @FXML
    Ellipse hihat_top;

    @FXML
    Ellipse hihat_bottom;

    private double phiR, thetaR, psiR;
    private double phiL, thetaL, psiL;
    private double center_right = 0.0, center_left = 0.0;

    private MyoDrum myoDrum = new MyoDrum(); //MyoDrum object

    //When the "Center Your Position" button is toggled, reset the drum sticks to parallel and angled center to the screen
    @FXML
    private void handleButtonAction(ActionEvent event) {
        myoDrum.setModify(true);
        center_right = myoDrum.getYaw_angle_right();
        center_left = myoDrum.getYaw_angle_left();
    }

    //Initialize the drum sticks with the given texture
    private void initCyl(Cylinder cyl, String name) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/textures/"+name)));
        cyl.setMaterial(material);
    }

    //Initialize the cymbals with the given texture
    private void initEll(Ellipse ell, String name) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/textures/"+name)));
        Image img = new Image("/textures/"+name,false);
        ell.setFill(new ImagePattern(img));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCyl(cylLeft, "wood1thin.jpg"); //drum stick texture
        initCyl(cylRight, "wood1thin.jpg"); //drum stick texture
        initEll(crash, "cymbal.jpg"); //cymbal texture
        initEll(ride, "cymbal.jpg"); //cymbal texture
        initEll(hihat_top, "cymbal.jpg"); //cymbal texture
        initEll(hihat_bottom, "cymbal.jpg"); //cymbal texture

        new Thread(() -> myoDrum.test()).start(); //Open a thread to run the DeviceListener within MyoDrum to receive data

        /*
         * The underlying algorithm that allows the drum sticks to rotate on all 3 dimensions
         * at once along one axis of rotation. ф(phi) represents the pitch angles, θ(theta) represents
         * the roll angles, and ψ(psi) represents the yaw angles with respect to the center angle.
         * A large matrix is formed by getting the dot product of each axis which yields one singular
         * axis of rotation as shown in Wolfram MathWorld: http://mathworld.wolfram.com/RotationMatrix.html
         * Pitch and Roll are swapped because the orientation of the armband should be held sideways like
         * a drum stick. Then the angle is computed from the matrix as a single rotation axis from the
         * equation: angle = arccos(1/2(A11 + A22 + A33 - 1)).
         */
        new Thread(() -> {
            while(true){
                try {
                    phiR = myoDrum.getPitch_angle_right();
                    thetaR = myoDrum.getRoll_angle_right();
                    psiR = myoDrum.getYaw_angle_right() - center_right;

                    phiL = myoDrum.getPitch_angle_left();
                    thetaL = myoDrum.getRoll_angle_left();
                    psiL = myoDrum.getYaw_angle_left() - center_left;

                    double A11=Math.cos(phiR)*Math.cos(psiR);
                    double A12=Math.cos(thetaR)*Math.sin(phiR)+Math.cos(phiR)*Math.sin(thetaR)*Math.sin(psiR);
                    double A13=Math.sin(phiR)*Math.sin(thetaR)-Math.cos(phiR)*Math.cos(thetaR)*Math.sin(psiR);
                    double A21=-Math.cos(psiR)*Math.sin(phiR);
                    double A22=Math.cos(phiR)*Math.cos(thetaR)-Math.sin(phiR)*Math.sin(thetaR)*Math.sin(psiR);
                    double A23=Math.cos(phiR)*Math.sin(thetaR)+Math.cos(thetaR)*Math.sin(phiR)*Math.sin(psiR);
                    double A31=Math.sin(psiR);
                    double A32=-Math.cos(psiR)*Math.sin(thetaR);
                    double A33=Math.cos(thetaR)*Math.cos(psiR);

                    double B11=Math.cos(phiL)*Math.cos(psiL);
                    double B12=Math.cos(thetaL)*Math.sin(phiL)+Math.cos(phiL)*Math.sin(thetaL)*Math.sin(psiL);
                    double B13=Math.sin(phiL)*Math.sin(thetaL)-Math.cos(phiL)*Math.cos(thetaL)*Math.sin(psiL);
                    double B21=-Math.cos(psiL)*Math.sin(phiL);
                    double B22=Math.cos(phiL)*Math.cos(thetaL)-Math.sin(phiL)*Math.sin(thetaL)*Math.sin(psiL);
                    double B23=Math.cos(phiL)*Math.sin(thetaL)+Math.cos(thetaL)*Math.sin(phiL)*Math.sin(psiL);
                    double B31=Math.sin(psiL);
                    double B32=-Math.cos(psiL)*Math.sin(thetaL);
                    double B33=Math.cos(thetaL)*Math.cos(psiL);

                    double d = Math.acos((A11+A22+A33-1d)/2d);
                    if(d!=0d){
                        double den=2d*Math.sin(d);
                        Point3D p= new Point3D((A32-A23)/den,(A13-A31)/den,(A21-A12)/den);
                        cylRight.setRotationAxis(p);
                        cylRight.setRotate(Math.toDegrees(d));
                    }
                    double d1 = Math.acos((B11+B22+B33-1d)/2d);
                    if(d1!=0d){
                        double den=2d*Math.sin(d1);
                        Point3D p= new Point3D((B32-B23)/den,(B13-B31)/den,(B21-B12)/den);
                        cylLeft.setRotationAxis(p);
                        cylLeft.setRotate(Math.toDegrees(d1));
                    }
                    Thread.sleep(50);
                } catch (Throwable e) {
                    System.err.println("Error caught while trying to sleep: "+e.toString());
                }
            }
        }).start();

    }    
}
