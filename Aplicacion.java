import javax.swing.*;

public class Aplicacion {

	public static void main( String[] args ) 
	{
		CanvasJuego miCanvas = new CanvasJuego(  );
		
		JFrame marco = new JFrame();
		
		marco.add                      ( miCanvas );
		marco.pack                     (          );
		marco.setResizable             ( false    );
		marco.setLocationRelativeTo    ( null     );
		marco.setVisible               ( true     );
		marco.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		
		miCanvas.init();	
	}
}

