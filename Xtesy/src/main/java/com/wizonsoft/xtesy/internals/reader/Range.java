package com.wizonsoft.xtesy.internals.reader;

/**
 * @author Wasiq B
 * @since 29-Nov-2014 6:54:34 pm
 */
public final class Range {
	private final int	fromRow;
	private final int	toRow;

	/**
	 * @author Wasiq B
	 * @since 13-Feb-2015 11:39:53 am
	 */
	public Range () {
		this.fromRow = -1;
		this.toRow = -1;
	}

	/**
	 * @author Wasiq B
	 * @since 29-Nov-2014 6:55:25 pm
	 * @param fromRow
	 * @param toRow
	 */
	public Range (final int fromRow, final int toRow) {
		this.fromRow = fromRow;
		this.toRow = toRow;
	}

	/**
	 * @author Wasiq B
	 * @since 29-Nov-2014 6:56:02 pm
	 * @return the col
	 */
	public int getFromRow () {
		return this.fromRow;
	}

	/**
	 * @author Wasiq B
	 * @since 29-Nov-2014 6:56:02 pm
	 * @return the row
	 */
	public int getToRow () {
		return this.toRow;
	}
}