public class Proces implements Comparable<Proces>{
	long s; //start - czas dodania
	int t; //time - czas pozostały do ukończenia
	
	Proces(int t, long s){
		this.s=s;
		this.t=t;		
	}

	public int compareTo(Proces p) {
		return ((Integer)t).compareTo(p.t);
	}
}
