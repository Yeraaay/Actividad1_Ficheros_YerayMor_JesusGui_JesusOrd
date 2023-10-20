package Ficheros;

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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfazDisney {

    private JFrame frame;
    private static JPanel panelConFondo;
    private JButton botonAnimado;
    private static Font fuenteBotonAnimado;
    private GridBagConstraints constraints;
    private static JPanel panelBotonesPeliculasSeries;
    private static BufferedImage imagenFondo = null;
    private static Dimension dimensionFija;

    private static String[] opcionesPeliculas = {"MARVEL", "PIXAR", "STAR WARS", "DISNEY"};
    private static String[] opcionesSeries = {"MARVEL", "PIXAR", "STAR WARS", "DISNEY"};

    private static String[] opcionesPeliculasMarvel = {"Iron Man", "DeadPool"};
    private static String[] opcionesPeliculasPixar = {"Toy Story", "Cars"};
    private static String[] opcionesPeliculasStarWars = {"Ascenso De Sky-Walker", "Han Solo"};
    private static String[] opcionesPeliculasDisney = {"El Rey León", "Frozen"};

    private static String[] opcionesSeriesMarvel = {"Loki", "Daredevil"};
    private static String[] opcionesSeriesPixar = {"", ""};
    private static String[] opcionesSeriesStarWars = {"", ""};
    private static String[] opcionesSeriesDisney = {"", ""};

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

    // Agregamos las imágenes de los botones
    private static Icon[] iconosPeliculas = {
        new ImageIcon("marvel.png"),
        new ImageIcon("pixar.jpg"),
        new ImageIcon("starwars.png"),
        new ImageIcon("disney.jpg")
    };

    // Agregamos las imágenes de los botones para las series (ajustar los nombres de las imágenes)
    private static Icon[] iconosSeries = {
        new ImageIcon("marvel_series.png"),
        new ImageIcon("pixar_series.jpg"),
        new ImageIcon("starwars_series.png"),
        new ImageIcon("disney_series.jpg")
    };

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

    private void initialize() {
        frame = new JFrame("Bienvenido a Disney");
        frame.setSize(1100, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

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

        frame.add(panelConFondo);
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

    public static void agregarDesplegablesSeries() {
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear un ícono con la imagen escalada para que coincida con el tamaño del botón
        ImageIcon iconoSeriesMarvel = new ImageIcon("imagenes/marvel_series.png");
        Image imageSeriesMarvel = iconoSeriesMarvel.getImage();
        Image newImageSeriesMarvel = imageSeriesMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesMarvel = new ImageIcon(newImageSeriesMarvel);
        JButton botonDesplegarSeriesMarvel = new JButton(iconoSeriesMarvel);

        ImageIcon iconoSeriesPixar = new ImageIcon("imagenes/pixar_series.jpg");
        Image imageSeriesPixar = iconoSeriesPixar.getImage();
        Image newImageSeriesPixar = imageSeriesPixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesPixar = new ImageIcon(newImageSeriesPixar);
        JButton botonDesplegarSeriesPixar = new JButton(iconoSeriesPixar);

        ImageIcon iconoSeriesStarWars = new ImageIcon("imagenes/starwars_series.png");
        Image imageSeriesStarWars = iconoSeriesStarWars.getImage();
        Image newImageSeriesStarWars = imageSeriesStarWars.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
        iconoSeriesStarWars = new ImageIcon(newImageSeriesStarWars);
        JButton botonDesplegarSeriesStarWars = new JButton(iconoSeriesStarWars);

        ImageIcon iconoSeriesDisney = new ImageIcon("imagenes/disney_series.jpg");
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
}