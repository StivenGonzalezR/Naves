
public class  HiloPersonaje extends Thread {
	private Personaje p;
	private boolean activo;
	private long espera;
	private CanvasJuego miCanvas;
	private boolean rot=true;
	

	private int DELTA_X = 1;
	private int DELTA_Y = 90;
	private int DELTA_X2 = 1;
	private int DELTA_Y2 = 1;

	public HiloPersonaje(CanvasJuego c, Personaje p, long espera) {
		this.p = p;
		activo = true;
		this.espera = espera;
		miCanvas = c;

		start();
	}

	@Override
	public void run() {
		while (activo) {
			if (p.getMov() == 1) {
				if (p.getX() > miCanvas.getWidth()) {
					p.setX(0);
					p.setY(p.getY() + DELTA_Y);
					
					if (p.getY() > miCanvas.getHeight()) {
						p.setY(0);
					}

				} else {
					p.setX(p.getX() + DELTA_X);
				}

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (p.getMov() == 2) {
				if (p.getY() > miCanvas.getHeight()){
					p.setY(0);
					p.setX(p.getX() + DELTA_X2);

					if (p.getX()>miCanvas.getWidth()){
						p.setX(0);
					}
				} else {
					p.setY(p.getY() + DELTA_Y2);
				}

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else if (p.getMov() == 3) {
				if (p.getY() > miCanvas.getHeight() || p.getX()> miCanvas.getWidth()){
					p.setX(0);
					p.setY(0);
					p.setX(p.getX() + DELTA_X2);
					
				} else {
					p.setY(p.getY() + DELTA_Y2);
					p.setX(p.getX() + DELTA_X2);
				}

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
	

	public void detener() {
		activo = false;
	}
}