package Ficheros;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Estructuramil {
	public static void main(String[] args) {

		//CREACION DE PELICULAS

		//Peliculas Marvel
		Pelicula ironman = new Pelicula("IRON MAN", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula deadpool = new Pelicula("DEADPOOL", 1002, "Tim Miller", 5.1, Genero.comedia, Genero.acción, Genero.super_heroes, 110);

		//Peliculas Pixar
		Pelicula toystory = new Pelicula("TOY STORY", 1003, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula cars = new Pelicula("CARS", 1004, "kikewest", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 120);

		//Peliculas Star Wars
		Pelicula elAscensoDeSkyWalker = new Pelicula("EL ASCENSO DE SKY-WALKER", 1005, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula hanSolo = new Pelicula("HAN SOLO", 1006, "kikewest", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 120);

		//Peliculas Disney Classic
		Pelicula reyLeon  = new Pelicula("EL REY LEON", 1007, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula frozen  = new Pelicula("FROZEN", 1008, "kikewest", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 120);
		
		//Añadimos las peliculas
		
		
		//CREACION DE SERIES

		//Peliculas Marvel
		Serie loki  = new Serie("LOKI", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Serie daredevil  = new Serie("DAREDEVIL", 1002, "Tim Miller", 5.1, Genero.comedia, Genero.acción, Genero.super_heroes, 110);

		//Peliculas Pixar
		Serie monstruosSA  = new Serie("MONSTRUOS S.A", 1003, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Serie dugDays  = new Serie("DUG DAYS", 1004, "kikewest", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 120);

		//Peliculas Star Wars
		Serie mandalorian = new Serie("MANDALORIAN", 1005, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Serie kenobi = new Serie("KENOBI", 1006, "kikewest", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 120);

		//Peliculas Disney Classic
		Serie hercules = new Serie("HERCULES", 1007, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Serie aladdin = new Serie("ALADDIN", 1008, "kikewest", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 120);


		// Utilizar JAXB para marshalling y convertir objetos en XML
		try {
			JAXBContext context = JAXBContext.newInstance(Pelicula.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Producto (ironman)
			marshaller.marshal(ironman, new File("Disney.xml"));

			// Marshalling de Pelicula (cars)
			marshaller.marshal(deadpool, new File("Disney.xml"));


		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void leerPelicula() {
		try {
			JAXBContext context = JAXBContext.newInstance(Pelicula.class);
			Marshaller marshaller = context.createMarshaller();
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Pelicula peliculaFromXml = (Pelicula) unmarshaller.unmarshal(new File("pelicula.xml")); 
			System.out.println(peliculaFromXml);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

