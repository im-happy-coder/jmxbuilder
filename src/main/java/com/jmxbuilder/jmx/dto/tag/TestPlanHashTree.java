package com.jmxbuilder.jmx.dto.tag;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPlanHashTree {

    @XmlElement(name = "TestPlan")
    private List<TestPlan> testPlanList;

    @XmlElement(name = "hashTree")
    private List<ThreadGroupHashTree> threadGroupHashTreeList;
}
