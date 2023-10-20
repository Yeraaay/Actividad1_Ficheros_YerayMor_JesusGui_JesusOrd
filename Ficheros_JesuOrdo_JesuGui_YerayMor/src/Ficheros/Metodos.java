package Ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Metodos {


	public static Disney crearXML() {

		//Creamos las listas para agregar las peliculas
		List<Pelicula> peliculasMarvel = new ArrayList<>();
		List<Pelicula> peliculasPixar = new ArrayList<>();
		List<Pelicula> peliculasStarWars = new ArrayList<>();
		List<Pelicula> peliculasDisney = new ArrayList<>(); 


		//CREACION DE ESPECTADORES DE PELICULAS
		int[] espectadoresIronman = {1000, 1800, 1500, 1900, 1200, 1300, 1400, 900, 2200, 2000, 1700, 1600};
		int[] espectadoresdeadpool = {950, 1750, 1600, 1850, 1350, 1450, 1250, 850, 2350, 1950, 1675, 1625};
		int[] espectadorestoystory = {1100, 1950, 1700, 2000, 1400, 1600, 1350, 800, 2100, 1900, 1750, 1550};
		int[] espectadorescars = {1050, 1900, 1650, 1925, 1300, 1400, 1450, 875, 2250, 2050, 1725, 1575};
		int[] espectadoreselAscensoDeSkyWalker = {980, 1740, 1480, 1870, 1250, 1350, 1420, 920, 2380, 2030, 1760, 1590};
		int[] espectadoreshanSolo = {1025, 1825, 1575, 1905, 1285, 1385, 1465, 945, 2315, 2075, 1735, 1515};
		int[] espectadoresreyLeon = {1050, 1850, 1550, 1975, 1325, 1375, 1435, 925, 2435, 2095, 1785, 1560};
		int[] espectadoresfrozen = {975, 1785, 1525, 1935, 1275, 1340, 1405, 910, 2265, 2025, 1705, 1585};

		//CREACION DE PELICULAS
		//Peliculas Marvel
		Pelicula ironman = new Pelicula("IRON MAN", 1000, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120, espectadoresIronman);
		Pelicula deadpool = new Pelicula("DEADPOOL", 1001, "Tim Miller", 5.1, Genero.comedia, Genero.acción, Genero.super_heroes, 110, espectadoresdeadpool);

		//Peliculas Pixar
		Pelicula toystory = new Pelicula("TOY STORY", 1002, "John Lasseter", 5.1, Genero.comedia, Genero.acción, Genero.animación, 120, espectadorestoystory);
		Pelicula cars = new Pelicula("CARS", 1003, "John Lasseter", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 116, espectadorescars);

		//Peliculas Star Wars
		Pelicula elAscensoDeSkyWalker = new Pelicula("EL ASCENSO DE SKY-WALKER", 1004, "J. J. Abrams", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 146, espectadoreselAscensoDeSkyWalker);
		Pelicula hanSolo = new Pelicula("HAN SOLO", 1005, "Ron Howard", 8.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 135, espectadoreshanSolo);

		//Peliculas Disney Classic
		Pelicula reyLeon  = new Pelicula("EL REY LEON", 1006, "Rob Minkoff", 5.1, Genero.musical, Genero.acción, Genero.super_heroes, 127, espectadoresreyLeon);
		Pelicula frozen  = new Pelicula("FROZEN", 1007, "Chris Buck", 8.1, Genero.musical, Genero.familiar, Genero.animación, 120, espectadoresfrozen);


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
		CategoriaPeliculas categoriaPeliculas = new CategoriaPeliculas(peliculasMarvel, peliculasPixar,  peliculasDisney, peliculasStarWars);

		//Creamos las listas para agregar las series
		List<Serie> seriesMarvel = new ArrayList<>();
		List<Serie> seriesPixar = new ArrayList<>();
		List<Serie> seriesStarWars = new ArrayList<>();
		List<Serie> seriesDisney = new ArrayList<>();


		//CREACION DE ESPECTADORES DE SERIES
		// CREACION DE ESPECTADORES DE SERIES
		int[] espectadoresloki = {1100, 1900, 1600, 2000, 1300, 1400, 1500, 1000, 2300, 2100, 1800, 1700};
		int[] espectadoresdaredevil = {1050, 1850, 1700, 1950, 1450, 1550, 1350, 950, 2450, 2050, 1775, 1725};
		int[] espectadoresmonstruosSA = {1200, 2050, 1800, 2100, 1500, 1700, 1450, 900, 2200, 2000, 1850, 1650};
		int[] espectadoresdugDays = {1150, 2000, 1750, 2025, 1400, 1500, 1550, 925, 2350, 2150, 1825, 1675};
		int[] espectadoresmandalorian = {1080, 1840, 1580, 1970, 1350, 1450, 1520, 980, 2420, 2070, 1790, 1620};
		int[] espectadoreskenobi = {1125, 1925, 1675, 2005, 1385, 1485, 1565, 945, 2355, 2115, 1775, 1555};
		int[] espectadoreschipychop = {1150, 1950, 1650, 2075, 1425, 1475, 1535, 925, 2535, 2195, 1885, 1660};
		int[] espectadoresdinosaruios = {1075, 1885, 1625, 2035, 1375, 1440, 1505, 910, 2365, 2125, 1805, 1685};


		//CREACION DE SERIES
		//Peliculas Marvel
		Serie loki  = new Serie("LOKI", 2000, "Kate Herron", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 2, espectadoresloki);
		Serie daredevil  = new Serie("DAREDEVIL", 2001, "Mark Steven Johnson", 5.1, Genero.aventura, Genero.acción, Genero.super_heroes, 3, espectadoresdaredevil);

		//Peliculas Pixar
		Serie monstruosSA  = new Serie("MONSTRUOS A LA OBRA", 2002, "Pete Docter", 5.1, Genero.familiar, Genero.comedia, Genero.animación, 1, espectadoresmonstruosSA);
		Serie dugDays  = new Serie("DUG Y CARL", 2003, "Bob Peterson", 8.1, Genero.familiar, Genero.comedia, Genero.animación, 1, espectadoresdugDays);

		//Peliculas Star Wars
		Serie mandalorian = new Serie("MANDALORIAN", 2004, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 3, espectadoresmandalorian);
		Serie kenobi = new Serie("KENOBI", 2005, "Deborah Chow", 8.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 1, espectadoreskenobi);

		//Peliculas Disney Classic
		Serie chipychop = new Serie("CHIP Y CHOP", 2006, "Josh Becker", 5.1, Genero.comedia, Genero.animación, Genero.infantil, 2, espectadoreschipychop);
		Serie dinosaurios = new Serie("DINOSAURIOS", 2007, "Guy Ritchie", 8.1, Genero.familiar, Genero.comedia, Genero.animación, 4, espectadoresdinosaruios);

		//Añadimos las series
		seriesMarvel.add(loki);
		seriesMarvel.add(daredevil);

		seriesPixar.add(monstruosSA);
		seriesPixar.add(dugDays);

		seriesStarWars.add(mandalorian);
		seriesStarWars.add(kenobi);

		seriesDisney.add(chipychop);
		seriesDisney.add(dinosaurios);

		//Creamos una instancia de las categorias para agregar las listas de series
		CategoriaSeries categoriaSeries = new CategoriaSeries(seriesMarvel, seriesPixar, seriesDisney, seriesStarWars);


		// Crear un objeto de la clase Disney y configurar las categorías en ese objeto.
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
		return disney;
	}

	public static String leerXML(String rutaArchivoXML) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File(rutaArchivoXML);

			Document document = builder.parse(xmlFile);
			document.getDocumentElement().normalize();

			return displayNode(document.getDocumentElement(), "");
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al leer el archivo XML: " + e.getMessage();
		}
	}

	public static String displayNode(Node node, String indent) {
		StringBuilder result = new StringBuilder();

		if (node instanceof Element) {
			result.append(indent).append("").append(node.getNodeName()).append("\n");
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				result.append(displayNode(children.item(i), indent + "  "));
			}
		} else if (node instanceof Text) {
			String text = ((Text) node).getWholeText().trim();
			if (!text.isEmpty()) {
				result.append(indent).append(text).append("\n");
			}
		}

		return result.toString();
	}


	public static void modificarTituloPorCodigo(Disney disney) {
		String codigoString = JOptionPane.showInputDialog("Introduce el código de la película o serie que deseas modificar el título:");

		if (codigoString == null) {
			// El usuario canceló la entrada o presionó Cancelar
			return;
		}

		try {
			int codigo = Integer.parseInt(codigoString);

			String nuevoTitulo = JOptionPane.showInputDialog("Introduce el nuevo título: ");

			if (nuevoTitulo == null) {
				// El usuario canceló la entrada o presionó Cancelar
				return;
			}

			CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
			CategoriaSeries categoriaSeries = disney.getSeries();
			boolean encontrado = false;
			
			// Busca en la lista de películas de Marvel
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
				if (pelicula.getCodigo() == codigo) {
					pelicula.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			// Busca en la lista de películas de Pixar
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
				if (pelicula.getCodigo() == codigo) {
					pelicula.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			// Busca en la lista de películas de Star Wars
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
				if (pelicula.getCodigo() == codigo) {
					pelicula.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			// Busca en la lista de películas de Disney Classic
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
				if (pelicula.getCodigo() == codigo) {
					pelicula.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			// Si no se encontró en las películas, busca en las series
			for (Serie serie : categoriaSeries.getSeriesMarvel()) {
				if (serie.getCodigo() == codigo) {
					serie.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			for (Serie serie : categoriaSeries.getSeriesPixar()) {
				if (serie.getCodigo() == codigo) {
					serie.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			for (Serie serie : categoriaSeries.getSeriesStarWars()) {
				if (serie.getCodigo() == codigo) {
					serie.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}

			for (Serie serie : categoriaSeries.getSeriesDisney()) {
				if (serie.getCodigo() == codigo) {
					serie.setTitulo(nuevoTitulo);
					encontrado = true;
				}
			}
			
			if (encontrado) JOptionPane.showMessageDialog(null, "Titulo modificado correctamente!");
			else JOptionPane.showMessageDialog(null, "No se encontró ninguna película o serie con el código " + codigo);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Por favor, introduce un código válido.");
		}
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
	
	public static int espectadoresAnuales(Disney disney, int codigo) {
		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		CategoriaSeries categoriaSeries = disney.getSeries();

		// Busca en las listas de películas
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		// Busca en las listas de series
		for (Serie serie : categoriaSeries.getSeriesMarvel()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		for (Serie serie : categoriaSeries.getSeriesPixar()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		for (Serie serie : categoriaSeries.getSeriesStarWars()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		for (Serie serie : categoriaSeries.getSeriesDisney()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		// Si no se encontró, devolver -1 o un valor que indique que el código no existe
		return -1;
	}

	// Método auxiliar para sumar los valores de un array
	private static int sumarEspectadoresAnuales(int[] espectadores) {
		int suma = 0;
		for (int espectadoresmes : espectadores) {
			suma += espectadoresmes;
		}
		return suma;
	}

	public static void agregarPelicula(Disney disney) {
		String titulo = JOptionPane.showInputDialog("Introduce el título de la película:");
		if (titulo == null) return; // Usuario canceló

		String codigoStr = JOptionPane.showInputDialog("Introduce el código de la película:");
		if (codigoStr == null) return;
		int codigo = Integer.parseInt(codigoStr);

		String director = JOptionPane.showInputDialog("Introduce el nombre del director:");
		if (director == null) return;

		String ratingStr = JOptionPane.showInputDialog("Introduce el rating de la película:");
		if (ratingStr == null) return;
		double rating = Double.parseDouble(ratingStr);

		Genero genero1 = (Genero) JOptionPane.showInputDialog(null, "Introduce el género 1:", "Género 1",
		        JOptionPane.QUESTION_MESSAGE, null,
		        Genero.values(), Genero.values()[0]);
		if (genero1 == null) return;

		Genero genero2 = (Genero) JOptionPane.showInputDialog(null, "Introduce el género 2:", "Género 2",
		        JOptionPane.QUESTION_MESSAGE, null,
		        Genero.values(), Genero.values()[0]);
		if (genero2 == null) return;

		Genero genero3 = (Genero) JOptionPane.showInputDialog(null, "Introduce el género 3:", "Género 3",
		        JOptionPane.QUESTION_MESSAGE, null,
		        Genero.values(), Genero.values()[0]);
		if (genero3 == null) return;

		String duracionStr = JOptionPane.showInputDialog("Introduce la duración de la película:");
		if (duracionStr == null) return;
		int duracion = Integer.parseInt(duracionStr);

		int[] espectadoresAnuales = new int[12];
		for (int i = 0; i < 12; i++) {
			espectadoresAnuales[i] = 0;
		}

		String categoria = JOptionPane.showInputDialog("Introduce la categoría (marvel, pixar, starwars o disney):").toLowerCase();
		if (categoria == null) return;

		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		List<Pelicula> listaCategoria = null;

		switch (categoria) {
		case "marvel":
			listaCategoria = categoriaPeliculas.getPeliculasMarvel();
			break;
		case "pixar":
			listaCategoria = categoriaPeliculas.getPeliculasPixar();
			break;
		case "starwars":
			listaCategoria = categoriaPeliculas.getPeliculasStarWars();
			break;
		case "disney":
			listaCategoria = categoriaPeliculas.getPeliculasDisney();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Categoría no válida");
			return;
		}

		Pelicula nuevaPelicula = new Pelicula(titulo, codigo, director, rating, genero1, genero2, genero3, duracion, espectadoresAnuales);
		listaCategoria.add(nuevaPelicula);

		JOptionPane.showMessageDialog(null, "Pelicula agregada a la lista de " + categoria);

		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void agregarSerie(Disney disney) {
		String titulo = JOptionPane.showInputDialog("Introduce el título de la serie:");
		if (titulo == null) return; // Usuario canceló

		String codigoStr = JOptionPane.showInputDialog("Introduce el código de la serie:");
		if (codigoStr == null) return;
		int codigo = Integer.parseInt(codigoStr);

		String director = JOptionPane.showInputDialog("Introduce el nombre del director:");
		if (director == null) return;

		String ratingStr = JOptionPane.showInputDialog("Introduce el rating de la serie:");
		if (ratingStr == null) return;
		double rating = Double.parseDouble(ratingStr);

		Genero genero1 = (Genero) JOptionPane.showInputDialog(null, "Introduce el género 1:", "Género 1",
		        JOptionPane.QUESTION_MESSAGE, null,
		        Genero.values(), Genero.values()[0]);
		if (genero1 == null) return;

		Genero genero2 = (Genero) JOptionPane.showInputDialog(null, "Introduce el género 2:", "Género 2",
		        JOptionPane.QUESTION_MESSAGE, null,
		        Genero.values(), Genero.values()[0]);
		if (genero2 == null) return;

		Genero genero3 = (Genero) JOptionPane.showInputDialog(null, "Introduce el género 3:", "Género 3",
		        JOptionPane.QUESTION_MESSAGE, null,
		        Genero.values(), Genero.values()[0]);
		if (genero3 == null) return;

		String temporadasStr = JOptionPane.showInputDialog("Introduce el numero de temporadas:");
		if (temporadasStr == null) return;
		int temporadas = Integer.parseInt(temporadasStr);

		int[] espectadoresAnuales = new int[12];
		for (int i = 0; i < 12; i++) {
			espectadoresAnuales[i] = 0;
		}

		String categoria = JOptionPane.showInputDialog("Introduce la categoría (marvel, pixar, starwars o disney):").toLowerCase();
		if (categoria == null) return;

		CategoriaSeries categoriaSeries = disney.getSeries();
		List<Serie> listaCategoria = null;

		switch (categoria) {
		case "marvel":
			listaCategoria = categoriaSeries.getSeriesMarvel();
			break;
		case "pixar":
			listaCategoria = categoriaSeries.getSeriesPixar();
			break;
		case "starwars":
			listaCategoria = categoriaSeries.getSeriesStarWars();
			break;
		case "disney":
			listaCategoria = categoriaSeries.getSeriesDisney();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Categoría no válida");
			return;
		}

		Serie nuevaSerie = new Serie(titulo, codigo, director, rating, genero1, genero2, genero3, temporadas, espectadoresAnuales);
		listaCategoria.add(nuevaSerie);

		JOptionPane.showMessageDialog(null, "Serie agregada a la lista de " + categoria);

		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static void eliminarPorCodigo(Disney disney) {
		String codigoString = JOptionPane.showInputDialog("Introduce el código de la película o serie que deseas eliminar:");

		if (codigoString == null) {
			// El usuario canceló la entrada o presionó Cancelar
			return;
		}

		try {
			int codigo = Integer.parseInt(codigoString);

			boolean peliculaEliminada = false;
			boolean serieEliminada = false;

			CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
			CategoriaSeries categoriaSeries = disney.getSeries();

			// Buscar en las listas de películas
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
				if (pelicula.getCodigo() == codigo) {
					categoriaPeliculas.getPeliculasMarvel().remove(pelicula);
					peliculaEliminada = true;
					break;
				}
			}
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
				if (pelicula.getCodigo() == codigo) {
					categoriaPeliculas.getPeliculasPixar().remove(pelicula);
					peliculaEliminada = true;
					break;
				}
			}
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
				if (pelicula.getCodigo() == codigo) {
					categoriaPeliculas.getPeliculasStarWars().remove(pelicula);
					peliculaEliminada = true;
					break;
				}
			}
			for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
				if (pelicula.getCodigo() == codigo) {
					categoriaPeliculas.getPeliculasDisney().remove(pelicula);
					peliculaEliminada = true;
					break;
				}
			}

			// Buscar en las listas de series
			for (Serie serie : categoriaSeries.getSeriesMarvel()) {
				if (serie.getCodigo() == codigo) {
					categoriaSeries.getSeriesMarvel().remove(serie);
					serieEliminada = true;
					break;
				}
			}
			for (Serie serie : categoriaSeries.getSeriesPixar()) {
				if (serie.getCodigo() == codigo) {
					categoriaSeries.getSeriesPixar().remove(serie);
					serieEliminada = true;
					break;
				}
			}
			for (Serie serie : categoriaSeries.getSeriesStarWars()) {
				if (serie.getCodigo() == codigo) {
					categoriaSeries.getSeriesStarWars().remove(serie);
					serieEliminada = true;
					break;
				}
			}
			for (Serie serie : categoriaSeries.getSeriesDisney()) {
				if (serie.getCodigo() == codigo) {
					categoriaSeries.getSeriesDisney().remove(serie);
					serieEliminada = true;
					break;
				}
			}

			if (peliculaEliminada) {
				JOptionPane.showMessageDialog(null, "Película con código " + codigo + " eliminada.");
			} else if (serieEliminada) {
				JOptionPane.showMessageDialog(null, "Serie con código " + codigo + " eliminada.");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ninguna película o serie con el código " + codigo);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, introduce un código válido.");
		}

		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static String obtenerInfoPorTitulo(Disney disney, String titulo) {
		StringBuilder info = new StringBuilder();

		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		CategoriaSeries categoriaSeries = disney.getSeries();

		// Buscar en las listas de películas
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Marvel").append("\n");
				return info.toString();
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Pixar").append("\n");
				return info.toString();
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Star Wars").append("\n");
				return info.toString();
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Disney").append("\n");
				return info.toString();
			}
		}

		// Buscar en las listas de series
		for (Serie serie : categoriaSeries.getSeriesMarvel()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Marvel").append("\n");
				return info.toString();
			}
		}
		for (Serie serie : categoriaSeries.getSeriesPixar()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Pixar").append("\n");
				return info.toString();
			}
		}
		for (Serie serie : categoriaSeries.getSeriesStarWars()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Star Wars").append("\n");

				return info.toString();
			}
		}
		for (Serie serie : categoriaSeries.getSeriesDisney()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Disney").append("\n");
				return info.toString();
			}
		}
		return "No se encontró ninguna película o serie con el título: " + titulo;
	}

}
