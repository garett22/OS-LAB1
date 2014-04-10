//obs�uga scenariuszy
//wyw�aszczanie w sjf



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
		System.out.println("�rednia: " + suma / lista.size());
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		FIFO f = new FIFO();
		//SJF s = new SJF();
		ROT r = new ROT(5); // d�ugo�� czasu przydzielonego na wykonanie procesu
							// (wst�pnie 5)
		for (int i = 0; i < 20; i++) {
			int time = (int) (20 * Math.random()); // d�ugo��
			f.dodaj(time, f.zegar);
			//s.dodaj(time, s.zegar);
			r.dodaj(time, r.zegar);
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				"Scenariusz1.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// sb.append(",");
				line = br.readLine();

			}

			String everything = sb.toString();

			System.out.println(everything);

			StringTokenizer stringtokenizer = new StringTokenizer(everything,
					" ");
			while (stringtokenizer.hasMoreElements()) {
				// System.out.println(stringtokenizer.nextToken());
				
				int dlugosc = Integer.valueOf(stringtokenizer.nextToken());
				int czas_rozpoczecia = Integer.valueOf(stringtokenizer.nextToken());

				f.dodaj(dlugosc, czas_rozpoczecia);
				r.dodaj(dlugosc, czas_rozpoczecia);

			}
		}

		while (!f.cpu.isEmpty()) {
			f.wykonaj();
		}

		//while (!s.cpu.isEmpty()) {
			//s.wykonaj(0);
			//System.out.println("3");
		//}

		while (!r.cpu.isEmpty()) {
			r.wykonaj();
		}

		System.out.println("Statystyka dla FIFO");
		srednia(f.o);
		mediana(f.o);
		//System.out.println("Statystyka dla SJF");
		//srednia(s.o);
		//mediana(s.o);
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