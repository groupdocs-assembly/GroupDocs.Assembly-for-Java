package com.groupdocs.assembly.examples;

//ExStart:ContactFunctions
/**
 * A custom function type registered through {@code DocumentAssembler.getKnownTypes()}. It has to be a
 * top-level, publicly visible type so that the template engine can resolve it by name.
 */
public class ContactFunctions {

	/**
	 * Composes a display name out of the values passed from a template expression.
	 */
	public static String formatName(String title, String firstName, String lastName) {
		return title + " " + firstName + " " + lastName;
	}
}
//ExEnd:ContactFunctions
