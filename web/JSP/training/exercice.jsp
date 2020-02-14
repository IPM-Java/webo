<%@page import="java.util.ArrayList"%>
<%@page import="business.Exercice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body class="h-100 bg-light">
        <%@include file="../../Template/user/header.html" %>
        <div class="container mt-5 mb-5">
            <div class="row"><h4 class="display-4">Seance de la semaine X</h4></div>
            <button id="btnCancel" class="btn btn-danger mt-4" onclick="confirm('Etes-vous sûr ?');">Abandonner la séance</button>
            <div id="accordion" class="mt-1">
                <div class="card">
                    <div class="card-header py-4 px-4" id="headingOne">
                        <h5 class="mb-0" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Echauffement
                        </h5>
                    </div>
                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">

                        </div>
                    </div>
                </div>
            <%
               ArrayList<Exercice> exercices = (ArrayList<Exercice>)request.getAttribute("exercices");
               ArrayList<Integer> ids = (ArrayList)request.getAttribute("ids");              
               String heading;
               String body;
               String btnStatus;
               for (Exercice e : exercices) {
                   heading = "heading" + String.valueOf(e.getOrdre());
                   body = "collapse" + String.valueOf(e.getOrdre());
                   if (e.getOrdre() == 1) {
                       btnStatus = "";
                   } else {                      
                       btnStatus = "disabled";
                   }
            %>              
                <div <% out.println("id=\"" + e.getIdEx() + "\""); %> class="card" >
                    <div <% out.println("id=\"header-" + e.getIdEx() + "\""); %> class="card-header py-4 px-4" <% out.println("id=\"" + heading + "\""); %> >
                        <h5 class="mb-0" <% out.println("data-target=\"#" + body + "\""); %> data-toggle="collapse" 
                                  aria-expanded="false" <% out.println("aria-controls=\"#" + body + "\""); %> >
                            <% out.println("Exercice " + e.getOrdre() + " : " + e.getNomEx().toLowerCase()); %>
                        </h5>
                    </div>
                    <div <% out.println("id=\"" + body + "\""); %> class="collapse"
                            <% out.println("aria-labelledby=\"" + heading + "\""); %> data-parent="#accordion">
                        <div class="card-body">
                            <div class="row">
                                <div class="row-sm-6">
                                    <img src="Public/img/crunch.jpg" class="img-fluid" height="400" width="600" alt=""/>
                                </div>
                                <div class="row-sm-6 px-5 py-5">
                                    <p><% out.println("Faire " + e.getSerie() + " serie de " + e.getNbRep() + " répétitions" ); %></p>                                   
                                    <p class="mt-3">Cocher la case correspondante : </p>
                                    <!-- désactiver / active radio boutton -->
                                    <div class="value" <% out.println("id=\"btn-radio-" + e.getOrdre() + "\""); %>>
                                        <input type="radio" name="<% out.println("radio-ibput-" + e.getOrdre()); %>" value="Facile" class="<% out.println("resultat" + e.getIdEx()); %>">Facile
                                        <input type="radio" name="<% out.println("radio-ibput-" + e.getOrdre()); %>" value="Bien" class="<% out.println("resultat" + e.getIdEx()); %>">Bien
                                        <input type="radio" name="<% out.println("radio-ibput-" + e.getOrdre()); %>" value="Difficile" class="<% out.println("resultat" + e.getIdEx()); %>">Difficile
                                    </div>
                                    <p class="mt-3"><% out.println(e.getObjectif()); %></p>
                                </div>                                  
                            </div>
                            <div class="row d-flex justify-content-center fadeIn">
                                <button class="btn btn-danger modo" data-toggle="modal" data-target="#exampleModalCenter"
                                        <% out.println("id=\"btn-skip-" + e.getOrdre() + "\""); %> <% out.println(btnStatus); %> >Sauter exercice</button>
                                <button class="btn btn-secondary validation" <% out.println("id=\"btn-valid-" + e.getOrdre() + "\""); %> <% out.println(btnStatus); %> >Valider exercice</button>                               
                            </div>
                            <%
                                if (e.getOrdre() > 1) {
                            %>
                                <div class="row d-flex justify-content-center fadeIn" <% out.println("id=\"span-" + e.getOrdre() + "\""); %> ><small>Vous devez valider tous les exercices !</small></div>
                            <%
                                }
                            %>
                        </div>
                        <input type="hidden" <% out.println("id=\"ordre-" + e.getIdEx() + "\""); %> value="<% out.println(e.getOrdre()); %>">
                    </div>
                </div>                                
            <%
               }
            %>
                <div class="card">
                    <div class="card-header py-4 px-4" id="headingTwo">
                        <h5 class="mb-0 " data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                              Ettirements
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                            
                        </div>
                    </div>
                </div>            
            </div>
            <div class="row d-flex justify-content-center fadeIn">
                <a href="TrainingHomeServlet"><button id="btnSeance" class="btn btn-danger btn-block mt-3" disabled="disabled">Valider ma séance</button></a>
            </div>  
        </div>
        <input type="hidden" id="occ" value="<% out.println(ids.get(0).intValue()); %>">
        <input type="hidden" id="userId" value="<% out.println(ids.get(1).intValue()); %>">
        <input type="hidden" id="exos" value="<% out.println(exercices.size()); %>">
        <input type="hidden" id="cmp" value="0">
        <!-- Modal skip -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Confirmation</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Pour qu'elle raison souhaitez-vous sauter cet exercice  ?</p>
                        <div class="row d-flex justify-content-center fadeIn">
                            <button id="diff" type="button" class="btn btn-danger mr-2 skip" data-dismiss="modal" value="difficile" onclick="enregistrerSkip(this.value)">Difficulté</button>
                            <button id="inap" type="button" class="btn btn-warning ml-2 skip" data-dismiss="modal" value="inadapter" onclick="enregistrerSkip(this.value)">Inadapté</button>                            
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    </div>
                </div>
            </div>
            <input type="hidden" id="modoId" value="" />
        </div>
        <script src="Public/javascript/exercice.js"></script>
    </body>
</html>
