package com.jmxbuilder.jmx.dto.param;

import com.jmxbuilder.jmx.dto.jaxb.Hsp;
import lombok.Data;

import java.util.List;

/**
 * packageName    : com.jmxbuilder.jmx.dto.data
 * fileName       : Params
 * author         : im-happy-coder
 * date           : 22. 11. 11.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 11.        im-happy-coder       최초 생성
 */
@Data
public class Params {

    private String name;

    private String value;

    private String contentType;

    private String memtaData;

    private String encode;

    private String equals;

    List<Hsp> hspList;
}
