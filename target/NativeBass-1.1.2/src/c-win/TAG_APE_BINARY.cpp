/* DO NOT EDIT - AUTOGENERATED */
/**
 * 				NativeBass Project
 *
 * Want to use BASS (www.un4seen.com) in the Java language ? NativeBass is made for you.
 * Copyright � 2007-2011 J�r�me JOUVIE
 *
 * Created on 02 jul. 2007
 * @version file v1.1.1
 * @author J�r�me JOUVIE (Jouvieje)
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

#include "NativeBass.h"
#include "bass.h"
#include "bassenc.h"
#include "bassflac.h"
#include "bassmidi.h"
#include "bassmix.h"
#include "basswv.h"
#include "bass_aac.h"
#include "bass_ac3.h"
#include "bass_alac.h"
#include "bass_fx.h"
#include "bass_mpc.h"
#include "bass_spx.h"
#include "Utils.h"
#include "Pointer.h"
#include "JavaObject.h"
#include "jouvieje_bass_structures_StructureJNI.h"
#include "CallbackManager.h"

JNIEXPORT jlong JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1new(JNIEnv *java_env, jclass jcls) {
	TAG_APE_BINARY *result_ = new TAG_APE_BINARY();
	CheckAllocation(java_env, result_);
	N2J_PTR2ADR(jresult, result_, TAG_APE_BINARY *);
	return jresult;
}

JNIEXPORT void JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1delete(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	delete pointer;
}

JNIEXPORT jstring JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1get_1key(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	const char *result_ = N2J_CAST(pointer->key, const char *);
	jstring jresult = 0;
	if(result_) {
		jresult = java_env->NewStringUTF((const char *)result_);
	}
	return jresult;
}

JNIEXPORT void JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1set_1key(JNIEnv *java_env, jclass jcls, jlong jpointer, jbyteArray jkey) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	const char *key = 0;
	if(jkey) {
		key = (const char *)getByteArrayElements(java_env, jkey);
		pointer->key = key;
	}
	else {
		pointer->key = (const char *)0;
	}
}

JNIEXPORT jlong JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1get_1data(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	N2J_PTR2ADR(jresult, pointer->data, const void *);
	return jresult;
}

JNIEXPORT void JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1set_1data(JNIEnv *java_env, jclass jcls, jlong jpointer, jlong jdata) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	pointer->data = N2J_ADR2PTR(jdata, void *);
}

JNIEXPORT jint JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1get_1length(JNIEnv *java_env, jclass jcls, jlong jpointer) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	DWORD result_ = pointer->length;
	return (jint)result_;
}

JNIEXPORT void JNICALL Java_jouvieje_bass_structures_StructureJNI_TAG_1APE_1BINARY_1set_1length(JNIEnv *java_env, jclass jcls, jlong jpointer, jint jlength) {
	TAG_APE_BINARY *pointer = N2J_CAST(jpointer, TAG_APE_BINARY *);
	DWORD length = (DWORD)jlength;
	pointer->length = length;
}



