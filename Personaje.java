import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author JHONNATAN OSORIO
 *
 */
public class Personaje {
	
	private Image imagen;
	private int   x, y,xrot1,xrot2,yrot;
	private int   ancho, alto;
	private int mov;
	public Personaje ( String nombre, int x, int y,int mov )
	{
		this.x = x;
		this.y = y;
		this.xrot1=x+60;
		this.xrot2=x-60;
		this.yrot=y+60;
		this.mov=mov;
		imagen = new ImageIcon( "res/"+nombre ).getImage();
		ancho = imagen.getWidth( null );
		alto  = imagen.getHeight( null );
	}
	
	public void render( Graphics g )
	{
	
		g.drawImage( imagen, x, y, ancho, alto, null);
		g.setColor(Color.white); 
		g.drawString("x: "+x+" y: "+y, x, y);
		
	
	}

	public int getX() 
	{
		return x;
	}

	public int getXrot1() {
		return xrot1;
	}

	public int getXrot2() {
		return xrot2;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	
	public int getY() 
	{
		return y;
	}

	
	public void setY( int y ) 
	{
		this.y = y;
	}

	public int getMov() {
		return mov;
	}

	public int getYrot() {
		return yrot;
	}

	public void setYrot(int yrot) {
		this.yrot = yrot;
	}
	
	

}
