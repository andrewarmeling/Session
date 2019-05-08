//$(document).ready(function () {
//
//    var $usuario = $('#usuario');
//    var $senha = $('#senha');
//
//    $('#botao-login').click(function(){
//    	
////        var $senhaCodificada = btoa($senha.val());
////        
////        var dados = {
////            usuario: $usuario.val(),
////            senha: $senhaCodificada
////        };
//    	
//    	var dados = {
//    			usuario: $usuario.val(),
//    			senha: $senha.val()
//    	};
//        
//        $.post("login", dados,
//            function(data, satus) {
//                console.log(data);
//            }
//        );
//
//    });
//
//});

function onSubmit() {
	
	var dados = {
			usuario: $('#usuario').val(),
			senha: $('#senha').val()
	};
    
    $.post("login", dados,
        function(data, status) {
    		window.location = data.url;    	
            console.log(data);
        }
    );
	
	return false;
}