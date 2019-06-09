package antlife;

public abstract class GameObject {

	int x;
	int y;
	int range;
	public boolean isDiscovered;
	public int r;
	public int g;
	public int b;
	public abstract void draw();
	double radius;
	
	public void print(){
		System.out.println("I am a GameObject");
	}
	

}
