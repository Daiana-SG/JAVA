package Modelo;
import static org.junit.Assert.*;
import org.junit.*;

public class HectareaTest {
	
	@Test
	public void DeberiaCrearUnaHectareaYAsignarleUnaTierraSinEdificio(){
		
		Hectarea unaHectarea = new Hectarea(1,2);
		Tierra unaTierra = new Tierra();
		unaHectarea.asignarSuperficie(unaTierra);
		assertEquals(unaHectarea.dibujarSuperficie(),"T");
	}
	
	@Test
	public void DeberiaAsignarAguaAUnaHectareaSinEdificio(){
		
		Hectarea unaHectarea = new Hectarea(1,2);
		Agua unAgua = new Agua();
		unaHectarea.asignarSuperficie(unAgua);
		assertEquals(unaHectarea.dibujarSuperficie(),"A");
	}
	
	@Test
	public void DeberiaDevolverLaDistanciaEntreLasHectareas(){
		
		Hectarea unaHectarea = new Hectarea(1,2);
		Hectarea otraHectarea = new Hectarea(7,8);
		
		assertEquals(unaHectarea.calcularDistancia(otraHectarea),12);
	}
	@Test
	public void DeberiaCrearUnaHectareaConTierraATravesDelMetodoDeClase(){
		
		Hectarea unaHectarea = Hectarea.hectareaConTierra(1, 2);
		
		assertEquals(unaHectarea.dibujarSuperficie(),"T");
		assertEquals(unaHectarea.getCoordenadaX(),1);
		assertEquals(unaHectarea.getCoordenadaY(),2);
	}
	
	@Test
	public void DeberiaCrearUnaHectareaConAguaATravesDelMetodoDeClase(){
		
		Hectarea unaHectarea = Hectarea.hectareaConAgua( 5 , 13 );
		
		assertEquals(unaHectarea.dibujarSuperficie(),"A");
		assertEquals(unaHectarea.getCoordenadaX(),5);
		assertEquals(unaHectarea.getCoordenadaY(),13);
	}
	
}
