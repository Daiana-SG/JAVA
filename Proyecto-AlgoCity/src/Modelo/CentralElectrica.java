package Modelo;

public class CentralElectrica extends Construccion{
	
	protected int capacidadDeAbastecimiento;
	protected int radio;
	
	public int obtenerCapacidadDeAbast(){
		return this.capacidadDeAbastecimiento;
	}
	
	public int obtenerRadio(){
		return this.radio;
	}

}
