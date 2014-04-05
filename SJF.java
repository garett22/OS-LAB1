import java.util.ArrayList;

public class SJF {
	ArrayList<Proces> cpu = new ArrayList<Proces>(); // Sjf
	ArrayList<Integer> o = new ArrayList<Integer>(); // czasy Oczekiwañ

	SJF() {
	}

	void dodaj(int t, long s) {
		cpu.add(new Proces(t, s));
	}

	void wykonaj(long zegar) { //wykonanie jednego taktu
		if (!cpu.isEmpty()) {
			Proces p = cpu.get(0);
			cpu.remove(0);
			if (p.getT() > 1) {
				p.setT(p.getT() - 1);
				cpu.add(0, p);
			} else
				o.add((int) (zegar - p.getS())); // long-long=>int
		}
	}
}