package com.ict.user03.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    private final Path fileStorageLocation = Paths.get("uploads");

    public FileUploadController() {
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (IOException ex) {
            throw new RuntimeException("디렉토리를 생성할 수 없습니다.", ex);
        }
    }

    @PostMapping("/upload")
    public UploadFileResponse uploadFile(@RequestParam("upload") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/uploads/")
                    .path(fileName)
                    .toUriString();

            return new UploadFileResponse(true, fileDownloadUri);
        } catch (IOException ex) {
            throw new RuntimeException("파일 업로드 실패", ex);
        }
    }

    public static class UploadFileResponse {
        private boolean uploaded;
        private String url;

        public UploadFileResponse(boolean uploaded, String url) {
            this.uploaded = uploaded;
            this.url = url;
        }

        // getters and setters
    }
}
