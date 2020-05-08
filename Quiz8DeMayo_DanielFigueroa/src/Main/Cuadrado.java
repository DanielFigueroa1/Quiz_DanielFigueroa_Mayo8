package Main;

import processing.core.PApplet;

public class Cuadrado implements Runnable {

	PApplet app;
	int x;
	int y;
	int tipo;
	int tamanoX;
	int tamanoY;
	int posXInicial;
	int posYInicial;
	int vel;
	boolean vivo = true;

	public Cuadrado(PApplet app, int x, int y, int tipo) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.posXInicial = x;
		this.posYInicial = y;
		this.tipo = tipo;
		vel = -1;
		tamanoX = app.width / 30;
		tamanoY = app.height / 20;
		System.out.println(tipo);
	}

	public void pintar() {
		if (tipo == 0) {
			app.fill(0);
		} else if (tipo == 1) {
			app.fill(255);
		} else if (tipo == 2) {
			app.fill(255,0,0);
		}
		app.rect(x, y, tamanoX, tamanoY);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public void run() { //si la x llega a cierta posicion rebota
		// TODO Auto-generated method stub
		while (vivo) {

			try { //milesimas de segundo el sleep es para que no sea tan rapido
				x += vel;
				y += vel;
				if (x <= posXInicial - tamanoX || y <= posYInicial - tamanoX || x >= posXInicial || y >= posYInicial) {
					vel *= -1;
				}
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		
		}
	}

	public void click(int mx, int my) {
		if (mx > x && mx < x+tamanoX && my > y && my < y+tamanoY) {
			vivo = false;
			tipo = 2;
		}
	}
}
