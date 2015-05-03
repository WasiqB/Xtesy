package com.wizonsoft.teasy.internals.parsers;

import static com.wizonsoft.teasy.utils.lang.Strings.isNullOrEmpty;

import java.lang.reflect.Field;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import com.wizonsoft.teasy.annotations.*;

/**
 * @author Wasiq B
 * @since 01-Jan-2015 7:51:03 pm
 */
public final class XmlParser {
	private static DocumentBuilder			builder;
	private static Document					document;
	private static DocumentBuilderFactory	factory;
	private static Element					root;

	/**
	 * @author Wasiq B
	 * @since 01-Jan-2015 8:09:21 pm
	 * @throws ParserConfigurationException
	 */
	private static void newDocument () throws ParserConfigurationException {
		factory = DocumentBuilderFactory.newInstance ();
		builder = factory.newDocumentBuilder ();
		document = builder.newDocument ();
	}

	/**
	 * @author Wasiq B
	 * @since 01-Jan-2015 8:13:13 pm
	 * @param source
	 */
	private static <T> void serialize (final T source) {
		XmlElement element = source.getClass ().getAnnotation (XmlElement.class);
		if (element.isRoot () && source.getClass ().isSynthetic ()) {
			root = document.createElement (element.value ());
			document.appendChild (root);
		}
		for (final Field field : source.getClass ().getDeclaredFields ()) {
			if (field.isAnnotationPresent (XmlElement.class)) {
				element = field.getAnnotation (XmlElement.class);
				String value = element.value ();
				if (isNullOrEmpty (value)) {
					value = field.getName ();
				}
				final Element child = document.createElement (value);
				root.appendChild (child);
			}
			else {
				final XmlAttribute attr = field.getAnnotation (XmlAttribute.class);
			}
		}
	}

	/**
	 * @author Wasiq B
	 * @since 01-Jan-2015 7:59:21 pm
	 * @param path
	 * @param source
	 * @throws ParserConfigurationException
	 */
	public static <T> void serialize (final String path, final T source)
			throws ParserConfigurationException {
		newDocument ();
		if (source.getClass ().isAnnotationPresent (XmlElement.class)) {
			serialize (source);
		}
	}
}