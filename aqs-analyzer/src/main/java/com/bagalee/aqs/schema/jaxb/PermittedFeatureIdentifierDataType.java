//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.03 at 09:57:03 PM MDT 
//


package com.bagalee.aqs.schema.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for PermittedFeatureIdentifierDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PermittedFeatureIdentifierDataType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="PermittedFeatureIdentifierContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PermittedFeatureIdentifierDataType", propOrder = {
    "value"
})
public class PermittedFeatureIdentifierDataType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "PermittedFeatureIdentifierContext")
    protected String permittedFeatureIdentifierContext;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the permittedFeatureIdentifierContext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermittedFeatureIdentifierContext() {
        return permittedFeatureIdentifierContext;
    }

    /**
     * Sets the value of the permittedFeatureIdentifierContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermittedFeatureIdentifierContext(String value) {
        this.permittedFeatureIdentifierContext = value;
    }

}