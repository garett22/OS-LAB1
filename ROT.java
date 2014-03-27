package zadanie1SO;

import java.util.ArrayList;

public class ROT {
	int k; // Kwant czasu
	ArrayList<Proces> cpu = new ArrayList<Proces>(); // Rot
	ArrayList<Integer> o = new ArrayList<Integer>(); // czasy Oczekiwañ
	long zegar = 0;

	ROT(int k) {
		this.k = k;
	}

	void dodaj(int t, long s) {
		cpu.add(new Proces(t, s));
	}

	void wykonaj() {
		if (!cpu.isEmpty()) {
			Proces p = cpu.get(0);
			cpu.remove(0);
			if (p.getT() >= k) {
				p.setT(p.getT() - k);
				zegar += k;
				cpu.add(p);
			} else {
				zegar += p.getT();
				o.add((int) (zegar - p.getS()));
			}

			o.add((int) (zegar - p.getS())); // long-long=>int
		}
	}
}