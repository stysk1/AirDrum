@echo off
java -Djava.library.path=../lib/$1 -classpath NativeBass-Examples.jar:../lib/NativeBass.jar jouvieje.bass.examples.$2
