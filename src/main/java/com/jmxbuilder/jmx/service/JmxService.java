package com.jmxbuilder.jmx.service;

import com.jmxbuilder.jmx.dto.entity.FileEntity;
import com.jmxbuilder.jmx.dto.jaxb.ExcelColumn;
import com.jmxbuilder.jmx.dto.repo.FileRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;

/**
 * packageName    : com.jmxbuilder.jmx.service
 * fileName       : JmxService
 * author         : im-happy-coder
 * date           : 22. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 12. 12.        im-happy-coder       최초 생성
 */

@RequiredArgsConstructor
@Service
public class JmxService {

    @Value("${org.dir}")
    private String orgPath;

    @Value("${jmx.dir}")
    private String jmxPath;

    @Value("${xml.dir}")
    private String xmlPath;

    private final FileRepository fileRepository;

    public Long saveFile(MultipartFile files) throws IOException, JAXBException {
        if (files.isEmpty()) {
            return null;
        }

        // file name export
        String origName = files.getOriginalFilename();

        // file import
        String savedPath = orgPath + origName;

        // jmx Name
        String jmxNm = "export.jmx";

        // jmx  파일
        String jmxSavedPath = jmxPath + jmxNm;

        // file Entity
        FileEntity file = FileEntity.builder()
                .orgNm(origName)
                .orgSavePath(savedPath)
                .jmxSavePath(jmxSavedPath)
                .build();

        //  오리지널 파일 저장
        files.transferTo(new File(savedPath));

        // database file save
        FileEntity savedFile = fileRepository.save(file);

        return savedFile.getId();
    }

    public List<ExcelColumn> read(MultipartFile file) throws IOException {

        List<ExcelColumn> dataList = new ArrayList<>();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("do not excel file.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 2; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Row row = worksheet.getRow(i);

            ExcelColumn data = new ExcelColumn();

            data.setUrl(row.getCell(0).getStringCellValue());


            //URL uriComponents
            UriComponents uriComponents = UriComponentsBuilder.fromUriString(data.getUrl()).build();
            MultiValueMap<String, String> queryParams = uriComponents.getQueryParams();

            // keys
            Set<String> keySet = queryParams.keySet();
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                String keys = it.next();
                queryParams.get(keys);
                String values = queryParams.get(keys).get(0);
            }
            dataList.add(data);
        }
        return dataList;
    }

    // TestPlan + HttpSampleProxy  Merge
    public void xmlMerge() throws IOException {

        File file1 = new File(xmlPath + "hsp.xml");
        File file2 = new File(xmlPath + "testPlan.xml");
        BufferedReader hspRead = new BufferedReader(new FileReader(file1));
        BufferedReader tpRead = new BufferedReader(new FileReader(file2));

        String hsp = null;
        String testPlan = null;
        StringBuilder sb = new StringBuilder();

        // HttpSampleProxy, TesPlan 합치기
        while ((testPlan = tpRead.readLine()) != null) {
            if (testPlan.equals("                </TransactionController>")) {
                sb.append(testPlan + "\n");
                sb.append("    <hashTree>\n");
                while ((hsp = hspRead.readLine()) != null) {
                    sb.append("        " + hsp + "\n");
                }
                sb.append("    </hashTree>\n");
                continue;
            }
            sb.append(testPlan + "\n");
        }
        FileWriter fw = new FileWriter(jmxPath + "export.jmx");
        fw.write(sb.toString());
        fw.close();
    }
}
