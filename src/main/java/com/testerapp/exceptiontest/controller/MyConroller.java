package com.testerapp.exceptiontest.controller;


import com.testerapp.exceptiontest.exception.CustomEx2;
import com.testerapp.exceptiontest.exception.CustomEx3;
import com.testerapp.exceptiontest.exception.CustomExA1;
import com.testerapp.exceptiontest.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class MyConroller
{


    @Autowired
  private  XmlService xs;



    @GetMapping("/playA")
    public void playA() throws CustomExA1
    {
        throw  new CustomExA1("My Custom Exception A1");

    }

    @GetMapping("/playB")
    public void playB() throws CustomEx2
    {
        throw  new CustomEx2("My Custom Exception A2");

    }
    @GetMapping("/playC")
    public void playC() throws  CustomEx3 {
        throw  new CustomEx3("My Custom Exception A3");

    }

    @GetMapping("/playD")
    public void playD() throws CustomEx3, ParserConfigurationException, IOException, SAXException {
        xs.parseInXmlDOMModel();


    }

    @GetMapping("/playE")
    public String playE() throws CustomEx3, ParserConfigurationException, IOException, SAXException, XMLStreamException {
        return xs.createInXml();




    }

    @GetMapping("/playF")
    public void playF() throws CustomEx3, ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException {
         xs.modifyInXml();




    }




}
