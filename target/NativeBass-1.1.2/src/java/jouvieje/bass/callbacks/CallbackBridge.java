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

package jouvieje.bass.callbacks;

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

class CallbackBridge extends Pointer {
	protected final static int NB_CALLBACKS = 17;

	public static void BPMBEATPROC_BRIDGE(int chan, double beatpos, long user) {
		BPMBEATPROC callback = (BPMBEATPROC)CallbackManager.getCallback(0, chan, false);
		try {
			callback.BPMBEATPROC(chan, beatpos, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void BPMPROC_BRIDGE(int chan, float bpm, long user) {
		BPMPROC callback = (BPMPROC)CallbackManager.getCallback(1, chan, false);
		try {
			callback.BPMPROC(chan, bpm, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void BPMPROCESSPROC_BRIDGE(int chan, float percent) {
		BPMPROCESSPROC callback = (BPMPROCESSPROC)CallbackManager.getCallback(2, chan, false);
		try {
			callback.BPMPROCESSPROC(chan, percent);
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void DOWNLOADPROC_BRIDGE(ByteBuffer buffer, int length, long user) {
		DOWNLOADPROC callback = (DOWNLOADPROC)CallbackManager.getCallback(3);
		if(buffer != null) {
			buffer.order(ByteOrder.nativeOrder());
		}
		try {
			callback.DOWNLOADPROC(buffer, length, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void DSPPROC_BRIDGE(long handle, int channel, ByteBuffer buffer, int length, long user) {
		DSPPROC callback = (DSPPROC)CallbackManager.getCallback(4, handle, false);
		if(buffer != null) {
			buffer.order(ByteOrder.nativeOrder());
		}
		try {
			callback.DSPPROC(handle == 0 ? null : HDSP.asHDSP(Pointer.newPointer(handle)), channel, buffer, length, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static boolean ENCODECLIENTPROC_BRIDGE(long handle, boolean connect, String client, String headers, long user) {
		ENCODECLIENTPROC callback = (ENCODECLIENTPROC)CallbackManager.getCallback(5, handle, false);
		try {
			boolean javaResult = callback.ENCODECLIENTPROC(handle == 0 ? null : HENCODE.asHENCODE(Pointer.newPointer(handle)), connect, client, headers, user == 0 ? null : Pointer.newPointer(user));
			return javaResult;
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return false;
		}
	}
	public static void ENCODENOTIFYPROC_BRIDGE(long handle, int status, long user) {
		ENCODENOTIFYPROC callback = (ENCODENOTIFYPROC)CallbackManager.getCallback(6, handle, false);
		try {
			callback.ENCODENOTIFYPROC(handle == 0 ? null : HENCODE.asHENCODE(Pointer.newPointer(handle)), status, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void ENCODEPROC_BRIDGE(long handle, int channel, long buffer, int length, long user) {
		ENCODEPROC callback = (ENCODEPROC)CallbackManager.getCallback(7, handle, false);
		try {
			callback.ENCODEPROC(handle == 0 ? null : HENCODE.asHENCODE(Pointer.newPointer(handle)), channel, buffer == 0 ? null : Pointer.newPointer(buffer), length, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void ENCODEPROCEX_BRIDGE(long handle, int channel, long buffer, int length, long offset, long user) {
		ENCODEPROCEX callback = (ENCODEPROCEX)CallbackManager.getCallback(8, handle, false);
		try {
			callback.ENCODEPROCEX(handle == 0 ? null : HENCODE.asHENCODE(Pointer.newPointer(handle)), channel, buffer == 0 ? null : Pointer.newPointer(buffer), length, offset, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static void FILECLOSEPROC_BRIDGE(long user) {
		FILECLOSEPROC callback = (FILECLOSEPROC)CallbackManager.getCallback(9, user, false);
		try {
			callback.FILECLOSEPROC(user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static long FILELENPROC_BRIDGE(long user) {
		FILELENPROC callback = (FILELENPROC)CallbackManager.getCallback(10, user, false);
		try {
			long javaResult = callback.FILELENPROC(user == 0 ? null : Pointer.newPointer(user));
			return javaResult;
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return 0;
		}
	}
	public static int FILEREADPROC_BRIDGE(long buffer, int length, long user) {
		FILEREADPROC callback = (FILEREADPROC)CallbackManager.getCallback(11, buffer, false);
		try {
			int javaResult = callback.FILEREADPROC(buffer == 0 ? null : Pointer.newPointer(buffer), length, user == 0 ? null : Pointer.newPointer(user));
			return javaResult;
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return 0;
		}
	}
	public static boolean FILESEEKPROC_BRIDGE(long offset, long user) {
		FILESEEKPROC callback = (FILESEEKPROC)CallbackManager.getCallback(12, offset, false);
		try {
			boolean javaResult = callback.FILESEEKPROC(offset, user == 0 ? null : Pointer.newPointer(user));
			return javaResult;
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return false;
		}
	}
	public static void MIDIINPROC_BRIDGE(int device, double time, long buffer, int length, long user) {
		MIDIINPROC callback = (MIDIINPROC)CallbackManager.getCallback(13, device, false);
		try {
			callback.MIDIINPROC(device, time, buffer == 0 ? null : Pointer.newPointer(buffer), length, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public static boolean RECORDPROC_BRIDGE(long handle, ByteBuffer buffer, int length, long user) {
		RECORDPROC callback = (RECORDPROC)CallbackManager.getCallback(14, handle, false);
		if(buffer != null) {
			buffer.order(ByteOrder.nativeOrder());
		}
		try {
			boolean javaResult = callback.RECORDPROC(handle == 0 ? null : HRECORD.asHRECORD(Pointer.newPointer(handle)), buffer, length, user == 0 ? null : Pointer.newPointer(user));
			return javaResult;
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return false;
		}
	}
	public static int STREAMPROC_BRIDGE(long handle, ByteBuffer buffer, int length, long user) {
		STREAMPROC callback = (STREAMPROC)CallbackManager.getCallback(15, handle, false);
		if(buffer != null) {
			buffer.order(ByteOrder.nativeOrder());
		}
		try {
			int javaResult = callback.STREAMPROC(handle == 0 ? null : HSTREAM.asHSTREAM(Pointer.newPointer(handle)), buffer, length, user == 0 ? null : Pointer.newPointer(user));
			return javaResult;
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			return 0;
		}
	}
	public static void SYNCPROC_BRIDGE(long handle, int channel, int data, long user) {
		SYNCPROC callback = (SYNCPROC)CallbackManager.getCallback(16, handle, false);
		try {
			callback.SYNCPROC(handle == 0 ? null : HSYNC.asHSYNC(Pointer.newPointer(handle)), channel, data, user == 0 ? null : Pointer.newPointer(user));
		} catch(Throwable throwable) {
			throwable.printStackTrace();
		}
	}

	protected static String getCallbackName(int type) {
		switch(type) {
			case 0: return "BPMBEATPROC";
			case 1: return "BPMPROC";
			case 2: return "BPMPROCESSPROC";
			case 3: return "DOWNLOADPROC";
			case 4: return "DSPPROC";
			case 5: return "ENCODECLIENTPROC";
			case 6: return "ENCODENOTIFYPROC";
			case 7: return "ENCODEPROC";
			case 8: return "ENCODEPROCEX";
			case 9: return "FILECLOSEPROC";
			case 10: return "FILELENPROC";
			case 11: return "FILEREADPROC";
			case 12: return "FILESEEKPROC";
			case 13: return "MIDIINPROC";
			case 14: return "RECORDPROC";
			case 15: return "STREAMPROC";
			case 16: return "SYNCPROC";
			default: return "UNKNOW_"+type;
		}
	}
}