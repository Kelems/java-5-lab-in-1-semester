package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Base64;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем параметры запроса
        String imageName = request.getParameter("imageName");
        String extensionFile = request.getParameter("extensionFile");

        // Проверяем, что имя изображения не пустое
        if (imageName == null || imageName.isEmpty()) {
            request.setAttribute("error", "Название не задано");
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

        // Отправляем HTML-страницу с изображением
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + imageName + "</h1>");
        out.println("<img src=\"data:image/jpeg;base64," + encodeFileToBase64Binary(imageFile) + "\" />");
        out.println("</body></html>");
    }

    // Метод для кодирования файла в Base64
    private String encodeFileToBase64Binary(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(bytes);
    }
}