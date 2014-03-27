package zadanie1SO;
// dodaæ obs³ugê wyw³aszczania

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SJF {
	SortedSet<Proces> cpu=new TreeSet<Proces>(); //Sjf
	ArrayList<Integer> o=new ArrayList<Integer>(); //czasy Oczekiwañ
	long zegar=0;
	
	SJF(){}
	
	void dodaj(int t, long s){
		cpu.add(new Proces(t,s));
	}
	
	void wykonaj(){ 
		Iterator<Proces> it=cpu.iterator();
		if (it.hasNext()){
			Proces p=it.next();
			it.remove();
			zegar+=p.getT();
			o.add((int)(zegar-p.getS())); //long-long=>int
		}
	}
	
	void wywlaszcz(){}
}