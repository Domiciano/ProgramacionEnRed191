$(document).ready(init);

function init(){
	
	var curso = new Curso("Programacion en red");
	
	var est = new Estudiante("Daniel","Gomez","A0000","4.7");
	console.log(est);
	console.log(est.toJson());
	
	curso.estudiantes.push(est);
	console.log(curso);
	
	var database = firebase.database();
	var id = database.ref("cursos/PROGRARED/estudiantes").push().key;
	var obj = {_id:id,nombre:"Carlos",apellido:"Lizalda",codigo:"A00110011",promedio:"4.9"};
	console.log(id);
	database.ref("cursos/PROGRARED/estudiantes/"+id).set(obj);
	
	database.ref("cursos/PROGRARED/estudiantes").once('value', function(snap){
		
		snap.forEach(function(child){
			console.log( child.val() );
		});
		
	} );
	//.set(obj);
}