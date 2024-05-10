<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Изображение <%= request.getParameter("imageName") %></title>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
                background-color: #f0f0f0;
            }
            .container {
                text-align: center;
            }
            img {
                max-width: 100%;
                height: auto;
                max-height: 80vh; /* Фиксированная высота для изображения */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Изображение: <%= request.getParameter("imageName") + request.getParameter("extensionFile") %></h1>
            <img src="data:image/jpeg;base64,<%= request.getAttribute("imageData") %>"></img>
        </div>
        <div class="container">
            <a href="ImageServlet">
                <button>Вернуться к поиску изображений</button>
            </a>
        </div>
    </body>
</html>