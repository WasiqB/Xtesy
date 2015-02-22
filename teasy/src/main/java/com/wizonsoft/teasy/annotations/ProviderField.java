package com.wizonsoft.teasy.annotations;

import java.lang.annotation.*;

/**
 * @author Wasiq B
 * @since 13-Dec-2014 12:11:19 pm
 */
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface ProviderField {
	/**
	 * @author Wasiq B
	 * @since 13-Dec-2014 12:14:57 pm
	 * @return
	 */
	String fieldName ();
}