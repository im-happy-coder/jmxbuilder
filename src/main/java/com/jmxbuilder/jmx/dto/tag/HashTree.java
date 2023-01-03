package com.jmxbuilder.jmx.dto.tag;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * packageName    : com.jmxbuilder.jmx.dto.tag
 * fileName       : HashTree
 * author         : im-happy-coder
 * date           : 22. 11. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 16.        im-happy-coder       최초 생성
 */
@Data
@XmlRootElement(name = "hashTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class HashTree {

    @XmlAttribute
    private String hashTree;
}
