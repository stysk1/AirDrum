package com.kevin.myodrum;

import java.lang.Math;
import java.util.ArrayList;

import com.thalmic.myo.*;

import static jouvieje.bass.Bass.*;
import jouvieje.bass.BassInit;
import jouvieje.bass.exceptions.BassException;
import jouvieje.bass.structures.HSTREAM;


public class MyoDrum extends AbstractDeviceListener{
    private static final int SCALE = 50;
    private double rollW;
    private double pitchW;
    private double yawW;
    private double gyroX, gyroY, gyroZ;
    private double gyroX_right, gyroY_right, gyroZ_right;
    private double roll_angle_right, roll_angle_left;
    private double yaw_angle_right, yaw_angle_left;
    private double pitch_angle_right, pitch_angle_left;
    private boolean readyLeft = true, readyRight = true;
    private double centerRight, centerLeft;
    private String sound = "";
    private boolean modify = true;
    private int device = -1;
    private int freq = 44100;
    private ArrayList<Myo> knownMyos = new ArrayList<>();

    public MyoDrum() {
        rollW = 0; pitchW = 0; yawW = 0;
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public double getRoll_angle_right(){ return roll_angle_right;}
    public double getRoll_angle_left(){ return roll_angle_left;}

    public double getYaw_angle_right(){ return yaw_angle_right;}
    public double getYaw_angle_left(){ return yaw_angle_left;}

    public double getPitch_angle_right(){ return pitch_angle_right;}
    public double getPitch_angle_left(){ return pitch_angle_left;}

    //onPair() override will output which hand the Myo is in
    @Override
    public void onPair(Myo myo, long timestamp, FirmwareVersion firmwareVersion) {
        knownMyos.add(myo);
        if (knownMyos.size() == 1) System.out.println("Right hand connected.\n");
        else if (knownMyos.size() == 3) System.out.println("Left hand connected.\n");
    }

    //identifyMyo() returns which hand the Myo is in: Right=1, Left=2
    public int identifyMyo(Myo myo) {
        for (int i = 0; i < knownMyos.size(); i++) {
            if (knownMyos.get(i) == myo) return i + 1;
        }
        return 0;
    }

    // onUnpair() is called whenever the Myo is disconnected from Myo Connect by the user
    @Override
    public void onUnpair(Myo myo, long timestamp) {
        rollW = 0;
        pitchW = 0;
        yawW = 0;
    }

    //pickSound() chooses a random variation of the 4 hits on the selected sound
    public String pickSound(String volume) {
        String tone = Integer.toString((int)(Math.random() * 4 + 1));
        String location = "src/main/resources/sounds/";
        String extension = ".wav";
        String concat = location + volume + " " + tone + extension;
        return concat;
    }

    @Override
    public void onGyroscopeData(Myo myo, long timestamp, Vector3 gyro){
        gyroX = gyro.getX();
        gyroY = gyro.getY();
        gyroZ = gyro.getZ();

        if(identifyMyo(myo) == 1) {
            gyroX_right = gyro.getX();
            gyroY_right = gyro.getY();
            gyroZ_right = gyro.getZ();
        }

        final HSTREAM[] streamHandle = new HSTREAM[1];
        BASS_Init(device, freq, 0, null, null);



        /* RIGHT HAND ALGORITHMS
         * Snare Drum - Wrist is straight and can be angled slightly to the left or the right
         * Hi Hat - On the left side of the snare
         * Crash Cymbal- On the right side of the snare
         * Ride Cymbal - Farther right past the crash cymbal
         * Hard Snare Hit - Turn wrist so knuckles are facing up. Hits in any position
         */
        if (identifyMyo(myo) == 1 && rollW >= 25 && ((Math.abs(centerRight - yawW) <= 3) || (yawW - centerRight > 47 && yawW - centerRight <= 50))) {
            sound = pickSound("Snare/Snare Med");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 1 && rollW >= 25 && ((yawW - centerRight >= 5 && yawW - centerRight < 15) || (centerRight - yawW > 36 && centerRight - yawW <= 46))) {
            sound = pickSound("Hi Hat/Closed Hi hat");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 1 && rollW >= 25 && ((centerRight-yawW >= 5 && centerRight-yawW < 10) || (yawW - centerRight > 41 && yawW - centerRight <= 46))) {
            sound = pickSound("Crash/Crash alt");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 1 && rollW >= 25 && ((centerRight - yawW >= 10 && centerRight - yawW <= 20) || (yawW - centerRight >= 31 && yawW - centerRight <= 41))) {
            sound = pickSound("Ride/Ride");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 1 && gyroZ >= 500 && readyRight) {
            //modify = true;
            //System.out.println("MODIFIED CENTER");
            sound = pickSound("Snare/Snare Hardest");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }

        /* LEFT HAND ALGORITHMS
         * Snare Drum - Wrist is straight and can be angled slightly to the left or the right
         * Hi Hat - On the left side of the snare
         * Crash Cymbal- On the right side of the snare
         * Ride Cymbal - Farther right past the crash cymbal
         * Bass Drum - Turn wrist so knuckles are facing up. Hits in any position
         *
         * Snare uses the difference of the absolute value to account for both left and right positions around the center
         * The yaw values are represented as a circle so everything after the ORs account for reaching around the other side of the circle
         * EX: If center is 1, the values to the left such as 50 and downwards need to be accounted for
         */
        if (identifyMyo(myo) == 3 && rollW >= 25 && ((Math.abs(centerLeft - yawW) <= 3) || (yawW - centerLeft > 47 && yawW - centerLeft <= 50))) {
            sound = pickSound("Snare/Snare Med");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 3 && rollW >= 25 && ((yawW - centerLeft >= 5 && yawW - centerLeft < 10) || (centerLeft - yawW > 41 && centerLeft - yawW <= 46))) {
            sound = pickSound("Hi Hat/Closed Hi hat");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 3 && rollW >= 25 && ((centerLeft - yawW >= 5 && centerLeft - yawW < 10) || (yawW - centerLeft > 41 && yawW - centerLeft <= 46))) {
            sound = pickSound("Crash/Crash alt");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 3 && rollW >= 25 && ((centerLeft - yawW >= 10 && centerLeft - yawW <= 15) || (yawW - centerLeft > 36 && yawW - centerLeft <= 41))) {
            sound = pickSound("Ride/Ride");
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }
        if (identifyMyo(myo) == 3 && gyroZ <= -500 && readyLeft) {
            sound = pickSound("Kick/Kick Hard");
            System.out.println("[GYROX]: "+gyroX+ ", [GYROZ]: "+gyroZ);
            streamHandle[0] = BASS_StreamCreateFile(false, sound, 0, 0, 0); //Load randomized sound file
        }


        if (streamHandle[0] != null && identifyMyo(myo) == 1 && readyRight && (gyroX <= -500 || gyroZ >= 500)) {
            Thread rightThread = new Thread(new Runnable() {
                private HSTREAM stream;
                {
                    this.stream = streamHandle[0];
                }
                //playRight() plays the sound that was hit on the drum set and waits a realistic fraction of time to prevent flams from a single right hand hit
                @Override
                public void run(){
                    readyRight = false;
                    BASS_ChannelPlay(this.stream.asInt(), false);
                    try {
                        Thread.sleep(1000/9);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    readyRight = true;
                }
            });
            rightThread.start();
            System.out.println("[RIGHT: " +sound+"]");
        }

        if (streamHandle[0] != null && identifyMyo(myo) == 3 && readyLeft && (gyroX <= -500 || gyroZ <= -500)) {
            Thread leftThread = new Thread(new Runnable() {
                private HSTREAM stream;
                {
                    this.stream = streamHandle[0];
                }
                //playRight() plays the sound that was hit on the drum set and waits a realistic fraction of time to prevent flams from a single right hand hit
                @Override
                public void run(){
                    readyLeft = false;
                    BASS_ChannelPlay(this.stream.asInt(), false);
                    try {
                        Thread.sleep(1000/9);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    readyLeft = true;
                }
            });
            leftThread.start();
            System.out.println("[LEFT: " +sound+ "]");
        }

    }


    @Override
    public void onOrientationData(Myo myo, long timestamp, Quaternion rotation) {
        Quaternion normalized = rotation.normalized();

        double roll = Math.atan2(2.0f * (normalized.getW() * normalized.getX() + normalized.getY() * normalized.getZ()), 1.0f - 2.0f * (normalized.getX() * normalized.getX() + normalized.getY() * normalized.getY()));
        double pitch = Math.asin(2.0f * (normalized.getW() * normalized.getY() - normalized.getZ() * normalized.getX()));
        double yaw = Math.atan2(2.0f * (normalized.getW() * normalized.getZ() + normalized.getX() * normalized.getY()), 1.0f - 2.0f * (normalized.getY() * normalized.getY() + normalized.getZ() * normalized.getZ()));

        rollW = ((roll + Math.PI) / (Math.PI * 2.0) * SCALE);
        pitchW = ((pitch + Math.PI / 2.0) / Math.PI * SCALE);
        yawW = ((yaw + Math.PI) / (Math.PI * 2.0) * SCALE);

        if(identifyMyo(myo) == 1) roll_angle_right = roll * -1 + 90;//(roll + Math.PI) / (Math.PI * 2.0) * 180);
        else if(identifyMyo(myo) == 3) roll_angle_left = roll * -1 + 90;//((roll + Math.PI) / (Math.PI * 2.0) * 180);

        if(identifyMyo(myo) == 1) yaw_angle_right = yaw;//((yaw + Math.PI) / (Math.PI * 2.0) * 180);
        else if(identifyMyo(myo) == 3) yaw_angle_left = yaw;//((yaw + Math.PI) / (Math.PI * 2.0) * 180);

        if(identifyMyo(myo) == 1) pitch_angle_right = pitch;//((pitch + Math.PI / 2.0) / Math.PI * 180) + 90;
        else if(identifyMyo(myo) == 3) pitch_angle_left = pitch;//((pitch + Math.PI / 2.0) / Math.PI * 180) + 90;

        if (modify && identifyMyo(myo) == 1) { centerRight = yawW; modify = false; }//Center right Myo
        else if (modify && identifyMyo(myo) == 3) { centerLeft = yawW; modify = false; } //Center left Myo
    }


    public void test() {
        try {
            BassInit.loadLibraries();
        } catch(BassException e) {
            System.out.println("NativeBass error! "+e.getMessage()+"\n");
            return;
        }

        HSTREAM streamHandle;
        /* Initialize default output device */
        if(!BASS_Init(-1, 44100, 0, null, null)) {
            System.out.println("Can't initialize device");
        }

        // We catch any exceptions that might occur below -- see the catch statement for more details.
        try {
            // First, we create a Hub with our application identifier. The Hub provides access to one or more Myos.
            Hub hub = new Hub("com.tcnj.airdrum");

            System.out.println("Attempting to find a Myo...");

            // Next, we attempt to find a Myo to use. If a Myo is already paired in Myo Connect, this will return that Myo
            // immediately.
            // waitForMyo() takes a timeout value in milliseconds. In this case we will try to find a Myo for 10 seconds, and
            // if that fails, the function will return a null pointer.
            Myo myo = hub.waitForMyo(10000);

            // If waitForMyo() returned a null pointer, we failed to find a Myo, so exit with an error message.
            if (myo == null) {
                System.err.println("Unable to find a Myo!");
            }

            // We've found a Myo.
            System.out.println("Connected to a Myo armband!");

            // Next we construct an instance of our DeviceListener, so that we can register it with the Hub.
            //AbstractDeviceListener collector = new MyoDrum();

            // Hub::addListener() takes the address of any object whose class inherits from DeviceListener, and will cause
            // Hub::run() to send events to all registered device listeners.
            hub.addListener(this);

            // Finally we enter our main loop.
            while (true) {
                // In each iteration of our main loop, we run the Myo event loop for a set number of milliseconds.
                // In this case, we wish to update our display 100 times a second, so we run for 1000/100 milliseconds.
                hub.run(1000 / 100);
            }

            /* As very last, close Bass */
            //BASS_Free();

            // If a standard exception occurred, we print out its message and exit.
        } catch (Exception e) {
            System.err.println("Error: "+e.toString());
        }
    }
}
