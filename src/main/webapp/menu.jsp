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
            --rojo-salida: #c62828;
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
            padding: 30px 0 10px;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 28px;
        }
        header p {
            margin: 10px 0 0;
            font-size: 18px;
        }
        main {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 40px 20px;
        }
        .intro {
            font-size: 20px;
            color: var(--azul-claro);
            margin-bottom: 25px;
            font-weight: bold;
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
        .boton-salir {
            background-color: var(--rojo-salida);
        }
        .boton-salir:hover {
            background-color: #a00000;
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
    <p>Bienvenido al sistema</p>
</header>

<main>
    <div class="intro">Seleccione una opción</div>
    <div class="botonera">
        <a class="boton" href="consorcio/registrarConsorcio.jsp">Registrar Consorcio</a>
        <a class="boton" href="institucion/registrarInstitucion.jsp">Registrar una Institución</a>
        <a class="boton" href="cliente/registrarCliente.jsp">Registrar Cliente</a>
        <a class="boton" href="asociar/asociarCliente.jsp">Asociar Cliente a Institución</a>
        <a class="boton" href="#">Ver Datos Guardados</a>
        <a class="boton boton-salir" href="index.jsp">Salir del Sistema</a>
    </div>
</main>

<footer>
    &copy; 2025 Universidad Don Bosco — Proyecto de Cátedra
</footer>
</body>
</html>