package com.wizonsoft.xtesy.annotations;

import java.lang.annotation.*;

import com.wizonsoft.xtesy.core.utils.Strings;

/**
 * @author Wasiq B
 * @since 13-Feb-2015 11:23:25 am
 */
@Retention (RetentionPolicy.RUNTIME)
@Target ({ ElementType.FIELD, ElementType.TYPE })
public @interface ApiParameter {
	/**
	 * @author Wasiq B
	 * @since 13-Feb-2015 11:24:08 am
	 * @return
	 */
	String name () default Strings.EMPTY;

	/**
	 * @author Wasiq B
	 * @since 13-Feb-2015 11:24:33 am
	 * @return
	 */
	int priority () default -1;
}