<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .mensaje-exito {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .mensaje-exito h2 {
            color: green;
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
<div class="mensaje-exito">
    <h2>REGISTRO COMPLETADO CON ¡ÉXITO!</h2>
    <a href="../menu.jsp" class="boton">Volver al Menú</a>
</div>
</body>
</html>