alert("carregou22");
var titulo = document.querySelector(".jb-row-title");
titulo.addEventListener("click", function(event) {
    
    event.preventDefault();
    
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/target/work/index.json");
    
    xhr.addEventListener("load", function() {
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
    });
    
    xhr.send();
});
