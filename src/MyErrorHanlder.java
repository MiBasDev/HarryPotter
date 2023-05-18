
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * CLase que manexa os posibles erros de validación no procesamento do documento
 * XML usando o esquema.
 *
 * @author Miguel Bastos Gándara.
 */
public class MyErrorHanlder implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }

}
