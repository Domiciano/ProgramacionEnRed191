package entity;

public class Pelicula {

	private int id;
	private String nombre;
	private String pais;
	private String idioma;
	private int generoId;
	
	public Pelicula() {
		
	}
	
	
	public Pelicula(int id, String nombre, String pais, String idioma, int generoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.idioma = idioma;
		this.generoId = generoId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getGeneroId() {
		return generoId;
	}
	public void setGeneroId(int generoId) {
		this.generoId = generoId;
	}
	
	
	
}
