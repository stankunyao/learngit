package com.harmony.themis.software.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AgentXmlUtils {
	public static Document getDocument(InputStream in) throws XmlException {
		Document doc = null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(in);
		} catch (ParserConfigurationException e) {
			throw new XmlException(e);
		} catch (SAXException e) {
			throw new XmlException("xml.parse.error", e);
		} catch (IOException e) {
			throw new XmlException("xml.read.error", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return doc;
	}
	public static Element getRootElementFromStream(InputStream in)
			throws XmlException {
		return getDocument(in).getDocumentElement();
	}

	public static List<Element> getElements(Element parent, String tagName) {
		NodeList nodes = parent.getElementsByTagName(tagName);
		List elements = new ArrayList();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			
			if ((node instanceof Element)) {
				elements.add((Element) node);
			}
		}

		return elements;
	}

	public static Element getElement(Element parent, String tagName) {
		List children = getElements(parent, tagName);

		if (children.isEmpty()) {
			return null;
		}
		return (Element) children.get(0);
	}

	public static List<Element> getChildElements(Element parent, String tagName) {
		NodeList nodes = parent.getElementsByTagName(tagName);
		List elements = new ArrayList();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (((node instanceof Element)) && (node.getParentNode() == parent)) {
				elements.add((Element) node);
			}
		}

		return elements;
	}

	public static Element getChildElement(Element parent, String tagName) {
		List children = getChildElements(parent, tagName);

		if (children.isEmpty()) {
			return null;
		}
		return (Element) children.get(0);
	}

	public static String getElementValue(Element parent, String tagName) {
		String value = null;

		Element element = getElement(parent, tagName);
		if (element != null) {
			value = element.getFirstChild().getNodeValue();
		}
		if (value == null) {
			value = parent.getAttribute(tagName);
		}

		return value;
	}
}
