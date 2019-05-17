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

package jouvieje.bass;

import jouvieje.bass.exceptions.BassException;
import org.jouvieje.libloader.LibLoader;
import org.jouvieje.libloader.LibraryConfig;
import org.jouvieje.libloader.PlatformLibrary;

/**
 * Initialization of <code>NativeBass</code>.<BR>
 * You should call <code><a href="#loadLibraries()">BassInit.loadLibraries()</a></code> before using <code>NativeBass</code>.
 */
public class BassInit {
	private BassInit(){}
	
	/** Display errors when loading libraries */
	public static boolean DEBUG = false;
	/** Indicates if libraries has been loaded */
	protected static boolean librariesLoaded = false;
	/** Indicates if libraries has been loaded */
	protected static boolean[] pluginsLoaded = new boolean[12];

	/**
	 * Load native libraries
	 * @throws BassException exception that occures when all libraries are not properly loaded.
	 */
	public static void loadLibraries() throws BassException {
		final String[] libs = new String[] {"bass", "NativeBass"};
		final boolean[] libLoaderFirst = new boolean[] {true, false};
		
		final String lib = "lib";
		final String dll = ".dll";
		final String so = ".so";
		final String dylib = ".dylib";
		final String jnilib = ".jnilib";
		
		LibLoader.DEBUG = DEBUG;
		for(int i = 0; i < libs.length; i++) {
			final String libName = libs[i];
			final boolean libLoader = libLoaderFirst[i];

			final String x64 = (i == 1) ? "64" : "";
			final String macLib = (i == 0) ? dylib : jnilib;
			
			final LibraryConfig libConfig = new LibraryConfig();
			libConfig.windowsLibraries = new PlatformLibrary(libName, libName+dll);
			libConfig.windows64Libraries = new PlatformLibrary(libName+x64, libName+x64+dll);
			libConfig.linuxLibraries = new PlatformLibrary(libName, lib+libName+so);
			libConfig.linux64Libraries = new PlatformLibrary(libName+x64, lib+libName+x64+so);
			libConfig.macLibraries = new PlatformLibrary(libName, lib+libName+macLib);
			
			if(!LibLoader.loadLibrary(libConfig, libLoader)) {
				throw new BassException("no "+libName+" in java.library.path or org.lwjgl.librarypath");
			}
			printlnDebug(libName+" successfully loaded");
		}
		
		//Attach callbacks
		if(!attachJavaVM()) {
			throw new BassException("JVM not attached");
		}
		

		final String[] libsOpt = new String[] {
			"bass_aac", "bass_ac3", "bass_alac",
			"bass_fx", "bass_mpc", "bass_spx",
			"bassenc", "bassflac",
			"bassmidi", "bassmix", "basswv"
		};
		for(int i = 0; i < libsOpt.length; i++) {
			final String libName = libsOpt[i];
			final LibraryConfig libConfig = new LibraryConfig();
			libConfig.windowsLibraries = new PlatformLibrary(libName, libName+dll);
			libConfig.windows64Libraries = new PlatformLibrary(libName, libName+dll);
			libConfig.linuxLibraries = new PlatformLibrary(libName, lib+libName+so);
			libConfig.linux64Libraries = new PlatformLibrary(libName, lib+libName+so);
			libConfig.macLibraries = new PlatformLibrary(libName, lib+libName+dylib);
			
			final boolean loaded = LibLoader.loadLibrary(libConfig, true);
			pluginsLoaded[i] = loaded;
			if(!loaded) {
				printlnDebug(libName+" not loaded");
			}
			else {
				printlnDebug(libName+" successfully loaded");
			}
		}
		
		librariesLoaded = true;
	}
	
	protected final static int get_NATIVEBASS_JAR_VERSION() {
		return 0x00010101;
	}

	protected final static native boolean attachJavaVM();
	protected final static native int get_BASSVERSION();
	protected final static native int get_NATIVEBASS_VERSION();
	
	/**
	 * BASS version.
	 */
	public final static int BASSVERSION() {
		checkInit();
		return get_BASSVERSION();
	}
	/**
	 * NativeBass jar version.<br>
	 * 0xaaaabbcc -> aaaa = major version number.  bb = minor version number.  cc = development version number.<br>
	 * <br>
	 * <B><U>Warning :</U></B><br>
	 * NativeBass & BASS have different versions !
	 */
	public final static int NATIVEBASS_JAR_VERSION() {
		checkInit();
		return get_NATIVEBASS_JAR_VERSION();
	}
	/**
	 * NativeBass library version.<br>
	 * 0xaaaabbcc -> aaaa = major version number.  bb = minor version number.  cc = development version number.<br>
	 * <br>
	 * <B><U>Warning :</U></B><br>
	 * NativeBass & BASS have different versions !
	 */
	public final static int NATIVEBASS_LIBRARY_VERSION() {
		checkInit();
		return get_NATIVEBASS_VERSION();
	}
	
	/** @return true if all requiered libraries are loaded. */
	public final static boolean isLibrariesLoaded() {
		return librariesLoaded;
	}
	private final static void checkInit() {
		if(!isLibrariesLoaded()) {
			throw new RuntimeException("Libraries not loaded, use Init.loadLibraries().");
		}
	}
	
	/** @return true if AAC is loaded */
	public final static boolean isPluginAacLoaded() {
		return pluginsLoaded[0];
	}
	/** @return true if AC3 is loaded */
	public final static boolean isPluginAc3Loaded() {
		return pluginsLoaded[1];
	}
	/** @return true if ALAC is loaded */
	public final static boolean isPluginAlacLoaded() {
		return pluginsLoaded[2];
	}
	/** @return true if Fx is loaded */
	public final static boolean isPluginFxLoaded() {
		return pluginsLoaded[3];
	}
	/** @return true if Mpc is loaded */
	public final static boolean isPluginMpcLoaded() {
		return pluginsLoaded[4];
	}
	/** @return true if SPX is loaded */
	public final static boolean isPluginSpxLoaded() {
		return pluginsLoaded[5];
	}
	/** @return true if ENC is loaded */
	public final static boolean isPluginEncLoaded() {
		return pluginsLoaded[6];
	}
	/** @return true if FLAC is loaded */
	public final static boolean isPluginFlacLoaded() {
		return pluginsLoaded[7];
	}
	/** @return true if MIDI is loaded */
	public final static boolean isPluginMidiLoaded() {
		return pluginsLoaded[8];
	}
	/** @return true if MIX is loaded */
	public final static boolean isPluginMixLoaded() {
		return pluginsLoaded[9];
	}
	/** @return true if WV is loaded */
	public final static boolean isPluginWvLoaded() {
		return pluginsLoaded[10];
	}
	
	private static void printlnDebug(String s) {
		if(DEBUG) {
			java.lang.System.out.println(s);
		}
	}
}