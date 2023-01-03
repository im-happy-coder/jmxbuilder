package com.jmxbuilder.jmx.controller;

import com.jmxbuilder.jmx.dto.entity.FileEntity;
import com.jmxbuilder.jmx.dto.repo.FileRepository;
import com.jmxbuilder.jmx.jaxb.JaxbMarshal;
import com.jmxbuilder.jmx.jaxb.ObjectMapping;
import com.jmxbuilder.jmx.service.JmxService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class JmxController {

    private final JmxService jmxService;

    private final FileRepository fileRepository;

    @GetMapping("/upload")
    public String upload() {
        return "jmx/upload";
    }

    @GetMapping("/view")
    public String view(Model model) {
        List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all", files);
        return "jmx/view";
    }

    @PostMapping("/view/read")
    public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException, JAXBException {

        model.addAttribute("datas", jmxService.read(file));
        jmxService.saveFile(file);

        return "jmx/read";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadAttach(@PathVariable Long id) throws IOException, JAXBException {

        JaxbMarshal jaxbMarshal = new JaxbMarshal();

        FileEntity file = fileRepository.findById(id).orElse(null);

        jaxbMarshal.createTestPlanFile();

        jaxbMarshal.createHspFile(file.getOrgSavePath());

        jmxService.xmlMerge();

        String encodedFileName = UriUtils.encode("export.jmx", StandardCharsets.UTF_8);

        UrlResource resource = new UrlResource("file:" + file.getJmxSavePath());

        String contentDisposition = "attachement; filename=\"" + encodedFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
    }

}
