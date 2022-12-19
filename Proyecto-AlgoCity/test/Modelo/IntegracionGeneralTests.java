package Modelo;

import static org.junit.Assert.*;
import org.junit.*;

public class IntegracionGeneralTests {
	
	@Test
	public void DeberiaContruirUnaMiniCiudad(){
		
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador("Andres",1310);
		unJugador.asignarMapa(unMapa);
		
		unJugador.construirCentralEolica(7, 0);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(0, 1);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(7, 1);
		unJugador.construirRuta(origen, destino);
		origen = unMapa.obtenerHectareaEnPosicion(7, 2);
		destino = unMapa.obtenerHectareaEnPosicion(7, 5);
		unJugador.construirRuta(origen, destino);
		origen = unMapa.obtenerHectareaEnPosicion(4, 2);
		destino = unMapa.obtenerHectareaEnPosicion(4, 5);
		unJugador.construirRuta(origen, destino);
		origen = unMapa.obtenerHectareaEnPosicion(1, 2);
		destino = unMapa.obtenerHectareaEnPosicion(1, 5);
		unJugador.construirRuta(origen, destino);
		unJugador.construirComercio(5, 0);
		unJugador.construirResidencia(6, 0);
		origen = unMapa.obtenerHectareaEnPosicion(7, 0);
		destino = unMapa.obtenerHectareaEnPosicion(2, 0);
		unJugador.construirLineasDeTension(origen, destino);
		origen = unMapa.obtenerHectareaEnPosicion(2, 0);
		destino = unMapa.obtenerHectareaEnPosicion(2, 4);
		unJugador.construirLineasDeTension(origen, destino);
		
		unJugador.construirIndustria(2, 4);
		
		assertTrue(unJugador.obtenerDinero()== 0);
		assertTrue(unMapa.obtenerHectareaEnPosicion(2, 4).dibujarSuperficie() == "I");

	}
	

}
