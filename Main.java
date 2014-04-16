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
		System.out.println("Œrednia: " + suma / lista.size());
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		FIFO f = new FIFO();
		SJF s = new SJF();
		ROT r = new ROT(5); // d³ugoœæ czasu przydzielonego na wykonanie procesu
							// (wstêpnie 5)
/*		for (int i = 0; i < 20; i++) {
			int time = (int) (20 * Math.random()); // d³ugoœæ
			f.dodaj(time, f.zegar);
			s.dodaj(time, s.zegar);
			r.dodaj(time, r.zegar);
		}
*/
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
				int czas_rozpoczecia = Integer.valueOf(stringtokenizer
						.nextToken());

				f.dodaj(dlugosc, czas_rozpoczecia);
				s.dodaj(dlugosc, czas_rozpoczecia);
				r.dodaj(dlugosc, czas_rozpoczecia);

			}
		}

		while (!f.cpu.isEmpty()) {
			f.wykonaj();
		}

		while (!s.cpu.isEmpty()) {
			s.wykonaj();
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
	}

}