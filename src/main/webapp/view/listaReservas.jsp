<%-- 
    Document   : listaReservas
    Created on : 6/06/2018, 06:57:28 PM
    Author     : cgaop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">

        <title>LISTA RESERVAS</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/css/jumbotron.css" rel="stylesheet">
    </head>

    <body>

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

            <a class="navbar-brand" href="#">Aplicacion - LISTA RESERVAS -</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/index.jsp">INICIO</a>
                    </li> 

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/view/registroHabitacion.jsp">Registrar Habitacion</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/view/registroReserva.jsp">Registrar Reserva</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/HabitacionServlet?accion=listar">listar Habitaciones</a>
                    </li>
                    

                </ul>        
            </div>
        </nav>

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    
                    <h6><c:out value="${sessionScope.MENSAJE}"></c:out></h6>

                    <h2> TABLA </h2>
                    <br><br>

                    <table class="table">
                        <caption>Lista de reservas hechas</caption>
                        <thead>
                            <tr>
                                <th scope="col">id Reserva</th>
                                <th scope="col">id Habitacion</th>

                                <th scope="col">Camas reservadas</th>
                                <th scope="col">Precio por cama</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="reserva" items="${sessionScope.LISTADO}">
                               
                                <tr>
                                    <td><c:out value="${reserva.getIdReserva()}"/></td>
                                    <td><c:out value="${reserva.getIdHabitacionR()}"/></td>

                                    <td><c:out value="${reserva.getCamasR()}"/></td>
                                    <td><c:out value="${reserva.getPrecioCama()}"/></td>
                                    <!--td>
                                        <div class="col">
                                            <a class="btn btn-primary" 
                                               href=".../UsuariosServlet?accion=eliminar&idUser={usuario.getDocumento()}">Eliminar</a>
                                            <a class="btn btn-primary"
                                               href=".../UsuariosServlet?accion=modificar&idUser=.$..{usuario.getDocumento()}">Modificar</a>
                                        </div> 
                                    </td-->
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>

            </main>

            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

        </body>
    </html>