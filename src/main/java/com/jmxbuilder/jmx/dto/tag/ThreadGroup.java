package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "ThreadGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThreadGroup {

    @XmlAttribute(name = "guiclass")
    private String guiclass;

    @XmlAttribute(name = "testclass")
    private String testclass;

    @XmlAttribute(name = "testname")
    private String testname;

    @XmlAttribute(name = "enabled")
    private String enabled;

    @XmlElement(name = "stringProp")
    private List<StringProp> stringPropList;

    @XmlElement(name = "elementProp")
    private List<ElementProp> elementPropList;

    @XmlElement(name = "boolProp")
    private List<BoolProp> boolPropList;
}
