package com.xiao.common.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * xml工具
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/31 21:02
 */
public class XmlUtils {

    public static String createConfigXml() {

        String xmlString = "";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlStandalone(true);

            Element configuration = document.createElement("configuration");
            document.appendChild(configuration);

            for (int i = 0; i < 2; i++) {
                Element property = document.createElement("property");
                configuration.appendChild(property);
                Element name = document.createElement("name");
                name.setTextContent("name" + i);
                property.appendChild(name);
                Element value = document.createElement("value");
                value.setTextContent("value" + i);
                property.appendChild(value);
            }

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(bos));
            xmlString = bos.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xmlString;
    }

    public static void main(String[] args) {
        String hdfsSitConfigXml = XmlUtils.createConfigXml();
        System.out.println(hdfsSitConfigXml);
        InputStream inputStream = new ByteArrayInputStream(hdfsSitConfigXml.getBytes(StandardCharsets.UTF_8));

        System.out.println(inputStream);
    }

}
