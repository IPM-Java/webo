<%@page import="java.util.ArrayList"%>
<%@page import="utils.ValidationError"%>
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
        
        <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/sign-in/">           
        <link href="/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="apple-touch-icon" href="/docs/4.4/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/4.4/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/4.4/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
        <link rel="icon" href="/docs/4.4/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#563d7c">
        
        <style>
            .bd-placeholder-img {
              font-size: 1.125rem;
              text-anchor: middle;
              -webkit-user-select: none;
              -moz-user-select: none;
              -ms-user-select: none;
              user-select: none;
            }

            @media (min-width: 768px) {
              .bd-placeholder-img-lg {
                font-size: 3.5rem;
              }
            }
        </style>
        
        <link type="text/css" rel="stylesheet" href="Public/css/main.css" />
    </head>
    
    <body class="text-center">       

        <form action="AuthentificationServlet" name="connexion" method="POST" class="form-signin">
            <img class="mb-4" src="Public/img/logo-min.png" alt="" width="120" height="120">

            <h1 class="h3 mb-3 font-weight-normal">Connectez vous</h1>

            <label for="email" class="sr-only">Adresse email</label>
            <input type="text" name="email" class="form-control" placeholder="adresse email..." value="${email}" autofocus>

            <label for="password" class="sr-only">Password</label>
            <input type="password" name="password" class="form-control" placeholder="mot de passe.." value="${password}">        

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            
            <c:if test="${error_auth != null}">
                <div class="alert alert-danger" role="alert">${error_auth}</div>
            </c:if>
            
            <c:if test="${error_input != null}">
                <div class="alert alert-danger mt-3" role="alert">
                    <c:forEach var="error"  items="${requestScope['error_input']}" >
                        <p>${error.toString()}</P>
                    </c:forEach>
                </div>
            </c:if>
            
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>              
        </form>
            
    </body> 
</html>
