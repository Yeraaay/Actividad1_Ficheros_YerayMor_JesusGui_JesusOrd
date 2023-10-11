package Ficheros;

public class producto {
	public  String Titulo="";
	public  int Codigo=0;
	public String Autor="";
	public  double Nota=0.0;
	public  Genero Genero=null;
	
	
	
	public producto() {
		this.Titulo = null;
		this.Codigo = 0;
		this.Autor = null;
		this.Nota = 0;
		this.Genero = null;
	}
	
	public producto(String titulo, int codigo, String autor, double nota, Genero genero) {
		super();
		this.Titulo = titulo;
		this.Codigo = codigo;
		this.Autor = autor;
		this.Nota = nota;
		this.Genero = genero;
	}
	

	public String toString() {
		return "producto [Titulo=" + Titulo + ", Codigo=" + Codigo + ", Autor=" + Autor + ", Nota=" + Nota + ", Genero="
				+ Genero + "]";
	}

	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public  int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public double getNota() {
		return Nota;
	}
	public void setNota(double nota) {
		Nota = nota;
	}
	public Genero getGenero() {
		return Genero;
	}
	public void setGenero(Genero genero) {
		Genero = genero;
	}
}

