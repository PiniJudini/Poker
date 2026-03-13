package poker;

import java.util.Arrays;
import java.util.Scanner;

public class Cartas {
	int valor;
	String palo;
	String color;

	public Cartas(int valor, String palo, String color) {
		this.valor = valor;
		this.palo = palo;
		this.color = color;
	}

	public void mostrar() {
		if (this.color.equals("Negro"))
			System.out.println(this.valor + " de " + this.palo);
		else
			System.err.println(this.valor + " de " + this.palo);
	}

	public void mostrarCentro() {
		if (this.color.equals("Negro"))
			System.out.print(this.valor + " de " + this.palo + " - ");
		else
			System.err.print(this.valor + " de " + this.palo + " - ");
	}

	public static Cartas[] Cartillas(Cartas[] baraja) {
		// Corazones
		Cartas dosC = new Cartas(2, "Corazones", "Rojo");
		Cartas tresC = new Cartas(3, "Corazones", "Rojo");
		Cartas cuatroC = new Cartas(4, "Corazones", "Rojo");
		Cartas cincoC = new Cartas(5, "Corazones", "Rojo");
		Cartas seisC = new Cartas(6, "Corazones", "Rojo");
		Cartas sieteC = new Cartas(7, "Corazones", "Rojo");
		Cartas ochoC = new Cartas(8, "Corazones", "Rojo");
		Cartas nueveC = new Cartas(9, "Corazones", "Rojo");
		Cartas diezC = new Cartas(10, "Corazones", "Rojo");
		Cartas onceC = new Cartas(11, "Corazones", "Rojo");
		Cartas doceC = new Cartas(12, "Corazones", "Rojo");
		Cartas treceC = new Cartas(13, "Corazones", "Rojo");
		Cartas aC = new Cartas(14, "Corazones", "Rojo");

		// Diamantes
		Cartas dosD = new Cartas(2, "Diamantes", "Rojo");
		Cartas tresD = new Cartas(3, "Diamantes", "Rojo");
		Cartas cuatroD = new Cartas(4, "Diamantes", "Rojo");
		Cartas cincoD = new Cartas(5, "Diamantes", "Rojo");
		Cartas seisD = new Cartas(6, "Diamantes", "Rojo");
		Cartas sieteD = new Cartas(7, "Diamantes", "Rojo");
		Cartas ochoD = new Cartas(8, "Diamantes", "Rojo");
		Cartas nueveD = new Cartas(9, "Diamantes", "Rojo");
		Cartas diezD = new Cartas(10, "Diamantes", "Rojo");
		Cartas onceD = new Cartas(11, "Diamantes", "Rojo");
		Cartas doceD = new Cartas(12, "Diamantes", "Rojo");
		Cartas treceD = new Cartas(13, "Diamantes", "Rojo");
		Cartas aD = new Cartas(14, "Diamantes", "Rojo");

		// Picas
		Cartas dosP = new Cartas(2, "Picas", "Negro");
		Cartas tresP = new Cartas(3, "Picas", "Negro");
		Cartas cuatroP = new Cartas(4, "Picas", "Negro");
		Cartas cincoP = new Cartas(5, "Picas", "Negro");
		Cartas seisP = new Cartas(6, "Picas", "Negro");
		Cartas sieteP = new Cartas(7, "Picas", "Negro");
		Cartas ochoP = new Cartas(8, "Picas", "Negro");
		Cartas nueveP = new Cartas(9, "Picas", "Negro");
		Cartas diezP = new Cartas(10, "Picas", "Negro");
		Cartas onceP = new Cartas(11, "Picas", "Negro");
		Cartas doceP = new Cartas(12, "Picas", "Negro");
		Cartas treceP = new Cartas(13, "Picas", "Negro");
		Cartas aP = new Cartas(14, "Picas", "Negro");

		// Treboles
		Cartas dosT = new Cartas(2, "Tréboles", "Negro");
		Cartas tresT = new Cartas(3, "Tréboles", "Negro");
		Cartas cuatroT = new Cartas(4, "Tréboles", "Negro");
		Cartas cincoT = new Cartas(5, "Tréboles", "Negro");
		Cartas seisT = new Cartas(6, "Tréboles", "Negro");
		Cartas sieteT = new Cartas(7, "Tréboles", "Negro");
		Cartas ochoT = new Cartas(8, "Tréboles", "Negro");
		Cartas nueveT = new Cartas(9, "Tréboles", "Negro");
		Cartas diezT = new Cartas(10, "Tréboles", "Negro");
		Cartas onceT = new Cartas(11, "Tréboles", "Negro");
		Cartas doceT = new Cartas(12, "Tréboles", "Negro");
		Cartas treceT = new Cartas(13, "Tréboles", "Negro");
		Cartas aT = new Cartas(14, "Tréboles", "Negro");
		Cartas[] barajilla = { dosC, tresC, cuatroC, cincoC, seisC, sieteC, ochoC, nueveC, diezC, onceC, doceC, treceC,
				aC, dosD, tresD, cuatroD, cincoD, seisD, sieteD, ochoD, nueveD, diezD, onceD, doceD, treceD, aD, dosP,
				tresP, cuatroP, cincoP, seisP, sieteP, ochoP, nueveP, diezP, onceP, doceP, treceP, aP, dosT, tresT,
				cuatroT, cincoT, seisT, sieteT, ochoT, nueveT, diezT, onceT, doceT, treceT, aT };
		for (int i = 0; i < baraja.length; i++) {
			baraja[i] = barajilla[i];
		}
		return baraja;
	}

	public static void repartir(Cartas[] baraja, Cartas[] cartas) {
		int contador = 0;
		do {
			int carta = 0;
			boolean repetido;
			do {
				carta = (int) (Math.random() * (51 - 1 + 1) + 1);
				repetido = false;
				for (int i = 0; i < cartas.length; i++) {
					if (cartas[i] == baraja[carta])
						repetido = true;
				}
			} while (repetido == true);
			contador++;
			cartas[contador - 1] = baraja[carta];
		} while (contador < cartas.length);
	}

	public static void partida(int inicialPC, int inicialPersona) {
		Cartas[] baraja = new Cartas[52];
		Cartas.Cartillas(baraja);
		Cartas[] cartas = new Cartas[9];

		int dineroPersona = 100;
		int dineroPC = 100;
		int dineroGanador = 0;
		int rondaexterna = 0;
		// Hacer la escalera
		do {
			Cartas.repartir(baraja, cartas);
			Cartas[] manoPC = { cartas[8], cartas[6] };
			Cartas[] manoPersona = { cartas[5], cartas[3] };
			Cartas[] centro = { cartas[1], cartas[4], cartas[7], cartas[0], cartas[2] };
			Cartas[] centroPersona = { cartas[5], cartas[3], cartas[1], cartas[4], cartas[7], cartas[0], cartas[2] };
			Cartas[] centroPC = { cartas[8], cartas[6], cartas[1], cartas[4], cartas[7], cartas[0], cartas[2] };

			rondaexterna++;
			int apuesta = 0;
			int apuestaPC = 0;
			int ronda = 1;
			String entrada = "";
			int jugadaPC = 0;
			System.out.println("Tu mano es: ");
			for (int i = 0; i < manoPersona.length; i++)
				manoPersona[i].mostrar();
			System.out.println();

			do {
				Scanner teclado = new Scanner(System.in);
				boolean correcto = false;
				System.out.print("- ");
				for (int i = 0; i < ronda + 2; i++)
					centro[i].mostrarCentro();
				System.out.println("");
				System.out.println();

				if (ronda >= 2) {
					if (manoPC[0].valor == manoPC[1].valor || manoPC[0].palo == manoPC[1].palo)
						jugadaPC = (int) (Math.random() * (2 - 1 + 1) + 1);
					else
						jugadaPC = (int) (Math.random() * (3 - 1 + 1) + 1);

					if (jugadaPC == 2) {
						boolean correcto1 = false;
						int importe = 0;
						importe = comprobarImportePC(importe, correcto1, dineroPC);
						apuestaPC = apuestaPC + importe;
						System.out.println("P(ancho)C sube!!!");
					} else if (jugadaPC == 1) {
						// apuestaPC se queda igual
						System.out.println("P(ancho)C ha pasado");
					} else {
						ronda = 4;
						// dineroPC se queda igual
						dineroPersona = dineroPersona + apuesta + apuestaPC;
						System.out.println("P(ancho)C ha foldeado (pringado)");
					}
				} else
					apuestaPC = 5;
				System.out.println("Tu dinero actual es: " + dineroPersona);
				System.out.println("Apuesta PC: " + apuestaPC);

				// Verificar entrada
				if (ronda != 4) {
					entrada = comprobarEntrada(entrada, correcto, teclado);

					// ¿Qué has dicho?
					if (entrada.equals("foldeo") || entrada.equals("f")) {
						if (ronda > 1) {
							ronda = 4;
							dineroPersona = dineroPersona - apuesta;
							dineroPC = dineroPC + apuestaPC;
						} else
							ronda = 4;
						System.out.println("Cagón");
					} else if (entrada.equals("subir") || entrada.equals("s")) {
						boolean correcto1 = false;
						int importe = 0;
						importe = comprobarImportePersona(importe, correcto1, apuesta, apuestaPC);
						jugadaPC = (int) (Math.random() * (3 - 2 + 1) + 2);
						System.out.println("Apuesta central: " + (apuestaPC + apuesta));
						if (jugadaPC == 2) {
							apuesta = apuesta + importe;
							apuestaPC = apuesta;
							System.out.println("P(ancho)C ha igualado");
						} else if (jugadaPC == 3) {
							ronda = 4;
							dineroPC = dineroPC - apuestaPC;
							dineroPersona = dineroPersona + (apuesta + apuestaPC);
							System.out.println("P(ancho)C ha foldeado (pringado)");
						}
					} else if (entrada.equals("igualar") || entrada.equals("i")) {
						apuesta = apuestaPC;
						System.out.println("Has igualado");
					}
				}

				if (ronda != 4) {
					dineroPersona = dineroPersona - apuesta;
					dineroPC = dineroPC - apuestaPC;
					System.out.println("Siguiente ronda!!!");
				}
				ronda++;
				System.out.println("");
				System.out.println(dineroPersona);
				System.out.println(dineroPC);
			} while (ronda < 4);

			// Baraja del rival
			System.out.println("Mano PC:");
			for (int i = 0; i < manoPC.length; i++)
				manoPC[i].mostrar();
			System.out.println();

			int contadorColor = 0;
			int contadorEscalera = 0;
			int contadorNumeros = 0;
			int contadorColorPC = 0;
			int contadorEscaleraPC = 0;
			int contadorNumerosPC = 0;

			contadorColor = comprobarColor(contadorColor, centroPersona);
			contadorNumeros = comprobarParejas(contadorNumeros, centroPersona);
			contadorEscalera = comprobarEscalera(contadorEscalera, centroPersona);
			contadorColorPC = comprobarColorPC(contadorColorPC, centroPC);
			contadorEscaleraPC = comprobarEscaleraPC(contadorEscaleraPC, centroPC);
			contadorNumerosPC = comprobarParejasPC(contadorNumerosPC, centroPC);

			int puntuacionFinal = 0;
			int puntuacionFinalPC = 0;

			puntuacionFinal = puntuacionPersona(contadorColor, contadorEscalera, contadorNumeros, puntuacionFinal,
					centroPersona);
			puntuacionFinalPC = puntuacionPC(contadorColorPC, contadorEscaleraPC, contadorNumerosPC, puntuacionFinalPC,
					centroPC);
			if (jugadaPC != 3 && entrada.equals("foldeo")==false && entrada.equals("f")==false) {
				System.out.println("Tu puntuación es: " + puntuacionFinal);
				System.out.println("La puntuación de P(ancho)C es: " + puntuacionFinalPC);

				String veredicto = "";
				veredicto = compararResultados(
						puntuacionPersona(contadorColor, contadorEscalera, contadorNumeros, puntuacionFinal,
								centroPersona),
						puntuacionPC(contadorColorPC, contadorEscaleraPC, contadorNumerosPC, puntuacionFinalPC,
								centroPC),
						manoPC, manoPersona);
				if (veredicto.equals("Persona")) {
					System.out.println("Persona gana!!!");
					if (rondaexterna == 1) {
						dineroPersona = dineroPersona + apuesta + apuestaPC;
					} else {
						dineroPersona = dineroPersona + apuesta + apuestaPC;
					}
				} else {
					System.out.println("P(ancho)C gana!!!");
					if (rondaexterna == 1) {
						dineroPC = dineroPC + apuesta + apuestaPC;
					} else {
						dineroPC = dineroPC + apuesta + dineroPC;
					}
				}
			}
		} while (dineroPC > 0 || dineroPersona > 0);
	}

	public static String comprobarEntrada(String entrada, boolean correcto, Scanner teclado) {
		do {
			System.out.print("Qué quieres hacer? ");
			entrada = teclado.nextLine();
			entrada = entrada.toLowerCase();

			if (entrada.equals("subir") || entrada.equals("foldeo") || entrada.equals("igualar") || entrada.equals("f")
					|| entrada.equals("s") || entrada.equals("i"))
				correcto = true;
			else
				correcto = false;
		} while (correcto == false);
		return entrada;
	}
	
	public static int comprobarImportePC(int importe, boolean correcto1, int dineroPC) {
		do {
			importe = (int) (Math.random() * (dineroPC / 2 - 1 + 1) + 1);
			if (importe % 2 == 0)
				correcto1 = true;
			else
				correcto1 = false;
		} while (correcto1 == false);
		return importe;
	}

	public static int comprobarImportePersona(int importe, boolean correcto1, int apuesta, int apuestaPC) {
		do {
			Scanner teclado2 = new Scanner(System.in);
			System.out.print("Cuánto quieres subir? ");
			try {
				importe = teclado2.nextInt();
				if (importe % 2 == 0 && (apuesta + importe)>apuestaPC)
					correcto1 = true;
				else {
					correcto1 = false;
					System.out.println("No es una entrada correcta (número par y mayor a la apuesta del rival)");
				}
			} catch (Exception e) {
				correcto1 = false;
				System.out.println("No es una entrada correcta (número par y mayor a la apuesta del rival)");
			}
		} while (correcto1 == false);
		return importe;
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
			if (centroPersona[i].palo.equals("Corazones"))
				contadores[0]++;
			else if (centroPersona[i].palo.equals("Diamantes"))
				contadores[1]++;
			else if (centroPersona[i].palo.equals("Picas"))
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
		int[] centroPCvalor = { centroPC[0].valor, centroPC[1].valor, centroPC[2].valor, centroPC[3].valor,
				centroPC[4].valor, centroPC[5].valor, centroPC[6].valor };
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
		String[] centroPCpalo = { centroPC[0].palo, centroPC[1].palo, centroPC[2].palo, centroPC[3].palo,
				centroPC[4].palo, centroPC[5].palo, centroPC[6].palo };
		int[] contadores = new int[4];
		Arrays.sort(centroPCpalo);
		// Hacer array de Strings con los palos y copiar el de la escalera
		for (int i = 0; i < centroPC.length; i++) {
			if (centroPC[i].palo.equals("Corazones"))
				contadores[0]++;
			else if (centroPC[i].palo.equals("Diamantes"))
				contadores[1]++;
			else if (centroPC[i].palo.equals("Picas"))
				contadores[2]++;
			else
				contadores[3]++;
		}
		Arrays.sort(contadores);
		contadorColorPC = contadores[3];
		return contadorColorPC;
	}

	public static int puntuacionPersona(int contadorColor, int contadorEscalera, int contadorPareja,
			int puntuacionFinal, Cartas[] centroPersona) {
		int[] centroPersonavalor = { centroPersona[0].valor, centroPersona[1].valor, centroPersona[2].valor,
				centroPersona[3].valor, centroPersona[4].valor, centroPersona[5].valor, centroPersona[6].valor };
		Arrays.sort(centroPersonavalor);
		// Pareja
		if (contadorPareja == 1)
			puntuacionFinal = 2;
		// Doble Pareja
		if (contadorPareja == 2)
			puntuacionFinal = 4;
		// Trio
		if (contadorPareja == 3)
			puntuacionFinal = 6;
		// Escalera
		if (contadorEscalera >= 5)
			puntuacionFinal = 8;
		// Color
		if (contadorColor >= 5)
			puntuacionFinal = 10;
		// Full House (Trio + pareja)
		if (contadorPareja == 4)
			puntuacionFinal = 12;
		// Póker
		if (contadorPareja == 6)
			puntuacionFinal = 14;
		// Escalera Color
		if (contadorColor >= 5 && contadorEscalera >= 5)
			puntuacionFinal = 16;
		// Escalera Real
		if (contadorColor >= 5 && contadorEscalera >= 5 && centroPersonavalor[6] == 14)
			puntuacionFinal = 18;
		return puntuacionFinal;
	}

	public static int puntuacionPC(int contadorColor, int contadorEscalera, int contadorPareja, int puntuacionFinalPC,
			Cartas[] centroPC) {
		int[] centroPCvalor = { centroPC[0].valor, centroPC[1].valor, centroPC[2].valor, centroPC[3].valor,
				centroPC[4].valor, centroPC[5].valor, centroPC[6].valor };
		Arrays.sort(centroPCvalor);
		// Pareja
		if (contadorPareja == 1)
			puntuacionFinalPC = 2;
		// Doble Pareja
		if (contadorPareja == 2)
			puntuacionFinalPC = 4;
		// Trio
		if (contadorPareja == 3)
			puntuacionFinalPC = 6;
		// Escalera
		if (contadorEscalera >= 5)
			puntuacionFinalPC = 8;
		// Color
		if (contadorColor >= 5)
			puntuacionFinalPC = 10;
		// Full House (Trio + pareja)
		if (contadorPareja == 4)
			puntuacionFinalPC = 12;
		// Póker
		if (contadorPareja == 6)
			puntuacionFinalPC = 14;
		// Escalera Color
		if (contadorColor >= 5 && contadorEscalera >= 5)
			puntuacionFinalPC = 16;
		// Escalera Real
		if (contadorColor >= 5 && contadorEscalera >= 5 && centroPCvalor[6] == 14)
			puntuacionFinalPC = 18;
		return puntuacionFinalPC;
	}

	public static String compararResultados(int puntuacionFinal, int puntuacionFinalPC, Cartas[] manoPC,
			Cartas[] manoPersona) {
		String ganador = "";
		int[] manoPersonavalor = { manoPersona[0].valor, manoPersona[1].valor };
		int[] manoPCvalor = { manoPC[0].valor, manoPC[1].valor };
		Arrays.sort(manoPersonavalor);
		Arrays.sort(manoPCvalor);

		if (puntuacionFinal > puntuacionFinalPC)
			ganador = "Persona";
		else if (puntuacionFinal < puntuacionFinalPC)
			ganador = "PC";
		else {
			if (manoPersonavalor[1] > manoPCvalor[1])
				ganador = "Persona";
			else if (manoPersonavalor[1] < manoPCvalor[1])
				ganador = "PC";
			else {
				if (manoPersonavalor[0] > manoPCvalor[0])
					ganador = "Persona";
				else if (manoPersonavalor[0] < manoPCvalor[0])
					ganador = "PC";
			}
		}
		return ganador;
	}
}
/*
 * public static int contadorcentro(int contadorcentro, Cartas[] manoPersona,
 * Cartas[] centro) { Cartas[] centro2 = centro; for(int i=0; i<centro.length;
 * i++) { for(int o=i+1; o<centro.length; o++) {
 * if(centro[i].valor==centro[o].valor) contadorcentro++; } } return
 * contadorcentro; }
 * 
 * public static int contadorPersona(int contador, Cartas[] manoPersona,
 * Cartas[] centro) {
 * 
 * for(int i=0; i<centro.length; i++) {
 * if(manoPersona[0].valor==centro[i].valor) contador++;
 * if(manoPersona[1].valor==centro[i].valor) contador++; }
 * 
 * if(contador==2) contador = 2; else if(contador==1 && contadorcentro(contador,
 * manoPersona, centro)==2) contador += (contadorcentro(contador, manoPersona,
 * centro)-1); else contador += contadorcentro(contador, manoPersona, centro);
 * 
 * if(manoPersona[0].valor==manoPersona[1].valor) contador++;
 * 
 * return contador; }
 * 
 * public static int contadorPC(int contadorPC, Cartas[] manoPC, Cartas[]
 * centro) { for(int i=0; i<centro.length; i++) {
 * if(manoPC[0].valor==centro[i].valor) contadorPC++;
 * if(manoPC[1].valor==centro[i].valor) contadorPC++; }
 * 
 * if(contadorPC==2) contadorPC = 2; else if(contadorPC==1 &&
 * contadorcentro(contadorPC, manoPC, centro)==2) contadorPC +=
 * (contadorcentro(contadorPC, manoPC, centro)-1); else contadorPC +=
 * contadorcentro(contadorPC, manoPC, centro);
 * 
 * if(manoPC[0].valor==manoPC[1].valor) contadorPC++;
 * 
 * return contadorPC; }
 * 
 * public static void comprobarPersona(int contadorcolor, Cartas[] manoPersona,
 * Cartas[] centro) { switch (contadorPersona(contadorcolor, manoPersona,
 * centro)) { case 0: { System.out.println("No tienes nada"); break; } case 1: {
 * System.out.println("Tienes pareja"); break; } case 2: {
 * System.out.println("Tienes trio"); break; } case 3: {
 * System.out.println("TIENES UN PUTO POKERRR"); break; } } }
 * 
 * // ¿Qué has dicho? if (entrada.equals("foldeo") || entrada.equals("f")) {
 * ronda = 4; System.out.println("Eres un cagao"); } else if
 * (entrada.equals("subir") || entrada.equals("s")) {
 * System.out.print("Cuánto quieres subir? "); int subida = teclado.nextInt();
 * inicialPersona = inicialPersona - subida; } else if
 * (entrada.equals("igualar") || entrada.equals("i")) { int igualada =
 * inicialPersona - inicialPC; inicialPersona = inicialPersona - igualada; }
 * else { ronda = 4; System.err.println("No sabes jugar"); }
 * System.out.println(""); ronda += 1;
 * 
 * comprobarParejas(contadorNumeros, centroPersona);
 * comprobarEscalera(contadorEscalera, centroPersona);
 * comprobarColor(contadorColor, centroPersona);
 * 
 * comprobarParejasPC(contadorNumerosPC, centroPC);
 * comprobarEscaleraPC(contadorEscaleraPC, centroPC);
 * comprobarColorPC(contadorColorPC, centroPC);
 */