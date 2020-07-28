package com.azhar.scannerrestapi;

import com.azhar.scannerrestapi.models.Bug;
import com.azhar.scannerrestapi.services.FileService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.umd.cs.findbugs.BugInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.azhar.Application;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

import static com.sun.activation.registries.LogSupport.log;

@RestController
public class ReportController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @Autowired
    FileService fileService;

    @GetMapping("/files")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public Report uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        Path p = fileService.uploadFile(file);
        Report r = scanFile(p);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return r;
    }

    private Report scanFile(Path p) {
        ArrayList<Bug> data = new ArrayList<>();
        System.out.println(p.toAbsolutePath());
        Report r = new Report(counter.incrementAndGet(), "");
        try {
            Application a = new Application();
            Collection<BugInstance> bugs = a.findBugs(p.toAbsolutePath().toString());
            for (BugInstance b :
                    bugs) {
                Bug bug = new Bug(b.getPrimarySourceLineAnnotation().toString(),b.getMessage(),b.getType());
                data.add(bug);

            }
            r.setBugList(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }

}