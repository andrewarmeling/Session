document.getElementById("botao-login").onclick = function() {
    var validado = validarInput();
    var senhaCodificada = codificar(document.getElementById("senha").value);
    
}

function validarInput() {
    var usuario = document.getElementById("usuario").value;
    var senha = document.getElementById("senha").value;

    if(usuario != "" && usuario != null && senha != "" && senha != null) {
        return true;
    } else {
        return false;
    }
}

function codificar(senha) {
    return (btoa(senha));
}