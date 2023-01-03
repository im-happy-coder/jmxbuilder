package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;


@Data
@XmlRootElement(name = "HTTPSamplerProxy")
@XmlAccessorType(XmlAccessType.FIELD)
public class HTTPSamplerProxy {

    @XmlAttribute(name = "guiclass")
    private String guiclass;

    @XmlAttribute(name = "testclass")
    private String testclass;

    @XmlAttribute(name = "testname")
    private String testname;

    @XmlAttribute(name = "enabled")
    private String enabled;

    @XmlElement(name = "elementProp")
    private List<ElementProp> elementPropList;

    @XmlElement(name = "stringProp")
    private List<StringProp> httpStringProp;

    @XmlElement(name = "boolProp")
    private List<BoolProp> httpBoolProp;

//    @XmlAnyElement(lax = true)
//    private List list;
}
