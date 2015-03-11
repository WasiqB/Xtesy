package com.wizonsoft.teasy.annotations;

import java.lang.annotation.*;

/**
 * @author Wasiq B
 * @since 01-Jan-2015 7:43:44 pm
 */
@Target ({ ElementType.TYPE, ElementType.FIELD })
@Retention (RetentionPolicy.RUNTIME)
@Deprecated
public @interface XmlElement {
	/**
	 * @author Wasiq B
	 * @since 01-Jan-2015 8:11:16 pm
	 * @return
	 */
	boolean isRoot () default false;

	/**
	 * @author Wasiq B
	 * @since 01-Jan-2015 7:45:20 pm
	 * @return
	 */
	String value () default "";
}