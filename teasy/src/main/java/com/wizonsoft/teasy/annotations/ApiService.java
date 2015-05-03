package com.wizonsoft.teasy.annotations;

import java.lang.annotation.*;

import com.wizonsoft.teasy.utils.lang.Strings;

/**
 * @author Wasiq B
 * @since 13-Feb-2015 11:21:24 am
 */
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
public @interface ApiService {
	/**
	 * @author Wasiq B
	 * @since 13-Feb-2015 11:22:48 am
	 * @return
	 */
	String name () default Strings.EMPTY;
}