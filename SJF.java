// dodaæ obs³ugê wyw³aszczania

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SJF {
	SortedSet<Proces> cpu=new TreeSet<Proces>(); //Sjf
	List<Integer> o=new ArrayList<Integer>(); //czasy Oczekiwañ
	
	SJF(){}
	
	void dodaj(int t, long s){
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
	
	void wywlaszcz(){}
}
