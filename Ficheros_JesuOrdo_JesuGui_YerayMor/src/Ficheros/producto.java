package Ficheros;

public class producto {
	public  String titulo="";
	public  int codigo=0;
	public String autor="";
	public  double nota=0.0;
	public  Genero genero=null;
	
	
	
	public producto() {
		this.titulo = null;
		this.codigo = 0;
		this.autor = null;
		this.nota = 0;
		this.genero = null;
	}
	
	public producto(String titulo, int codigo, String autor, double nota, Genero genero) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.autor = autor;
		this.nota = nota;
		this.genero = genero;
	}
	public String toString() {
		return "producto []";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		titulo = titulo;
	}
	public  int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		codigo = codigo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		autor = autor;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		nota = nota;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		genero = genero;
	}

}
