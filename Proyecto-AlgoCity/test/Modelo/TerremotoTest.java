package Modelo;
import static org.junit.Assert.*;

import org.junit.*;

public class TerremotoTest {
	
	
	@Test
	public void deberiaDevolverLasDosConstruccionesDaniadasSegunDistancia(){
		
		Mapa unMapa = new Mapa(2,1);
		
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0,0);
		Comercial unComercio = new Comercial(unaHectarea.obtenerSuperficie());
		unaHectarea.obtenerSuperficie().construir(unComercio);
		
		Hectarea otraHectarea = unMapa.obtenerHectareaEnPosicion(1,0);
		Residencial unaCasa = new Residencial(otraHectarea.obtenerSuperficie());
		otraHectarea.obtenerSuperficie().construir(unaCasa);
		
		unMapa.aplicarTerremoto(0,0);
		
		assertTrue( unaHectarea.obtenerSuperficie().obtenerEstadoConstruccion() == 0.0 );
		assertTrue( otraHectarea.obtenerSuperficie().obtenerEstadoConstruccion() == 1.5 );
	}

	@Test
	public void deberiaDevolverUnaConstruccionIntactaYLaOtraDaniada(){
	
		Mapa unMapa = new Mapa(68,1);
	
		Hectarea unaHectarea = unMapa.obtenerHectareaEnPosicion(0,0);
		Comercial unComercio = new Comercial(unaHectarea.obtenerSuperficie());
		unaHectarea.obtenerSuperficie().construir(unComercio);
	
		Hectarea otraHectarea = unMapa.obtenerHectareaEnPosicion(66,0);
		Residencial unaCasa = new Residencial(otraHectarea.obtenerSuperficie());
		otraHectarea.obtenerSuperficie().construir(unaCasa);

		Hectarea algunaHectarea = unMapa.obtenerHectareaEnPosicion(67,0);
		Industrial unaIndustria = new Industrial(algunaHectarea.obtenerSuperficie());
		algunaHectarea.obtenerSuperficie().construir(unaIndustria);
	
		for(int i=1;i<66;i++){
			Hectarea auxiliarHectarea = unMapa.obtenerHectareaEnPosicion(i,0);
			Residencial auxiliarCasa = new Residencial(auxiliarHectarea.obtenerSuperficie());
			auxiliarHectarea.obtenerSuperficie().construir(auxiliarCasa);
		}
		
		unMapa.aplicarTerremoto(0,0);
	
		assertTrue( unaHectarea.obtenerSuperficie().obtenerEstadoConstruccion() == 0.0 );
		assertTrue( otraHectarea.obtenerSuperficie().obtenerEstadoConstruccion() == 99.0 );
		assertTrue( algunaHectarea.obtenerSuperficie().obtenerEstadoConstruccion() == 100.0 );
	}

}
