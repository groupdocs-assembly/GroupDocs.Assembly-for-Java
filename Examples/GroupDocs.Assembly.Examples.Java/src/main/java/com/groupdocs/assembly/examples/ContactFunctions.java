package com.groupdocs.assembly.examples;

import com.groupdocs.assembly.system.data.DataRow;

//ExStart:ContactFunctions
/**
 * A custom function type registered through {@code DocumentAssembler.getKnownTypes()}. It has to be a
 * top-level, publicly visible type so that the template engine can resolve it by name.
 */
public class ContactFunctions {

	/**
	 * Accepts a single DataRow (a JSON object node such as {@code root}) and reads its columns.
	 */
	public static String formatName(DataRow contact) {
		if (contact == null) {
			return "";
		}

		return contact.get("title") + " " + contact.get("firstName") + " " + contact.get("lastName");
	}
}
//ExEnd:ContactFunctions
