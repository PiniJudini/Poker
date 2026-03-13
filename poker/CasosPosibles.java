package poker;

import java.util.Arrays;

public class CasosPosibles {
	public static void main(String[] args) {
		Cartas[] baraja = new Cartas[52];
		Cartas.Cartillas(baraja);
		// ¡A repartir!
		Cartas[] cartas = new Cartas[9];
		Cartas.repartir(baraja,cartas);
		
		// Creación de manos y mesa
		Cartas[] manoPC = {cartas[8], cartas[6]};
		Cartas[] manoPersona = {cartas[5], cartas[3]};
		Cartas[] centro = {cartas[1], cartas[4], cartas[7], cartas[0], cartas[2]};
		Cartas[] centroPersona = {cartas[5], cartas[3],cartas[1], cartas[4], cartas[7], cartas[0], cartas[2]};
		Cartas[] centroPC = {cartas[8], cartas[6],cartas[1], cartas[4], cartas[7], cartas[0], cartas[2]};

		System.out.println("Tu mano es: ");
		for(int i=0; i<manoPersona.length; i++)
			manoPersona[i].mostrar();
		System.out.println();
		
		System.out.print("- ");
		for (int i = 0; i < 5; i++)
			centro[i].mostrarCentro();
		System.out.println("");
		System.out.println();
		int ronda = 1;
		int inicialPersona = 100;
		int inicialPC = 100;
		
		// Baraja del rival
		System.out.println("Mano PC:");
		for(int i=0; i<manoPC.length; i++)
			manoPC[i].mostrar();
		System.out.println();
		
		int contadorNumeros = 0;
		int contadorEscalera = 0;
		int contadorColor = 0;
		int contadorNumerosPC = 0;
		int contadorEscaleraPC = 0;
		int contadorColorPC = 0;
				
		int puntuacionFinal = 0;
		int puntuacionFinalPC = 0;
		puntuacionPersona(Cartas.comprobarColor(contadorColor, centroPersona), comprobarEscalera(contadorEscalera, centroPersona), comprobarParejas(contadorNumeros, centroPersona), puntuacionFinal, centroPersona);
		puntuacionPC(comprobarColor(contadorColorPC, centroPC), comprobarEscaleraPC(contadorEscaleraPC, centroPC), comprobarParejasPC(contadorNumerosPC, centroPC), puntuacionFinalPC, centroPC);
		
		System.out.println(puntuacionPersona(Cartas.comprobarColor(contadorColor, centroPersona), comprobarEscalera(contadorEscalera, centroPersona), comprobarParejas(contadorNumeros, centroPersona), puntuacionFinal, centroPersona));
		System.out.println(puntuacionPC(comprobarColor(contadorColorPC, centroPC), comprobarEscaleraPC(contadorEscaleraPC, centroPC), comprobarParejasPC(contadorNumerosPC, centroPC), puntuacionFinalPC, centroPC));
	}
	
	public static int comprobarParejas(int contadorNumeros, Cartas[] centroPersona) {
		// Antes de sortear el array ves las parejas, trios, doble pareja, poker...
		for (int i = 0; i < centroPersona.length; i++) {
			for (int o = i + 1; o < centroPersona.length; o++) {
				if (centroPersona[i].valor == centroPersona[o].valor)
					contadorNumeros++;
			}
		}
		return contadorNumeros;
	}

	public static int comprobarEscalera(int contadorEscalera, Cartas[] centroPersona) {
		int[] centroPersonavalor = { centroPersona[0].valor, centroPersona[1].valor, centroPersona[2].valor,
				centroPersona[3].valor, centroPersona[4].valor, centroPersona[5].valor, centroPersona[6].valor };
		Arrays.sort(centroPersonavalor);

		// Para encontrar cartas iguales para la escalera y moverlas alante
		for (int i = 0; i < centroPersonavalor.length; i++) {
			if (i < centroPersonavalor.length - 1) {
				if ((centroPersonavalor[i]) == centroPersonavalor[i + 1]) {
					int temp = centroPersonavalor[i + 1];
					for (int j = i + 1; j >= 0; j--) {
						if (j > 0)
							centroPersonavalor[j] = centroPersonavalor[j - 1];
					}
					centroPersonavalor[0] = temp;
				}
			}
		}

		// Para saber si es escalera
		for (int i = 0; i < centroPersonavalor.length; i++) {
			if (i < centroPersonavalor.length - 1) {
				if ((centroPersonavalor[i] + 1) == centroPersonavalor[i + 1]) {
					contadorEscalera++;
				} else
					contadorEscalera = 1;
			}
		}
		return contadorEscalera;
	}

	public static int comprobarColor(int contadorColor, Cartas[] centroPersona) {
		String[] centroPersonapalo = { centroPersona[0].palo, centroPersona[1].palo, centroPersona[2].palo,
				centroPersona[3].palo, centroPersona[4].palo, centroPersona[5].palo, centroPersona[6].palo };
		int[] contadores = new int[4];
		Arrays.sort(centroPersonapalo);
		// Hacer array de Strings con los palos y copiar el de la escalera
		for (int i = 0; i < centroPersona.length; i++) {
			if(centroPersona[i].palo.equals("Corazones"))
				contadores[0]++;
			else if(centroPersona[i].palo.equals("Diamantes"))
				contadores[1]++;
			else if(centroPersona[i].palo.equals("Picas"))
				contadores[2]++;
			else
				contadores[3]++;
		}
		Arrays.sort(contadores);
		contadorColor = contadores[3];
		return contadorColor;
	}
	
	public static int comprobarParejasPC(int contadorNumerosPC, Cartas[] centroPC) {
		// Antes de sortear el array ves las parejas, trios, doble pareja, poker...
		for (int i = 0; i < centroPC.length; i++) {
			for (int o = i + 1; o < centroPC.length; o++) {
				if (centroPC[i].valor == centroPC[o].valor)
					contadorNumerosPC++;
			}
		}
		return contadorNumerosPC;
	}

	public static int comprobarEscaleraPC(int contadorEscaleraPC, Cartas[] centroPC) {
		int[] centroPCvalor = { centroPC[0].valor, centroPC[1].valor, centroPC[2].valor,
				centroPC[3].valor, centroPC[4].valor, centroPC[5].valor, centroPC[6].valor };
		Arrays.sort(centroPCvalor);

		// Para encontrar cartas iguales para la escalera y moverlas alante
		for (int i = 0; i < centroPCvalor.length; i++) {
			if (i < centroPCvalor.length - 1) {
				if ((centroPCvalor[i]) == centroPCvalor[i + 1]) {
					int temp = centroPCvalor[i + 1];
					for (int j = i + 1; j >= 0; j--) {
						if (j > 0)
							centroPCvalor[j] = centroPCvalor[j - 1];
					}
					centroPCvalor[0] = temp;
				}
			}
		}

		// Para saber si es escalera
		for (int i = 0; i < centroPCvalor.length; i++) {
			if (i < centroPCvalor.length - 1) {
				if ((centroPCvalor[i] + 1) == centroPCvalor[i + 1]) {
					contadorEscaleraPC++;
				} else
					contadorEscaleraPC = 1;
			}
		}
		return contadorEscaleraPC;
	}

	public static int comprobarColorPC(int contadorColorPC, Cartas[] centroPC) {
		String[] centroPCpalo = { centroPC[0].palo, centroPC[1].palo, centroPC[2].palo,
				centroPC[3].palo, centroPC[4].palo, centroPC[5].palo, centroPC[6].palo };
		int[] contadores = new int[4];
		Arrays.sort(centroPCpalo);
		// Hacer array de Strings con los palos y copiar el de la escalera
		for (int i = 0; i < centroPC.length; i++) {
			if(centroPC[i].palo.equals("Corazones"))
				contadores[0]++;
			else if(centroPC[i].palo.equals("Diamantes"))
				contadores[1]++;
			else if(centroPC[i].palo.equals("Picas"))
				contadores[2]++;
			else
				contadores[3]++;
		}
		Arrays.sort(contadores);
		contadorColorPC = contadores[3];
		return contadorColorPC;
	}
	
	public static int puntuacionPersona(int contadorColor, int contadorEscalera, int contadorPareja, int puntuacionFinal, Cartas[] centroPersona) {
		int[] centroPersonavalor = { centroPersona[0].valor, centroPersona[1].valor, centroPersona[2].valor,
				centroPersona[3].valor, centroPersona[4].valor, centroPersona[5].valor, centroPersona[6].valor };
		Arrays.sort(centroPersonavalor);
		// Pareja
		if(contadorPareja==1)
			puntuacionFinal = 2;
		// Doble Pareja
		if(contadorPareja==2)
			puntuacionFinal = 4;
		// Trio
		if(contadorPareja==3)
			puntuacionFinal = 6;
		// Escalera
		if(contadorEscalera>=5)
			puntuacionFinal = 8;
		// Color
		if(contadorColor>=5)
			puntuacionFinal = 10;
		// Full House (Trio + pareja)
		if(contadorPareja==4)
			puntuacionFinal = 12;
		// Póker
		if(contadorPareja==6)
			puntuacionFinal = 14;
		// Escalera Color
		if(contadorColor>=5 && contadorEscalera>=5)
			puntuacionFinal = 16;
		// Escalera Real
		if(contadorColor>=5 && contadorEscalera>=5 && centroPersonavalor[6]==14)
			puntuacionFinal = 18;
		return puntuacionFinal;
	}
	
	public static int puntuacionPC(int contadorColor, int contadorEscalera, int contadorPareja, int puntuacionFinalPC, Cartas[] centroPC) {
		int[] centroPCvalor = { centroPC[0].valor, centroPC[1].valor, centroPC[2].valor,
				centroPC[3].valor, centroPC[4].valor, centroPC[5].valor, centroPC[6].valor };
		Arrays.sort(centroPCvalor);
		// Pareja
		if(contadorPareja==1)
			puntuacionFinalPC = 2;
		// Doble Pareja
		if(contadorPareja==2)
			puntuacionFinalPC = 4;
		// Trio
		if(contadorPareja==3)
			puntuacionFinalPC = 6;
		// Escalera
		if(contadorEscalera>=5)
			puntuacionFinalPC = 8;
		// Color
		if(contadorColor>=5)
			puntuacionFinalPC = 10;
		// Full House (Trio + pareja)
		if(contadorPareja==4)
			puntuacionFinalPC = 12;
		// Póker
		if(contadorPareja==6)
			puntuacionFinalPC = 14;
		// Escalera Color
		if(contadorColor>=5 && contadorEscalera>=5)
			puntuacionFinalPC = 16;
		// Escalera Real
		if(contadorColor>=5 && contadorEscalera>=5 && centroPCvalor[6]==14)
			puntuacionFinalPC = 18;
		return puntuacionFinalPC;
	}
	
	public static String compararResultados(int puntuacionFinal, int puntuacionFinalPC, Cartas[] manoPC, Cartas[] manoPersona) {
		String ganador = "";
		int[] manoPersonavalor = {manoPersona[0].valor, manoPersona[1].valor};
		int[] manoPCvalor = {manoPC[0].valor, manoPC[1].valor};
		Arrays.sort(manoPersonavalor);
		Arrays.sort(manoPCvalor);
		
		if(puntuacionFinal>puntuacionFinalPC)
			ganador = "Persona";
		else if(puntuacionFinal<puntuacionFinalPC)
			ganador = "PC";
		else {
			if(manoPersonavalor[1]>manoPCvalor[1])
				ganador = "Persona";
			else if(manoPersonavalor[1]<manoPCvalor[1])
				ganador = "PC";
			else {
				if(manoPersonavalor[0]>manoPCvalor[0])
					ganador = "Persona";
				else if(manoPersonavalor[0]<manoPCvalor[0])
					ganador = "PC";
			}
		}
		return ganador;
	}
}
/* 
 * 		Cartas[] manoPC = {cartas[0], cartas[1]};
		Cartas[] manoPersona = {cartas[2], cartas[3]};
		Cartas[] centro = {cartas[4], cartas[5], cartas[6], cartas[7], cartas[8]};
		Cartas[] centroPersona = {cartas[2], cartas[3],cartas[4], cartas[5], cartas[6], cartas[7], cartas[8]};
		Cartas[] escalera = {cartas[2], cartas[3],cartas[4], cartas[5], cartas[6], cartas[7], cartas[8]};
		Cartas[] centroPC = {cartas[0], cartas[1],cartas[4], cartas[5], cartas[6], cartas[7], cartas[8]};
 * */
