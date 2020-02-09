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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>   
    <body class="h-100">
        <%@include file="../../Template/user/header.html" %>
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
            </div>
        </div>
    </body> 
</html>
