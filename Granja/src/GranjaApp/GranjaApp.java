package GranjaApp;

import registros.RegistroDeCabra;
import registros.RegistroDeVaca;

public class GranjaApp {
	public static void main(String[] args) throws Exception {
		RegistroDeVaca registroVaca = new RegistroDeVaca();
		RegistroDeCabra registroCabra = new RegistroDeCabra();
		
		registroVaca.runVaca();
		registroCabra.runCabra();
	}
}
