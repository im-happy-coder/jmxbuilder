package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementProp {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "elementType")
    private String elementType;

    @XmlAttribute(name = "guiclass")
    private String guiclass;

    @XmlAttribute(name = "testclass")
    private String testclass;

    @XmlAttribute(name = "enabled")
    private String enabled;

    @XmlAttribute(name = "testname")
    private String testname;

    @XmlElement(name = "boolProp")
    private List<BoolProp> boolPropList;

    @XmlElement(name = "stringProp")
    private List<StringProp> stringPropList;

    @XmlElement(name = "collectionProp")
    private List<CollectionProp> collectionPropList;
}
