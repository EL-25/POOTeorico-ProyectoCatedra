<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Asociar Clientes a una Institución</title>
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
        .error {
            color: var(--rojo-error);
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<header>
    <h1>Asociar Clientes a una Institución</h1>
</header>
<main>
    <!-- 🔍 Formulario de búsqueda -->
    <form method="post" action="${pageContext.request.contextPath}/AsociarClienteServlet">
        <input type="hidden" name="accion" value="buscar" />
        <label for="idCliente">ID o DUI:</label>
        <input type="text" id="idCliente" name="idCliente" required value="${requestScope.idCliente}" />
        <button type="submit" class="boton">Buscar</button>
    </form>

    <!-- 🔗 Formulario de asociación -->
    <form method="post" action="${pageContext.request.contextPath}/AsociarClienteServlet">
        <input type="hidden" name="accion" value="asociar" />
        <input type="hidden" name="idCliente" value="${requestScope.idCliente}" />

        <label for="nombre">NOMBRE:</label>
        <input type="text" id="nombre" class="readonly" readonly value="${requestScope.nombre}" />

        <div class="grupo">
            <label>INSTITUCIONES ASOCIADO:</label>
            <div class="lista">
                <%
                    List<String> asociadas = (List<String>) request.getAttribute("institucionesAsociadas");
                    if (asociadas != null && !asociadas.isEmpty()) {
                        for (String inst : asociadas) {
                %>
                • <%= inst %><br/>
                <%
                    }
                } else {
                %>
                Sin asociaciones registradas.
                <%
                    }
                %>
            </div>
        </div>

        <div class="grupo">
            <label for="idInstitucion">INSTITUCIONES DISPONIBLES:</label>
            <select id="idInstitucion" name="idInstitucion" required>
                <option value="">-- Seleccione una institución --</option>
                <%
                    List<String> disponibles = (List<String>) request.getAttribute("institucionesDisponibles");
                    if (disponibles != null) {
                        for (String inst : disponibles) {
                %>
                <option value="<%= inst %>"><%= inst %></option>
                <%
                        }
                    }
                %>
            </select>
            <%
                String accion = request.getParameter("accion");
                String idInstitucion = request.getParameter("idInstitucion");
                if ("asociar".equals(accion) && (idInstitucion == null || idInstitucion.isEmpty())) {
            %>
            <div class="error">¡Selecciona un elemento de la lista!</div>
            <%
                }
            %>
        </div>

        <button type="submit" class="boton">ASOCIAR CLIENTE</button>
    </form>
</main>
</body>
</html>
