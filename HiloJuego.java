

public class HiloJuego implements Runnable
{

	private CanvasJuego miCanvas;

	public HiloJuego( CanvasJuego miCanvas) 
	{
		this.miCanvas = miCanvas;
	}

	
	/**
	 * Crear un ejecutor de 60 frames por segundo. 
	 * Actualiza las animaciones y los movimientos 
	 * (incluyendo las colisiones).
	 */
	@Override
	public void run() {
		
		long ultimoTiempo = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / 60;

		while ( true ) 
		{
			long tiempoAhora = System.nanoTime();
			delta           += ( tiempoAhora - ultimoTiempo ) / ns;
			ultimoTiempo     = tiempoAhora;

			if ( delta >= 1 ) 
			{
				miCanvas.render();
			}
		}
	}
}

