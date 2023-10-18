package Ficheros;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Estructurabuena {

	public static void main(String[] args) {

		Pelicula ironman = new Pelicula("IRON MAN", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula deadpool = new Pelicula("deadpool", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula cars = new Pelicula("CARS", 1001, "John Lasseter", 5.0, Genero.deportes, Genero.acción, Genero.animación, 115);
		

		CategoriaPeliculas.peliculasMarvel.add(ironman);
		CategoriaPeliculas.peliculasMarvel.add(deadpool);
		CategoriaPeliculas.peliculasPixar.add(cars);

		try {
		// Utilizar JAXB para marshalling y convertir objetos en XML
			JAXBContext context = JAXBContext.newInstance(Pelicula.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Producto (ironman)
			marshaller.marshal(CategoriaPeliculas.peliculasMarvel, new File("Disney.xml"));

			// Marshalling de Pelicula (cars)
			marshaller.marshal(CategoriaPeliculas.peliculasPixar, new File("Disney.xml"));

			System.out.println("Peliculas añadidas correctamente!");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void leerPelicula() {
		try {
			JAXBContext context = JAXBContext.newInstance(Pelicula.class);
			Marshaller marshaller = context.createMarshaller();
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Pelicula peliculaFromXml = (Pelicula) unmarshaller.unmarshal(new File("Disney.xml")); 
			System.out.println(peliculaFromXml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
