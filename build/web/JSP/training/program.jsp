<%@page import="module.training.model.SeanceModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="business.Seance"%>
<%@page import="business.Program"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Page d'accueil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="Public/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>   
    <body class="h-100">
        <%@include file="../../Template/user/header.html" %>
        <div class="container mt-5">
            <div class="jumbotron">
                <h1>Mes Entraînements</h1>     

                <h3>Programme en cours</h3>

                <table class = "table table-hover table-striped mt-3">
                    <thead class="thead-dark">                        
                        <tr>
                            <th>No.</th>
                            <th>Program </th>
                            <th>Description </th>
                        </tr>                  
                    </thead>
                    <tbody>
                        <%//Récupération de la liste avec les attributs.
                            ArrayList<Program> programs = (ArrayList<Program>) request.getAttribute("programs");
                            for (Program p : programs) {
                                out.println("<tr><td>" + p.getIdP() + "</td>");
                                out.println("<td>" + p.getNomP() + "</td>");
                                out.println("<td>" + p.getDescriptionP() + "</td></tr>");
                            }
                        %>
                    </tbody>
                </table>

                <%//Récupération de la liste avec les attributs.
                    Float tauxReal = (Float) request.getAttribute("tauxReal");
                    out.println("<progress value=" + tauxReal + " max='1' style=\"width: 100%\">" + tauxReal + "</progress>");
                %>

                <h3>Séance disponible</h3>

                <table class = "table table-hover table-striped mt-3">
                    <thead class="thead-dark">                        
                        <tr>
                            <th>Séance</th>
                            <th>occurence</th>
                            <th>Action</th>
                        </tr>                  
                    </thead>
                    <tbody>                   
                        <%//Récupération de la liste avec les attributs.
                            ArrayList<Seance> seances = (ArrayList<Seance>) request.getAttribute("seances");
                            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String date = sDateFormat.format(new java.util.Date());
                            int nbweek = SeanceModel.getWeekOfYear(date);

                            for (Seance s : seances) {
                                out.println("<tr>");
                                out.println("<td>" + s.getNomS() + "</td>");
                                out.println("<td>" + s.getIdO() + "</td>");
                                String link;
                                if ("Bilan".equals(s.getNomS())) {
                                    link = "BilanServlet?occurence=" + s.getIdO();
                                } else {
                                    link = "SeanceServlet?occurence=" + s.getIdO();
                                }
                                if (s.getNumSem() == nbweek) {
                                    out.println("<td><a href=\"" + link + "\"><button class='btn btn-success' />Commencer</button></a></td>");
                                } else if (s.getNumSem() > nbweek) {
                                    out.println("<td><a href=\"" + link + "\"><button class='btn btn-secondary' disabled='disabled'/>En attente</button></a></td>");
                                } else {
                                    out.println("<td><a href=\"" + link + "\"><button class='btn btn-dark' disabled='disabled'/>Terminer</button></a></td>");
                                }
                                out.println("</tr>");
                            }
                        %>
                    </tbody>
                </table>                         
            </div>
        </div>
    </body> 
</html>

