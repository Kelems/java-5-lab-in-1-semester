package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.*;

public class ImageServlet extends HttpServlet {
    private static final String IMAGES_DIRECTORY = "resources/images"; // Замените на правильный путь

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageName = request.getParameter("imageName");
        Path imagePath = Paths.get(IMAGES_DIRECTORY, imageName);

        if (Files.exists(imagePath)) {
            response.setContentType(getServletContext().getMimeType(imagePath.toString()));
            try (InputStream in = Files.newInputStream(imagePath);
                 OutputStream out = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h1>Image not found</h1></body></html>");
        }
    }
}