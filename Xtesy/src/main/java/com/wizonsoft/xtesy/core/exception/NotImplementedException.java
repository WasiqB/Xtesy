package com.wizonsoft.xtesy.core.exception;

/**
 * @author Wasiq B
 * @since 11-May-2015 4:56:48 pm
 */
public class NotImplementedException extends Exception {
	private static final long	serialVersionUID	= 520486719088142322L;

	/**
	 * @author Wasiq B
	 * @since 11-May-2015 4:56:49 pm
	 * @param message
	 */
	public NotImplementedException (String message) {
		super (message);
	}

	/**
	 * @author Wasiq B
	 * @since 11-May-2015 4:56:49 pm
	 * @param message
	 * @param cause
	 */
	public NotImplementedException (String message, Throwable cause) {
		super (message, cause);
	}

	/**
	 * @author Wasiq B
	 * @since 11-May-2015 4:56:49 pm
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NotImplementedException (String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super (message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @author Wasiq B
	 * @since 11-May-2015 4:56:49 pm
	 * @param cause
	 */
	public NotImplementedException (Throwable cause) {
		super (cause);
	}
}