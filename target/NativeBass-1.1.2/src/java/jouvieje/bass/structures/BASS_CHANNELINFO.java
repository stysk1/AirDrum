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

package jouvieje.bass.structures;

import jouvieje.bass.*;
import jouvieje.bass.exceptions.*;
import jouvieje.bass.callbacks.*;
import jouvieje.bass.*;
import jouvieje.bass.defines.*;
import jouvieje.bass.enumerations.*;
import jouvieje.bass.structures.*;
import java.nio.*;
import jouvieje.bass.*;
import jouvieje.bass.enumerations.*;
import jouvieje.bass.structures.*;
import jouvieje.bass.utils.*;

public class BASS_CHANNELINFO extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>BASS_CHANNELINFO</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a BASS_CHANNELINFO object.
	 */
	public static BASS_CHANNELINFO asBASS_CHANNELINFO(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new BASS_CHANNELINFO(address);
	}
	/**
	 * Allocate a new <code>BASS_CHANNELINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  BASS_CHANNELINFO obj = BASS_CHANNELINFO.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static BASS_CHANNELINFO allocate() {
		final long pointer = StructureJNI.BASS_CHANNELINFO_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new BASS_CHANNELINFO(pointer);
	}

	protected BASS_CHANNELINFO(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>BASS_CHANNELINFO</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  BASS_CHANNELINFO obj = new BASS_CHANNELINFO();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>BASS_CHANNELINFO</code>, use the static "constructor" :
	 * <pre><code>  BASS_CHANNELINFO obj = BASS_CHANNELINFO.allocate();</code></pre>
	 * @see BASS_CHANNELINFO#allocate()
	 */
	public BASS_CHANNELINFO() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.BASS_CHANNELINFO_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * default playback rate
	 */
	public int getFreq() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.BASS_CHANNELINFO_get_freq(pointer);
		return javaResult;
	}
	/**
	 * default playback rate
	 */
	public void setFreq(int freq) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_freq(pointer, freq);
	}

	/**
	 * channels
	 */
	public int getChannels() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.BASS_CHANNELINFO_get_chans(pointer);
		return javaResult;
	}
	/**
	 * channels
	 */
	public void setChannels(int channels) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_chans(pointer, channels);
	}

	/**
	 * BASS_SAMPLE/STREAM/MUSIC/SPEAKER flags
	 */
	public int getFlags() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.BASS_CHANNELINFO_get_flags(pointer);
		return javaResult;
	}
	/**
	 * BASS_SAMPLE/STREAM/MUSIC/SPEAKER flags
	 */
	public void setFlags(int flags) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_flags(pointer, flags);
	}

	/**
	 * type of channel
	 */
	public int getChannelType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.BASS_CHANNELINFO_get_ctype(pointer);
		return javaResult;
	}
	/**
	 * type of channel
	 */
	public void setChannelType(int channelType) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_ctype(pointer, channelType);
	}

	/**
	 * original resolution
	 */
	public int getOrigRes() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.BASS_CHANNELINFO_get_origres(pointer);
		return javaResult;
	}
	/**
	 * original resolution
	 */
	public void setOrigRes(int origRes) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_origres(pointer, origRes);
	}

	/**
	 * plugin
	 */
	public HPLUGIN getPlugin() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.BASS_CHANNELINFO_get_plugin(pointer);
		return javaResult == 0 ? null : HPLUGIN.asHPLUGIN(Pointer.newPointer(javaResult));
	}
	/**
	 * plugin
	 */
	public void setPlugin(HPLUGIN plugin) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_plugin(pointer, Pointer.getPointer(plugin));
	}

	/**
	 * sample
	 */
	public HSAMPLE getSample() {
		if(pointer == 0) throw new NullPointerException();
		long javaResult = StructureJNI.BASS_CHANNELINFO_get_sample(pointer);
		return javaResult == 0 ? null : HSAMPLE.asHSAMPLE(Pointer.newPointer(javaResult));
	}
	/**
	 * sample
	 */
	public void setSample(HSAMPLE sample) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_sample(pointer, Pointer.getPointer(sample));
	}

	/**
	 * filename
	 */
	public String getFilename() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.BASS_CHANNELINFO_get_filename(pointer);
		return javaResult;
	}
	/**
	 * filename
	 */
	public void setFilename(String filename) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.BASS_CHANNELINFO_set_filename(pointer, filename == null ? null : filename.getBytes());
	}

}