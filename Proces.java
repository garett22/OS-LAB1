public class Proces implements Comparable<Proces>{
	long s; //start - czas dodania
	int t; //time - czas pozosta³y do ukoñczenia
	
	Proces(int t, long s){
		this.s=s;
		this.t=t;		
	}

	public int compareTo(Proces p) {
		return ((Integer)t).compareTo(p.t);
	}
}
