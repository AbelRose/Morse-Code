package com.matrix.enigma.scrambler.reflector;

import static com.matrix.enigma.scrambler.Util.toInt;

public class ReflectorImpl implements Reflector {

	private char[] mapping;

	public ReflectorImpl(ReflectorType reflector) {
		mapping = reflector.getMapping();
	}

	public char reflect(char c) {
		int value = toInt(c);
		return mapping[value];
	}
}