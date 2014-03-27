package zadanie1SO;

import java.util.ArrayList;

public class FIFO {
	ArrayList<Proces> cpu = new ArrayList<Proces>();
	ArrayList<Integer> o = new ArrayList<Integer>(); // czasy Oczekiwañ
	long zegar = 0;

	FIFO() {
	}

	void dodaj(int t, long s) {
		cpu.add(new Proces(t, s));
	}

	void wykonaj() { 
		if (!cpu.isEmpty()) {
			Proces p = cpu.get(0);
			cpu.remove(0);
			zegar += p.getT();
			o.add((int) (zegar - p.getS())); // long-long=>int
		}
	}
}