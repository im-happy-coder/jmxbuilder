package com.jmxbuilder.jmx.dto.tag;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "HeaderManager")
@XmlAccessorType(XmlAccessType.FIELD)
public class HeaderManager {

    //    @XmlElement(name = "collectionProps")
//    List<CollectionProp> collectionProps;

//    @XmlAnyElement(lax = true)
//    List<T> list;

    private String headStyle;
}
