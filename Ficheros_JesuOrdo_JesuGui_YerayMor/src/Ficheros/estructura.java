package Ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class estructura {

	public static void crearXML() {
		try {
			//Creamos un objeto "DocumentBuilderFactory"
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			//Creamos un objeto "DocumentBuilder"
			DocumentBuilder builder = factory.newDocumentBuilder();

			//Creamos un nuevo documento "XML"
			Document document = builder.newDocument();

			//Crea el elemento raiz
			Element raizDisney = document.createElement("Disney");

			//Agreamos dicha raiz al documento creado
			document.appendChild(raizDisney);

			//Creamos los elementos y sus atributos

			//ELEMENTO PELICULAS Y SUS RESPECTIVOS ELEMENTOS
			Element peliculas = document.createElement("Peliculas");
			//Elementos hijos de "Peliculas"
			Element p_marvel = document.createElement("Marvel");    
			Element p_pixar = document.createElement("Pixar");    
			Element p_starWras = document.createElement("Star Wars");    
			Element p_nationalGeographic = document.createElement("National Geographic");
			Element p_disneyClassic= document.createElement("Disney Classic");

			//Elementos hijos de "Marvel"
			Element ironMan = document.createElement("Iron-Man");
			Element deadPool = document.createElement("DeadPool");

			//Elementos hijos de "Pixar"
			Element toyStory = document.createElement("Toy Story");
			Element cars = document.createElement("Cars");

			//Elementos hijos de "Star Wars"
			Element elAscensoDeSkyWalker = document.createElement("El Ascenso De Sky Walker");
			Element hanSolo = document.createElement("Han Solo");

			//Elementos hijos de "National Geographic"
			Element pompeya = document.createElement("La Verdad Sobre Pompeya");
			Element invasionExtraterrestre = document.createElement("Invasion Extraterrestre");

			//Elementos hijos de "Disney Classic"
			Element reyLeon = document.createElement("El Rey León");
			Element frozen = document.createElement("Frozen");
			
			
			
			//ELEMENTO SERIES Y SUS RESPECTIVOS ELEMENTOS
			Element series = document.createElement("Peliculas");
			//Elementos hijos de "Peliculas"
			Element s_marvel = document.createElement("Marvel");    
			Element s_pixar = document.createElement("Pixar");    
			Element s_starWras = document.createElement("Star Wars");    
			Element s_nationalGeographic = document.createElement("National Geographic");
			Element s_disneyClassic= document.createElement("Disney Classic");

			//Elementos hijos de "Marvel"
			Element loki = document.createElement("Loki");
			Element daredevil = document.createElement("Daredevil");

			//Elementos hijos de "Pixar"
			Element monstruosSA = document.createElement("Monstruos S.A.");
			Element dugDays = document.createElement("Dug Days");

			//Elementos hijos de "Star Wars"
			Element mandalorian = document.createElement("The Mandalorian");
			Element kenobi = document.createElement("Obi-Wan Kenobi");

			//Elementos hijos de "National Geographic"
			Element vivirBajoCero = document.createElement("Vivir Bajo Cero");
			Element cosmos = document.createElement("Cosmos");

			//Elementos hijos de "Disney Classic"
			Element hercules = document.createElement("Hércules");
			Element aladdin = document.createElement("Aladdin");
			
			
			//Añadimos los elementos hijos al elemento padre
			raizDisney.appendChild(peliculas);
			raizDisney.appendChild(series);
			
			//Añadimos las peliculas al padre "Peliuclas"
			peliculas.appendChild(p_marvel);
			peliculas.appendChild(p_pixar);
			peliculas.appendChild(p_starWras);
			peliculas.appendChild(p_nationalGeographic);
			peliculas.appendChild(p_disneyClassic);
			
			//Añadimos las series al padre "Series"
			series.appendChild(s_marvel);
			series.appendChild(s_pixar);
			series.appendChild(s_starWras);
			series.appendChild(s_nationalGeographic);
			series.appendChild(s_disneyClassic);
			
			//Añadimos las Peliculas
			p_marvel.appendChild(ironMan);
			p_marvel.appendChild(deadPool);
			
			p_pixar.appendChild(toyStory);
			p_pixar.appendChild(cars);
			
			p_starWras.appendChild(elAscensoDeSkyWalker);
			p_starWras.appendChild(hanSolo);
			
			p_nationalGeographic.appendChild(pompeya);
			p_nationalGeographic.appendChild(invasionExtraterrestre);
			
			p_disneyClassic.appendChild(reyLeon);
			p_disneyClassic.appendChild(frozen);
			
			//Añadimos las Series
			s_marvel.appendChild(loki);
			s_marvel.appendChild(daredevil);
			
			s_pixar.appendChild(monstruosSA);
			s_pixar.appendChild(dugDays);
			
			s_starWras.appendChild(mandalorian);
			s_starWras.appendChild(kenobi);
			
			s_nationalGeographic.appendChild(vivirBajoCero);
			s_nationalGeographic.appendChild(cosmos);
			
			s_disneyClassic.appendChild(hercules);
			s_disneyClassic.appendChild(aladdin);
			
			
			

//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage().toString());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage().toString());
//		} catch (IOException e) {
//			System.out.println(e.getMessage().toString());
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}


}