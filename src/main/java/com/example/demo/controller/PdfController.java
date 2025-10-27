package com.example.demo.controller;

import com.example.demo.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/resume")
public class PdfController {

    @Autowired
    private  PdfService pdfService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdf(@RequestBody MultipartFile file, @RequestParam String role) throws IOException {
        return ResponseEntity.ok(pdfService.aiAnalysis(file.getInputStream(), role));
    }
}
