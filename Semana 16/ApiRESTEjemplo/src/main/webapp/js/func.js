$(document).ready(init);

function init(){
	alert("Alfa");
	/*
	//El primer metodo luego de la pagina carga
	var i = 10;
	var j = 20;
	var nombre = "Programacion en red";
	
	suma = i+j+nombre;
	div = i/j;
	console.log(div);

	
	array = ["Alfa","Beta"];
	array.push("Gamma");
	array.splice(1, 1);
	
	console.log(array);
	
	var miObjeto = {nombre:"Jefferson",apellido:"Lerma"};
	console.log(miObjeto);
	json = JSON.stringify(miObjeto);
	console.log(json);
	*/
	
	
	$("#btn_calcular").click( function(event){
		peso = $("#txt_peso").val();
		altura = $("#txt_altura").val();
		imc = peso/(altura*altura);
		
		$("#txt_respuesta").html("Su IMC es "+imc);
		
		$("#historial").append("<li>"+ imc +"</li>");
		
	});
	
	//http://localhost:8080/ApiRESTEjemplo/web/actor/find/2
	$("#btn_find_actor").click(function(event){
		id = $("#txt_id_actor").val();
		
		$.ajax({
			url:"web/actor/find/"+id,
			type:"GET"
		}).done( function(response){
			json = JSON.stringify(response);
			console.log(JSON.parse(json));
			
			$("#actor_resultado").html(response.nombre);
			
		} );
		
	});
	
	
	$("#btn_insert_actor").click(function(event){
		name = $("#txt_name_actor").val();
		obj = {nombre:name,id:0};
		obj_str = JSON.stringify(obj);
		
		$.ajax({
			url:"web/actor/",
			type:"POST",
			contentType:"application/json",
			data:obj_str
		}).done( function(response){
			console.log(response);
			
		});
		
	});
	
}


function postActor(){
	
	
}


