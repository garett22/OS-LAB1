import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FIFO {
	List<Proces> cpu=new ArrayList<Proces>();
	List<Integer> o=new ArrayList<Integer>(); //czasy Oczekiwañ
	
	FIFO(){}
	
	void dodaj(int t, int s){
		cpu.add(new Proces(t,s));
	}
	
	long wykonaj(long t){ //otrzymuje aktualny czas procesora
		Iterator<Proces> it=cpu.iterator();
		if (it.hasNext()){
			Proces p=it.next();
			it.remove();
			o.add((int)(t-p.s)); //long-long=>int
			return t+p.t; 
		}
		else return 0; //nie wykonano procesu, wiêc wykorzystany czas procesora =0
	}
}
