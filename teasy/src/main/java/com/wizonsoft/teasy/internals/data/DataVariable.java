package com.wizonsoft.teasy.internals.data;

import com.wizonsoft.teasy.data.IDataVariable;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 8:01:01 pm
 */
public class DataVariable implements IDataVariable {
	private final int		index;
	private final String	name;

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 8:01:44 pm
	 * @param name
	 * @param index
	 */
	public DataVariable (final String name, final int index) {
		this.name = name;
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataVariable#getIndex()
	 */
	@Override
	public int getIndex () {
		return this.index;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataVariable#getName()
	 */
	@Override
	public String getName () {
		return this.name;
	}
}