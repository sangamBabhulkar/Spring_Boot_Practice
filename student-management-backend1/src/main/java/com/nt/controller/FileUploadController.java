package com.nt.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("http://localhost:5173")
public class FileUploadController {

    private final String UPLOAD_DIR =
            System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/upload")
    public String uploadImage(
            @RequestParam("file") MultipartFile file)
            throws IOException {

        if (file.isEmpty()) {
            return "File is empty";
        }

        String originalName =
                file.getOriginalFilename();

        String newFileName =
                UUID.randomUUID()
                + "_"
                + originalName;

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        Files.copy(
            file.getInputStream(),
            Paths.get(
                UPLOAD_DIR + newFileName
            )
        );

        return newFileName;
    }
}