package animales;

public class Vaca extends Animal{
	
	 
	private int yearDelProducto;
	private byte  semanaDelProducto;
	private float litrosDeLeche;
	
	//Metodo Constructor de Vaca
	public Vaca(String codigoRegistro, byte edad, String fechaAdquisicion, String raza,
				int yearDelProducto, byte semanaDelProducto, float litrosDeLeche) {
		super(codigoRegistro, edad, fechaAdquisicion, raza);
		this.yearDelProducto = yearDelProducto;
		this.litrosDeLeche = litrosDeLeche;
		this.semanaDelProducto = semanaDelProducto;
	}
	
	//Metodos get para vaca
	
	public int getYearProducto() {
		return yearDelProducto;
	}
	public float getLitroDeLeche() {
		return litrosDeLeche;
	}
	public byte getSemanaDelProducto() {
		return semanaDelProducto;
	}
}
