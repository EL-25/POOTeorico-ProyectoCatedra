<%@ page import="java.sql.Connection" %>
<%@ page import="com.udb.consorcio.dao.Conexion" %>
<%
    String estadoConexion;
    boolean conexionExitosa = false;
    try {
        Connection conn = Conexion.getConnection();
        if (conn != null){
            estadoConexion = "Conexión exitosa a la Base de Datos.";
            conexionExitosa = true;
        } else {
            estadoConexion = "No se pudo establecer la conexión.";
        }
    } catch (Exception e) {
        estadoConexion = "Error al conectar: " + e.getMessage();
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión | Consorcio Financiero</title>
    <style>
        :root {
            --azul-udb: #003366;
            --azul-claro: #0055a5;
            --gris-fondo: #f4f6f9;
            --verde-ok: #2e7d32;
            --rojo-error: #c62828;
        }
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--gris-fondo);
            color: #333;
            display: flex;
            flex-direction: column;
            height: 100vh;
        }
        header {
            background-color: var(--azul-udb);
            color: white;
            padding: 30px 0;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 28px;
        }
        header p {
            margin: 5px 0 0;
            font-size: 16px;
        }
        main {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .estado {
            margin-bottom: 20px;
            font-size: 16px;
            color: <%= conexionExitosa ? "var(--verde-ok)" : "var(--rojo-error)" %>;
            font-weight: bold;
        }
        form {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #aaa;
            width: 350px;
            text-align: left;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            margin-top: 20px;
            width: 100%;
            padding: 10px;
            background-color: var(--azul-claro);
            color: white;
            border: none;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            margin-bottom: 10px;
        }
        .usuarionew{
            text-align: center;
        }
        .usuarionew a {
            text-decoration: none;
            color: #2b2bba;
        }
        .usuarionew a:hover {
            text-decoration: underline;
        }

        button:hover {
            background-color: #003f7f;
        }
        footer {
            padding: 20px;
            font-size: 13px;
            color: #777;
            background-color: #eaeaea;
            text-align: center;
        }
    </style>
</head>
<body>
<header>
    <h1>CONSORCIO FINANCIERO</h1>
    <p>Bienvenido/a</p>
</header>

<main>
    <p class="estado"><%= estadoConexion %></p>
    <form action="login" method="post">
        <label for="idUsuario">Usuario (ID):</label>
        <input type="text" name="idUsuario" id="idUsuario" required>

        <label for="contrasena">Contraseña:</label>
        <input type="password" name="contrasena" id="contrasena" required>

        <button type="submit">Iniciar Sesión</button>
        <div class="usuarionew">
        <a href="usuario/registrarUsuario.jsp">Registrar un Usuario</a>
        </div>
    </form>
</main>

<footer>
    Términos y Condiciones | Políticas de Privacidad
</footer>
</body>
</html>