package com.foundway.send.smsservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;shortNumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;timeStamp&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;hashedPwd&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;message&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;address&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;level&quot; type=&quot;{http://www.foundway.com/send/smsservice}PriorityLevel&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "shortNumber", "timeStamp", "hashedPwd",
		"message", "address", "level" })
@XmlRootElement(name = "Send")
public class Send {

	protected String shortNumber;
	protected String timeStamp;
	protected String hashedPwd;
	protected String message;
	protected String address;
	@XmlElement(required = true)
	protected PriorityLevel level;

	/**
	 * Gets the value of the shortNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShortNumber() {
		return shortNumber;
	}

	/**
	 * Sets the value of the shortNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShortNumber(String value) {
		this.shortNumber = value;
	}

	/**
	 * Gets the value of the timeStamp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the value of the timeStamp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTimeStamp(String value) {
		this.timeStamp = value;
	}

	/**
	 * Gets the value of the hashedPwd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHashedPwd() {
		return hashedPwd;
	}

	/**
	 * Sets the value of the hashedPwd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHashedPwd(String value) {
		this.hashedPwd = value;
	}

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Gets the value of the address property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the value of the address property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress(String value) {
		this.address = value;
	}

	/**
	 * Gets the value of the level property.
	 * 
	 * @return possible object is {@link PriorityLevel }
	 * 
	 */
	public PriorityLevel getLevel() {
		return level;
	}

	/**
	 * Sets the value of the level property.
	 * 
	 * @param value
	 *            allowed object is {@link PriorityLevel }
	 * 
	 */
	public void setLevel(PriorityLevel value) {
		this.level = value;
	}

}
