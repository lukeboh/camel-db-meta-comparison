function updateValues(event) {
    
    event.preventDefault();
    updateValues();
}

function updateValues() {
    errorMessage = document.querySelector("#error");
    
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 0) {
          console.log("FALHA DE REDE");
          errorMessage.textContent = "Off-Line";
        }
      };

    xhr.open("GET", "/target/work/index.json");
    
    xhr.addEventListener("load", function() {
        if (xhr.status == 200) {
            errorMessage.textContent = "";
            var resposta = xhr.responseText;
            //console.log(resposta);
            var result = JSON.parse(resposta);
            //console.log(result);
            var keys = Object.keys(result);
            for(var i=0;i<keys.length;i++){
                var key = keys[i];
                //console.log(key, result[key]);
                var elemento = document.querySelector("#id-" + key);
                //console.log(elemento);
                if (elemento != null) {
                    console.log("Achou #id-" + key + " valor [" + result[key] + "]");
                    elemento.textContent = result[key];
                } else {
                    console.log("NÃO Achou #id-" + key);
                }
            }
        } else {
            console.log(xhr.status);
            console.log(xhr.responseText);
        }
    });
    
    xhr.send();
}

function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10)
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
            updateValues();
        }
    }, 1000);
}

window.onload = function () {
    updateValues();
    var period = 60 * 1,
        display = document.querySelector("#timer");
    startTimer(period, display);
};

var titulo = document.querySelector(".jb-row-title");
titulo.addEventListener("click", updateValues);
