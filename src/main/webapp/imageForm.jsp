<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Image Form</title>
    </head>
    <body>
        <form action="imageServlet" method="get">
            <label for="imageName">Enter image name:</label>
            <input type="text" id="imageName" name="imageName">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>