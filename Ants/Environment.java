package antlife;

import apcs.Window;

public class Environment {

	public static void main(String[] args) {
	
		Window.size(700, 700);
		
		
		Hill hill = new Hill();
		
		while(true){
			Window.frame();
			Window.out.background("yellow green");
			
			
			hill.exist();
			
			
		}
		
	}

}
