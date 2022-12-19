package Controlador;

import java.awt.event.ActionListener;

import Modelo.*;
import Vista.*;


public class Controlador  {
	
	private Mapa unMapa;
	private Jugador unJugador;
    private Ventana vista;

    public Controlador(Mapa unMapa,Jugador unJugador, Ventana vista) {
    	this.unMapa = unMapa;
    	this.unJugador = unJugador;
    	this.vista = vista;
       	
   }
    //public void setVista(VistaConsola vista) {
       // this.vista = vista;
       

}
