package com.amil.teste.sysplan.common;

import java.util.regex.Pattern;

public interface GamePatternConstant {

	// Create a string pattern objects
	final String PATTERN_WORLD_CONSTANT = "<WORLD> killed ([^\\s]+) by ([^\\s]+)";
	final String PATTERN_KILLER_CONSTANT = "([^\\s]+) killed ([^\\s]+) using ([^\\s]+)";

	// Create a pattern objects
	final Pattern WORLD_PATTERN = Pattern.compile(PATTERN_WORLD_CONSTANT);
	final Pattern KILLER_PATTERN = Pattern.compile(PATTERN_KILLER_CONSTANT);
}
