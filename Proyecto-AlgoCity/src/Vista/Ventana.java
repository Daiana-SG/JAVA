package Vista;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class Ventana {

	public static void main(String[]args){
		JFrame ventana = new JFrame("AlgoCity");
		ventana.setSize(700,500);
		ventana.getContentPane().setLayout(new FlowLayout());
		
		JLabel etiqueta = new JLabel(); 
		etiqueta.setText("Coloque en el Mapa:"); 		
		ventana.getContentPane().add(etiqueta);
		
		SpringLayout layout = new SpringLayout();
		ventana.setLayout(layout);
		//creo los botones
		JButton botonIndustria = new JButton("Industria");
		//se posicionan los botones
		layout.putConstraint(SpringLayout.SOUTH,botonIndustria, 50, SpringLayout.SOUTH, ventana);
		JButton botonResidencia = new JButton("Residencia");
		layout.putConstraint(SpringLayout.SOUTH,botonResidencia, 80 ,SpringLayout.SOUTH, ventana);
		JButton botonComercio = new JButton("Comercio");
		layout.putConstraint(SpringLayout.SOUTH,botonComercio, 110, SpringLayout.SOUTH, ventana);
		JButton botonBomberos = new JButton("Est Bomeros");
		layout.putConstraint(SpringLayout.SOUTH,botonBomberos, 140, SpringLayout.SOUTH, ventana);
		botonBomberos.setBackground(Color.RED); 
		JButton botonPozo = new JButton("Pozo de Agua");
		layout.putConstraint(SpringLayout.SOUTH,botonPozo, 170, SpringLayout.SOUTH, ventana);
		JButton botonCEolica = new JButton("Central Eolica");
		layout.putConstraint(SpringLayout.SOUTH,botonCEolica, 200, SpringLayout.SOUTH, ventana);
		JButton botonCMineral = new JButton("Central Mineral");
		layout.putConstraint(SpringLayout.SOUTH,botonCMineral, 230, SpringLayout.SOUTH, ventana);
		JButton botonCNuclear = new JButton("Central Nuclear");
		layout.putConstraint(SpringLayout.SOUTH,botonCNuclear, 260, SpringLayout.SOUTH, ventana);
		
		ventana.getContentPane().add(botonIndustria);
		ventana.getContentPane().add(botonResidencia);
		ventana.getContentPane().add(botonComercio);
		ventana.getContentPane().add(botonBomberos);
		ventana.getContentPane().add(botonPozo);
		ventana.getContentPane().add(botonCEolica);
		ventana.getContentPane().add(botonCMineral);
		ventana.getContentPane().add(botonCNuclear);
		
		
		JLabel campoDeEstado = new JLabel(); 
		campoDeEstado.setText("Barra de Estado:"); 
		JTextField campoDeMensajes = new JTextField("Ejemplo",20);
		layout.putConstraint(SpringLayout.WEST,campoDeEstado, 200,SpringLayout.WEST, ventana);
		layout.putConstraint(SpringLayout.WEST,campoDeMensajes, 300,SpringLayout.WEST, ventana);
		
		ventana.getContentPane().add(campoDeEstado);
		ventana.getContentPane().add(campoDeMensajes);
		//se hace visible la ventana
		ventana.setVisible(true);
	}
}
