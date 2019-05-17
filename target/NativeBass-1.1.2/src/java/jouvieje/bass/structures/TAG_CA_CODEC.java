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

public class TAG_CA_CODEC extends Pointer {
	/**
	 * Create a view of the <code>Pointer</code> object as a <code>TAG_CA_CODEC</code> object.<br>
	 * This view is valid only if the memory holded by the <code>Pointer</code> holds a TAG_CA_CODEC object.
	 */
	public static TAG_CA_CODEC asTAG_CA_CODEC(Pointer pointer) {
		long address = Pointer.getPointer(pointer);
		if(address == 0) return null;
		return new TAG_CA_CODEC(address);
	}
	/**
	 * Allocate a new <code>TAG_CA_CODEC</code>.<br>
	 * The call <code>isNull()</code> on the object created will return false.<br>
	 * <pre><code>  TAG_CA_CODEC obj = TAG_CA_CODEC.allocate();
	 *  (obj == null) <=> obj.isNull() <=> false
	 * </code></pre>
	 */
	public static TAG_CA_CODEC allocate() {
		final long pointer = StructureJNI.TAG_CA_CODEC_new();
		if(pointer == 0) throw new OutOfMemoryError();
		return new TAG_CA_CODEC(pointer);
	}

	protected TAG_CA_CODEC(long pointer) {
		super(pointer);
	}

	/**
	 * Create an object that holds a null <code>TAG_CA_CODEC</code>.<br>
	 * The call <code>isNull()</code> on the object created will returns true.<br>
	 * <pre><code>  TAG_CA_CODEC obj = new TAG_CA_CODEC();
	 *  (obj == null) <=> false
	 *  obj.isNull() <=> true
	 * </code></pre>
	 * To creates a new <code>TAG_CA_CODEC</code>, use the static "constructor" :
	 * <pre><code>  TAG_CA_CODEC obj = TAG_CA_CODEC.allocate();</code></pre>
	 * @see TAG_CA_CODEC#allocate()
	 */
	public TAG_CA_CODEC() {
		super();
	}

	public void release() {
		if(pointer != 0) {
			StructureJNI.TAG_CA_CODEC_delete(pointer);
		}
		pointer = 0;
	}

	/**
	 * file format
	 */
	public int getFileType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.TAG_CA_CODEC_get_ftype(pointer);
		return javaResult;
	}
	/**
	 * file format
	 */
	public void setFileType(int fileType) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.TAG_CA_CODEC_set_ftype(pointer, fileType);
	}

	/**
	 * audio format
	 */
	public int getAudioType() {
		if(pointer == 0) throw new NullPointerException();
		int javaResult = StructureJNI.TAG_CA_CODEC_get_atype(pointer);
		return javaResult;
	}
	/**
	 * audio format
	 */
	public void setAudioType(int audioType) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.TAG_CA_CODEC_set_atype(pointer, audioType);
	}

	/**
	 * description
	 */
	public String getName() {
		if(pointer == 0) throw new NullPointerException();
		String javaResult = StructureJNI.TAG_CA_CODEC_get_name(pointer);
		return javaResult;
	}
	/**
	 * description
	 */
	public void setName(String name) {
		if(pointer == 0) throw new NullPointerException();
		StructureJNI.TAG_CA_CODEC_set_name(pointer, name == null ? null : name.getBytes());
	}

}