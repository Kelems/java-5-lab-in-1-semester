<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Домашняя странница</title>
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
            <h2>Hello World!</h2>

            <a href="ImageServlet">
                <button>Открыть поиск изображений</button>
            </a>
        </div>
    </body>
</html>
