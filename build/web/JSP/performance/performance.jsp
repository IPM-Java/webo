<<<<<<< HEAD
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
=======
>>>>>>> 8cfcf9c6d2fc32aa5cd472a3ed6976d53b064c1e
<%@page import="business.Bilan"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Mes performances</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="Public/css/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>             
    </head>   
    <body class="h-100">
        <%@include file="../../Template/user/header.html" %>
<<<<<<< HEAD
        <div class="container-md mt-5">
            <h1>Peformance: </h1> 
            <div class="row">
                <div class="col-md-8">         
                    <table class = "table table-hover table-striped mt-3">
                        <thead class="thead-dark">
                        <th> Date de la séance </th>
                        <th> Fc1min </th>
                        <th> FC30Flexions </th>
                        <th> FC5Mins </th>
                        <th> Indice de Dickson </th>
                        </thead>
                        <tbody>
                            <%//Récupération de la liste avec les attributs.
                                ArrayList<Bilan> bilans = (ArrayList<Bilan>) request.getAttribute("bilans");
                                for (Bilan b : bilans) {
                                    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy");                                  
                                    out.println("<tr>");
                                    out.println("<td>" + ft.format((Date)b.getDateoccprog()) + "</td>");
                                    out.println("<td>" + b.getFc1min() + "</td>");
                                    out.println("<td>" + b.getFc30flexions() + "</td>");
                                    out.println("<td>" + b.getFc5mins() + "</td>");
                                    out.println("<td>");
                                        out.println("<div class=\"indiceDickson\">" + b.getIndiceDickson() + "</div>");
                                    out.println("</td>");
                                    out.println("</tr>");
                                }%>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4 pl-2">
                    <div class = "card mt-3"> 
                        <div class = "card-body"> 
                            <canvas id="chLine"></canvas>
                        </div> 
                    </div>   
                </div>
=======
        <div class="container mt-5">
            <div class="jumbotron">
                <h1>Peformance: </h1>
                
                <table>
            <tr>
                <th>Fc1min</th>
                <th>Pseudo</th>
                <th>Message</th>               
            </tr>
          
            <%
                //Récupération de la liste avec les attributs. 
                ArrayList<Bilan> bilans = (ArrayList<Bilan>) request.getAttribute("bilans");
                
               //création de mes lignes du tableau
               for (Bilan b :bilans)
               {
                   out.println("<td>" + b.getFc1min() + "</td>");
                   out.println("<td>" + b.getFc30flexions() + "</td>");
                   out.println("<td>" + b.getFc5mins()+ "</td></tr>");
               }

                %>
        </table>
>>>>>>> 8cfcf9c6d2fc32aa5cd472a3ed6976d53b064c1e
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
        <script type ="text/JavaScript" src ="Public/javascript/main.js"></script>
        <script>window.addEventListener("load", graphe);</script>
    </body> 
</html>
