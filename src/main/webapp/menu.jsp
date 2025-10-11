<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Menú Principal | Consorcio Financiero</title>
    <style>
        :root {
            --azul-udb: #003366;
            --azul-claro: #0055a5;
            --gris-fondo: #f4f6f9;
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
            padding: 40px 20px;
        }
        h2 {
            color: var(--azul-claro);
            margin-bottom: 30px;
        }
        .botonera {
            display: flex;
            flex-direction: column;
            gap: 15px;
            align-items: center;
        }
        .boton {
            display: inline-block;
            padding: 12px 24px;
            background-color: var(--azul-claro);
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 16px;
            transition: background-color 0.3s ease;
            width: 250px;
            text-align: center;
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
    </style>
</head>
<body>
<header>
    <h1>CONSORCIO FINANCIERO</h1>
    <p>Menú Principal</p>
</header>

<main>
    <h2>Seleccione una opción</h2>
    <div class="botonera">
        <a class="boton" href="consorcio/registrarConsorcio.jsp">Registrar Consorcio</a>
        <a class="boton" href="usuario/registrarUsuario.jsp">Registrar Usuario</a>
        <a class="boton" href="#">Ver Datos Guardados</a>
        <a class="boton" href="index.jsp">Salir del Sistema</a>
    </div>
</main>

<footer>
    &copy; 2025 Universidad Don Bosco — Proyecto de Cátedra
</footer>
</body>
</html>