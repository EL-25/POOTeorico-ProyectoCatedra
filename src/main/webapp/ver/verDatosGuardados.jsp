<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.udb.consorcio.beans.DatosGuardados" %>
<html>
<head>
    <title>Ver Datos Guardados</title>
    <style>
        :root {
            --azul-udb: #003366;
            --azul-claro: #0055a5;
            --rojo-error: #c62828;
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
            padding: 30px;
            max-width: 800px;
            margin: auto;
            background-color: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-top: 20px;
            font-weight: bold;
        }
        input[type="text"], select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .readonly {
            background-color: #eee;
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
        .grupo {
            margin-top: 20px;
        }
        .lista {
            background-color: #eee;
            padding: 10px;
            border-radius: 4px;
            min-height: 60px;
        }
    </style>
    <script>
        function actualizarEtiqueta() {
            const tipo = document.getElementById("tipo").value;
            const etiqueta = document.getElementById("etiqueta-id");
            etiqueta.textContent = tipo === "cliente" ? "DUI:" : "ID:";
        }
    </script>
</head>
<body>
<header>
    <h1>Ver Datos Guardados</h1>
</header>
<main>
    <form method="post" action="${pageContext.request.contextPath}/VerDatosServlet">
        <label for="tipo">Seleccione el tipo de entidad:</label>
        <select name="tipo" id="tipo" required onchange="actualizarEtiqueta()">
            <option value="">-- Seleccione --</option>
            <option value="consorcio">Consorcio</option>
            <option value="institucion">Institución Financiera</option>
            <option value="cliente">Cliente</option>
        </select>

        <label id="etiqueta-id" for="id">ID:</label>
        <input type="text" name="id" id="id" required />

        <button type="submit" class="boton">Buscar</button>
    </form>

    <%
        String tipo = (String) request.getAttribute("tipo");
        DatosGuardados datos = (DatosGuardados) request.getAttribute("datos");

        if ("consorcio".equals(tipo) && datos.getIdConsorcio() != null) {
    %>
    <div class="grupo">
        <label>ID Consorcio:</label>
        <div class="lista"><%= datos.getIdConsorcio() %></div>

        <label>Nombre:</label>
        <div class="lista"><%= datos.getNombreConsorcio() %></div>

        <label>Fecha de Registro:</label>
        <div class="lista"><%= datos.getFechaRegistro() %></div>
    </div>
    <%
    } else if ("institucion".equals(tipo) && datos.getIdInstitucion() != null) {
    %>
    <div class="grupo">
        <label>ID Institución:</label>
        <div class="lista"><%= datos.getIdInstitucion() %></div>

        <label>Nombre:</label>
        <div class="lista"><%= datos.getNombreInstitucion() %></div>

        <label>Tipo:</label>
        <div class="lista"><%= datos.getTipoInstitucion() %></div>

        <label>Fecha de Fundación:</label>
        <div class="lista"><%= datos.getFechaFundacion() %></div>

        <label>Pertenece a Consorcio:</label>
        <div class="lista"><%= datos.getPerteneceConsorcio() %></div>
    </div>
    <%
    } else if ("cliente".equals(tipo) && datos.getIdCliente() != 0) {
    %>
    <div class="grupo">
        <label>DUI:</label>
        <div class="lista"><%= datos.getDui() %></div>

        <label>Nombre:</label>
        <div class="lista"><%= datos.getNombreCliente() %></div>

        <label>Fecha de Nacimiento:</label>
        <div class="lista"><%= datos.getFechaNacimiento() %></div>

        <label>Género:</label>
        <div class="lista"><%= datos.getGenero() %></div>

        <label>Departamento:</label>
        <div class="lista"><%= datos.getDepartamento() %></div>

        <label>Municipio:</label>
        <div class="lista"><%= datos.getMunicipio() %></div>

        <label>Complemento:</label>
        <div class="lista"><%= datos.getComplemento() %></div>
    </div>
    <%
        }
    %>
</main>
</body>
</html>

