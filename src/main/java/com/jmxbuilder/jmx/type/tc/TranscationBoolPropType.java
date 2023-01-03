package com.jmxbuilder.jmx.type.tc;

import com.jmxbuilder.jmx.dto.tag.TransactionController;

/**
 * packageName    : com.jmxbuilder.jmx.type.tc
 * fileName       : TranscationBoolPropType
 * author         : im-happy-coder
 * date           : 22. 11. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 16.        im-happy-coder       최초 생성
 */
public enum TranscationBoolPropType {
    INCLUDETIMERS("TransactionController.includeTimers"), PARENT("TransactionController.parent");

    private String name;

    TranscationBoolPropType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
