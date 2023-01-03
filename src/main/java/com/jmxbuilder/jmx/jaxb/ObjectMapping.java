package com.jmxbuilder.jmx.jaxb;

import com.jmxbuilder.jmx.dto.entity.FileEntity;
import com.jmxbuilder.jmx.dto.jaxb.Hsp;
import com.jmxbuilder.jmx.type.BoolPropType;
import com.jmxbuilder.jmx.type.StringPropType;
import com.jmxbuilder.jmx.type.hsp.HspBoolPropType;
import com.jmxbuilder.jmx.type.hsp.HspStringPropType;
import com.jmxbuilder.jmx.parsing.ExcelToObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * packageName    : com.jmxbuilder.jmx.common
 * fileName       : ObjectToParser
 * author         : im-happy-coder
 * date           : 22. 11. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 29.        im-happy-coder       최초 생성
 */
public class ObjectMapping {

    //hsp Parsing
    public static HashMap<Enum, String> parsingData(String orgSavedPath, int i) throws IOException {

        Hsp hsp = new Hsp();

        // Excel Data List 가져오기
        hsp.setParamsList(ExcelToObject.readExcel(orgSavedPath));

        HashMap<Enum, String> hmap = new HashMap<>();

        // StrProp Data
        hmap.put(StringPropType.NAME, hsp.getParamsList().get(i).getName());
        hmap.put(StringPropType.VALUE, hsp.getParamsList().get(i).getValue());
        hmap.put(StringPropType.METADATA, hsp.getParamsList().get(i).getMemtaData());
        // BoolProp Data
        hmap.put(BoolPropType.ENCODE, hsp.getParamsList().get(i).getEncode());
        hmap.put(BoolPropType.EQUALS, hsp.getParamsList().get(i).getEquals());
        // HspStrProp Data
        hmap.put(HspStringPropType.DOMAIN, hsp.getParamsList().get(i).getHspList().get(i).getDomain());
        hmap.put(HspStringPropType.PATH, hsp.getParamsList().get(i).getHspList().get(i).getPath());
        hmap.put(HspStringPropType.PORT, "");
        hmap.put(HspStringPropType.PROTOCOL, "");
        hmap.put(HspStringPropType.CONTENTENCODING, "");
        hmap.put(HspStringPropType.EMBEDDED_URL_RE, "");
        hmap.put(HspStringPropType.CONNECTION_TIMEOUT, "");
        hmap.put(HspStringPropType.RESPONSE_TIMEOUT, "");
        hmap.put(HspStringPropType.COMMENTS, "");
        hmap.put(HspStringPropType.METHOD, "GET");
        // HspBoolProp Data
        hmap.put(HspBoolPropType.FOLLOW_REDIRECTS, "true");
        hmap.put(HspBoolPropType.AUTO_REDIRECTS, "false");
        hmap.put(HspBoolPropType.USE_KEEPALIVE, "true");
        hmap.put(HspBoolPropType.MULTIPART_POST, "false");
        hmap.put(HspBoolPropType.BROWSER_COMPATIBLE, "false");

        return hmap;
    }
}
