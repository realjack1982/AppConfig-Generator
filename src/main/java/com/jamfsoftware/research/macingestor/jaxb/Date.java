//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.17 at 09:04:29 AM CDT 
//


package com.jamfsoftware.research.macingestor.jaxb;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.dd.plist.NSDate;
import com.jamfsoftware.research.macingestor.MACDataType;


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
 *         &lt;element name="defaultValue" type="{}dateValueType" minOccurs="0"/>
 *         &lt;element name="constraint" type="{}dateConstraintType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="keyName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "defaultValue",
    "constraint"
})
@XmlRootElement(name = "date")
public class Date implements MACDataType{

    protected DateValueType defaultValue;
    protected DateConstraintType constraint;
    @XmlAttribute(name = "keyName", required = true)
    protected java.lang.String keyName;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link DateValueType }
     *     
     */
    public DateValueType getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateValueType }
     *     
     */
    public void setDefaultValue(DateValueType value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the constraint property.
     * 
     * @return
     *     possible object is
     *     {@link DateConstraintType }
     *     
     */
    public DateConstraintType getConstraint() {
        return constraint;
    }

    /**
     * Sets the value of the constraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateConstraintType }
     *     
     */
    public void setConstraint(DateConstraintType value) {
        this.constraint = value;
    }

    /**
     * Gets the value of the keyName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getKeyName() {
        return keyName;
    }

    /**
     * Sets the value of the keyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setKeyName(java.lang.String value) {
        this.keyName = value;
    }

	@Override
	public java.lang.String getValidation() {
		java.lang.String attributes = "";
		
		if(constraint != null && constraint.isNullable() != null && !constraint.isNullable()){
    		attributes += "data-parsley-required=\"\" ";
    	}
		
		if(constraint != null && constraint.getMin() != null){
			attributes += "data-parsley-min=\"" + constraint.getMin() + "\" ";
		}
		
		if(constraint != null && constraint.getMax() != null){
			attributes += "data-parsley-max=\"" + constraint.getMax() + "\" ";
		}
		
		
		return attributes;
	}

	@Override
	public List<java.lang.String> getDefaultValueList() {
		List<java.lang.String> date = new ArrayList<java.lang.String>();
		if (defaultValue != null && defaultValue.getValue() != null) {
			date.add(defaultValue.getValue().toString());
		} else {
			date.add("");
		}
		return date;
	}

	@Override
	public boolean isUserOrDeviceVariable() {
		return false;
	}

	@Override
	public java.lang.String getDefaultPresentationType() {
		return "datetime";
	}

	@Override
	public Options getOptions() {
		return null;
	}

	@Override
	public Object getPlistObject(java.lang.String[] submissions) {
		System.out.println(submissions[0]);
		try {
			return new NSDate(submissions[0] + ":00Z");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
