package com.jmxbuilder.jmx.type;

/**
 * packageName    : com.jmxtestbuilder.toy.utils
 * fileName       : ElementPropType
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */
public enum ElementPropType {
    NAME("id"), ELEMENTTYPE("HTTPArgument");

    private String name;

    ElementPropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
