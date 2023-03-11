package com.turedurenaru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
    public static File createUniqueFile(File directory, String fileName) {
        String name;
        String extention;
        if (fileName.contains(".")) {
            name = fileName.split("\\.")[0];
            extention = "." + fileName.split("\\.")[1];
        } else {
            name = fileName;
            extention = "";
        }
        int counter = 0;
        do {
            String uniqueName = String.format("%s%03d%s", name, ++counter, extention);
            File f = new File(directory, uniqueName);
            if (!f.exists()) {
                return f;
            }
        } while (true);
    }
}