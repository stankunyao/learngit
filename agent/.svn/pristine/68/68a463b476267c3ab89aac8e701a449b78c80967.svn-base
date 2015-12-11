package com.foundway.send.smsservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PriorityLevel.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;PriorityLevel&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;Normal&quot;/&gt;
 *     &lt;enumeration value=&quot;Hight&quot;/&gt;
 *     &lt;enumeration value=&quot;Most&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PriorityLevel")
@XmlEnum
public enum PriorityLevel {

	@XmlEnumValue("Normal")
	NORMAL("Normal"), @XmlEnumValue("Hight")
	HIGHT("Hight"), @XmlEnumValue("Most")
	MOST("Most");
	private final String value;

	PriorityLevel(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static PriorityLevel fromValue(String v) {
		for (PriorityLevel c : PriorityLevel.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
