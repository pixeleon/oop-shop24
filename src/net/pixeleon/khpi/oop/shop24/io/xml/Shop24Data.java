
package net.pixeleon.khpi.oop.shop24.io.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkingHourData" maxOccurs="24">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Oclock" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="CustomersNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="Comment" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Address" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "workingHourData"
})
@XmlRootElement(name = "Shop24Data")
public class Shop24Data {

    @XmlElement(name = "WorkingHourData", required = true)
    protected List<Shop24Data.WorkingHourData> workingHourData;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Address")
    protected String address;

    /**
     * Gets the value of the workingHourData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workingHourData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkingHourData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shop24Data.WorkingHourData }
     * 
     * 
     */
    public List<Shop24Data.WorkingHourData> getWorkingHourData() {
        if (workingHourData == null) {
            workingHourData = new ArrayList<Shop24Data.WorkingHourData>();
        }
        return this.workingHourData;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Oclock" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="CustomersNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="Comment" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class WorkingHourData {

        @XmlAttribute(name = "Oclock", required = true)
        protected int oclock;
        @XmlAttribute(name = "CustomersNumber", required = true)
        protected int customersNumber;
        @XmlAttribute(name = "Comment", required = true)
        protected String comment;

        /**
         * Gets the value of the oclock property.
         * 
         */
        public int getOclock() {
            return oclock;
        }

        /**
         * Sets the value of the oclock property.
         * 
         */
        public void setOclock(int value) {
            this.oclock = value;
        }

        /**
         * Gets the value of the customersNumber property.
         * 
         */
        public int getCustomersNumber() {
            return customersNumber;
        }

        /**
         * Sets the value of the customersNumber property.
         * 
         */
        public void setCustomersNumber(int value) {
            this.customersNumber = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
        }

    }

}
