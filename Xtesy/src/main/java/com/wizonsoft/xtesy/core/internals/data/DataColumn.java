package com.wizonsoft.xtesy.internals.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.data.IDataColumn;
import com.wizonsoft.xtesy.data.IDataVariable;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 8:02:45 pm
 */
public class DataColumn <T> implements IDataColumn {
	private static Logger		log;
	private final T				value;
	private final IDataVariable	variable;

	static {
		log = LogManager.getLogger (DataColumn.class);
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 8:10:10 pm
	 * @param variable
	 * @param value
	 */
	public DataColumn (final IDataVariable variable, final T value) {
		log.entry ();
		this.variable = variable;
		this.value = value;
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataColumn#getValue()
	 */
	@SuppressWarnings ("unchecked")
	@Override
	public T getValue () {
		log.entry ();
		return log.exit (this.value);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataColumn#getVariable()
	 */
	@Override
	public IDataVariable getVariable () {
		log.entry ();
		return log.exit (this.variable);
	}
}