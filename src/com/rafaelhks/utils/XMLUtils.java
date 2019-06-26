package com.rafaelhks.utils;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XMLUtils {
	
	public static Object getElementByTag(Document xml, String tagPath) throws Exception {
		XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        return xp.evaluate("//"+tagPath,
                xml.getDocumentElement());
	}
	
	public static Object getElementByTag(String xml, String tag) throws Exception {
		Document doc = convertStringToXMLDocument(xml);
		return getElementByTag(doc, tag);
	}

	public static Document convertStringToXMLDocument(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
        
        return doc;
    }
}
