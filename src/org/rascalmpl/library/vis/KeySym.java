/*******************************************************************************
 * Copyright (c) 2009-2013 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
package org.rascalmpl.library.vis;

// This code was generated by Rascal API gen
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IInteger;
import org.eclipse.imp.pdb.facts.IString;
import org.eclipse.imp.pdb.facts.type.Type;
import org.eclipse.imp.pdb.facts.type.TypeFactory;
import org.eclipse.imp.pdb.facts.type.TypeStore;

public class KeySym {
	public static final TypeStore typestore = new TypeStore();

 	private static final TypeFactory tf = TypeFactory.getInstance();

	
	public static final Type KeyModifier = tf.abstractDataType(typestore, "KeyModifier");
 	public static final Type KeyModifier_modCtrl = tf.constructor(typestore,KeyModifier,"modCtrl");
 	public static final Type KeyModifier_modAlt = tf.constructor(typestore,KeyModifier,"modAlt");
 	public static final Type KeyModifier_modCommand = tf.constructor(typestore,KeyModifier,"modCommand");
 	public static final Type KeyModifier_modShift = tf.constructor(typestore,KeyModifier,"modShift");
 				
	public static final Type KeySym = tf.abstractDataType(typestore, "KeySym");
 	public static final Type KeySym_keyKeypadEqual = tf.constructor(typestore,KeySym,"keyKeypadEqual");
 	public static final Type KeySym_keyEscape = tf.constructor(typestore,KeySym,"keyEscape");
 	public static final Type KeySym_keyUnknown = tf.constructor(typestore,KeySym,"keyUnknown",tf.integerType(),"keyCode");
 	public static final Type KeySym_keyHome = tf.constructor(typestore,KeySym,"keyHome");
 	public static final Type KeySym_keyCapsLock = tf.constructor(typestore,KeySym,"keyCapsLock");
 	public static final Type KeySym_keyInsert = tf.constructor(typestore,KeySym,"keyInsert");
 	public static final Type KeySym_keyAltLeft = tf.constructor(typestore,KeySym,"keyAltLeft");
 	public static final Type KeySym_keyF15 = tf.constructor(typestore,KeySym,"keyF15");
 	public static final Type KeySym_keyF9 = tf.constructor(typestore,KeySym,"keyF9");
 	public static final Type KeySym_keyEnd = tf.constructor(typestore,KeySym,"keyEnd");
 	public static final Type KeySym_keyPrintable = tf.constructor(typestore,KeySym,"keyPrintable",tf.stringType(),"key");
 	public static final Type KeySym_keyF17 = tf.constructor(typestore,KeySym,"keyF17");
 	public static final Type KeySym_keyBreak = tf.constructor(typestore,KeySym,"keyBreak");
 	public static final Type KeySym_keyF20 = tf.constructor(typestore,KeySym,"keyF20");
 	public static final Type KeySym_keyControlRight = tf.constructor(typestore,KeySym,"keyControlRight");
 	public static final Type KeySym_keyPageDown = tf.constructor(typestore,KeySym,"keyPageDown");
 	public static final Type KeySym_keyKeypad5 = tf.constructor(typestore,KeySym,"keyKeypad5");
 	public static final Type KeySym_keyCommandLeft = tf.constructor(typestore,KeySym,"keyCommandLeft");
 	public static final Type KeySym_keyF18 = tf.constructor(typestore,KeySym,"keyF18");
 	public static final Type KeySym_keyKeypad2 = tf.constructor(typestore,KeySym,"keyKeypad2");
 	public static final Type KeySym_keyKeypad9 = tf.constructor(typestore,KeySym,"keyKeypad9");
 	public static final Type KeySym_keyHelp = tf.constructor(typestore,KeySym,"keyHelp");
 	public static final Type KeySym_keyF1 = tf.constructor(typestore,KeySym,"keyF1");
 	public static final Type KeySym_keyScrollLock = tf.constructor(typestore,KeySym,"keyScrollLock");
 	public static final Type KeySym_keyF4 = tf.constructor(typestore,KeySym,"keyF4");
 	public static final Type KeySym_keyF10 = tf.constructor(typestore,KeySym,"keyF10");
 	public static final Type KeySym_keyF8 = tf.constructor(typestore,KeySym,"keyF8");
 	public static final Type KeySym_keyKeypadCr = tf.constructor(typestore,KeySym,"keyKeypadCr");
 	public static final Type KeySym_keyPause = tf.constructor(typestore,KeySym,"keyPause");
 	public static final Type KeySym_keyPageUp = tf.constructor(typestore,KeySym,"keyPageUp");
 	public static final Type KeySym_keyKeypad8 = tf.constructor(typestore,KeySym,"keyKeypad8");
 	public static final Type KeySym_keyKeypadAdd = tf.constructor(typestore,KeySym,"keyKeypadAdd");
 	public static final Type KeySym_keyKeypad6 = tf.constructor(typestore,KeySym,"keyKeypad6");
 	public static final Type KeySym_keyKeypad7 = tf.constructor(typestore,KeySym,"keyKeypad7");
 	public static final Type KeySym_keyF11 = tf.constructor(typestore,KeySym,"keyF11");
 	public static final Type KeySym_keyArrowUp = tf.constructor(typestore,KeySym,"keyArrowUp");
 	public static final Type KeySym_keyF7 = tf.constructor(typestore,KeySym,"keyF7");
 	public static final Type KeySym_keyF16 = tf.constructor(typestore,KeySym,"keyF16");
 	public static final Type KeySym_keyKeypad1 = tf.constructor(typestore,KeySym,"keyKeypad1");
 	public static final Type KeySym_keyF3 = tf.constructor(typestore,KeySym,"keyF3");
 	public static final Type KeySym_keyArrowLeft = tf.constructor(typestore,KeySym,"keyArrowLeft");
 	public static final Type KeySym_keyPrintScreen = tf.constructor(typestore,KeySym,"keyPrintScreen");
 	public static final Type KeySym_keyBackSpace = tf.constructor(typestore,KeySym,"keyBackSpace");
 	public static final Type KeySym_keyKeypadDivide = tf.constructor(typestore,KeySym,"keyKeypadDivide");
 	public static final Type KeySym_keyF2 = tf.constructor(typestore,KeySym,"keyF2");
 	public static final Type KeySym_keyF13 = tf.constructor(typestore,KeySym,"keyF13");
 	public static final Type KeySym_keyCommandRight = tf.constructor(typestore,KeySym,"keyCommandRight");
 	public static final Type KeySym_keyTab = tf.constructor(typestore,KeySym,"keyTab");
 	public static final Type KeySym_keyF6 = tf.constructor(typestore,KeySym,"keyF6");
 	public static final Type KeySym_keyF19 = tf.constructor(typestore,KeySym,"keyF19");
 	public static final Type KeySym_keyKeypadSubtract = tf.constructor(typestore,KeySym,"keyKeypadSubtract");
 	public static final Type KeySym_keyKeypad4 = tf.constructor(typestore,KeySym,"keyKeypad4");
 	public static final Type KeySym_keyKeypadDecimal = tf.constructor(typestore,KeySym,"keyKeypadDecimal");
 	public static final Type KeySym_keyNumLock = tf.constructor(typestore,KeySym,"keyNumLock");
 	public static final Type KeySym_keyAltRight = tf.constructor(typestore,KeySym,"keyAltRight");
 	public static final Type KeySym_keyEnter = tf.constructor(typestore,KeySym,"keyEnter");
 	public static final Type KeySym_keyShiftLeft = tf.constructor(typestore,KeySym,"keyShiftLeft");
 	public static final Type KeySym_keyArrowDown = tf.constructor(typestore,KeySym,"keyArrowDown");
 	public static final Type KeySym_keyKeypad0 = tf.constructor(typestore,KeySym,"keyKeypad0");
 	public static final Type KeySym_keyKeypadMultiply = tf.constructor(typestore,KeySym,"keyKeypadMultiply");
 	public static final Type KeySym_keyControlLeft = tf.constructor(typestore,KeySym,"keyControlLeft");
 	public static final Type KeySym_keyF12 = tf.constructor(typestore,KeySym,"keyF12");
 	public static final Type KeySym_keyShiftRight = tf.constructor(typestore,KeySym,"keyShiftRight");
 	public static final Type KeySym_keyF5 = tf.constructor(typestore,KeySym,"keyF5");
 	public static final Type KeySym_keyKeypad3 = tf.constructor(typestore,KeySym,"keyKeypad3");
 	public static final Type KeySym_keyF14 = tf.constructor(typestore,KeySym,"keyF14");
 	public static final Type KeySym_keyArrowRight = tf.constructor(typestore,KeySym,"keyArrowRight");
 				
	
 	public static int KeySym_keyUnknown_keyCode(IConstructor c){
 		return ((IInteger)c.get(0)).intValue();
 	}
 	public static String KeySym_keyPrintable_key(IConstructor c){
 		return ((IString)c.get(0)).getValue();
 	}
 
	private static final class InstanceHolder {
		public final static KeySym factory = new KeySym();
	}
	  
	public static KeySym getInstance() {
		return InstanceHolder.factory;
	}
	
	
	public static TypeStore getStore() {
		return typestore;
	}
}