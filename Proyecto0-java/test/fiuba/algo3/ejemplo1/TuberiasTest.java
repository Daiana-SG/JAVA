package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TuberiasTest {

	private Mapa coordenadas;
	
	@Test
	public void AlCrearUnaTuberiaDevuelveElObjetoTuberia(){
	
		Hectarea unaHectarea = new Hectarea(1,2);
		Tuberia unaTuberia = new Tuberia(unaHectarea);				
				
		Assert.assertEquals(unaTuberia.ubicacion(),unaHectarea);
					
	}
	
	@Test
	public void siHayAguaPuedoCrearUnPozo() {
		
		Juego juego = new Juego();
		Mapa mapa = new Mapa();
		Hectarea hectarea = new Hectarea(); 
		mapa.ubicarEctarea = (1,2); //ver bien esto
		juego.agregarPozo(); 
		
		Assert.assertEquals(hectarea.getContenido =='agua', result);
	}
	
	@Test
	public void siNoHayAguaYSeQuiereCrearUnPozoLanzarExcepcion{
		
		Mapa mapa = new Mapa ();
		Hectarea hectarea = new Hectarea(); 
		mapa.ubicarEctarea = (x,y);
		
		if(hectarea.getContenido()!='agua') throw new NoSePuedeCrearUnPozoSiNoHayAguaException();
		
		
		
			
	}

}
