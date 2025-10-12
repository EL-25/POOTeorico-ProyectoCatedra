<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro Exitoso de Institución</title>
    <style>
        :root {
            --azul-udb: #003366;
            --verde-ok: #2e7d32;
            --gris-fondo: #f4f6f9;
        }
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: var(--gris-fondo);
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
            text-align: center;
            border-radius: 8px;
        }
        h2 {
            color: var(--verde-ok);
            margin-bottom: 20px;
        }
        .botonera {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 30px;
        }
        .boton {
            padding: 12px 24px;
            background-color: var(--azul-udb);
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .boton:hover {
            background-color: #002244;
        }
    </style>
</head>
<body>
<header>
    <h1>Registro de Institución Financiera</h1>
</header>
<main>
    <h2>
        <%= request.getAttribute("mensajeExito") != null
                ? request.getAttribute("mensajeExito")
                : "¡Institución registrada exitosamente!" %>
    </h2>
    <div class="botonera">
        <a href="<%= request.getContextPath() %>/institucion/registrarInstitucion.jsp" class="boton">Registrar Otra Institución</a>
        <a href="<%= request.getContextPath() %>/menu.jsp" class="boton">Volver al Menú Principal</a>
    </div>
</main>
</body>
</html>
