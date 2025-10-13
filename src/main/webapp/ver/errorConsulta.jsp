<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error de Consulta</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            padding: 40px;
        }
        .contenedor {
            background-color: #f5c6cb;
            border: 1px solid #f1b0b7;
            padding: 25px;
            border-radius: 8px;
            max-width: 600px;
            margin: auto;
        }
        h1 {
            font-size: 24px;
            margin-bottom: 15px;
        }
        p {
            font-size: 18px;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 18px;
            background-color: #721c24;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #501217;
        }
    </style>
</head>
<body>
<div class="contenedor">
    <h1>Error al consultar</h1>
    <p>
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "No se recibió mensaje de error." %>
    </p>
    <a href="<%= request.getContextPath() %>/ver/verDatosGuardados.jsp">Volver al formulario</a>
    <a href="<%= request.getContextPath() %>/menu.jsp">Ir al menú</a>
</div>
</body>
</html>