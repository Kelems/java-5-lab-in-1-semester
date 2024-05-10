package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем параметры запроса
        String imageName = request.getParameter("imageName");
        String extensionFile = request.getParameter("extensionFile");

        // Проверяем, что имя изображения не пустое
        if (imageName == null || imageName.isEmpty()) {
            request.setAttribute("error", "Введите название требуемого изображения");
            request.getRequestDispatcher("/imageForm.jsp").forward(request, response);
            return;
        }

        // Формируем путь к изображению
        String imagePath = "C:/Users/Mishpaha/Desktop/java/java-5-lab-in-1-semester/src/main/resources/images/" + imageName + extensionFile;
        File imageFile = new File(imagePath);

        // Проверяем, существует ли файл
        if (!imageFile.exists()) {
            request.setAttribute("error", "Изображение не обрнаружено по адресу: " + imagePath);
            request.getRequestDispatcher("/imageForm.jsp").forward(request, response);
            return;
        }

        // Устанавливаем атрибут imageData в запросе и перенаправляем на imageShow.jsp
        request.setAttribute("imageData", EncodeFile.encodeFileToBase64(imageFile));
        request.getRequestDispatcher("/imageShow.jsp").forward(request, response);
    }
}