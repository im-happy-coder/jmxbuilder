package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "TransactionController")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionController {

    @XmlAttribute(name = "guiclass")
    private String guiclass;

    @XmlAttribute(name = "testclass")
    private String testclass;

    @XmlAttribute(name = "testname")
    private String testname;

    @XmlAttribute(name = "enabled")
    private String enabled;

    @XmlElement(name = "boolProp")
    private List<BoolProp> transactionBoolPropList;

//    @XmlElement(name = "hasTree")
//    List<HTTPHashTree> httpHashTreeList;


}
