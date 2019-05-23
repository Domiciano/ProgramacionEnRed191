$(document).ready(init);

function init(){
	socket = new WebSocket("ws://172.30.187.236:8080/EjemploWebSockets/echo");
	
	socket.onopen = function(){
		$("#recepcion").append("<p>Conectado!</p>");
	};
	socket.onmessage = function(event){
		$("#recepcion").append("<p>" + event.data.toString() + "</p>");
	};
	socket.onclose = function(){
		
	};
	
	//Evento del boton
	$("#btn_enviar").click(function(e){
		var texto = $("#txt_mensaje").val();
		socket.send(texto);
	});
	
	$("#btn_auth").click(function(e){
		var username = $("#txt_username").val();
		socket.send("ID::"+username);
	});
	
	
	
}