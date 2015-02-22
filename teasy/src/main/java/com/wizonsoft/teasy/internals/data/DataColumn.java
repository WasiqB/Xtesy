package com.wizonsoft.teasy.internals.data;

import com.wizonsoft.teasy.data.*;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 8:02:45 pm
 */
public class DataColumn <T> implements IDataColumn {
	private final T				value;
	private final IDataVariable	variable;

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 8:10:10 pm
	 * @param variable
	 * @param value
	 */
	public DataColumn (final IDataVariable variable, final T value) {
		this.variable = variable;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataColumn#getValue()
	 */
	@SuppressWarnings ("unchecked")
	@Override
	public T getValue () {
		return this.value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataColumn#getVariable()
	 */
	@Override
	public IDataVariable getVariable () {
		return this.variable;
	}
}