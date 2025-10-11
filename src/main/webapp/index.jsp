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
    <title>Inicio | Consorcio Financiero</title>
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
        }
        header {
            background-color: var(--azul-udb);
            color: white;
            padding: 30px 0;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
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
            padding: 40px 20px;
            text-align: center;
        }
        .estado {
            margin: 20px auto;
            font-size: 18px;
            color: <%= conexionExitosa ? "var(--verde-ok)" : "var(--rojo-error)" %>;
            font-weight: bold;
        }
        .boton {
            display: inline-block;
            margin-top: 30px;
            padding: 12px 24px;
            background-color: var(--azul-claro);
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .boton:hover {
            background-color: #003f7f;
        }
        footer {
            padding: 20px;
            font-size: 13px;
            color: #777;
            background-color: #eaeaea;
            text-align: center;
        }
        html, body {
            height: 100%;
            margin: 0;
            display: flex;
            flex-direction: column;
        }

        main {
            flex: 1; /* Esto empuja el footer hacia abajo */
            padding: 40px 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<header>
    <h1>Consorcio Financiero</h1>
    <p>Sistema institucional de gestión académica</p>
</header>

<main>
    <h2>Bienvenido al sistema</h2>
    <p class="estado"><%= estadoConexion %></p>
    <a class="boton" href="#">Acceder al módulo principal</a>
</main>

<footer>
    &copy; 2025 Universidad Don Bosco — Proyecto de Cátedra
</footer>
</body>
</html>