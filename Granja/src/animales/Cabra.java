package animales;

public class Cabra extends Animal{
	
	private byte  mesDelProducto;
	private int yearProducto;
	private float litrosDeLeche;
	
	//Metodo Constructor de Vaca
	public Cabra(String codigoRegistro, byte edad, String fechaAdquisicion, String raza,
				int yearProducto, byte mesDelProducto, float litrosDeLeche) {
		super(codigoRegistro, edad, fechaAdquisicion, raza);
		this.yearProducto = yearProducto;
		this.litrosDeLeche = litrosDeLeche;
		this.mesDelProducto = mesDelProducto;
	}
	
	//Metodos get para vaca
	
	public int getYearProducto() {
		return yearProducto;
	}
	public float getLitroDeLeche() {
		return litrosDeLeche;
	}
	public byte getMesDelProducto() {
		return mesDelProducto;
	}
}
