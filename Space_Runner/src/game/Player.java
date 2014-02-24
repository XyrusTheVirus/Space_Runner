package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	 int x,dx,y,dy;
	 Image image;
	 ImageIcon i;
	 ImageIcon l;
	 ImageIcon dead_right,dead_left;
	 GUIBackground d;
	 Thread thread;
	 
	
	public Player(){
		i=new ImageIcon("Space Runner 2jpg.png");
	    image=i.getImage();
	    l=new ImageIcon("Space Runner_left.png");
	    dead_right=new ImageIcon("Dead_Right.png");
	    dead_left=new ImageIcon("Dead_Left.png");
	    x=420;
	    y=285;
	}
	
	public Rectangle getBounds(int v){
		return new Rectangle(x,v,21,38);
	}
	
	public void move(){
		x=x+dx;
		y=y+dy;
	}
	
	@Override
	public int getX(){
		return x;
	}
	
	@Override
	public int getY(){
		
		return y;
	}

	
	public Image getImage(){
		return image;
	}
	
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode(); 	
		
		if(key==KeyEvent.VK_LEFT){
			if(getX()<=52){
				dx=0;
				image=l.getImage();
			}
			
			else{
				dx=-2;
				image=l.getImage();
			}
		}
			
		if(key==KeyEvent.VK_RIGHT){
			if(getX()>=1206){
				dx=0;
				image=i.getImage();
			}
			
			else{
				dx=2;
				image=i.getImage();
			}
		}
		
		if(key==KeyEvent.VK_UP){
			dy=-1;
			image=i.getImage();
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode(); 	
		
		if(key==KeyEvent.VK_LEFT);
			dx=0;
			
		if(key==KeyEvent.VK_RIGHT);
			dx=0;
			
		if(key==KeyEvent.VK_UP);
			dy=0;
			
		if(key==KeyEvent.VK_DOWN);
			dy=0;
	}
	
	public void strike(){
		thread=new Thread(this);
		thread.start();
	}

	
	@Override
	public void run() {
		try{
			d.done=false;
			Thread.sleep(1000);
			}catch(Exception e){}{}
		
	}
	
	
}
