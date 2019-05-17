HOW TO RUN EXAMPLES ?

Java must be properly installed and accessible from command line.
Open a terminal (command line), and go to this examples directory using cd.

To run an example, use depending on your system:
	./runBass.sh platform example
	runBass.bat platform example

where platform is

	win32, win64, linux32, linux64 or mac

and example is	

	BassTest, ConTes, CustLoop, Speakers, Spectrum, LiveSpec, LiveFx, 
	RecTest, DspTest, FxTest, Plugins, Synth, WriteWav, Test3D


PARTICULAR EXAMPLES
-------------------

  [Contest]
Requiere a music file to play.
Either put BASS.WAV here or edit 'ConTest.bat' and change the file name.

  [RecTest]
See 'LiveSpec' note.

  [LiveSpec]
This example is a spectrum analyser using the record output.
To record something, you need to play a music somewhere (like a music player, a game ...).
If you have some troubles under Windows (ie record nothing), open 'Recording Panel' of Windows enable wave output.

  [Plugins]
To obtain BASS Plugins, go to http://www.un4seen.com/.
Then, extract the bass***.dll plugin here.


