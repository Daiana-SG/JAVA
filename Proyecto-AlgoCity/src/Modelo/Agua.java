package Modelo;


public class Agua extends Superficie {
	
	public Agua(){
		this.construccion = null;
		this.dibujo = "A";
		this.esAgua = true;
		this.esTierra = false;
	}
	public boolean tieneTanqueDeAgua(){
		return (this.construccion != null);
	}
	
	public void construirPozoDeAgua(){
		this.construccion = new PozoDeAgua();
	}
	
	public boolean puedoConstruirResidencia(){
		return false;
	}
	
	public boolean puedoConstruirComercio(){
		return false;
	}
	
	public boolean puedoConstruirIndustria(){
		return false;
	}
	
	public boolean puedoConstruirEdificioTerrestre(){
		return false;
	}
	
    public boolean puedoConstruirPozoDeAgua(){
		
		return (!this.tieneConstruccion());
	}


}
