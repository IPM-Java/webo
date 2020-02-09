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
        <%@include file="../../Template/annonymous/header.html" %>
        <div id="page-container" class="container-fluid pr-0 pl-0 h-100 d-flex flex-column">
            <div id="page-content" class="d-flex justify-content-center fadeIn pt-5 pb-4">
                <div class="container">
                    <c:if test="${error_auth != null}">
                        <div class="alert alert-danger" role="alert">${error_auth}</div>
                    </c:if>
                    <div class="jumbotron mt-2">
                        <h2 class="display-3 text-center">Jean david</h2>
                        <h4 class="display-4 text-center">Coach personnalisé</h4>
                        <div>
                            <img src="Public/img/logo-wrap.png" class="img-fluid mx-auto d-block" />
                        </div>
                    </div>
                    <hr>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4">
                                <h3>Créer un compte</h3>
                                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                                <p><a class="btn btn-secondary" href="#" role="button">Créer un compte &raquo;</a></p>
                            </div>
                            <div class="col-md-4">
                                <h3>Réaliser une candidature</h3>
                                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                                <p><a class="btn btn-secondary" href="#" role="button">Demander un programme &raquo;</a></p>
                            </div>
                            <div class="col-md-4">
                                <h3>Suivez vos candidatures</h3>
                                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                                <p><a class="btn btn-secondary" href="#" role="button">Pricing &raquo;</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../../Template/footer.html" %>
        </div>
    </body> 
</html>
