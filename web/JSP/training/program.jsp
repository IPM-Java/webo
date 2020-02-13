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
        <style>
            ul a {
                text-decoration: none !important;
                color: black;
            }
        </style>
    </head>   
    <body class="h-100">
        <%@include file="../../Template/user/header.html" %>
        <div class="container mt-5">
            <div class="jumbotron px-5 py-5">
                <div class="row"><h4 class="display-4">Mon Programme</h4></div>
                <hr>
                <%
                    Program programme = (Program)request.getAttribute("programme");
                    out.println("<p>" + programme.getNomP() + "</p>");
                    out.println("<p>" + programme.getDescriptionP()+ "</p>");
                %>                   

                <%//Récupération de la liste avec les attributs.
                    //Float tauxReal = (Float) request.getAttribute("tauxReal");
                    //out.println("<progress value=" + tauxReal + " max='1' style=\"width: 100%\">" + tauxReal + "</progress>");
                %>

                <div class="row"><h4 class="display-4 mt-3">Mes séances</h4></div>
                <hr>
                <ul class="list-group">
                    <%
                        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String date = sDateFormat.format(new java.util.Date());
                        int nbweek = SeanceModel.getWeekOfYear(date);
                        String link;
                        for (Seance s : (ArrayList<Seance>) request.getAttribute("seances")) {                               
                            if ("Bilan".equals(s.getNomS())) {
                                link = "BilanServlet?occurence=" + s.getIdO();
                            } else {
                                link = "ExerciceServlet?occurence=" + s.getIdO();
                            }                            
                            if (s.getNumSem() == nbweek) {
                                out.println("<a href=\"" + link + "\"><li class=\"list-group-item list-group-item-light\">"
                                        + s.getNumSem() + " " +  s.getNomS() + " : <br>" + s.getDescriptif()                                                                           
                                        + "</li></a>");                              
                            } else if (s.getNumSem() < nbweek) {
                                String classFormat;
                                if (s.isCompleted()) {
                                    classFormat = "list-group-item-success";
                                } else {
                                    classFormat = "list-group-item-danger";
                                }
                                out.println("<a href=\"" + link + "\"><li class=\"list-group-item " + classFormat + "\">"
                                        + s.getNumSem() + "     " +  s.getNomS() + " : <br>" + s.getDescriptif()                                                                           
                                        + "</li></a>");    
                            } else {
                                out.println("<li class=\"list-group-item list-group-item-secondary\">"
                                        + s.getNumSem() + " " +  s.getNomS() + " : <br>" + s.getDescriptif()                                                                           
                                        + "</li>");                                  
                            }
                            out.println("</tr>");
                        }                            
                    %>                        
                </ul>
            </div>
        </div>
    </body> 
</html>

