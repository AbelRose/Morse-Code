package com.matrix.enigma;

import com.johnflan.enigma.scrambler.Scrambler;

import static com.johnflan.enigma.scrambler.Util.ASCII_OFFSET;

public class EnigmaMachineImpl implements EnigmaMachine{
	
	private Scrambler scrambler;
	
	public EnigmaMachineImpl(Scrambler scrambler) {
		this.scrambler = scrambler;
	}
		
	public String encrypt(String plainText){
		plainText = validateInput(plainText);
		
		char[] inputArray = plainText.toCharArray();
		String cipherText = "";
		
		for (int i = 0; i < inputArray.length ; i++){
			cipherText = cipherText + encrypt(inputArray[i]);
		}
		return cipherText;
	}

	public char encrypt(char pt){
		return scrambler.encode(pt);
	}
	
	private String validateInput(String plainText){
		plainText = plainText.toUpperCase();
		String validatedText = removeInvalidCharacters(plainText);
		
		return validatedText;
	}
	
	private String removeInvalidCharacters(String plainText){
		String sanitisedString = "";
		for (char c : plainText.toCharArray()){
			int charValue = (int) c - ASCII_OFFSET;
			if (charValue >= 0 && charValue <= 25){
				sanitisedString += c;
			}
		}
		return sanitisedString;
	}
}
