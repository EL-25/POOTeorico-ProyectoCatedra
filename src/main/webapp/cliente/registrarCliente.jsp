<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
    List<Map<String, String>> instituciones = new ArrayList<>();
    String errorCarga = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/consorcio-financiero", "consorcio_user", "consorcio1234");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id_institucion, nombre FROM institucion");

        while (rs.next()) {
            Map<String, String> inst = new HashMap<>();
            inst.put("id", rs.getString("id_institucion"));
            inst.put("nombre", rs.getString("nombre"));
            instituciones.add(inst);
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        errorCarga = "Error al cargar instituciones: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Cliente</title>
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
            max-width: 700px;
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
        .boton:hover {
            background-color: #003f7f;
        }
        .error {
            color: var(--rojo-error);
            font-weight: bold;
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<header>
    <h1>Registrar Cliente</h1>
</header>
<main>
    <% if (errorCarga != null) { %>
    <p class="error"><%= errorCarga %></p>
    <% } %>

    <form action="<%= request.getContextPath() %>/RegistrarClienteServlet" method="post">
        <label for="dui">DUI:</label>
        <input type="text" id="dui" name="dui" required pattern="\d{8}-\d" placeholder="00000000-0" title="Formato: 00000000-0">

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>

        <label for="genero">Género:</label>
        <select id="genero" name="genero" required>
            <option value="">Seleccione</option>
            <option value="Masculino">Masculino</option>
            <option value="Femenino">Femenino</option>
        </select>

        <label for="departamento">Departamento:</label>
        <input type="text" id="departamento" name="departamento" required>

        <label for="municipio">Municipio:</label>
        <input type="text" id="municipio" name="municipio" required>

        <label for="complemento">Complemento:</label>
        <input type="text" id="complemento" name="complemento">

        <label for="idInstitucion">Institución:</label>
        <select id="idInstitucion" name="idInstitucion" required>
            <option value="">Seleccione una institución</option>
            <% for (Map<String, String> inst : instituciones) { %>
            <option value="<%= inst.get("id") %>"><%= inst.get("nombre") %></option>
            <% } %>
        </select>

        <button type="submit" class="boton">Guardar</button>
        <a href="<%= request.getContextPath() %>/menu.jsp" class="boton volver">Volver</a>
    </form>
</main>
</body>
</html>