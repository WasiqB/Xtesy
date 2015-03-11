package com.wizonsoft.teasy.annotations;

import java.lang.annotation.*;

/**
 * @author Wasiq B
 * @since 01-Jan-2015 7:45:55 pm
 */
@Target (ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
@Deprecated
public @interface XmlAttribute {
	/**
	 * @author Wasiq B
	 * @since 01-Jan-2015 7:46:54 pm
	 * @return
	 */
	String value () default "";
}