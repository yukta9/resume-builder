package com.example.demo.service;

import java.io.InputStream;

public interface PdfService {
    String aiAnalysis(InputStream file, String role);
}
