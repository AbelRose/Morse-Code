package com.matrix.enigma;

import com.matrix.enigma.scrambler.plugboard.Plugboard;
import com.matrix.enigma.scrambler.plugboard.PlugboardImpl;
import com.matrix.enigma.scrambler.reflector.ReflectorType;
import com.matrix.enigma.scrambler.rotor.RotorType;
import com.matrix.file.ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Enigma {

	public static String enigma(String sourceFile) throws Exception {
		
		Plugboard plugboard = new PlugboardImpl();
		plugboard.addCable('A', 'H').addCable('Q', 'C').addCable('P', 'Z');
		
		EnigmaMachine enigmaMachine = EnigmaMachineBuilder
				.addRotor1(RotorType.I, 'H')
				.addRotor2(RotorType.II, 'A')
				.addRotor3(RotorType.III, 'A')
				.addReflector(ReflectorType.B)
				.addPlugBoard(plugboard)
				.build();

		return enigmaMachine.encrypt(sourceFile);


//		String pt = sourceFile; // file operation
//		String ct = enigmaMachine.encrypt(pt); // file operation
//
//		System.out.println(pt);
//		System.out.println(ct);
	}
//
//	public static void main(String[] args) throws Exception {
//		String str = "HELLO";
//		String enigma = enigma(str);
//		System.out.println(enigma);
//	}
}
