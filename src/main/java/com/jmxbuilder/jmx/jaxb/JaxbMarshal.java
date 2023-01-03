package com.jmxbuilder.jmx.jaxb;

import com.jmxbuilder.jmx.dto.entity.FileEntity;
import com.jmxbuilder.jmx.dto.jaxb.Hsp;
import com.jmxbuilder.jmx.dto.repo.FileRepository;
import com.jmxbuilder.jmx.dto.tag.*;
import com.jmxbuilder.jmx.parsing.ExcelToObject;
import com.jmxbuilder.jmx.xmltagsdata.httpsampleproxy.HspTag;
import com.jmxbuilder.jmx.xmltagsdata.jmetertestplan.JmeterTestPlanTag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * packageName    : com.jmxtestbuilder.toy.common
 * fileName       : Test
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */
public class JaxbMarshal {

    private static final String xmlHspPath = "/app/download/xml/hsp.xml";

    private static final String xmlTestPlanPath = "/app/download/xml/testPlan.xml";

    // Jaxb Marshaling to <JmeterTestPlan>
    public void createTestPlanFile() throws JAXBException, IOException {
        File testplanFile = new File(xmlTestPlanPath);
        JAXBContext testPlanJC = JAXBContext.newInstance(JmeterTestPlan.class);
        Marshaller marshaller = testPlanJC.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(JmeterTestPlanTag.jmeterTestPlan(), testplanFile);
    }

    // Jaxb Marshaling to <HttpSamplProxy>
    public void createHspFile(String orgSavedPath) throws JAXBException, IOException {

        StringWriter sw = new StringWriter();
        FileWriter fw = new FileWriter(xmlHspPath);
        Hsp hsp = new Hsp();

        // Excel Data List 가져오기
        hsp.setParamsList(ExcelToObject.readExcel(orgSavedPath));

        // Excel Data List String Append
        JAXBContext jaxbContext = JAXBContext.newInstance(HTTPSamplerProxy.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        for (int i = 1; i < hsp.getParamsList().size(); i++) {
            marshaller.marshal(HspTag.httpSamplerProxy(ObjectMapping.parsingData(orgSavedPath, i)), sw);
            sw.append("\n<hashTree/>\n");
        }
        fw.write(sw.toString());
        fw.close();
    }
}