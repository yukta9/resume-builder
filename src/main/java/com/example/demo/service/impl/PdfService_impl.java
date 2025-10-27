package com.example.demo.service.impl;

import com.example.demo.service.PdfService;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PdfService_impl implements PdfService {

    @Override
    public String aiAnalysis(InputStream file, String role ) {
       return " ";
    }
}
