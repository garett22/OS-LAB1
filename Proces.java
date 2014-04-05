public class Proces implements Comparable<Proces> {

	private long s; // start - czas dodania
	private int t; // time - czas pozosta�y do uko�czenia
	private long r; //w kt�rym takcie zegara nale�y zacz�� proces

	Proces(int l,long z) {
		s=z;
		t=l;
	}
	
	Proces(int l,long z, long rozp){
		t=l;
		s=rozp;
		r=rozp;
	}

	@Override
	public String toString() {
		return "Proces [s=" + s + ", t=" + t + "]";
	}

	public int compareTo(Proces p) {
		return ((Integer) t).compareTo(p.t);
	}

	/*public void losowanie() { // losowanie czas�w
		this.s = (int) (20 * Math.random());
		this.t = (int) (20 * Math.random());
	}*/

	public long getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}
	
	public long getR() {
		return r;
	}

	public void setR(long r) {
		this.r = r;
	}

}