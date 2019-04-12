$(document).ready(function () {

    var $usuario = $('#usuario');
    var $senha = $('#senha');

    $('#botao-login').click(function(){
    	
        var $senhaCodificada = btoa($senha.val());
        
        var dados = {
            usuario: $usuario.val(),
            senha: $senhaCodificada
        };
        
        $.ajax({
            type: "POST",
            url: "/Session/login",
            data: dados,
            success: function (response) {
                alert("ok");
            }

        });

    });

});