package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "jmeterTestPlan")
@XmlAccessorType(XmlAccessType.FIELD)
public class JmeterTestPlan {

    @XmlAttribute
    private String version;

    @XmlAttribute
    private String properties;

    @XmlAttribute
    private String jmeter;

    @XmlElement(name = "hashTree")
    private List<TestPlanHashTree> testPlanHashTreeList;


}
