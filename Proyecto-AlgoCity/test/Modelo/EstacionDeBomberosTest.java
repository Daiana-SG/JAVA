package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstacionDeBomberosTest {

	@Test
	public void BomberosCreadosCon100DeEstado(){
		
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos(unaTierra);
		
		assertTrue(bomberos.obtenerEstado() == 100.0);
	}
	@Test
	public void AlSufrirunaCatastrofeNoSeModificaSuEstado(){
		Mapa unMapa = new Mapa(10,10);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(5,5);
		//Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos(unaHectarea.obtenerSuperficie());
		unaHectarea.obtenerSuperficie().construir(bomberos);
		
		unMapa.aplicarTerremoto(5, 5);
		
		assertTrue(bomberos.obtenerEstado() == 100.0); 
	}
	
	@Test
	public void estacionDeBomberosReparaConstrucciones(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		
		unMapa.construirRutaPavimentada(5, 3);
		unMapa.construirLineasDeTension(unMapa.obtenerHectareaEnPosicion(5,3), unMapa.obtenerHectareaEnPosicion(5,2));
		unMapa.construirTuberiaDeAgua(unMapa.obtenerHectareaEnPosicion(5, 3), unMapa.obtenerHectareaEnPosicion(5, 2));
		
		unMapa.construirResidencial(5,2);
		unMapa.construirResidencial(1,4);
		
		Construccion unaResidencia = unMapa.obtenerHectareaEnPosicion(5, 2).obtenerSuperficie().obtenerConstruccion();
		Construccion otraResidencia = unMapa.obtenerHectareaEnPosicion(5, 3).obtenerSuperficie().obtenerConstruccion();
		
		unMapa.aplicarTerremoto(2, 3);
		
		float estadoDeUnaResidenciaPostTerremoto = unaResidencia.obtenerEstado();
		float estadoDeOtraResidenciaPostTerremoto = otraResidencia.obtenerEstado();
		
		unMapa.construirEstacionDeBomberos(2, 4);
		
		Hectarea hectareaConEstacionDeBomberos = unMapa.obtenerHectareaEnPosicion(2, 4);
		EstacionDeBomberos estacionDeBomberos = (EstacionDeBomberos) hectareaConEstacionDeBomberos.obtenerSuperficie().obtenerConstruccion();
		
		int resultadoDeCompracionUnaResidencia = Float.compare(unaResidencia.obtenerEstado(),estadoDeUnaResidenciaPostTerremoto);
		int resultadoDeCompracionOtraResidencia = Float.compare(otraResidencia.obtenerEstado(),estadoDeOtraResidenciaPostTerremoto);
		
		assertTrue(resultadoDeCompracionUnaResidencia >= 0);
		assertTrue(resultadoDeCompracionUnaResidencia >= 0);	
	}
		
}


