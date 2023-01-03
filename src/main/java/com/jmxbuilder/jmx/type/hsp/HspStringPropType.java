package com.jmxbuilder.jmx.type.hsp;

/**
 * packageName    : com.jmxbuilder.jmx.type
 * fileName       : HspStringProp
 * author         : im-happy-coder
 * date           : 22. 11. 11.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 11.        im-happy-coder       최초 생성
 */
public enum HspStringPropType {
    DOMAIN("HTTPSampler.domain"), PORT("HTTPSampler.port"), PROTOCOL("HTTPSampler.protocol"), CONTENTENCODING("HTTPSampler.contentEncoding"),
    PATH("HTTPSampler.path"), METHOD("HTTPSampler.method"), EMBEDDED_URL_RE("HTTPSampler.embedded_url_re"), CONNECTION_TIMEOUT("HTTPSampler.connect_timeout"),
    RESPONSE_TIMEOUT("HTTPSampler.response_timeout"), COMMENTS("TestPlan.comments");

    private String name;

    HspStringPropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
