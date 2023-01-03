package com.jmxbuilder.jmx.xmltagsdata.httpsampleproxy;

import com.jmxbuilder.jmx.dto.tag.*;
import com.jmxbuilder.jmx.type.BoolPropType;
import com.jmxbuilder.jmx.type.StringPropType;
import com.jmxbuilder.jmx.type.hsp.HspBoolPropType;
import com.jmxbuilder.jmx.type.hsp.HspStringPropType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * packageName    : com.jmxbuilder.jmx.xmltag.httpsampleproxy
 * fileName       : HspTag
 * author         : im-happy-coder
 * date           : 22. 12. 6.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 12. 6.        im-happy-coder       최초 생성
 */
public class HspTag {
    // <HTTPSampleProxy>
    public static HTTPSamplerProxy httpSamplerProxy(HashMap<Enum, String> hpmap) {
        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
        List<ElementProp> elementPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();
        List<BoolProp> boolPropList = new ArrayList<>();

        elementPropList.add(elementPropHSP(hpmap));

        httpSamplerProxy.setGuiclass("HttpTestSampleGui");
        httpSamplerProxy.setTestclass("HTTPSamplerProxy");
        httpSamplerProxy.setTestname("HTTP Request");
        httpSamplerProxy.setEnabled("true");
        httpSamplerProxy.setElementPropList(elementPropList);

        //HttpSampleProxy stringProp Data insert
        stringPropList.add(stringproplist(HspStringPropType.DOMAIN, hpmap.get(HspStringPropType.DOMAIN)));
        stringPropList.add(stringproplist(HspStringPropType.PORT, hpmap.get(HspStringPropType.PORT)));
        stringPropList.add(stringproplist(HspStringPropType.PROTOCOL, hpmap.get(HspStringPropType.PROTOCOL)));
        stringPropList.add(stringproplist(HspStringPropType.CONTENTENCODING, hpmap.get(HspStringPropType.CONTENTENCODING)));
        stringPropList.add(stringproplist(HspStringPropType.PATH, hpmap.get(HspStringPropType.PATH)));
        stringPropList.add(stringproplist(HspStringPropType.METHOD, hpmap.get(HspStringPropType.METHOD)));
        stringPropList.add(stringproplist(HspStringPropType.EMBEDDED_URL_RE, hpmap.get(HspStringPropType.EMBEDDED_URL_RE)));
        stringPropList.add(stringproplist(HspStringPropType.CONNECTION_TIMEOUT, hpmap.get(HspStringPropType.CONNECTION_TIMEOUT)));
        stringPropList.add(stringproplist(HspStringPropType.RESPONSE_TIMEOUT, hpmap.get(HspStringPropType.RESPONSE_TIMEOUT)));
        stringPropList.add(stringproplist(HspStringPropType.COMMENTS, hpmap.get(HspStringPropType.COMMENTS)));

        httpSamplerProxy.setHttpStringProp(stringPropList);

        //HttpSampleProxy boolProp Data insert
        boolPropList.add(boolproplist(HspBoolPropType.FOLLOW_REDIRECTS, hpmap.get(HspBoolPropType.FOLLOW_REDIRECTS)));
        boolPropList.add(boolproplist(HspBoolPropType.AUTO_REDIRECTS, hpmap.get(HspBoolPropType.AUTO_REDIRECTS)));
        boolPropList.add(boolproplist(HspBoolPropType.USE_KEEPALIVE, hpmap.get(HspBoolPropType.USE_KEEPALIVE)));
        boolPropList.add(boolproplist(HspBoolPropType.MULTIPART_POST, hpmap.get(HspBoolPropType.MULTIPART_POST)));
        boolPropList.add(boolproplist(HspBoolPropType.BROWSER_COMPATIBLE, hpmap.get(HspBoolPropType.BROWSER_COMPATIBLE)));

        httpSamplerProxy.setHttpBoolProp(boolPropList);

        return httpSamplerProxy;
    }

    // <HTTPSampleProxy>
    //  <stringProp>
    public static StringProp stringproplist(HspStringPropType hsp, String value) {
        StringProp stringProp = new StringProp();
        stringProp.setName(hsp.getName());
        stringProp.setValue(value);

        return stringProp;
    }

    // <HTTPSampleProxy>
    //  <boolProp>
    public static BoolProp boolproplist(HspBoolPropType hbp, String value) {
        BoolProp boolProp = new BoolProp();
        boolProp.setName(hbp.getName());
        boolProp.setValue(value);

        return boolProp;
    }

    // <HTTPSampleProxy>
    //  <elementProp>
    public static ElementProp elementPropHSP(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<CollectionProp> collectionPropList = new ArrayList<>();
        collectionPropList.add(cp(hpmap));

        elementProp.setName("HTTPsampler.Arguments");
        elementProp.setElementType("Arguments");
        elementProp.setGuiclass("HTTPArgumentsPanel");
        elementProp.setTestclass("Arguments");
        elementProp.setEnabled("true");
        elementProp.setCollectionPropList(collectionPropList);

        return elementProp;
    }

    //  <collection>
    public static CollectionProp cp(HashMap<Enum, String> hpmap) {
        CollectionProp collectionProp = new CollectionProp();
        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(ep(hpmap));

        collectionProp.setName("Arguments.arguments");
        collectionProp.setElementPropList(elementPropList);

        return collectionProp;
    }

    //  <collection>
    //      <elementProp>
    public static ElementProp ep(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<BoolProp> boolPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();

        boolPropList.add(bp(BoolPropType.ENCODE, hpmap.get(BoolPropType.ENCODE)));
        boolPropList.add(bp(BoolPropType.EQUALS, hpmap.get(BoolPropType.EQUALS)));

        stringPropList.add(sp(StringPropType.VALUE, hpmap.get(StringPropType.VALUE)));
        stringPropList.add(sp(StringPropType.METADATA, hpmap.get(StringPropType.METADATA)));
        stringPropList.add(sp(StringPropType.NAME, hpmap.get(StringPropType.NAME)));

        elementProp.setName("id");
        elementProp.setElementType("HTTPArgument");

        if (hpmap.get(StringPropType.VALUE) == null) {
            return null;
        } else {
            elementProp.setBoolPropList(boolPropList);
            elementProp.setStringPropList(stringPropList);
            return elementProp;
        }

    }

    //  <collection>
    //      <elementProp>
    //          <boolProp>
    public static BoolProp bp(BoolPropType bp, String value) {
        BoolProp boolProp = new BoolProp();
        boolProp.setName(bp.getName());
        boolProp.setValue(value);

        return boolProp;
    }

    //  <collection>
    //      <elementProp>
    //          <stringProp>
    public static StringProp sp(StringPropType sp, String value) {
        StringProp stringProp = new StringProp();
        stringProp.setName(sp.getName());
        stringProp.setValue(value);

        return stringProp;
    }
}
