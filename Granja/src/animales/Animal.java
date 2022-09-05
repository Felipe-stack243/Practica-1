package animales;

public class Animal {
	
	private byte edad;
	private String fechaAdquisicion, raza, codigoRegistro;
	
	//Metodo Constructor
	public Animal(String codigoRegistro, byte edad, String fechaAdquisicion, String raza) {
		this.codigoRegistro = codigoRegistro;
		this.edad = edad;
		this.fechaAdquisicion = fechaAdquisicion;
		this.raza = raza;
	}
	
	//Metodos get para nuestras variables
	public String getCodigoRegistro() {
		return codigoRegistro;
	}
	public byte getEdad() {
		return edad;
	}
	public String getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public String getRaza() {
		return raza;
	}
}
