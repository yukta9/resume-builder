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
        try(PDDocument doc = PDDocument.load(file)){
            PDFTextStripper textStripper = new PDFTextStripper();
            textStripper.setSortByPosition(true);
            String textValue = textStripper.getText(doc);
            String prompt = String.format("""
You are an experienced resume optimization coach specializing in tailoring resumes for specific job roles.

Analyze the following resume content and provide output strictly in valid JSON format with these keys:
- "roleFitSummary": a concise summary (max 3 sentences) of how well this resume aligns with the given role.
- "suggestions": improvements focused on clarity, measurable impact, alignment with the target role, and grammatical correctness or sentence fluency.
Provide the response in this JSON format:
[
    {
       "section_name": "Project name",
       "section_improvement": "…Improvement value…"
    },
    {
       "section_name": "Experience",
       "section_improvement": "…Improvement value…"
    },
]
                    
Use the following role context: %s
Resume text:
%s
Your response must contain only the JSON object — no extra text, code fences, or commentary.""", role, normalize(textValue));
            return aiAnalyseResponse(prompt);
        }
        catch (IOException io){
            System.out.println(io);
            return "";
        }
    }

    private String aiAnalyseResponse(String normalizedText){
        Client client = Client.builder().apiKey("AIzaSyAB-HIRKGkT0AzpgWYNJ7TcrEej62LXg1Q").build();
        GenerateContentResponse response = client.models.generateContent("gemini-2.5-flash", normalizedText, null);
        return response.text();
    }

    private String normalize(String s) {
        if (s == null) return "";
        // collapse whitespace/newlines
        return s.replaceAll("\\r", "")
                .replaceAll("[\\t ]+", " ")
                .replaceAll("\\n{2,}", "\n")
                .trim();
    }
}