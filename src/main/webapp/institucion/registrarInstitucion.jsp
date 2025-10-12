<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Institución</title>
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
        input, select {
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
        .volver {
            display: inline-block;
            text-align: center;
            text-decoration: none;
            margin-left: 10px;
            background-color: #777;
            padding: 12px 24px;
            border-radius: 6px;
            color: white;
            font-size: 16px;
        }
        .volver:hover {
            background-color: #555;
        }
        .error {
            color: var(--rojo-error);
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<header>
    <h1>Registrar Institución Financiera</h1>
</header>
<main>
    <form action="${pageContext.request.contextPath}/registrarInstitucion" method="post">

        <label for="nombre">Nombre de la Institución:</label>
        <input type="text" id="nombre" name="nombre" required pattern="[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,}" title="Solo letras, mínimo 3 caracteres">

        <label for="tipo">Tipo de Institución:</label>
        <select id="tipo" name="tipo" required>
            <option value="BANCO">BANCO</option>
            <option value="COOPERATIVA">COOPERATIVA</option>
        </select>

        <label for="fechaFundacion">Fecha de Fundación:</label>
        <input type="date" id="fechaFundacion" name="fechaFundacion" required>

        <label for="idConcorcio">Consorcio que pertenece (ID numérico):</label>
        <input type="text" id="idConcorcio" name="idConcorcio" required pattern="[0-9]{1,}" title="Solo números">

        <button type="submit" class="boton">Guardar</button>
        <a href="${pageContext.request.contextPath}/menu.jsp" class="volver">Volver</a>

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

