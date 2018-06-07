<%-- 
    Document   : registroHabitacion
    Created on : 6/06/2018, 06:16:23 PM
    Author     : cgaop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   < <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../../../favicon.ico">

        <title>HABITACIONES</title>

        <!-- Bootstrap core CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/css/jumbotron.css" rel="stylesheet">
    </head>

    <body>

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

            <a class="navbar-brand" href="#">Aplicacion - HABITACIONES -</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/index.jsp">Inicio</a>
                    </li>                                      
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.servletContext.contextPath}/HabitacionServlet?accion=listar">Listar Habitaciones</a>
                    </li>

                </ul>        
            </div>
        </nav>

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">

                    <!-- FORM INVOCA AL SERVLET -->
                    <form method="post" action="${pageContext.servletContext.contextPath}/HabitacionServlet">

                        <div class="form-row">
                            <div class="col">
                                <input type="text" name="txtidhabitacion" class="form-control" placeholder="id habitacion">
                            </div>  
                            <div class="col">
                                <input type="number" name="txtcamas" class="form-control" placeholder="Numero de camas">
                            </div>
                        </div>

                        <div class="form-row">                            
                            <div class="col-sm-3">
                                <label for="inputState">Tipo Habitacion</label>                                 
                            </div>
                            <div class="col-sm-3"> 
                                <select id="inputState" class="form-control" name="txttipo">
                                    <option value="compartida">Compartida</option>
                                    <option value="privada">Privada</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">                            
                            <div class="col-sm-3">
                                <label for="inputState">Baño privado:</label>                                 
                            </div>
                            <div class="col-sm-3"> 
                                <select id="inputState" class="form-control" name="txtprivado">
                                    <option selected value="si">SI</option>
                                    <option value="no">NO</option>
                                </select>
                            </div>
                        </div>

                        <br><br><br>

                        <!-- DIV BOTONES -->
                        <center>
                            <div class="">
                                <button name="accion" value="crear" type="submit" class="btn btn-primary">Registrar Habitacion</button>
                            </div>                            
                            <!--div class="">
                                <button name="accion" value="listar" type="submit" class="btn btn-primary">Listar cursos</button>
                            </div-->
                        </center>

                    </form>

                </div>
            </div>

        </main>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

    </body>
</html>
