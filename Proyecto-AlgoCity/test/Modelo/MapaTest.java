package Modelo;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import Modelo.Excepciones.ExcepcionCoordenadasFueraDelMapa;

public class MapaTest {
	
	
	
	@Test
	public void DeberiaObtenerLaHectareaReferenciada(){
		Mapa unMapa = new Mapa(5,5);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0,0);
		assertEquals(unaHectarea , unMapa.obtenerHectareaEnPosicion(0,0));
	}
	
	@Test
	public void DeberiaObtenerUnaResidenciaEnLaHectareaPedida(){
		
		Mapa unMapa = new Mapa(10,10);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(1, 1);
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		unaTierra.construir(unaResidencia);
		unaHectarea.asignarSuperficie(unaTierra);
		
		
		assertEquals(unaHectarea.dibujarSuperficie(),"R"); 
	}
	
	@Test
	public void DeberiaObtenerUnPozoDeAguaEnLaHectareaSolicitada(){
		
		Mapa unMapa = new Mapa (10,10);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(2,1);
		Agua porcionDeAgua = new Agua();
		unaHectarea.asignarSuperficie(porcionDeAgua);
		PozoDeAgua unPozo = new PozoDeAgua(porcionDeAgua);
		porcionDeAgua.construir(unPozo); 
		
		Assert.assertEquals(unaHectarea.dibujarSuperficie(),"P");
	}
	@Test
	public void DeberiaObtenerUnaRutaEnLaHectareaPedida(){
		
		Mapa unMapa = new Mapa(10,10);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(3, 3);
		Tierra unaTierra = new Tierra();
		unaHectarea.asignarSuperficie(unaTierra);
		RutaPavimentada unaRuta = new RutaPavimentada(unaTierra);
		unaTierra.construir(unaRuta);
		
		
		assertEquals(unaHectarea.dibujarSuperficie(),"Rt"); 
	}
	
	@Test
	public void DeberiaLanzarExcepcionDeCoordenadasFueraDeMapa(){
		Mapa unMapa = new Mapa(5,5);
		
		try {
			Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(7,9);
			fail();
		}
		catch(ExcepcionCoordenadasFueraDelMapa excep){}	
	}
	
	@Test
	public void DeberiaObtenerSoloLasHectareasAledaniasQueSeEncuentranEnMapaSobreLateral(){
		//esto hay que hacerlo random
		Mapa unMapa = new Mapa(10,10);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0, 1);
		
		ArrayList<Hectarea> hectareasVecinas = unMapa.obtenerHectareasAledanias(unaHectarea);
		
		
		assertEquals(hectareasVecinas.size(),5); 
	}
	
	@Test
	public void DeberiaObtenerSoloLasHectareasAledaniasQueSeEncuentranEnMapaSobreEsquina(){
		
		Mapa unMapa = new Mapa(10,10);
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0, 0);
		
		ArrayList<Hectarea> hectareasVecinas = unMapa.obtenerHectareasAledanias(unaHectarea);
		
		
		assertEquals(hectareasVecinas.size(),3); 
	}
	
	@Test
	public void DeberiaObtenerLasHectareasAledaniasALaPedida(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(4, 5);
		ArrayList<Hectarea> hectareasVecinas = unMapa.obtenerHectareasAledanias(unaHectarea);
		
		assertEquals(hectareasVecinas.size(),5);
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(3,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(4,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(5,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(3,5)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(5,5)));
		
	}

	@Test
	public void DeberiaObtenerLasHectareasAledaniasALaPedidaSegunRadio(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(4,5);
		ArrayList<Hectarea> hectareasVecinas = unMapa.obtenerHectareasAledanias(unaHectarea,2);
		
		assertEquals(hectareasVecinas.size(),14);
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(3,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(4,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(5,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(3,5)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(5,5)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(2,3)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(2,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(2,5)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(3,3)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(4,3)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(5,3)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(6,3)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(6,4)));
		assertTrue(hectareasVecinas.contains(unMapa.obtenerHectareaEnPosicion(6,5)));
	}
	
	@Test
	public void DeberiaObtenerLasReferenciasPorCadaConstruccion(){
		Mapa unMapa = new Mapa(10,10);
		//se construye una residencia
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0,0);
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		unaTierra.construir(unaResidencia);
		unaHectarea.asignarSuperficie(unaTierra);
		
		//se construye un comercio
		Hectarea unaHectarea2 = unMapa.obtenerHectareaEnPosicion(2,2);
		Tierra unaTierra2 = new Tierra();
		Comercial unComercio = new Comercial(unaTierra);
		unaTierra2.construir(unComercio);
		unaHectarea2.asignarSuperficie(unaTierra2);
		
		assertEquals(unaHectarea.dibujarSuperficie(),"R"); 
		assertEquals(unaHectarea2.dibujarSuperficie(),"C"); 
	
	}
	
	@Test
	public void DeberiaObtenerLasHectareasDeConstruccionesUbicadas(){
		Mapa unMapa = new Mapa(10,10);
		//se construye una residencia
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0,0);
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		unaTierra.construir(unaResidencia);
		unaHectarea.asignarSuperficie(unaTierra);
		//se construte una ruta
		Hectarea unaHectarea2 = unMapa.obtenerHectareaEnPosicion(2, 5);
		Tierra unaTierra2 = new Tierra();
		unaHectarea2.asignarSuperficie(unaTierra2);
		RutaPavimentada unaRuta = new RutaPavimentada(unaTierra2);
		unaTierra2.construir(unaRuta);
		//se construye un Pozo de agua
		Hectarea unaHectarea3 =unMapa.obtenerHectareaEnPosicion(8, 8);
		Agua porcionDeAgua = new Agua();
		unaHectarea3.asignarSuperficie(porcionDeAgua);
		PozoDeAgua unPozo = new PozoDeAgua(porcionDeAgua);
		porcionDeAgua.construir(unPozo);
				
		
		assertEquals(unaHectarea.dibujarSuperficie(),"R"); 
		assertEquals(unaHectarea , unMapa.obtenerHectareaEnPosicion(0,0));
		assertEquals(unaHectarea2.dibujarSuperficie(),"Rt"); 
		assertEquals(unaHectarea2 , unMapa.obtenerHectareaEnPosicion(2, 5));
		assertEquals(unaHectarea3.dibujarSuperficie(),"P"); 
		assertEquals(unaHectarea3 , unMapa.obtenerHectareaEnPosicion(8, 8));
	}
	
	@Test
	public void testVerificaTipoDeSuperficieEnUnaHectareaXLuegoDeCreacionDeMapaDesdeUnArchivo(){
		Mapa unMapa = new Mapa();
		unMapa.cargarMapa();
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(8, 0);
		Superficie superficie = unaHectarea.obtenerSuperficie();
		assertTrue(superficie.dibujo == "A");
	}

	@Test 
	public void testConstruccionesDaniadasReconstruidaPorBomberos(){
		Mapa unMapa = new Mapa(10,10);
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		Industrial unaIndustria = new Industrial(unaTierra);
		unaIndustria.daniarEnPorcentaje(40);
		Comercial unComercio = new Comercial(unaTierra);
		unComercio = new Comercial(unaTierra);
		unComercio.daniarEnPorcentaje(50);
		
		assertTrue(unaIndustria.obtenerEstado() == 60);
		assertTrue(unComercio.obtenerEstado() == 50);
		
		bomberos.aplicarReconstruccionA(unaIndustria);
		bomberos.aplicarReconstruccionA(unComercio);
		
		assertTrue(unaIndustria.obtenerEstado() == 63);
		assertTrue(unComercio.obtenerEstado() == 57);
			
	}
}
