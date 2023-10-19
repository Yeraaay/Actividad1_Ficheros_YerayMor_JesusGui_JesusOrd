package Ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Estructurabuena {

	public static void crearXML() {

		//Creamos las listas para agregar las peliculas
		List<Pelicula> peliculasMarvel = new ArrayList<>();
		List<Pelicula> peliculasPixar = new ArrayList<>();
		List<Pelicula> peliculasStarWars = new ArrayList<>();
		List<Pelicula> peliculasDisney = new ArrayList<>();

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
		peliculasMarvel.add(ironman);
		peliculasMarvel.add(deadpool);

		peliculasPixar.add(toystory);
		peliculasPixar.add(cars);

		peliculasStarWars.add(elAscensoDeSkyWalker);
		peliculasStarWars.add(hanSolo);

		peliculasDisney.add(reyLeon);
		peliculasDisney.add(frozen);


		//Creamos instancias de las categorias para agregar las listas
		CategoriaPeliculas categoriaPeliculas = new CategoriaPeliculas(peliculasMarvel, peliculasPixar, peliculasStarWars, peliculasDisney);



		//Creamos las listas para agregar las series
		List<Serie> seriesMarvel = new ArrayList<>();
		List<Serie> seriesPixar = new ArrayList<>();
		List<Serie> seriesStarWars = new ArrayList<>();
		List<Serie> seriesDisney = new ArrayList<>();

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

		//Añadimos las series
		seriesMarvel.add(loki);
		seriesMarvel.add(daredevil);

		seriesPixar.add(monstruosSA);
		seriesPixar.add(dugDays);

		seriesStarWars.add(mandalorian);
		seriesStarWars.add(kenobi);

		seriesDisney.add(hercules);
		seriesDisney.add(aladdin);

		//Creamos una instancia de las categorias para agregar las listas de series
		CategoriaSeries categoriaSeries = new CategoriaSeries(seriesMarvel, seriesPixar, seriesStarWars, seriesDisney);


		// Crear un objeto de la clase Disney y configurar las categorías en ese objeto
		Disney disney = new Disney(categoriaPeliculas, categoriaSeries);

		// Utilizar JAXB para marshalling y convertir objetos en XML
		System.out.println("disney creado");
		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo realisado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		

	}
	public static void main(String[] args) {
		crearXML();
	}
}
