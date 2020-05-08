package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private ArrayList<Cuadrado> cuadrados;

	boolean mov = false;

	public Logica(PApplet app) {
		this.app = app;
		cuadrados = new ArrayList<Cuadrado>();
		int tipo = 0;
		for (int i = 0; i < 30; i++) { //creacionde cuadrados horizontales
			for (int j = 0; j < 20; j++) { //creacion de cuadrados verticales
				cuadrados.add(new Cuadrado(app, app.width / 30 * (i), app.height / 20 * (j), tipo));
				tipo++;
				if (tipo > 1) {
					tipo = 0;
				}
			}
			tipo++;
			if (tipo > 1) {
				tipo = 0;
			}
		}
	}

	public void pintar() {
		for (int i = 0; i < cuadrados.size(); i++) {
			cuadrados.get(i).pintar();
		}

	}

	public void released() { 

		if (mov == false) { //si el cuadro se mueve no crea mas hilos
			for (int i = 0; i < cuadrados.size(); i++) {
				if ((i + 1) % 2 == 0) {
					if (cuadrados.get(i).getTipo() == 0) {
						Cuadrado a = cuadrados.get(i);
						new Thread(a).start();
					}
				}
			}
			mov = true;
		} else {
			for (int i = 0; i < cuadrados.size(); i++) {
				if ((i + 1) % 2 == 0) {
					if (cuadrados.get(i).getTipo() == 0) {
						Cuadrado a = cuadrados.get(i);
						a.click(app.mouseX,app.mouseY);
					}
				}
			}
		}

	}
}