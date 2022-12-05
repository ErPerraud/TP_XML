//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.09.11 à 03:29:30 PM CEST 
//


package my.library;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the my.library package. 
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

    private final static QName _Qualification_QNAME = new QName("", "qualification");
    private final static QName _Born_QNAME = new QName("", "born");
    private final static QName _Isbn_QNAME = new QName("", "isbn");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Dead_QNAME = new QName("", "dead");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: my.library
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Character }
     * 
     */
    public Character createCharacter() {
        return new Character();
    }

    /**
     * Create an instance of {@link Library }
     * 
     */
    public Library createLibrary() {
        return new Library();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qualification")
    public JAXBElement<String> createQualification(String value) {
        return new JAXBElement<String>(_Qualification_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "born")
    public JAXBElement<XMLGregorianCalendar> createBorn(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Born_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isbn")
    public JAXBElement<BigInteger> createIsbn(BigInteger value) {
        return new JAXBElement<BigInteger>(_Isbn_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dead")
    public JAXBElement<XMLGregorianCalendar> createDead(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Dead_QNAME, XMLGregorianCalendar.class, null, value);
    }

}
