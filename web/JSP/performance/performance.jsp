<%@page import="business.Exercice"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        <div class="container-md mt-5">
            <h1>Performances </h1> 
            <div class="row">
                <div class="col-md-8">                    
                    <table class = "table table-hover table-striped mt-3">
                        <thead class="thead-dark">
                        <th> Date de la séance </th>
                        <th> Fc1min </th>
                        <th> FC30Flexions </th>
                        <th> FC5Mins </th>
                        <th> Indice de Dickson </th>
                        <th> FC Cible </th>
                        </thead>
                        <tbody>
                            <%//Récupération de la liste avec les attributs.
                                ArrayList<Bilan> bilans = (ArrayList<Bilan>) request.getAttribute("bilans");
                                for (Bilan b : bilans) {
                                    SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
                                    out.println("<tr>");
                                    out.println("<td>" + ft.format((Date) b.getDateReal()) + "</td>");
                                    out.println("<td>" + b.getFc1min() + "</td>");
                                    out.println("<td>" + b.getFc30flexions() + "</td>");
                                    out.println("<td>" + b.getFc5mins() + "</td>");                                    
                                    out.println("<td>");
                                    out.println("<div class=\"indiceDickson\">" + b.getIndiceDickson() + "</div>");
                                    out.println("</td>");
                                    out.println("<td>" + b.getFormuleK()+ "</td>");
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
            </div>
            <H2>Exercices </H2>
            <table class = "table table-hover table-striped mt-3">
                <thead class="thead-dark">  
                <th> Nom Exercice </th>
                <th> Répétitions </th>
                <th> Temps </th>                        
                </thead>
                <tbody>
                    <%//Récupération de la liste avec les attributs.
                        for (Bilan b : bilans) {
                            ArrayList<Exercice> exercices = b.getExercices();
                            SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
                            ft.format((Date) b.getDateReal());
                            out.println("<tr><td colspan=\"3\" class=\"table-primary\" align=\"center\">" + ft.format((Date)b.getDateReal()) + "</td></tr>");
                            for (Exercice e : exercices) {
                                out.println("<tr>");
                                out.println("<td>" + e.getNomEx() + "</td>");
                                out.println("<td>" + e.getNbRep() + "</td>");
                                out.println("<td>" + e.getNbTemps() + "</td>");
                                out.println("</tr>");
                            }
                        }
                    %>
                </tbody>
            </table>
            <h2>Mensurations </h2>
            <table class = "table table-hover table-striped mt-3">
                <thead class="thead-dark">
                <th> Bras </th>    
                <th> Poitrine </th>
                <th> Taille </th>
                <th> Hanches </th>                        
                <th> Cuisses </th>  
                <TR>
                    </thead>
                <tbody>
                    <%//Récupération de la liste avec les attributs.
                        ArrayList<Bilan> mensurations = (ArrayList<Bilan>) request.getAttribute("bilans");
                        for (Bilan b : mensurations) {
                            out.println("<tr>");
                            out.println("<td>" + b.getBras() + "</td>");
                            out.println("<td>" + b.getPoitrine() + "</td>");
                            out.println("<td>" + b.getTaille() + "</td>");
                            out.println("<td>" + b.getHanches() + "</td>");
                            out.println("<td>" + b.getCuisses() + "</td>");
                            out.println("</tr>");
                        }%>
                </tbody>
            </table>
        </div>       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
        <script type ="text/JavaScript" src ="Public/javascript/main.js"></script>
        <script>window.addEventListener("load", main);</script>
    </body> 
</html>
