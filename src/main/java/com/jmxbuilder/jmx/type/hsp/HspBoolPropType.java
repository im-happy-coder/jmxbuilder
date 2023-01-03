package com.jmxbuilder.jmx.type.hsp;

/**
 * packageName    : com.jmxbuilder.jmx.type
 * fileName       : HspBoolPropType
 * author         : im-happy-coder
 * date           : 22. 11. 11.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 11.        im-happy-coder       최초 생성
 */
public enum HspBoolPropType {
    FOLLOW_REDIRECTS("HTTPSampler.follow_redirects"), AUTO_REDIRECTS("HTTPSampler.auto_redirects"),
    USE_KEEPALIVE("HTTPSampler.use_keepalive"), MULTIPART_POST("HTTPSampler.DO_MULTIPART_POST"),
    BROWSER_COMPATIBLE("HTTPSampler.BROWSER_COMPATIBLE_MULTIPART");

    private String name;

    HspBoolPropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
