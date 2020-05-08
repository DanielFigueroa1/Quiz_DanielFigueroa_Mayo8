package Main;

import processing.core.PApplet;

public class Main extends PApplet {
	
	private Logica log;

	public static void main(String[] args) {
		PApplet.main("Main.Main");
	}
	
	
	@Override
	public void settings() {
		size(600,400);
		
	}
	
	@Override
	public void setup() {
		log= new Logica(this);
		noStroke();
		
	}
	
	@Override
	public void draw() {
		background(255);
		log.pintar();
	}
	

	
	@Override
	public void mouseReleased() {
		log.released();
	}
	
}
	