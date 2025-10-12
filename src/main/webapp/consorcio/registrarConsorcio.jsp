<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Consorcio</title>
    <style>
        :root {
            --azul-udb: #003366;
            --azul-claro: #0055a5;
            --rojo-error: #c62828;
            --verde-ok: #2e7d32;
        }
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: var(--azul-udb);
            color: white;
            padding: 20px;
            text-align: center;
        }
        main {
            padding: 40px;
            max-width: 600px;
            margin: auto;
            background-color: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: var(--azul-udb);
        }
        label {
            display: block;
            margin-top: 20px;
            font-weight: bold;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .boton {
            margin-top: 30px;
            padding: 12px 24px;
            background-color: var(--azul-claro);
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }
        .boton:hover {
            background-color: #003f7f;
        }
        .error {
            color: var(--rojo-error);
            font-weight: bold;
            margin-top: 10px;
        }
        .volver {
            display: inline-block;
            text-align: center;
            text-decoration: none;
            margin-left: 10px;
            background-color: #777;
        }
        .volver:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<header>
    <h1>Registrar Consorcio</h1>
</header>
<main>
    <form action="${pageContext.request.contextPath}/registrarConsorcio" method="post">
        <label for="idConsorcio">ID del Consorcio:</label>
        <input type="text" id="idConsorcio" name="idConsorcio" required pattern="[A-Za-z0-9]{3,}" title="Mínimo 3 caracteres alfanuméricos">

        <label for="nombreConsorcio">Nombre del Consorcio:</label>
        <input type="text" id="nombreConsorcio" name="nombreConsorcio" required pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,}" title="Solo letras, mínimo 3 caracteres">

        <button type="submit" class="boton">Guardar</button>
        <a href="${pageContext.request.contextPath}/menu.jsp" class="boton volver">Volver</a>

        <%
            String error = (String) request.getAttribute("mensajeError");
            if (error != null) {
        %>
        <p class="error"><%= error %></p>
        <%
            }
        %>
    </form>
</main>
</body>
</html>