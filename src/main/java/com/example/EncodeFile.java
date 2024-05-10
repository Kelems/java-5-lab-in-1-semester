package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class EncodeFile {
    static String encodeFileToBase64(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(file.toPath());   // Получаем все байты файла обозначенного на пути
        return Base64.getEncoder().encodeToString(bytes);   // Кодируем в кодировке Base64
    }
}
