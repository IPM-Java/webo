document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("btnCancel").addEventListener("click", cancelSeance);
    bindEventListener();
    bindEventListenerSkip();
});

function bindEventListener() {
    var element = document.querySelectorAll(".validation");   
    for (var i = 0; i < element.length; i++) {
        element[i].addEventListener("click", validerExercice);
    }
}

function bindEventListenerSkip() {
    var element = document.querySelectorAll(".modo");   
    for (var i = 0; i < element.length; i++) {
        element[i].addEventListener("click", addExericeToModal);
    }
}

function addExericeToModal() {
    var elem = this;
    var node = elem.parentNode.parentNode.parentNode.parentNode; 
    var exercice = node.id;
    document.getElementById("modoId").value = exercice;   
}

function validerExercice() {
    var elem = this;  
    var node = elem.parentNode.parentNode.parentNode.parentNode; 
    var exercice = node.id;  
    var occ = document.getElementById("occ").value;
    
    let tag = ".resultat" + exercice;
    var radio = document.querySelectorAll(tag);
    var isButtonChecked = false;
    var value;
    for (var i = 0 ; i <= radio.length - 1; i++ ) {
        if (radio[i].checked) {
            isButtonChecked = true;
            value = radio[i].value;
        }
    }
    
    if (isButtonChecked) {
        enregistrerExercice(exercice, occ, value);
    } else {
        document.getElementById(exercice).focus();
        alert("Exercice " + exercice + " : cochez une valeur");
    }
}

function enregistrerExercice(idExercice, idOccurence, value) {
    var xhr = new XMLHttpRequest();

    var user = document.getElementById("userId").value;

    let url = "RealiserExerciceServlet?action=terminer&exercice=" +
            idExercice.trim() + "&occurence=" + idOccurence.trim() + 
            "&value=" + value.trim() + "&user=" + user.trim() ;
    
    xhr.open("GET", url); 
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onload = function() {
        if (xhr.status === 200) {
            incrementeCmp();
            updateDom(idExercice);
        }
    };
    xhr.send();  
}

function updateDom(idExercice) {
    
    let ele = "ordre-" + idExercice;
    var ordreActual = document.getElementById(ele).value;
    
    let btnValid = "btn-valid-" + ordreActual;
    
    let btnSkip = "btn-skip-" + ordreActual;
    let header = "header-" + idExercice;
    let radio = "btn-radio-" + ordreActual;
    
    document.getElementById(btnValid.trim()).disabled = true;
    document.getElementById(btnSkip.trim()).disabled = true;
    document.getElementById(header.trim()).classList.add("bg-success");
    document.getElementById(radio.trim()).style.pointerEvents = "none";
    
    if (!isLast()) {
        let ordreNext = parseInt(ordreActual) + 1;

        let btnValid1 = "btn-valid-" + ordreNext;
        let btnSkip1 = "btn-skip-" + ordreNext;
        let span = "span-" + ordreNext;
        document.getElementById(btnValid1.trim()).disabled = false;
        document.getElementById(btnSkip1.trim()).disabled = false;
        document.getElementById(span.trim()).style.display = "none";        
    }
    
}

function enregistrerSkip(value) {
    exercice =  document.getElementById("modoId").value;
    var occ = document.getElementById("occ").value;
    var user = document.getElementById("userId").value;
    
    var xhr = new XMLHttpRequest();

    let url = "RealiserExerciceServlet?action=" + value + "&exercice=" +
            exercice.trim() + "&occurence=" + occ.trim() + "&user=" + user.trim() ;
    
    xhr.open("GET", url); 
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onload = function() {
        if (xhr.status === 200) {
            incrementeCmp();
            updateDomSkip(exercice);
        }
    };
    xhr.send();  
}

function updateDomSkip(idExercice) {
    let ele = "ordre-" + idExercice;
    var ordreActual = document.getElementById(ele).value;
    
    let btnValid = "btn-valid-" + ordreActual;
    
    let btnSkip = "btn-skip-" + ordreActual;
    let header = "header-" + idExercice;
    let radio = "btn-radio-" + ordreActual;
    
    document.getElementById(btnValid.trim()).disabled = true;
    document.getElementById(btnSkip.trim()).disabled = true;
    document.getElementById(header.trim()).classList.add("bg-danger");
    document.getElementById(radio.trim()).style.pointerEvents = "none";
    
    if (!isLast()) {
        let ordreNext = parseInt(ordreActual) + 1;

        let btnValid1 = "btn-valid-" + ordreNext;
        let btnSkip1 = "btn-skip-" + ordreNext;
        let span = "span-" + ordreNext;
        document.getElementById(btnValid1.trim()).disabled = false;
        document.getElementById(btnSkip1.trim()).disabled = false;
        document.getElementById(span.trim()).style.display = "none";        
    }      
}

function incrementeCmp() {
    var cmp = parseInt(document.getElementById("cmp").value);
    document.getElementById("cmp").value = cmp + 1;
    checkBtnValider();
}

function checkBtnValider() {
    var cmp = parseInt(document.getElementById("cmp").value);
    var total = parseInt(document.getElementById("exos").value);
    if (total === cmp) {
        document.getElementById("btnSeance").disabled = false;
        document.getElementById("btnSeance").classList.remove("btn-danger");
        document.getElementById("btnSeance").classList.add("btn-success");
    }
}

function isLast() {
    var cmp = parseInt(document.getElementById("cmp").value);
    var total = parseInt(document.getElementById("exos").value);
    if (total === cmp) {
        return true;
    } else {
        return false;
    }
}

function cancelSeance() {
    var occ = document.getElementById("occ").value;
    var user = document.getElementById("userId").value;
    
    var xhr = new XMLHttpRequest();

    let url = "CancelSeanceServlet?occurence=" + occ.trim() + "&user=" + user.trim();
    
    xhr.open("GET", url); 
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onload = function() {
        if (xhr.status === 200) {
            window.location.replace("http://localhost:8080/webo/TrainingHomeServlet");
        }
    };
    xhr.send();      
}