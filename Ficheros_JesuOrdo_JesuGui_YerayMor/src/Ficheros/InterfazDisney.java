package Ficheros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class InterfazDisney {
	
	static Disney disney = new Disney();

    private static JFrame frame;
    private static JPanel panelConFondo;
    private static JButton botonAnimado;
    private static Font fuenteBotonAnimado;
    private static GridBagConstraints constraints;
    private static JPanel panelBotonesPeliculasSeries;
    private static JPanel panelBotones;
    private static BufferedImage imagenFondo = null;
    private static Dimension dimensionFija;
    
    private static String[] opcionesPeliculasMarvel = {"Iron Man", "DeadPool"};
    private static String[] opcionesPeliculasPixar = {"Toy Story", "Cars"};
    private static String[] opcionesPeliculasStarWars = {"El Ascenso De Sky-Walker", "Han Solo"};
    private static String[] opcionesPeliculasDisney = {"El Rey Leon", "Frozen"};

    private static String[] opcionesSeriesMarvel = {"Loki", "Daredevil"};
    private static String[] opcionesSeriesPixar = {"MonstruosSA", "DugDays"};
    private static String[] opcionesSeriesStarWars = {"Mandalorian", "Kenobi"};
    private static String[] opcionesSeriesDisney = {"ChipyChop", "Dinosaurios"};

    // JComboBox para las películas
    private static JComboBox<String> desplegableMarvel = new JComboBox<>(opcionesPeliculasMarvel);
    private static JComboBox<String> desplegablePixar = new JComboBox<>(opcionesPeliculasPixar);
    private static JComboBox<String> desplegableStarWars = new JComboBox<>(opcionesPeliculasStarWars);
    private static JComboBox<String> desplegableDisney = new JComboBox<>(opcionesPeliculasDisney);

    // JComboBox para las series
    private static JComboBox<String> desplegableSeriesMarvel = new JComboBox<>(opcionesSeriesMarvel);
    private static JComboBox<String> desplegableSeriesPixar = new JComboBox<>(opcionesSeriesPixar);
    private static JComboBox<String> desplegableSeriesStarWars = new JComboBox<>(opcionesSeriesStarWars);
    private static JComboBox<String> desplegableSeriesDisney = new JComboBox<>(opcionesSeriesDisney);
    
    // Añadimos un boton que nos permita volver al inicio del programa
    private static JButton btnVolver;
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazDisney window = new InterfazDisney();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InterfazDisney() {
        initialize();
    }

    public static void initialize() {
        frame = new JFrame("Bienvenido a Disney");
        frame.setSize(1100, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        
        disney = Metodos.crearXML();

        try {
            imagenFondo = ImageIO.read(new File("imagenes/portadaMM.jpg"));
            panelConFondo = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
            panelConFondo = new JPanel();
        }

        botonAnimado = new JButton("Bienvenido a Disney");
        botonAnimado.setFont(new Font("Arial", Font.PLAIN, 20));
        botonAnimado.setBackground(new Color(0, 123, 255));
        botonAnimado.setForeground(Color.WHITE);
        botonAnimado.setFocusPainted(false);
        botonAnimado.setBorderPainted(false);
        botonAnimado.setOpaque(true);

        botonAnimado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos la estructura del XML
            	abrirXML();
                botonAnimado.setVisible(false);
                botonAnimado.setEnabled(false);
            }
        });

        try {
            BufferedImage cursorImage = ImageIO.read(new File("imagenes/varita.png"));
            Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
            frame.setCursor(customCursor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        panelConFondo.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(150, 0, 0, 0);

        panelConFondo.add(botonAnimado, constraints);
        
        btnVolver = new JButton("Volver al Inicio");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 16));
        btnVolver.setBackground(new Color(255, 0, 0));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setOpaque(true);

        // Agrega un ActionListener al botón "Volver al Inicio"
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama a un método para volver a la interfaz principal
                volverAInterfazPrincipal();
            }
        });

        // Configura la posición del botón en el panel
        constraints.gridx = 0;
        constraints.gridy = 1; // Colócalo debajo de los demás componentes
        constraints.insets = new Insets(10, 0, 10, 0); // Ajustamos los márgenes

        // Agrega el botón "Volver al Inicio" al panel
        panelConFondo.add(btnVolver, constraints);

        
        frame.add(panelConFondo);
    }
    

    // Método para volver a la interfaz principal
    private static void volverAInterfazPrincipal() {
        // Ocultar y deshabilitar componentes específicos
    	panelConFondo.setVisible(false);
    	panelConFondo.setEnabled(false);
    	
        // Habilitar el botón "botonAnimado" y mostrarlo
        botonAnimado.setEnabled(true);
        botonAnimado.setVisible(true);

        frame.validate(); // Actualiza la interfaz
    }

    public static void abrirXML() {
        panelBotonesPeliculasSeries = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton botonPeliculas = new JButton("Películas");
        JButton botonSeries = new JButton("Series");
        JButton botonMostrarXML = new JButton("Mostrar XML");
        JButton botonOtrosDatos = new JButton("Otros Datos");

        fuenteBotonAnimado = new Font("Arial", Font.PLAIN, 24);
        botonPeliculas.setFont(fuenteBotonAnimado);
        botonSeries.setFont(fuenteBotonAnimado);
        botonMostrarXML.setFont(fuenteBotonAnimado);
        botonOtrosDatos.setFont(fuenteBotonAnimado);

        Color colorFijo = new Color(0, 80, 250);
        botonPeliculas.setBackground(colorFijo);
        botonSeries.setBackground(colorFijo);
        botonMostrarXML.setBackground(colorFijo);
        botonOtrosDatos.setBackground(colorFijo);

        botonPeliculas.setForeground(Color.WHITE);
        botonSeries.setForeground(Color.WHITE);
        botonMostrarXML.setForeground(Color.WHITE);
        botonOtrosDatos.setForeground(Color.WHITE);

        botonPeliculas.setFocusPainted(false);
        botonSeries.setFocusPainted(false);
        botonMostrarXML.setFocusPainted(false);
        botonOtrosDatos.setFocusPainted(false);

        botonPeliculas.setBorderPainted(false);
        botonSeries.setBorderPainted(false);
        botonMostrarXML.setBorderPainted(false);
        botonOtrosDatos.setBorderPainted(false);

        botonPeliculas.setOpaque(true);
        botonSeries.setOpaque(true);
        botonMostrarXML.setOpaque(true);
        botonOtrosDatos.setOpaque(true);

        dimensionFija = new Dimension(200, 80);
        botonPeliculas.setPreferredSize(dimensionFija);
        botonSeries.setPreferredSize(dimensionFija);
        botonMostrarXML.setPreferredSize(dimensionFija);
        botonOtrosDatos.setPreferredSize(dimensionFija);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 20, 20);
        panelBotonesPeliculasSeries.add(botonPeliculas, constraints);

        constraints.gridx = 1;
        panelBotonesPeliculasSeries.add(botonSeries, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelBotonesPeliculasSeries.add(botonMostrarXML, constraints);

        constraints.gridx = 1;
        panelBotonesPeliculasSeries.add(botonOtrosDatos, constraints);

        panelBotonesPeliculasSeries.setOpaque(false);

        botonPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDesplegablesPeliculas();
                botonPeliculas.setVisible(false);
                botonSeries.setVisible(false);
                botonMostrarXML.setVisible(false);
                botonOtrosDatos.setVisible(false);
            }
        });
        botonSeries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDesplegablesSeries();
                botonPeliculas.setVisible(false);
                botonSeries.setVisible(false);
                botonMostrarXML.setVisible(false);
                botonOtrosDatos.setVisible(false);
            }
        });
        
        botonMostrarXML.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String mostrar = Metodos.leerXML("Disney.xml");
            	JOptionPane.showMessageDialog(frame, mostrar, "DISNEY", JOptionPane.INFORMATION_MESSAGE);
            	
                botonPeliculas.setVisible(false);
                botonSeries.setVisible(false);
                botonMostrarXML.setVisible(false);
                botonOtrosDatos.setVisible(false);
            }
        });
        
        botonOtrosDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	desplegarOtrosDatos();
                botonPeliculas.setVisible(false);
                botonSeries.setVisible(false);
                botonMostrarXML.setVisible(false);
                botonOtrosDatos.setVisible(false);
            }
        });

        panelConFondo.add(panelBotonesPeliculasSeries);
        panelConFondo.revalidate();
    }

    public static void agregarDesplegablesPeliculas() {
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear un ícono con la imagen escalada
        ImageIcon iconoMarvel = new ImageIcon("imagenes/marvel.png");
        Image imageMarvel = iconoMarvel.getImage();
        Image newImageMarvel = imageMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoMarvel = new ImageIcon(newImageMarvel);
        JButton botonDesplegarMarvel = new JButton(iconoMarvel);

        ImageIcon iconoPixar = new ImageIcon("imagenes/pixar.jpg");
        Image imagePixar = iconoPixar.getImage();
        Image newImagePixar = imagePixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoPixar = new ImageIcon(newImagePixar);
        JButton botonDesplegarPixar = new JButton(iconoPixar);

        ImageIcon iconoStarWars = new ImageIcon("imagenes/starwars.png");
        Image imageStarWars = iconoStarWars.getImage();
        Image newImageStarWars = imageStarWars.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoStarWars = new ImageIcon(newImageStarWars);
        JButton botonDesplegarStarWars = new JButton(iconoStarWars);

        ImageIcon iconoDisney = new ImageIcon("imagenes/disney.jpg");
        Image imageDisney = iconoDisney.getImage();
        Image newImageDisney = imageDisney.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoDisney = new ImageIcon(newImageDisney);
        JButton botonDesplegarDisney = new JButton(iconoDisney);

        Font fuenteBotonesDesplegar = new Font("Arial", Font.PLAIN, 16);
        botonDesplegarMarvel.setFont(fuenteBotonesDesplegar);
        botonDesplegarMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableMarvel.showPopup();
            }
        });
        botonDesplegarPixar.setFont(fuenteBotonesDesplegar);
        botonDesplegarPixar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegablePixar.showPopup();
            }
        });
        botonDesplegarStarWars.setFont(fuenteBotonesDesplegar);
        botonDesplegarStarWars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableStarWars.showPopup();
            }
        });
        botonDesplegarDisney.setFont(fuenteBotonesDesplegar);
        botonDesplegarDisney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableDisney.showPopup();
            }
        });
        
        desplegableMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peliculaSeleccionada = (String) desplegableMarvel.getSelectedItem();
                
                // Obtenemos la información de la película
                String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (peliculaSeleccionada.equals("Iron Man")) cargarImagenFondo("ironman.jpg");
                else if (peliculaSeleccionada.equals("DeadPool")) cargarImagenFondo("deadpool.jpg");
            }
        });
        
        desplegablePixar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peliculaSeleccionada = (String) desplegablePixar.getSelectedItem();
                
                // Obtenemos la información de la película
                String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (peliculaSeleccionada.equals("Toy Story")) cargarImagenFondo("toystory.jpg");
                else if (peliculaSeleccionada.equals("Cars")) cargarImagenFondo("cars.jpg");
            }
        });
        
        desplegableStarWars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peliculaSeleccionada = (String) desplegableStarWars.getSelectedItem();
                
                // Obtenemos la información de la película
                String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (peliculaSeleccionada.equals("El Ascenso De Sky Walker")) cargarImagenFondo("skywalker.jpg");
                else if (peliculaSeleccionada.equals("Han Solo")) cargarImagenFondo("hansolo.jpg");
            }
        });
        
        desplegableDisney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peliculaSeleccionada = (String) desplegableDisney.getSelectedItem();
                
                // Obtenemos la información de la película
                String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (peliculaSeleccionada.equals("El Rey Leon")) cargarImagenFondo("reyleon.jpg");
                else if (peliculaSeleccionada.equals("Frozen")) cargarImagenFondo("frozen.jpg");
            }
        });
        
        Font fuenteOpciones = new Font("Arial", Font.PLAIN, 20);
        desplegableMarvel.setFont(fuenteOpciones);
        desplegablePixar.setFont(fuenteOpciones);
        desplegableStarWars.setFont(fuenteOpciones);
        desplegableDisney.setFont(fuenteOpciones);
        ((JLabel) desplegableMarvel.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) desplegablePixar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) desplegableStarWars.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) desplegableDisney.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        desplegableMarvel.setPreferredSize(dimensionFija);
        desplegablePixar.setPreferredSize(dimensionFija);
        desplegableStarWars.setPreferredSize(dimensionFija);
        desplegableDisney.setPreferredSize(dimensionFija);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 20, 20, 20);

        panelBotonesPeliculasSeries.add(botonDesplegarMarvel, constraints);
        constraints.gridx = 1;
        panelBotonesPeliculasSeries.add(botonDesplegarPixar, constraints);
        constraints.gridx = 2;
        panelBotonesPeliculasSeries.add(botonDesplegarStarWars, constraints);
        constraints.gridx = 3;
        panelBotonesPeliculasSeries.add(botonDesplegarDisney, constraints);

        constraints.gridx = 0;
        panelBotonesPeliculasSeries.add(desplegableMarvel, constraints);
        constraints.gridx = 1;
        panelBotonesPeliculasSeries.add(desplegablePixar, constraints);
        constraints.gridx = 2;
        panelBotonesPeliculasSeries.add(desplegableStarWars, constraints);
        constraints.gridx = 3;
        panelBotonesPeliculasSeries.add(desplegableDisney, constraints);

        panelConFondo.revalidate();
    }
    
    public static void cargarImagenFondo(String nombreImagen) {
        try {
            imagenFondo = ImageIO.read(new File("imagenes/" + nombreImagen));
            panelConFondo.repaint(); //Vuelve a pintar el panel para mostrar la nueva imagen de fondo
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void agregarDesplegablesSeries() {
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear un ícono con la imagen escalada para que coincida con el tamaño del botón
        ImageIcon iconoSeriesMarvel = new ImageIcon("imagenes/marvel.png");
        Image imageSeriesMarvel = iconoSeriesMarvel.getImage();
        Image newImageSeriesMarvel = imageSeriesMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesMarvel = new ImageIcon(newImageSeriesMarvel);
        JButton botonDesplegarSeriesMarvel = new JButton(iconoSeriesMarvel);

        ImageIcon iconoSeriesPixar = new ImageIcon("imagenes/pixar.jpg");
        Image imageSeriesPixar = iconoSeriesPixar.getImage();
        Image newImageSeriesPixar = imageSeriesPixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesPixar = new ImageIcon(newImageSeriesPixar);
        JButton botonDesplegarSeriesPixar = new JButton(iconoSeriesPixar);

        ImageIcon iconoSeriesStarWars = new ImageIcon("imagenes/starwars.png");
        Image imageSeriesStarWars = iconoSeriesStarWars.getImage();
        Image newImageSeriesStarWars = imageSeriesStarWars.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesStarWars = new ImageIcon(newImageSeriesStarWars);
        JButton botonDesplegarSeriesStarWars = new JButton(iconoSeriesStarWars);

        ImageIcon iconoSeriesDisney = new ImageIcon("imagenes/disney.jpg");
        Image imageSeriesDisney = iconoSeriesDisney.getImage();
        Image newImageSeriesDisney = imageSeriesDisney.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesDisney = new ImageIcon(newImageSeriesDisney);
        JButton botonDesplegarSeriesDisney = new JButton(iconoSeriesDisney);

        Font fuenteBotonesDesplegarSeries = new Font("Arial", Font.PLAIN, 16);
        botonDesplegarSeriesMarvel.setFont(fuenteBotonesDesplegarSeries);
        botonDesplegarSeriesMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableSeriesMarvel.showPopup();
            }
        });
        botonDesplegarSeriesPixar.setFont(fuenteBotonesDesplegarSeries);
        botonDesplegarSeriesPixar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableSeriesPixar.showPopup();
            }
        });
        botonDesplegarSeriesStarWars.setFont(fuenteBotonesDesplegarSeries);
        botonDesplegarSeriesStarWars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableSeriesStarWars.showPopup();
            }
        });
        botonDesplegarSeriesDisney.setFont(fuenteBotonesDesplegarSeries);
        botonDesplegarSeriesDisney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desplegableSeriesDisney.showPopup();
            }
        });
        
        desplegableSeriesMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SerieSeleccionada = (String) desplegableSeriesMarvel.getSelectedItem();
                
                // Obtenemos la información de la Serie
                String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (SerieSeleccionada.equals("Loki")) cargarImagenFondo("loki.jpg");
                else if (SerieSeleccionada.equals("Daredevil")) cargarImagenFondo("daredevil.jpg");
            }
        });
        
        desplegableSeriesPixar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SerieSeleccionada = (String) desplegableSeriesPixar.getSelectedItem();
                
                // Obtenemos la información de la Serie
                String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (SerieSeleccionada.equalsIgnoreCase("MonstruosSA")) cargarImagenFondo("monstruosSA.jpg");
                else if (SerieSeleccionada.equalsIgnoreCase("DugDays")) cargarImagenFondo("dugDays.jpg");
            }
        });
        
        desplegableSeriesStarWars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SerieSeleccionada = (String) desplegableSeriesStarWars.getSelectedItem();
                
                // Obtenemos la información de la Serie
                String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (SerieSeleccionada.equals("Mandalorian")) cargarImagenFondo("mandalorian.jpg");
                else if (SerieSeleccionada.equals("Kenobi")) cargarImagenFondo("kenobi.jpg");
            }
        });
        
        
        desplegableSeriesDisney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SerieSeleccionada = (String) desplegableSeriesDisney.getSelectedItem();
                
                // Obtenemos la información de la Serie
                String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);
                
                // Mostramos la información en un diálogo de mensaje (JOptionPane)
                JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
                
                // Cambiamos la imagen de fondo
                if (SerieSeleccionada.equalsIgnoreCase("ChipyChop")) cargarImagenFondo("chipychop.jpg");
                else if (SerieSeleccionada.equals("Dinosaurios")) cargarImagenFondo("dinosaurios.jpg");
            }
        });


        Font fuenteOpcionesSeries = new Font("Arial", Font.PLAIN, 20);
        desplegableSeriesMarvel.setFont(fuenteOpcionesSeries);
        desplegableSeriesPixar.setFont(fuenteOpcionesSeries);
        desplegableSeriesStarWars.setFont(fuenteOpcionesSeries);
        desplegableSeriesDisney.setFont(fuenteOpcionesSeries);
        ((JLabel) desplegableSeriesMarvel.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) desplegableSeriesPixar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) desplegableSeriesStarWars.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) desplegableSeriesDisney.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        desplegableSeriesMarvel.setPreferredSize(dimensionFija);
        desplegableSeriesPixar.setPreferredSize(dimensionFija);
        desplegableSeriesStarWars.setPreferredSize(dimensionFija);
        desplegableSeriesDisney.setPreferredSize(dimensionFija);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 20, 20, 20);

        panelBotonesPeliculasSeries.add(botonDesplegarSeriesMarvel, constraints);
        constraints.gridx = 1;
        panelBotonesPeliculasSeries.add(botonDesplegarSeriesPixar, constraints);
        constraints.gridx = 2;
        panelBotonesPeliculasSeries.add(botonDesplegarSeriesStarWars, constraints);
        constraints.gridx = 3;
        panelBotonesPeliculasSeries.add(botonDesplegarSeriesDisney, constraints);

        constraints.gridx = 0;
        panelBotonesPeliculasSeries.add(desplegableSeriesMarvel, constraints);
        constraints.gridx = 1;
        panelBotonesPeliculasSeries.add(desplegableSeriesPixar, constraints);
        constraints.gridx = 2;
        panelBotonesPeliculasSeries.add(desplegableSeriesStarWars, constraints);
        constraints.gridx = 3;
        panelBotonesPeliculasSeries.add(desplegableSeriesDisney, constraints);

        panelConFondo.revalidate();
    }
    
    public static void desplegarOtrosDatos() {
    	panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        frame.getContentPane().add(panelBotones, BorderLayout.CENTER);

        //Creamos los botones
        JButton btnModificarTitulo = new JButton("Modificar Título");
        JButton btnAgregarPelicula = new JButton("Agregar Película");
        JButton btnAgregarSerie = new JButton("Agregar Serie");
        JButton btnEliminarContenido = new JButton("Eliminar Contenido");
        
        fuenteBotonAnimado = new Font("Arial", Font.PLAIN, 24);
        btnModificarTitulo.setFont(fuenteBotonAnimado);
        btnAgregarPelicula.setFont(fuenteBotonAnimado);
        btnAgregarSerie.setFont(fuenteBotonAnimado);
        btnEliminarContenido.setFont(fuenteBotonAnimado);

        Color colorFijo = new Color(0, 80, 250);
        btnModificarTitulo.setBackground(colorFijo);
        btnAgregarPelicula.setBackground(colorFijo);
        btnAgregarSerie.setBackground(colorFijo);
        btnEliminarContenido.setBackground(colorFijo);

        btnModificarTitulo.setForeground(Color.WHITE);
        btnAgregarPelicula.setForeground(Color.WHITE);
        btnAgregarSerie.setForeground(Color.WHITE);
        btnEliminarContenido.setForeground(Color.WHITE);

        btnModificarTitulo.setFocusPainted(false);
        btnAgregarPelicula.setFocusPainted(false);
        btnAgregarSerie.setFocusPainted(false);
        btnEliminarContenido.setFocusPainted(false);

        btnModificarTitulo.setBorderPainted(false);
        btnAgregarPelicula.setBorderPainted(false);
        btnAgregarSerie.setBorderPainted(false);
        btnEliminarContenido.setBorderPainted(false);

        btnModificarTitulo.setOpaque(true);
        btnAgregarPelicula.setOpaque(true);
        btnAgregarSerie.setOpaque(true);
        btnEliminarContenido.setOpaque(true);

        dimensionFija = new Dimension(250, 120);
        btnModificarTitulo.setPreferredSize(dimensionFija);
        btnAgregarPelicula.setPreferredSize(dimensionFija);
        btnAgregarSerie.setPreferredSize(dimensionFija);
        btnEliminarContenido.setPreferredSize(dimensionFija);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 20, 20);
        panelBotones.add(btnAgregarPelicula, constraints);

        constraints.gridx = 1;
        panelBotones.add(btnAgregarSerie, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelBotones.add(btnModificarTitulo, constraints);

        constraints.gridx = 1;
        panelBotones.add(btnEliminarContenido, constraints);

        panelBotones.setOpaque(false);

        //Agregamos ActionListener para cada botón
        btnModificarTitulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Metodos.modificarTituloPorCodigo(disney);
            }
        });

        btnAgregarPelicula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Metodos.agregarPelicula(disney);
            }
        });

        btnAgregarSerie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Metodos.agregarSerie(disney);
            }
        });

        btnEliminarContenido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Metodos.eliminarPorCodigo(disney);
            }
        });
    }
}

