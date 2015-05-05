package com.wizonsoft.xtesy.annotations;

import java.lang.annotation.*;

/**
 * @author Wasiq B
 * @since 13-Dec-2014 12:21:54 pm
 */
@Retention (RetentionPolicy.RUNTIME)
@Target ({ ElementType.FIELD, ElementType.TYPE })
public @interface UIElement {
	/**
	 * @author Wasiq B
	 * @since 13-Dec-2014 12:24:00 pm
	 * @return
	 */
	boolean isParentElement () default false;

	/**
	 * @author Wasiq B
	 * @since 13-Dec-2014 12:23:30 pm
	 * @return
	 */
	String name ();
}