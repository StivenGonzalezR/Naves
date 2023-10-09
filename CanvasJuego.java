import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class CanvasJuego extends Canvas implements KeyListener {
	private static final long serialVersionUID = 1L;

	public static int ANCHO = 350;
	public static int ALTO = ANCHO / 14 * 10;
	public static int ESCALA = 3;

	private ArrayList<Personaje> listaPersonajes;

	private ArrayList<HiloPersonaje> hilotes;

	// private HiloPersonaje hiloP1, hiloP2;

	private Image fondo;

	public CanvasJuego() {
		Dimension dimension = new Dimension(ANCHO * ESCALA, ALTO * ESCALA);
		hilotes = new ArrayList<>();
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);

		addKeyListener(this);

		listaPersonajes = new ArrayList<>();
	}

	public synchronized void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(fondo, 0, 0, null);

		synchronized (listaPersonajes) {
			for (Personaje personaje : listaPersonajes) {
				personaje.render(g);
			}
			listaPersonajes.notify();
		}

		// listaPersonajes.notify();
		g.dispose();
		bs.show();
	}

	public void init() {
		Personaje p1, p2, p3, p4;

		fondo = new ImageIcon("res/Espacio.jpg").getImage();

		p1 = new Personaje("ovni1.png", 100, 350, 1);
		p2 = new Personaje("ovni1.png", 100, 290, 1);
		p3 = new Personaje("ovni2.png", 100, 100, 2);
		p4 = new Personaje("ovni2.png", 0, 0, 3);

		listaPersonajes.add(p1);
		listaPersonajes.add(p2);
		listaPersonajes.add(p3);
		listaPersonajes.add(p4);

		HiloPersonaje hiloP1 = new HiloPersonaje(this, p1, 4);
		hilotes.add(hiloP1);

		HiloPersonaje hiloP2 = new HiloPersonaje(this, p2, 4);
		hilotes.add(hiloP2);

		HiloPersonaje hiloP3 = new HiloPersonaje(this, p3, 4);
		hilotes.add(hiloP3);

		HiloPersonaje hiloP4 = new HiloPersonaje(this, p4, 4);
		hilotes.add(hiloP4);

		requestFocus();

		new Thread(new HiloJuego(this)).start();
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_1:
			hilotes.get(0).detener();
			break;

		case KeyEvent.VK_2:
			hilotes.get(1).detener();
			break;
		case KeyEvent.VK_3:

			
				Personaje p3;
				int x = (int) Math.floor(Math.random() * 1000);
				int y = (int) Math.floor(Math.random() * 500);
				int mov = (int) Math.floor(Math.random() * ((3)))+1;
				int vel = (int) Math.floor(Math.random() * ((9)))+1;
				if (vel % 2 == 0) {
					p3 = new Personaje("ovni1.png", x, y, mov);
				} else
					p3 = new Personaje("ovni2.png", x, y, mov);
				HiloPersonaje hiloP3 = new HiloPersonaje(this, p3, vel);
				hilotes.add(hiloP3);
				synchronized (listaPersonajes) {
				listaPersonajes.add(p3);
				listaPersonajes.notify();
			}

			break;
		case KeyEvent.VK_SPACE:
			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
