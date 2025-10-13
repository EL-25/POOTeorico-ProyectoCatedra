<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asociación Exitosa</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #e8f5e9;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #2e7d32;
        }
        a {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #2e7d32;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #1b5e20;
        }
    </style>
</head>
<body>
<h1>¡Cliente asociado exitosamente!</h1>
<a href="${pageContext.request.contextPath}/asociar/asociarCliente.jsp">Volver</a>
</body>
</html>
