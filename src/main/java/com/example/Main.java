package com.example;

import com.example.service.ExtractFromExcel;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {  
        try {
            new ExtractFromExcel().extractFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}