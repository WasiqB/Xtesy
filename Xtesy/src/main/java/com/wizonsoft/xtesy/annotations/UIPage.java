package com.wizonsoft.xtesy.annotations;

import java.lang.annotation.*;

/**
 * @author Wasiq B
 * @since 13-Dec-2014 12:15:42 pm
 */
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
public @interface UIPage {
	/**
	 * @author Wasiq B
	 * @since 13-Dec-2014 12:17:56 pm
	 * @return
	 */
	String name ();
}