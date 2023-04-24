package com.testerapp.exceptiontest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

@Slf4j
@Service
public class XmlService {


    public void parseInXmlDOMModel() throws ParserConfigurationException, IOException, SAXException
    {


    File ipfile = new File("C:\\Users\\akuma\\OneDrive\\Desktop\\inXml.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();

    Document doc= dbBuilder.parse(ipfile);
    doc.getDocumentElement().normalize();

    Element element=doc.getDocumentElement();

    System.out.println("Root Element : "+ element.getNodeName());
    log.info("Root Element : "+element.getNodeName());

    NodeList nl=doc.getElementsByTagName("Fruit");

    for(int i=0; i<nl.getLength();i++)
        {
            Node node= nl.item(i);


            System.out.println("Current Element : "+ node.getNodeName());
            log.info("Current Element : "+node.getNodeName());

            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element element1= (Element) node;

                System.out.println(element1.getAttribute("type"));

                System.out.println(element1.getElementsByTagName("fname").item(0).getTextContent());

                System.out.println(element1.getElementsByTagName("taste").item(0).getTextContent());

                System.out.println(element1.getElementsByTagName("shape").item(0).getTextContent());

                System.out.println(element1.getElementsByTagName("price").item(0).getTextContent());


            }


        }







  }

    public String createInXml() throws XMLStreamException, IOException {
        StringWriter sw = new StringWriter();
        XMLOutputFactory opxml=XMLOutputFactory.newInstance();
        XMLStreamWriter xmlStreamWriter= opxml.createXMLStreamWriter(sw);

        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeStartElement("cars");
        xmlStreamWriter.writeStartElement("supercar");
        xmlStreamWriter.writeAttribute("company","Tesla");
        xmlStreamWriter.writeStartElement("carname");
        xmlStreamWriter.writeCharacters("Tesla v2");
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.flush();
        xmlStreamWriter.close();

        String xmlString= sw.getBuffer().toString();
        sw.close();

        System.out.println(xmlString);

        return xmlString;



    }


  public void  modifyInXml() throws ParserConfigurationException, IOException, SAXException, TransformerException {

        File ipFile= new File("C:\\Users\\akuma\\OneDrive\\Desktop\\inXml.xml");
        DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder= docBuilderFac.newDocumentBuilder();

        Document doc= documentBuilder.parse(ipFile);


        NodeList nl= doc.getElementsByTagName("Fruit");



        for(int i=0; i<nl.getLength();i++)
        {

            nl.item(i).getAttributes().getNamedItem("type").setTextContent("flower");

            Node node= nl.item(i);

            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element ele = (Element) node;

                ele.getElementsByTagName("fname").item(0).setTextContent("Jasmine");
            }


        }
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      System.out.println("-----------Modified File-----------");
      StreamResult consoleResult = new StreamResult(System.out);
      transformer.transform(source, consoleResult);



    }

}
