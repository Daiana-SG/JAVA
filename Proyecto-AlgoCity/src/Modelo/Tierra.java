package Modelo;


public class Tierra extends Superficie {
	
	private LineaDeTension lineaDeTension;
	private TuberiaDeAgua tuberiaDeAgua;
	
	public Tierra(){
		
		this.lineaDeTension = null;
		this.tuberiaDeAgua = null;
		this.construccion = null;
		this.dibujo = "T";
		this.esAgua = false;
		this.esTierra = true;
	}
	
	
	public boolean tieneLineaDeTension(){
		return (this.lineaDeTension != null);
	}
	
	public boolean tieneTuberiaDeAgua(){
		return (this.tuberiaDeAgua != null);
	}

	public void setLineaDeTension(LineaDeTension lineaDeTension){
		this.lineaDeTension = null;
	}
	
	public void setTuberiaDeAgua(TuberiaDeAgua tuberiaDeAgua){
		this.tuberiaDeAgua = tuberiaDeAgua;
	}
	
	public boolean accesoARuta() {
		
		return true;
	}

	public boolean tieneLuz() {
		if(!this.tieneLineaDeTension()){
			return false;
		}
		else{
			return (this.lineaDeTension.estaConectada());
		}
	}


	public boolean tieneAgua() {
		return true;
	}

	public void construirResidencial(){
		this.construccion = new Residencial();
	}
	
	public void construirIndustrial(){
		this.construccion = new Industrial();
	}
	
	public void construirComercial(){
		this.construccion = new Comercial();
	}
	
	public void construirCentralEolica(){
		this.construccion = new CentralEolica();
	}
	
	public void construirCentralNuclear(){
		this.construccion = new CentralNuclear();
	}
	
	public void construirCentralMineral(){
		this.construccion = new CentralMineral();
	}
	
	public void construirRutaPavimentada(){
		this.construccion = new RutaPavimentada();
	}	
	
	public void construirEstacionDeBomberos(){
		this.construccion = new EstacionDeBomberos();
	}

	//Tierra con acceso A Luz
	public void crearLineaDeTension() {
		this.lineaDeTension = new LineaDeTension();
		this.dibujo = "Tl";
	}	
	
	//Tierra con acceso A Luz
	public void crearTuberiaDeAgua() {
		this.tuberiaDeAgua = new TuberiaDeAgua();
		this.dibujo = "Ta";
	}	
		
	public boolean puedoConstruirResidencia(){
		
		return (!this.tieneConstruccion());
	}
	
	public boolean puedoConstruirComercio(){
		
		return (!this.tieneConstruccion());
	}
	
    public boolean puedoConstruirIndustria(){
		
		return (!this.tieneConstruccion());
	}
    
    public boolean puedoConstruirEdificioTerrestre(){
		
		return (!this.tieneConstruccion());
	}
    
    public boolean puedoConstruirPozoDeAgua(){
    	return false;
    }
    
}
