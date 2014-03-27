//obs³uga scenariuszy
//wyw³aszczanie w sjf

package zadanie1SO;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static void mediana(ArrayList<Integer> lista) {
		Collections.sort(lista);
		if (lista.size() % 2 == 1)
			System.out.println("Mediana: " + lista.get(lista.size() / 2 - 1));
		else
			System.out.println("Mediana: "
					+ ((lista.get(lista.size() / 2 - 1) + (lista.get(lista
							.size() / 2 - 1))) / 2));
	}

	static void srednia(ArrayList<Integer> lista) {
		int suma = 0;
		for (int i = 0; i < lista.size(); i++) {
			suma += lista.get(i);
		}
		System.out.println("Œrednia: " + suma / lista.size());
	}

	public static void main(String[] args) {

		FIFO f = new FIFO();
		SJF s = new SJF();
		ROT r = new ROT(5); // d³ugoœæ czasu przydzielonego na wykonanie procesu
							// (wstêpnie 5)
		for (int i = 0; i < 20; i++) {
			int time = (int) (20 * Math.random()); // d³ugoœæ
			f.dodaj(time, f.zegar);
			s.dodaj(time, s.zegar);
			r.dodaj(time, r.zegar);
		}

		while (!f.cpu.isEmpty()) {
			f.wykonaj();
		}

		while (!s.cpu.isEmpty()) {
			s.wykonaj();
			System.out.println("3");
		}

		while (!r.cpu.isEmpty()) {
			r.wykonaj();
		}

		System.out.println("Statystyka dla FIFO");
		srednia(f.o);
		mediana(f.o);
		System.out.println("Statystyka dla SJF");
		srednia(s.o);
		mediana(s.o);
		System.out.println("Statystyka dla ROT");
		srednia(r.o);
		mediana(r.o);

		/*
		 * Collections.sort(listaProcesy, new Comparator<Proces>() { public int
		 * compare(Proces o1, Proces o2) { if (o1.getS() == o2.getS()) return 0;
		 * return o1.getS() < o2.getS() ? -1 : 1; } });
		 */

		/*
		 * for (licznik_zegara = 0; licznik_zegara < 10; licznik_zegara++) {
		 * 
		 * System.out.println(listaProcesy.size());
		 * 
		 * Proces e = listaProcesy.get(0);
		 * 
		 * kolejka.add(e);
		 * 
		 * listaProcesy.remove(0);
		 * 
		 * // System.out.println(kolejka.get(0));
		 * System.out.println(kolejka.get(kolejka.size() - 1));
		 * 
		 * }
		 */
	}

}