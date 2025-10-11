<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6ffe6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .box {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #aaa;
            text-align: center;
            width: 400px;
        }
        h2 {
            color: #006600;
            margin-bottom: 10px;
        }
        .mensaje {
            color: #009900;
            font-weight: bold;
            margin-top: 10px;
            margin-bottom: 25px;
        }
        .botones {
            display: flex;
            justify-content: center;
            gap: 20px;
        }
        .botones a {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #006600;
            color: white;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        .botones a:hover {
            background-color: #009900;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>Registro Exitoso</h2>
    <div class="mensaje">
        <%= request.getAttribute("mensajeExito") != null ? request.getAttribute("mensajeExito") : "¡Usuario registrado exitosamente!" %>
    </div>
    <div class="botones">
        <a href="<%= request.getContextPath() %>/index.jsp">Volver al Login</a>
        <a href="<%= request.getContextPath() %>/usuario/registrarUsuario.jsp">Registrar Otro Usuario</a>
    </div>
</div>
</body>
</html>