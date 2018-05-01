//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.17 at 09:04:29 AM CDT 
//


package com.jamfsoftware.research.macingestor.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.jamfsoftware.research.macingestor.MACDataType;
import com.jamfsoftware.research.macingestor.jaxb.Options.Option;


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
 *         &lt;element name="defaultValue" type="{}floatValueType" minOccurs="0"/>
 *         &lt;element name="constraint" type="{}floatConstraintType" minOccurs="0"/>
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
@XmlRootElement(name = "float")
public class Float implements MACDataType{

    protected FloatValueType defaultValue;
    protected FloatConstraintType constraint;
    @XmlAttribute(name = "keyName", required = true)
    protected java.lang.String keyName;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link FloatValueType }
     *     
     */
    public FloatValueType getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloatValueType }
     *     
     */
    public void setDefaultValue(FloatValueType value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the constraint property.
     * 
     * @return
     *     possible object is
     *     {@link FloatConstraintType }
     *     
     */
    public FloatConstraintType getConstraint() {
        return constraint;
    }

    /**
     * Sets the value of the constraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloatConstraintType }
     *     
     */
    public void setConstraint(FloatConstraintType value) {
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
		java.lang.String attributes = "pattern=\"(([1-9][0-9]*\\.?[0-9]*)|(\\.[0-9]+))([Ee][+-]?[0-9]+)?\" ";
		
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
		try {
			List<java.lang.String> defaults = new ArrayList<java.lang.String>();
			if (defaultValue != null) {
				defaults.add(defaultValue.getValue().toString());
			} else {
				defaults.add("");
			}
			return defaults;
		} catch (Exception e){
			return null;
		}
	}

	@Override
	public boolean isUserOrDeviceVariable() {
		return false;
	}

	@Override
	public java.lang.String getDefaultPresentationType() {
		if(constraint != null && constraint.values != null) {
			return "select";
		}
		
		return "input";
	}

	@Override
	public Options getOptions() {
		try {
			Options options = new Options();
			options.option = new ArrayList<Option>();
			for(java.lang.Float f : constraint.getValues().value){
				Option o = new Option();
				o.setValue(f.toString());
				o.setSelected(false);
				
				// set the language for display
				List<Language> lang = new ArrayList<Language>();
				Language l = new Language();
				l.setValue(f.toString());
				l.setValueAttribute("en-US");
				lang.add(l);
				o.language = lang;
				
				options.option.add(o);
			}
			return options;
			
		} catch (NullPointerException e){
			return new Options();
		}
	}

	@Override
	public Object getPlistObject(java.lang.String[] submissions) {
		return java.lang.Float.parseFloat(submissions[0]);
	}

}
