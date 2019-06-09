package oceansim;
import java.util.ArrayList;

import apcs.Window;

public class Ocean {

	public static void main(String[] args) {
		 
		ArrayList<Organism> os = new ArrayList<Organism>();
		Window.size(500, 500);
		
		//Adding Plankton to os 
		for(int i = 0; i < 30; i++) {
			os.add(new Plankton());
		}
		
		//Adding Clownfish to os
		for(int i = 0; i < 50; i ++) {
			os.add(new Clownfish());
		}
		
		
		//Adding a Whale to os
		Whale whale = new Whale();
		
		
		os.add(whale);
		
		while(true) {
			Window.frame(40);
			Window.out.background("dark blue");
			
			for(Organism o: os) {
				o.draw();
				o.move();
				whale.eat(o);
				//whale.findFocus(o);

			}
			
			for(int i = 0; i < os.size(); i++) {
				
				Organism temp = os.get(i);
				
				if(temp.alive != true) {
					os.remove(temp);
				}
			}
		}
	}
}


//for (int i = 0 ; i < list.size() ; i++) {
//	// get the organism at index i
//	Organism o = list.get(i);
//	
//	if (o.isDead()) {
//		list.remove(o);
//		System.out.println("removing");
//	}
//}
