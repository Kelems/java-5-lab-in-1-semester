<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Отображение изображения</title>
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
        </style>
    </head>
    <body>
        <div class="container">
            <form action="ImageServlet" method="get">
                <label for="imageName">Название изображения:</label>
                <input type="text" id="imageName" name="imageName">
                <select name="extensionFile">
                    <option value=".jpg">.jpg</option>
                    <option value=".png">.png</option>
                </select>
                <input type="submit" value="Отобразить изображение">
            </form>
            <% if (request.getAttribute("error") != null) { %>
                <p style="color: red;">
                    <%= request.getAttribute("error") %>
                </p>
            <% } %>
        </div>
    </body>
</html>