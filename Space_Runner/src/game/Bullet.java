package game;
import java.awt.*;
import javax.swing.*;

public class Bullet {
	
	int x,y;
	Image image;
	ImageIcon i;
	boolean k=false;
	
	public Bullet(int dx,int dy,String str){
		x=dx;
		y=dy;
		i=new ImageIcon(str);
		image=i.getImage();
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void move(){
		if(x<1206 && k==false)
			x=x+5;
		else
			x=54;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,7,5);
	}
}
