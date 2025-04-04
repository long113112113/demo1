package com.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtractFromExcel {
    String filePath = "d:\\lab_sparkminds\\demoexelv2\\hang.xlsx"; // default source

    // Thêm method extractFile() để giải nén file Excel vào folder 'midle'
    public void extractFile() throws IOException {
        Path source = Paths.get(filePath);
        Path destinationDir = Paths.get("D:\\lab_sparkminds\\demoexelv2\\src\\main\\java\\com\\example\\midle");
        
        // Create destination directory if it doesn't exist
        Files.createDirectories(destinationDir);
        
        // Extract only specific files from the .xlsx file
        try (ZipFile zipFile = new ZipFile(source.toFile())) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String entryName = entry.getName();
                
                // Check if entry is one of our target files
                if (entryName.equals("xl/worksheets/sheet1.xml") || entryName.equals("xl/sharedStrings.xml")) {
                    // Extract just the filename without path
                    String fileName = Paths.get(entryName).getFileName().toString();
                    Path entryPath = destinationDir.resolve(fileName);
                    
                    try (InputStream in = zipFile.getInputStream(entry);
                         OutputStream out = Files.newOutputStream(entryPath)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    }
                    System.out.println("Extracted: " + fileName);
                }
            }
        }
        System.out.println("Extraction complete");
    }
}
