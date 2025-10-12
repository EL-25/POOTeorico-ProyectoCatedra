<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String tipoError = request.getParameter("error");
    String mensaje = "Ha ocurrido un error inesperado.";

    if ("campos".equals(tipoError)) {
        mensaje = "¡DATOS INVÁLIDOS O CAMPOS VACÍOS!";
    } else if ("duplicado".equals(tipoError)) {
        mensaje = "¡EL CLIENTE YA ESTÁ REGISTRADO!";
    } else if ("formato".equals(tipoError)) {
        mensaje = "¡FORMATO DE DATOS INCORRECTO!";
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error en Registro</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .mensaje-error {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .mensaje-error h2 {
            color: red;
            margin-bottom: 20px;
        }
        .boton {
            background-color: #0055a5;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
        }
        .boton:hover {
            background-color: #003f7f;
        }
    </style>
</head>
<body>
<div class="mensaje-error">
    <h2><%= mensaje %></h2>
    <a href="registrarCliente.jsp" class="boton">Cerrar</a>
</div>
</body>
</html>