package com.jmxbuilder.jmx.dto.tag;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "collectionProp")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionProp {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "elementProp")
    List<ElementProp> elementPropList;

}
