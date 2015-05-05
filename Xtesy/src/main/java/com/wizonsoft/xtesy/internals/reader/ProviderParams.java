package com.wizonsoft.xtesy.internals.reader;

import java.util.*;

/**
 * @author Wasiq B
 * @since 07-Dec-2014 1:21:39 pm
 */
public class ProviderParams {
	private final Map <String, String>	fields;

	/**
	 * @author Wasiq B
	 * @since 07-Dec-2014 1:28:08 pm
	 */
	public ProviderParams () {
		this.fields = new HashMap <String, String> ();
	}

	/**
	 * @author Wasiq B
	 * @since 07-Dec-2014 1:34:05 pm
	 */
	public void clear () {
		this.fields.clear ();
	}

	/**
	 * @author Wasiq B
	 * @since 07-Dec-2014 1:31:19 pm
	 * @return
	 */
	public Set <String> getFields () {
		return this.fields.keySet ();
	}

	/**
	 * @author Wasiq B
	 * @since 07-Dec-2014 1:31:53 pm
	 * @param field
	 * @return
	 */
	public String getFieldValue (final String field) {
		return this.fields.get (field);
	}

	/**
	 * @author Wasiq B
	 * @since 13-Dec-2014 1:15:41 pm
	 * @param field
	 * @return
	 */
	public boolean hasField (final String field) {
		return this.fields.containsKey (field);
	}

	/**
	 * @author Wasiq B
	 * @since 07-Dec-2014 1:30:18 pm
	 * @param field
	 * @param value
	 */
	public void setFieldValue (final String field, final String value) {
		if (!hasField (field)) this.fields.put (field, value);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 5:57:12 pm
	 * @return
	 */
	public int size () {
		return this.fields.size ();
	}
}