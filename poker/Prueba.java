package poker;

import java.util.Scanner;

public class Prueba {
	public static void main(String[] args) {
		int[] manoPC = { 2, 2 };
		int[] manoPersona = { 6, 1 };

		int dineroGanador = 0;
		int dineroPersona = 100;
		int dineroPC = 100;
		int inicialPersona = 100;
		int inicialPC = 100;

		int ronda = 1;
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Tu dinero actual es: " + dineroPersona);
			int jugadaPC = 0;
			if (ronda >= 2) {
				if (manoPC[0] == manoPC[1])
					jugadaPC = (int) (Math.random() * (2 - 1 + 1) + 1);
				else
					jugadaPC = (int) (Math.random() * (3 - 1 + 1) + 1);

				if (jugadaPC == 2) {
					int importe = 0;
					while (importe % 2 != 0)
						importe = (int) (Math.random() * (dineroPC / 2 - 1 + 1) + 1);
					dineroGanador = dineroGanador + importe;
					System.out.println("P(ancho)C sube!!!");
				} else if (jugadaPC == 1) {
					dineroGanador = dineroGanador;
					System.out.println("P(ancho)C ha pasado");
				}
					
				else {
					ronda = 4;
					dineroPC = dineroPC - dineroGanador;
					dineroPersona = dineroPersona + dineroGanador;
					System.out.println("P(ancho)C ha foldeado (pringado)");
				}
			} else
				dineroGanador = 5;
			System.out.println("Apuesta central: " + dineroGanador);
			System.out.print("Introduce la entrada: ");
			String palabra1 = teclado.nextLine();

			if (palabra1.equals("i")) {
				if (jugadaPC == 1)
					dineroGanador = dineroGanador;
				else
					dineroGanador = 2 * dineroGanador;
				System.out.println("Has igualado");
			}

			else if (palabra1.equals("s")) {
				System.out.print("Cuánto quieres subir? ");
				int importe = teclado.nextInt();
				jugadaPC = (int) (Math.random() * (2 - 1 + 1) + 1);
				System.out.println("Apuesta central: " + (dineroGanador + importe));
				if (jugadaPC == 1) {
					dineroGanador = 2 * (dineroGanador + importe);
					System.out.println("P(ancho)C ha igualado");
				} else if (jugadaPC == 2) {
					if (ronda == 1) {
						ronda = 4;
						dineroPC = inicialPC - dineroGanador;
					} else {
						ronda = 4;
						dineroPC = inicialPC - dineroGanador / 2;
					}
					dineroPersona = dineroPersona + dineroGanador;
					System.out.println("P(ancho)C ha foldeado (pringado)");
				}
			} else {
				if (ronda > 1) {
					ronda = 4;
					dineroPC = inicialPersona - dineroGanador / 2;
					dineroPC = dineroPC + dineroGanador;
				} else
					ronda = 4;
				System.out.println("Cagón");
			}

			if (ronda != 4) {
				dineroPersona = inicialPersona - dineroGanador / 2;
				dineroPC = inicialPC - dineroGanador / 2;
				System.out.println("Siguiente ronda!!!");
			}
			ronda++;
			System.out.println(dineroGanador);
			System.out.println(dineroPersona);
			System.out.println(dineroPC);
		} while (ronda < 4);

	}
}
