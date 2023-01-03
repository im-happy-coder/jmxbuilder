package com.jmxbuilder.jmx.dto.jaxb;

import com.jmxbuilder.jmx.dto.param.Params;
import lombok.Data;

import java.util.List;

/**
 * packageName    : com.jmxtestbuilder.toy.dto.excel
 * fileName       : HSP
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */

@Data
public class Hsp {

    //StringProp
    private String domain;

    private String port;

    private String protocol;

    private String contentEncoding;

    private String path;

    private String method;

    private String embeddedUrlRe;

    private String connectTimeout;

    private String responseTimeout;

    private String comments;


    //BoolProp
    private String followRedirects;

    private String autoRedirects;

    private String useKeepalive;

    private String doMultipartPost;

    private String browserCompatibleMultipart;

    List<Params> paramsList;

}
