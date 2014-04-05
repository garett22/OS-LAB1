import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainW {

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

	public static ArrayList<Proces> doDodania = new ArrayList<Proces>();
	public static long zegar = 0;

	public static void main(String[] args) {
		SJF s = new SJF();
		SJF sw = new SJF(); //z wywlaszczaniem
		
		//==================================================================
		//losowanie proces�w
		for (int i = 0; i < 20; i++) {
			int time = (int) (20 * Math.random()); // d�ugo��
			s.dodaj(time, 0);
			sw.dodaj(time, 0);
		}
		Collections.sort(s.cpu);
		Collections.sort(sw.cpu);
		//dodawanie proces�w do p�niejszego uruchomienia
		System.out.println("wygenerowano grup� proces�w");
		int a = 1;
		Scanner sc = new Scanner(System.in);
		while (a == 1) {
			System.out.println("Doda� proces ? 1-tak 0-nie");
			a = sc.nextInt();
			if (a == 1) {
				System.out
						.println("podaj d�ugo�� procesu i kiedy ma zosta� dodany");
				int x = sc.nextInt(), y = sc.nextInt();
				doDodania.add(new Proces(x, 0, ((long) y)));
			}
		}
		Collections.sort(doDodania);
		//==================================================================
		
		while (!s.cpu.isEmpty()) {
			// wykonaj jeden takt, sprawd� czy nie trzeba doda�
			if (!doDodania.isEmpty()) {
				if (doDodania.get(0).getR() == zegar) { //dodaj, ale po pierwszym procesie
					Proces p=s.cpu.get(0);
					s.cpu.remove(0);
					s.cpu.add(new Proces(doDodania.get(0).getT(), zegar));
					Collections.sort(s.cpu);
					s.cpu.add(0, p);
				}
				if (doDodania.get(0).getR() == zegar) {
					sw.cpu.add(new Proces(doDodania.get(0).getT(), zegar));
					Collections.sort(s.cpu);
				}
				doDodania.remove(0);
			}			
			s.wykonaj(zegar);
			sw.wykonaj(zegar);
			zegar++;
		}

		System.out.println("Statystyka dla SJF z wyw�aszczaniem");
		srednia(sw.o);
		mediana(sw.o);
		System.out.println("Statystyka dla SJF bez wyw�aszczania");
		srednia(s.o);
		mediana(s.o);
		sc.close();
	}

}