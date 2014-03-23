import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ROT {
	int k; //Kwant czasu
	List<Proces> cpu=new ArrayList<Proces>(); //Rot
	List<Integer> o=new ArrayList<Integer>(); //czasy Oczekiwañ
	
	ROT(int k){
		this.k=k;
	}
	
	void dodaj(int t, long s){
		cpu.add(new Proces(t,s));
	}
	
	long wykonaj(long t){ //otrzymuje aktualny czas procesora
		Iterator<Proces> it=cpu.iterator();
		if (it.hasNext()){
			Proces p=it.next();
			it.remove();
			p.t-=k;
			if (p.t>0) cpu.add(p); 
				else o.add((int)(t-p.s)); //long-long=>int
			return t+k; //aktualny czas + czas wykonywania procesu 
		}
		else return 0; //nie wykonano procesu, wiêc wykorzystany czas procesora =0
	}
}
