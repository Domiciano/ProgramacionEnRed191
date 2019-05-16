class Curso{
	
	constructor(nombre){
		this.nombre = nombre;
		this.estudiantes = [];
		Object.seal(this);
	}
	
	toJson(){
		return JSON.stringify(this);
	}
}

class Estudiante{
	
	constructor(nombre, apellido, codigo, nota){
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
		this.nota = nota;
		Object.seal(this);
	}
	
	toJson(){
		return JSON.stringify(this);
	}
}