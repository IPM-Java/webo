/**
 * Main js file
 * 
 */
function graphe() {
    var chLine = document.getElementById("chLine");
    var colors = ['#007bff','#28a745','#333333','#c3e6cb','#dc3545','#6c757d'];
            
    var rawData = document.querySelectorAll(".indiceDickson");
    
    var dataSet = [];
    for (var i = 0 ; i <= rawData.length -1 ; i++ ) {
        dataSet.push(rawData[i].textContent);
    }
    
    var label = [];
    for (var i = 0 ; i <= dataSet.length -1 ; i++ ) {
        label.push("Bilan " + i);
    }
    
    var chartData = {
      labels: label,
      datasets: [{
        data: dataSet,
        backgroundColor: 'transparent',
        borderColor: colors[0],
        borderWidth: 4,
        pointBackgroundColor: colors[0]
      }]
    };
 
    if (chLine) {
        new Chart(chLine, {
            type: 'line',
            data: chartData,
            options: {
                scales: {
                    yAxes: [{
                            ticks: {beginAtZero: false
                            }
                        }]
                },
                legend: {
                    display: false
                }
            }
        });
    }
};