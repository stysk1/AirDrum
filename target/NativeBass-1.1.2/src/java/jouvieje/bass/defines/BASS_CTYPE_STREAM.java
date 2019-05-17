/* DO NOT EDIT - AUTOGENERATED */
/**
 * 				NativeBass Project
 *
 * Want to use BASS (www.un4seen.com) in the Java language ? NativeBass is made for you.
 * Copyright @ 2007-2011 Jérôme Jouvie
 *
 * Created on 02 jul. 2007
 * @version file v1.1.1
 * @author Jérôme Jouvie (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 * 
 * 
 * INTRODUCTION
 * BASS is an audio library for use in Windows and Mac OSX software.
 * Its purpose is to provide developers with the most powerful and
 * efficient (yet easy to use), sample, stream (MP3, MP2, MP1, OGG, WAV, AIFF,
 * custom generated, and more via add-ons), MOD music (XM, IT, S3M, MOD, MTM, UMX),
 * MO3 music (MP3/OGG compressed MODs),
 * and recording functions. All in a tiny DLL, under 100KB* in size.
 * 
 * BASS official web site :
 * 		http://www.un4seen.com/
 * 
 * 
 * GNU LESSER GENERAL PUBLIC LICENSE
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1 of the License,
 * or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the
 * Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307 USA 
 */

package jouvieje.bass.defines;

/**
 * BASS_CHANNELINFO type [NAME] BASS_CTYPE_STREAM
 */
public interface BASS_CTYPE_STREAM {
	/**  */
	public static final int BASS_CTYPE_STREAM_FLAC = 0x10900;
	/**  */
	public static final int BASS_CTYPE_STREAM_FLAC_OGG = 0x10901;
	/**  */
	public static final int BASS_CTYPE_STREAM_MIDI = 0x10d00;
	/**  */
	public static final int BASS_CTYPE_STREAM_MIXER = 0x10800;
	/**  */
	public static final int BASS_CTYPE_STREAM_SPLIT = 0x10801;
	/**  */
	public static final int BASS_CTYPE_STREAM_WV = 0x10500;
	/** AAC */
	public static final int BASS_CTYPE_STREAM_AAC = 0x10b00;
	/** MP4 */
	public static final int BASS_CTYPE_STREAM_MP4 = 0x10b01;
	/**  */
	public static final int BASS_CTYPE_STREAM_AC3 = 0x11000;
	/**  */
	public static final int BASS_CTYPE_STREAM_ALAC = 0x10e00;
	/**  */
	public static final int BASS_CTYPE_STREAM_MPC = 0x10a00;
	/**  */
	public static final int BASS_CTYPE_STREAM_SPX = 0x10c00;
}