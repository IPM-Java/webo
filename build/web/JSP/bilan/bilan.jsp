<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Realiser mon bilan</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="Public/css/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="Public/css/bilan.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>   
    <body class="h-100">
        <%@include file="../../Template/user/header.html" %>
        <div class="container d-flex flex-column mt-5">
            <h2 class="display-4">Réaliser mon bilan</h2>
            <form action="BilanServlet" method="POST" name="bilan">
                <div class="jumbotron mt-3 px-3 py-3">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row px-3"><h3>Condition physique</h3></div>
                            <hr>
                            <div class="form-group">
                                <label for="fc1">Fréquence cardiaque après 5 minutes au calme</label>
                                <input type="number" name="fc1" class="form-control" value="">
                            </div>
                            <div class="form-group">
                                <label for="fc2">Fréquence cardiaque après 30 flexions complètes en 45 secondes</label>
                                <input type="number" name="fc2" class="form-control" value="">
                            </div>
                            <div class="form-group">
                                <label for="fc3">Fréquence cardiaque 1 minutes allongée</label>
                                <input type="number" name="fc3" class="form-control" value="">
                            </div>                           
                        </div>
                        <div class="col-md-6">
                            <h3>Mensurations <small>si objectif minceur</small></h3>
                            <hr>
                            <div class="form-group">
                                <label for="bras">Bras <small class="text-muted">(cm)</small></label>
                                <input type="number" name="bras" class="form-control" value="">
                            </div>
                            <div class="form-group">
                                <label for="poitrine">Poitrine <small class="text-muted">(cm)</small></label>
                                <input type="number" name="poitrine" class="form-control" value="">
                            </div>                            
                            <div class="form-group">
                                <label for="taille">Taille <small class="text-muted">(cm)</small></label>
                                <input type="number" name="taille" class="form-control" value="">
                            </div>                            
                            <div class="form-group">
                                <label for="hanches">Hanches <small class="text-muted">(cm)</small></label>
                                <input type="number" name="hanches" class="form-control" value="">
                            </div>                            
                            <div class="form-group">
                                <label for="cuisses">Jambes <small class="text-muted">(cm)</small></label>
                                <input type="number" name="cuisses" class="form-control" value="">
                            </div>                     
                        </div>                            
                    </div>
                </div>
                <div class="jumbotron mt-3 px-3 py-3">
                    <div class="row mx-3"><h3>Performance</h3></div>
                    <hr>
                    <div class="row mt-3">
                        <div class="col-md-4">
                            <img src="Public/img/gainage.jpg" class="img-fluid" alt="">
                        </div>
                        <div class="col-md-4 mt-2">
                            <h4>Gainage : <small class="text-muted">Temps maximun</small></h4>                           
                            <div class="form-group mt-1">
                                <input type="time" name="gainage" class="form-control" value="">
                            </div>
                        </div>
                    </div>
                    <div class="border-top my-3"></div>
                    <div class="row">
                        <div class="col-md-4">
                            <img src="Public/img/fentes.jpg" class="img-fluid" alt=""> 
                        </div>
                        <div class="col-md-4 mt-2">
                            <h4>Fentes : <small>Répétition maximun</small></h4>
                            <div class="form-group">
                                <small>Fentes jambe gauche</small>
                                <input type="number" name="fgauche" class="form-control" value="">
                            </div>
                            <div class="form-group">
                                <small>Fentes jambe droite</small>
                                <input type="number" name="fdroite" class="form-control" value="">
                            </div>  
                        </div>
                    </div>
                    <div class="border-top my-3"></div>
                    <div class="row">
                        <div class="col-md-4">
                            <img src="Public/img/crunch.jpg" class="img-fluid" alt=""> 
                        </div>
                        <div class="col-md-4 mt-2">
                            <h4>Crunch : <small>Répétition maximun</small></h4>
                            <div class="form-group">
                                <input type="number" name="crunch" class="form-control" value="">
                            </div>
                        </div>
                    </div>
                    <div class="border-top my-3"></div>
                    <div class="row">
                        <div class="col-md-4">
                            <img src="Public/img/pompe.png" class="img-fluid" alt="">                        
                        </div>
                        <div class="col-md-4 mt-2">
                            <h4>Pompes : <small>Répétition maximun</small></h4>
                            <div class="form-group">
                                <input type="number" name="pompe" class="form-control" value="">
                            </div>                            
                        </div>
                    </div>
                    <div class="border-top my-3"></div>
                    <div class="row">
                        <div class="col-md-4">
                            <img src="Public/img/squat.png" class="img-fluid" alt=""> 
                        </div>
                        <div class="col-md-4 mt-2">
                            <h4>Squat : <small>Répétition maximun</small></h4>
                            <div class="form-group">
                                <input type="number" name="squat" class="form-control" value="">
                            </div>                            
                        </div>
                    </div>
                    <div class="border-top my-3"></div>
                    <div class="row">
                        <div class="col-md-4">
                            <img src="Public/img/dips.png" class="img-fluid" alt=""> 
                        </div>
                        <div class="col-md-4 mt-2">
                            <h4>Dips : <small>Répétition maximun</small></h4>                            
                            <div class="form-group">
                                <input type="number" name="dips" class="form-control" value="">
                            </div>                            
                        </div>
                    </div>
                </div>
                <div class="row mb-5"><button class="btn btn-success btn-block mr-auto">Envoyer mon bilan</button></div>
            </form>
        </div>         
    </body> 
</html>
