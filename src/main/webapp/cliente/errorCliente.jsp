<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String tipoError = request.getParameter("error");
    String mensaje = "Ha ocurrido un error inesperado.";

    if ("campos".equals(tipoError)) {
        mensaje = "¡DATOS INVÁLIDOS O CAMPOS VACÍOS!";
    } else if ("falloRegistro".equals(tipoError)) {
        mensaje = "¡No se pudo registrar el cliente. Intente nuevamente.!";
    } else if ("formato".equals(tipoError)) {
        mensaje = "¡FORMATO DE DATOS INCORRECTO!";
    }

    // Mensajes dinámicos desde el servlet
    String mensajeError = (String) request.getAttribute("mensajeError");
    String mensajeInfo = (String) request.getAttribute("mensajeInfo");
    if (mensajeError != null) {
        mensaje = mensajeError;
    } else if (mensajeInfo != null) {
        mensaje = mensajeInfo;
    }

    // Color institucional según tipo de mensaje
    String color = "red";
    if (mensajeInfo != null) {
        color = "#2e7d32"; // verde institucional
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
    <h2 style="color:<%= color %>"><%= mensaje %></h2>
    <a href="cliente/registrarCliente.jsp" class="boton">Volver al formulario</a>
    <a href="../menu.jsp" class="boton" style="margin-left: 10px;">Menú Principal</a>
</div>
</body>
</html>