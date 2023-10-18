package Ficheros;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Producto {
    private String Titulo;
    private int Codigo;
    private String Autor;
    private double Nota;
    private Genero Genero1;
    private Genero Genero2;
    private Genero Genero3;

    public Producto() {
        // Constructor vacío requerido por JAXB
    }

    public Producto(String titulo, int codigo, String autor, double nota, Genero genero1, Genero genero2, Genero genero3) {
        this.Titulo = titulo;
        this.Codigo = codigo;
        this.Autor = autor;
        this.Nota = nota;
        this.Genero1 = genero1;
        this.Genero2 = genero2;
        this.Genero3 = genero3;
    }

    @XmlElement
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    @XmlElement
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    @XmlElement
    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    @XmlElement
    public double getNota() {
        return Nota;
    }

    public void setNota(double nota) {
        Nota = nota;
    }

    @XmlElement
    public Genero getGenero1() {
        return Genero1;
    }

    public void setGenero1(Genero genero1) {
        Genero1 = genero1;
    }
    @XmlElement
    public Genero getGenero2() {
        return Genero2;
    }

    public void setGenero2(Genero genero2) {
        Genero2 = genero2;
    }
    @XmlElement
    public Genero getGenero3() {
        return Genero3;
    }

    public void setGenero3(Genero genero3) {
        Genero3 = genero3;
    }
}
