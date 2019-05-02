//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.05.02 a las 03:05:45 PM UYT 
//


package belt.wsdl;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the belt.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: belt.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllBeltsRequest }
     * 
     */
    public GetAllBeltsRequest createGetAllBeltsRequest() {
        return new GetAllBeltsRequest();
    }

    /**
     * Create an instance of {@link GetAllBeltsResponse }
     * 
     */
    public GetAllBeltsResponse createGetAllBeltsResponse() {
        return new GetAllBeltsResponse();
    }

    /**
     * Create an instance of {@link Belt }
     * 
     */
    public Belt createBelt() {
        return new Belt();
    }

}
