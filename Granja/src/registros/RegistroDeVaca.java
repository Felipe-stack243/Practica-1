package registros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import animales.Vaca;


public class RegistroDeVaca {
	static long numeroDeVaca=0;
	static Scanner input;
	static long totalDeVacas;
	static Vaca vaca[];
	static float mLeche = 0;
	
	//Este metodo es para saber cuantas vacas fueron ingresadas al archivo
	static void numeroDeVacas() throws Exception{
		      Path inputVaca = Paths.get("inputVacas.txt");
		      totalDeVacas = Files.lines(inputVaca).count();
	}
	
	//Este metodo esta leyendo los datos de las vacas
	
	static void leeDatos() throws FileNotFoundException {
		byte   edad, semanaDelProducto;
		float litrosDeLeche;
		String codigoRegistro, fechaAdquisicion, raza;
		int   yearDelProducto;
		vaca = new Vaca[(int) totalDeVacas];
		
		input=new Scanner(new FileInputStream("inputVacas.txt"));
		input.useDelimiter(";");
		
		while(input.hasNext()) {
			
			codigoRegistro = input.next();
			edad = input.nextByte();
			fechaAdquisicion = input.next();
			raza = input.next();
			yearDelProducto =input.nextInt();
			semanaDelProducto = input.nextByte();
			litrosDeLeche = input.nextFloat();
			vaca[(int) numeroDeVaca] = new Vaca ( codigoRegistro, edad, fechaAdquisicion, 
					 		raza,  yearDelProducto,  semanaDelProducto, litrosDeLeche);
			numeroDeVaca++;
		}
		input.close();
	}
	
	//Metodo para saber las Cantidades totales de leche
	
	static int cantidadTotalSemanal() {
		 int productoTotal = 0;
		for(int i=0; i<totalDeVacas; i++) {
			productoTotal+=vaca[i].getLitroDeLeche();
		}
		return productoTotal;
	}
	
	//Metodo para saber el promedio de litros por semana

	static int cantidadLecheProm() {
		int promedioSemanalVaca;
		promedioSemanalVaca= cantidadTotalSemanal()/7;
		return promedioSemanalVaca;
	}
	
	//Metodo para saber cual es la vaca con mayor produccion en la semana
	static String calculaMaxLeche() {
		float maxLeche = vaca[0].getLitroDeLeche();
		String codigoDeMaxLeche = null;
		for(int i=1;i<totalDeVacas;i++)
			if(vaca[i].getLitroDeLeche()>maxLeche) {
				codigoDeMaxLeche=vaca[i].getCodigoRegistro();
				mLeche = maxLeche;
			}
		return codigoDeMaxLeche;
	}
	//Metodo mostrar datos
	
	static void mostrarDatos() {
		System.out.println("   -----REGISTRO VACAS-----  ");
		System.out.println("La cantidad Total de litros esta semana fue: \n"+ cantidadTotalSemanal());
		System.out.println("\nLa vaca con mayor cantidad producidad es: "+ calculaMaxLeche()+" con "+mLeche+" Litros");
		System.out.println("\nEl promedio de leche producidad esta semana es: \n"+ cantidadLecheProm());
		System.out.println("+----------------------------------------------------------------------------------+");
	}
	
	//Metodo Run para porcesar nuestro programa
	public void runVaca() throws Exception {
		numeroDeVacas();
		leeDatos();
		mostrarDatos();
	}
	
}
