package Modelo;

public class Terremoto {
	
	private Hectarea epicentro;
	private float DisminucionDanioPorHa;
	
	public Terremoto( Hectarea epicentro){
		
		this.epicentro = epicentro;
		this.DisminucionDanioPorHa = (float)1.5;
	
	}
	
	public void aplicarDanio(Hectarea hectarea){

		int distancia = this.epicentro.calcularDistancia(hectarea);
		float danioPorcentual = 100 - (this.DisminucionDanioPorHa*distancia);
		if (danioPorcentual>0)
			hectarea.daniarSuperficie(danioPorcentual);
	}
	
	
	

}
