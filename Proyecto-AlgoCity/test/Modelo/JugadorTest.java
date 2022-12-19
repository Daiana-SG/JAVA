package Modelo;

import static org.junit.Assert.*;

import org.junit.*;

public class JugadorTest {
	
	@Test
	public void DeberiaCrearUnJugadorConNombreDineroYSinMapa(){
		
		Jugador unJugador = new Jugador ( "Andres" , 5000 );
		
		assertEquals(unJugador.obtenerNombre(),"Andres");
		assertTrue(unJugador.obtenerDinero() == 5000);
		assertTrue(unJugador.obtenerMapa() == null);
	}
	
	@Test
	public void DeberiaConstruirUnaCasaEnLaPosicionPedida(){
		
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ( "Andres" , 5000 );
		unJugador.asignarMapa(unMapa);
		unJugador.construirRuta(5, 5);
		Tierra unaTierra = (Tierra)unMapa.obtenerHectareaEnPosicion(5,5 ).obtenerSuperficie();
		unaTierra.crearLineaDeTension();
		unJugador.construirCentralEolica(3, 5);
		unJugador.construirResidencia(4, 5);
		
		assertEquals(unMapa.obtenerHectareaEnPosicion(5,5).dibujarSuperficie(),"Rt");
		assertEquals(unMapa.obtenerHectareaEnPosicion(4,5).dibujarSuperficie(),"R");
		
	}

	@Test
	public void DeberiaConstruirUnaCasaYRestarDinero(){
		
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ( "Andres" , 5000 );
		unJugador.asignarMapa(unMapa);
		unJugador.construirRuta(3,4);
		unJugador.construirCentralEolica(4, 4);
		Tierra unaTierra = (Tierra)unMapa.obtenerHectareaEnPosicion(3,4 ).obtenerSuperficie();
		unaTierra.crearLineaDeTension();
		unJugador.construirResidencia(4, 5);
		
		assertEquals(unMapa.obtenerHectareaEnPosicion(3,4).dibujarSuperficie(),"Rt");
		assertEquals(unMapa.obtenerHectareaEnPosicion(4,5).dibujarSuperficie(),"R");
		assertTrue(unJugador.obtenerDineroDisponible() == 3985);	
	}
	
	@Test
	public void NoDeberiaPoderConstruirLaIndustriaPorFaltaDeDinero(){
		
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ( "Andres" , 7 );
		unJugador.asignarMapa(unMapa);
		
		unJugador.construirIndustria(9 , 5);
		
		assertEquals(unMapa.obtenerHectareaEnPosicion(9,5).obtenerSuperficie().tieneConstruccion(),false);
		assertTrue(unJugador.obtenerDineroDisponible() == 7);
		
	}
	
	@Test
	public void DeberiaPoderConstruirLaIndustria(){
		
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ( "Andres" , 3020 );
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralMineral(7, 4);
		unJugador.construirRuta(6, 5);
		Tierra unaTierra = (Tierra)unMapa.obtenerHectareaEnPosicion(6,5 ).obtenerSuperficie();
		unaTierra.crearLineaDeTension();
		unJugador.construirIndustria(7 , 5);
		
		assertEquals(unMapa.obtenerHectareaEnPosicion(7,5).dibujarSuperficie(),"I");
		assertTrue(unJugador.obtenerDineroDisponible() == 0);
		
	}
	@Test 
	public void DeberiaPorderUbicarUnPozoDeAguaSiLaSuperficieEsAguaYDecrementaElDineroDelJugador(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Daiana" , 7000);
		unJugador.asignarMapa(unMapa);
		unJugador.construirPozoDeAgua(9,1); 
		
		assertEquals(unMapa.obtenerHectareaEnPosicion(9,1).dibujarSuperficie(),"P");
		assertTrue(unJugador.obtenerDineroDisponible() == 6750);		
	}
	@Test
	public void DebeDecrementarElMontoDelJugadorAlCrearUnaEstacionDeBomberos(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(2,1);
		Tierra unaTierra = new Tierra();
		unaHectarea.asignarSuperficie(unaTierra);
		Jugador unJugador = new Jugador ("Daiana" , 3000);
		unJugador.asignarMapa(unMapa);
		unJugador.construirEstacionDeBomberos(2, 1); 
		EstacionDeBomberos bomberos = new EstacionDeBomberos (unaTierra);
		unaTierra.construir(bomberos); 
		
		assertTrue(unJugador.obtenerDineroDisponible() == 1500);
		
	}
	
	@Test
	public void DeberiaCrearTendidoElectricoEnElTramoYPedido(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 1500);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralEolica(0,1);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(0, 1);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(0, 5);
		unJugador.construirLineasDeTension(origen, destino);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(0,1).dibujarSuperficie() == "Ce");
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 2).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 3).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 5).obtenerSuperficie().tieneLuz());
		assertFalse(unMapa.obtenerHectareaEnPosicion(2, 3).obtenerSuperficie().tieneLuz());
		assertTrue(unJugador.obtenerDinero() == 460);
	}
	
	@Test
	public void DeberiaCrearTendidoElectricoEnElTramoXPedido(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3100);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralMineral(0,4);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(0, 4);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(5, 4);
		unJugador.construirLineasDeTension(origen, destino);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(0 , 4).dibujarSuperficie() == "Cm");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(2 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(3 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(4 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5 , 4).obtenerSuperficie().tieneLuz());
		assertFalse(unMapa.obtenerHectareaEnPosicion(2 , 5).obtenerSuperficie().tieneLuz());
		assertTrue(unJugador.obtenerDinero() == 50);
	}
	
	@Test
	public void DeberiaCrearTendidoElectricoEnFormaDeEle(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3200);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralMineral(0,4);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(0, 4);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(5, 4);
		unJugador.construirLineasDeTension(origen, destino);
		origen = unMapa.obtenerHectareaEnPosicion(5, 4);
		destino = unMapa.obtenerHectareaEnPosicion(5, 0);
		unJugador.construirLineasDeTension(origen, destino);
		
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(0 , 4).dibujarSuperficie() == "Cm");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(2 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(3 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(4 , 4).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5 , 4).obtenerSuperficie().tieneLuz());
		assertFalse(unMapa.obtenerHectareaEnPosicion(2 , 5).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5 , 3).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5 , 2).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5 , 1).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5 , 0).obtenerSuperficie().tieneLuz());
		assertTrue(unJugador.obtenerDinero() == 110);
	}
	
	@Test
	public void DeberiaConstruirCentralEolicaRutaYComercio(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3200);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralEolica(0, 0);
		unJugador.construirRuta(1, 0);
		unJugador.construirComercio(2, 0);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 0).dibujarSuperficie()=="Ce");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(2, 0).dibujarSuperficie()=="C");
		assertTrue(unJugador.obtenerDinero() == 2185);
		
	}
	
	@Test
	public void DeberiaConstruirCentralEolicaRutaPeroNoComercio(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3200);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralEolica(0, 0);
		unJugador.construirRuta(1, 0);
		unJugador.construirRuta(2, 0);
		unJugador.construirRuta(3, 0);
		unJugador.construirRuta(4, 0);
		unJugador.construirRuta(5, 0);
		unJugador.construirRuta(6, 0);
		unJugador.construirComercio(7, 0);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 0).dibujarSuperficie()=="Ce");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(2, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(3, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(4, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(5, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(6, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(7, 0).dibujarSuperficie()=="T");
		assertTrue(unJugador.obtenerDinero() == 2140);
		
	}
	
	@Test
	public void DeberiaConstruirCentralEolicaRutaYComercioConLuzPorCercaniaACentral(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3200);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralEolica(0, 0);
		unJugador.construirRuta(1, 0);
		unJugador.construirRuta(2, 0);
		unJugador.construirRuta(3, 0);
		unJugador.construirComercio(4, 0);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(0, 0).dibujarSuperficie()=="Ce");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(2, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(3, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(4, 0).dibujarSuperficie()=="C");
		assertTrue(unJugador.obtenerDinero() == 2165);
		
	}
	
	@Test
	public void DeberiaConstruirCentralEolicaRutaYResidencia(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3200);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralEolica(1, 0);
		unJugador.construirRuta(2, 0);
		unJugador.construirRuta(3, 0);
		unJugador.construirRuta(4, 0);
		unJugador.construirRuta(5, 0);
		unJugador.construirLineasDeTension(unMapa.obtenerHectareaEnPosicion(1, 0),unMapa.obtenerHectareaEnPosicion(5, 0));
		//unJugador.construirResidencia(7, 0);
		
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 0).dibujarSuperficie()=="Ce");
		assertTrue(unMapa.obtenerHectareaEnPosicion(2, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(3, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(4, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(5, 0).dibujarSuperficie()=="Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1,0 ).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(2,0 ).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(3,0 ).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(4,0 ).obtenerSuperficie().tieneLuz());
		assertTrue(unMapa.obtenerHectareaEnPosicion(5,0 ).obtenerSuperficie().tieneLuz());
		
		
		//assertTrue(unMapa.obtenerHectareaEnPosicion(7, 0).dibujarSuperficie()=="R");
		assertTrue(unJugador.obtenerDinero() == 2120);
		
	}
	
	@Test
	public void DeberiaConstruirEstacionDeBomberos(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 3200);
		unJugador.asignarMapa(unMapa);
		unJugador.construirEstacionDeBomberos(1, 0);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 0).dibujarSuperficie()=="B");
		assertTrue(unJugador.obtenerDinero() == 1700);
		
	}
	
	@Test
	public void DeberiaConstruirRutasEnY(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 500);
		unJugador.asignarMapa(unMapa);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(1, 2);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(1, 5);
		unJugador.construirRuta(origen, destino);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 3).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 4).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 5).dibujarSuperficie()== "Rt");
		assertTrue(unJugador.obtenerDinero() == 460);
	}
	
	@Test
	public void DeberiaConstruirRutasEnX(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 500);
		unJugador.asignarMapa(unMapa);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(6, 2);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(1, 2);
		unJugador.construirRuta(origen, destino);
		
		assertTrue(unMapa.obtenerHectareaEnPosicion(1, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(2, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(3, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(4, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(5, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(6, 2).dibujarSuperficie()== "Rt");
		assertTrue(unJugador.obtenerDinero() == 440);
	}
	
	@Test
	public void NoDeberiaConstruirRutasEnX(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Jugador unJugador = new Jugador ("Andres" , 1500);
		unJugador.asignarMapa(unMapa);
		unJugador.construirCentralEolica(4, 2);
		Hectarea origen = unMapa.obtenerHectareaEnPosicion(6, 2);
		Hectarea destino = unMapa.obtenerHectareaEnPosicion(1, 2);
		unJugador.construirRuta(origen, destino);
		
		assertFalse(unMapa.obtenerHectareaEnPosicion(1, 2).dibujarSuperficie()== "Rt");
		assertFalse(unMapa.obtenerHectareaEnPosicion(2, 2).dibujarSuperficie()== "Rt");
		assertFalse(unMapa.obtenerHectareaEnPosicion(3, 2).dibujarSuperficie()== "Rt");
		assertTrue(unMapa.obtenerHectareaEnPosicion(4, 2).dibujarSuperficie()== "Ce");
		assertFalse(unMapa.obtenerHectareaEnPosicion(5, 2).dibujarSuperficie()== "Rt");
		assertFalse(unMapa.obtenerHectareaEnPosicion(6, 2).dibujarSuperficie()== "Rt");
		assertTrue(unJugador.obtenerDinero() == 500);
	}
	


}
