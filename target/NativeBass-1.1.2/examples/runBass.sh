echo "Usage  : sh run.sh <example_name>"
echo "Example: sh run.sh BassTest"
echo "Example: sh run.sh ConTest"
echo Running $1 ...
java -Djava.library.path=../lib/$1 -classpath NativeBass-Examples.jar:../lib/NativeBass.jar jouvieje.bass.examples.$2