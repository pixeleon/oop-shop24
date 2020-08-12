
package net.pixeleon.khpi.oop.shop24.io.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.pixeleon.khpi.oop.shop24.io.xml package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.pixeleon.khpi.oop.shop24.io.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Shop24Data }
     * 
     */
    public Shop24Data createShop24Data() {
        return new Shop24Data();
    }

    /**
     * Create an instance of {@link Shop24Data.WorkingHourData }
     * 
     */
    public Shop24Data.WorkingHourData createShop24DataWorkingHourData() {
        return new Shop24Data.WorkingHourData();
    }

}
