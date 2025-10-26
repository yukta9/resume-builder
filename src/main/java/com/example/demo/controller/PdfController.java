package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/resume")
public class PdfController {
    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdf(@RequestBody MultipartFile file, @RequestParam String role){
        return ResponseEntity.ok("route working");
    }
}
