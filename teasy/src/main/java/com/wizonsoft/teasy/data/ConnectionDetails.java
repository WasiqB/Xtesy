package com.wizonsoft.teasy.data;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 6:54:39 pm
 */
@Deprecated
public final class ConnectionDetails {
	private String	database;
	private String	driver;
	private String	owner;
	private String	password;
	private String	url;
	private String	userId;

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:57:15 pm
	 */
	public ConnectionDetails () {
		setDriver ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		setUrl ("jdbc:sqlserver://");
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @return the database
	 */
	public String getDatabase () {
		return this.database;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @return the driver
	 */
	public String getDriver () {
		return this.driver;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @return the owner
	 */
	public String getOwner () {
		return this.owner;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @return the password
	 */
	public String getPassword () {
		return this.password;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @return the url
	 */
	public String getUrl () {
		return this.url;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @return the userId
	 */
	public String getUserId () {
		return this.userId;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @param database
	 *            the database to set
	 */
	public void setDatabase (final String database) {
		this.database = database;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver (final String driver) {
		this.driver = driver;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner (final String owner) {
		this.owner = owner;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @param password
	 *            the password to set
	 */
	public void setPassword (final String password) {
		this.password = password;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @param url
	 *            the url to set
	 */
	public void setUrl (final String url) {
		this.url = url;
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 6:56:42 pm
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId (final String userId) {
		this.userId = userId;
	}
}