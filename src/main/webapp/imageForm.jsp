<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Form</title>
</head>
<body>
    <form action="ImageServlet" method="get">
        <label for="imageName">Image Name:</label>
        <input type="text" id="imageName" name="imageName">
        <input type="submit" value="Отобразить изображение">
    </form>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>