package game;
import java.awt.*;
import javax.swing.ImageIcon;

public class Enemies {
	int dx1,dy1,dx2,dy2,x,y;
	ImageIcon i;
	Image image;
	boolean k=false,k1=false;
	
	public Enemies(int x1, int y1,int x2,int y2,String str){
		dx1=x1;
		dy1=y1;
		dx2=x2;
		dy2=y2;
		x=dx1;
		y=dy2;
		i=new ImageIcon(str);
		image=i.getImage();
	}
	
	public void move(){
		
		if(dx1!=dx2){
			
			if(k==false && x>dx2)
				x--;
			
			if(x==dx2)
				k=true;
			
			if(k==true && x<dx1)
				x++;
		
			if(x==dx1)
				k=false;
		}
		
		else if(dy1!=dy2){
			
			if(k==false && y<dy2)
				y++;
			
			if(y==dy2)
				k=true;
			
			if(k==true && y>dy1)
				y--;
			
			if(y==dy1)
				k=false;
		}
			
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,34);
	}
	
	public Rectangle getBounds1(){ 
		return new Rectangle(x,y,17,15);
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
}
