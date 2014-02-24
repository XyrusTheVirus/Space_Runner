package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class GUIBackground extends JPanel implements ActionListener,Runnable {
	
	private static final long serialVersionUID = 1L;
    JFrame mainframe;
	JPanel mainpanel;
	JPanel datapanel;
	JTextField  score,level,lifes;
	Image image,image1,image2,image3,image4,image5,image6,image7,image8,image9;
	Image [] images={image3,image4,image9};
	ImageIcon ie,gunner,keypedalon,keypedaloff;
	Player p;
	Enemies e1,e2;
	Bullet bullet;
	Timer time;
	Thread animator;
	int b=0,v=295,i3,i2=0,i=0,life=3,score1=0,currLocation=650,distance;
	ArrayList<Integer> x=new ArrayList<Integer>();
	ArrayList<Integer> y=new ArrayList<Integer>();
	ArrayList<Integer> w=new ArrayList<Integer>();
	ArrayList<Enemies> e=new ArrayList<Enemies>();
	
	Map<Integer,Integer> ball=new HashMap<Integer,Integer>();
	boolean [] ball2;
	boolean z=true,m,b1=false,c1=false,hitThePedal=false;
	
	
	public GUIBackground(){
		p=new Player();	
		ie=new ImageIcon("Life.png");
		keypedaloff=new ImageIcon("KeyPedalOff.png");
		image7=keypedaloff.getImage();
		keypedalon=new ImageIcon("KeyPedalOn.png");
		image8=keypedalon.getImage();
		image5=ie.getImage();
		gunner=new ImageIcon("gunner.png");
		image6=gunner.getImage();
		e.add(i2,new Enemies(1206,640,890,640,"enemie1.png"));
		i2++;
		e.add(i2,new Enemies(51,320,51,640,"enemie2.png"));
		i2++;
		e.add(i2,new Enemies(1000,205,600,205,"Robot.png"));
		i2++;
		bullet=new Bullet(54,155,"Bullet.png");
		invokeInItWindow();
		addKeyListener(new AL());
		setFocusable(true);
		time=new Timer(5,this);
		time.start();
		}


		
	private void  InItWindow(){
		mainframe=new JFrame("GAME");
		mainframe.setPreferredSize(new Dimension(1280,800));
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = mainframe.getContentPane();
		cp.setLayout(new BorderLayout());
		mainpanel=new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.X_AXIS));
		mainpanel.add(this);
		mainframe.add(mainpanel,BorderLayout.CENTER);
		mainframe.pack();
		mainframe.setVisible(true);
		}
		
		private void invokeInItWindow(){
			SwingUtilities.invokeLater(
					new Runnable(){
						@Override
						public void run(){
						InItWindow();
						}
					});
		}
					
		boolean k=false;
		@Override
		public void paintComponent( Graphics g ){
			
			if(p.dy==-1 && k==false){
				k=true;
				m=true;
				animator=new Thread(this);
				animator.start();
			}
			
			if( (p.dx==-2 || p.dx==2) && (m==false)){
				while(isInIt()==false){
					v++;
					p.y++;
				}
				currLocation=v;
			}
			
			if((p.dx==2 || p.dx==-2)){
				if(p.getX()==1216 || p.getX()==50)
					p.dx=0;
			}
			
		   int hf=mainpanel.getHeight();
		   int wf=mainpanel.getWidth();
		  
		   g.setColor( Color.WHITE );
	       g.fillRect(0,0, wf, hf);
	       g.setColor( Color.BLACK );
	       g.drawLine(50, 50, 50, hf-50);
	       g.setColor( Color.BLACK );
	       g.drawLine(wf-50, 50, wf-50, hf-50);
	       g.setColor( Color.BLACK );
	       g.drawLine(50, hf-50, wf-50, hf-50);
	       
	       if(z==true){
	       x.add(i,50);
	       y.add(i,650);
      	   w.add(i,1206);
      	   i++;
	       }
	       
	       g.setColor( Color.BLACK );
	       g.drawRect(75,620,85,10);
	       if(z==true){
	       x.add(i,75);
	       y.add(i,585);
	       w.add(i,85);
	       i++;
	       }
	      
	       g.setColor( Color.BLACK );
	       g.drawRect(800,620,430,10);
	       if(z==true){
	       x.add(i,800);
	       y.add(i,585);
	       w.add(i,430);
	       i++;
	       }
	       	
	       g.setColor( Color.BLACK );
	       g.drawRect(950,570,100,10);
	       if(z==true){
	       x.add(i,950);
	       y.add(i,535);
	       w.add(i,100);
	       i++;
	       }
	       	
	       	g.setColor( Color.BLACK );
	 	    g.drawRect(800,520,150,10);
	 	    if(z==true){
	 	    x.add(i,800);
	 	    y.add(i,480);
	 	    w.add(i,150);
	 	    i++;
	 	    }
 		
	 	     g.setColor( Color.BLACK );
		     g.drawRect(700,450,100,10);
		     if(z==true){
		     x.add(i,700);
		     y.add(i,410);
		     w.add(i,100);
		     i++;
		     }
		     
		     g.setColor( Color.BLACK );
		     g.drawRect(600,380,100,10);
		     if(z==true){
		     x.add(i,600);
		     y.add(i,340);
		     w.add(i,100);
		     i++;
		     }
		       		
		     g.setColor( Color.BLACK );
		     g.drawRect(320,330,200,10);
			 if(z==true){
			 x.add(i,320);
			 y.add(i,295);
			 w.add(i,200);
			 i++;
			 }
			
			 g.setColor( Color.BLACK );
			 g.drawRect(50,310,170,10);
			 if(z==true){
			 x.add(i,50);
			 y.add(i,270);
			 w.add(i,170);
			 i++;
			 }
			 
			 g.setColor( Color.BLACK );	
			 g.drawRect(100,250,150,10);
			 if(z==true){
			 x.add(i,100);
			 y.add(i,210);
			 w.add(i,150);
			 i++;
			 }
			  
			  g.setColor( Color.BLACK );
			  g.drawRect(300,190,50,10);
			  if(z==true){
			  x.add(i,300);
			  y.add(i,150);
			  w.add(i,50);
			  i++;
			  }
		      
			  g.setColor( Color.BLACK );
		      g.drawRect(400,190,50,10);
			  if(z==true){
			  x.add(i,400);
			  y.add(i,150);
			  w.add(i,50);
			  i++;
			  }
		       	
		     g.setColor( Color.BLACK );
			 g.drawRect(600,220,400,10);
			 if(z==true){
			 x.add(i,600);
			 y.add(i,180);
			 w.add(i,400);
			 i++;
			 }
			 
			 g.setColor( Color.BLACK );
			 g.drawRect(1085,180,145,10);		
		     if(z==true){
		     x.add(i,1085);
		     y.add(i,140);
			 w.add(i,145);
			 i++;
			 }
	       
		   g.setColor( Color.BLACK );
	       g.drawLine(50, 50, wf-50, 50);
	       g.setColor( Color.BLACK );
	       g.drawLine(65, 320, 65, 640);
	       g.setColor( Color.BLACK );
	       g.drawLine(900, 655, wf-50, 655);
	       g.drawImage(image6,52,150,null);
	       g.drawImage(bullet.getImage(),bullet.getX(),bullet.getY(),null);
	       
	       hitThePedal();
	       if(hitThePedal==false)
	    	   g.drawImage(image7,310,180,null);
	       
	       else{
	    	   g.drawImage(image8,310,180,null);
	    	   bullet.k=true;
	       }
	       
	       if(z==true){
	    	   ball2=new boolean[10];
	    	   for(int c=0;c<10;c++)
	    		   ball2[c]=false;
	       }
	    	   
	       if(ball2[0]==false){
	       g.setColor( Color.ORANGE );
	       g.fillOval(90, 585 ,10, 10);
	       hitTheBall(90,585);
	       }
	      
	       if(b1==true){
	       ball2[0]=true;
	       b1=false;
	       score1++;
	       }
	       
	       if(ball2[1]==false){
	       g.setColor( Color.ORANGE );
	       g.fillOval(140, 585 ,10, 10);
	       hitTheBall(140,585);
	       }	
	       
	       if(b1==true){
	       ball2[1]=true;
	       b1=false;
	       score1++;
	       }
	       
	       if(ball2[2]==false){
		    g.setColor( Color.ORANGE );
		    g.fillOval(wf-350, 649 ,10, 10);
		    hitTheBall(wf-350,650);
		   }	
		       
		   if(b1==true){
		    ball2[2]=true;
		    b1=false;
		    score1++;
		    }
		       
		   if(ball2[3]==false){
		    g.setColor( Color.ORANGE );
		    g.fillOval(wf-250, 649 ,10, 10);
			hitTheBall(wf-250,650);
			}	
			       
		   if(b1==true){
	        ball2[3]=true;
    	    b1=false;
			score1++;
			}
		   
		   if(ball2[4]==false){
			    g.setColor( Color.ORANGE );
			    g.fillOval(wf-100, 585 ,10, 10);
				hitTheBall(wf-100,585);
				}	
				       
			   if(b1==true){
		        ball2[4]=true;
	    	    b1=false;
				score1++;
				}
			   
			   if(ball2[5]==false){
				    g.setColor( Color.ORANGE );
				    g.fillOval(wf-150, 585 ,10, 10);
					hitTheBall(wf-150,585);
					}	
					       
				   if(b1==true){
			        ball2[5]=true;
		    	    b1=false;
					score1++;
					}
			      
				   if(collision()==true){
			    	  
			    	   if(p.getImage()==p.i.getImage()){
			    		   p.strike();
			    		   p.image=p.dead_right.getImage();
			    		   g.drawImage(image1,0,0,null);
			    	       g.drawImage(p.getImage(),p.getX(),v,null);
			    	       life--;
			    	       p.strike();
			    	       p.x=440;
			    	       v=295;
			    	       p.image=p.i.getImage();	
			    	       done=true;
			    	       }
			    	   
			    	   else if(p.getImage()==p.l.getImage()){
			    		   p.strike();
			    		   p.image=p.dead_left.getImage();
			    		   g.drawImage(image2,0,0,null);
			    	       g.drawImage(p.getImage(),p.getX(),v,null);
			    	       life--;
			    	       p.strike();
			    	       p.x=440;
			    	       v=295;
			    	       p.image=p.i.getImage();	
			    	       done=true;
			    	   }
			    		   
			       }
		   
		   g.drawImage(image,0,0,null);
	       g.drawImage(p.getImage(),p.getX(),v,null);
	       g.setColor(Color.BLACK);
	       g.drawString("Level 1", 60, 720);
	       g.setColor(Color.BLACK);
		   g.drawString("Score: "+score1, 700,720);
	       
		   for(int i6=0;i6<life;i6++){
	       distance=distance+40;
	       g.drawImage(image5,distance,710,null);
	       }
	    
	       for(i3=0;i3<e.size();i3++){
	    	g.drawImage(images[i3],0,0,null);
	    	g.drawImage(e.get(i3).getImage(),e.get(i3).getX(),e.get(i3).getY(),null);
	    	}
	       
	       distance=1060;
	       z=false;
	    }	
		
		private class AL extends KeyAdapter{
			
			@Override
			public void keyReleased(KeyEvent e){
				p.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e){
				p.keyPressed(e);
				
			}
		}

		
		@Override
		public void actionPerformed(ActionEvent ea) {
			p.move();
			for(int i4=0;i4<e.size();i4++)
				e.get(i4).move();
			bullet.move();
			repaint();
		}


		@Override
		public void run() {
			
			long beforeTime,timeDiff,sleep;
			
			while(done==false){
				cycle();
				beforeTime=System.currentTimeMillis();
				timeDiff=System.currentTimeMillis()-beforeTime;
			    sleep=10-timeDiff;
				
				if(sleep<0)
					sleep=2;
				try{
					Thread.sleep(sleep);
				}catch(Exception e){}
				
				beforeTime=System.currentTimeMillis();
				
			}
			
			h=false;
			done=false;
			k=false;
			m=false;
		}
		
		
		boolean h=false;
		boolean done=false;
		public void cycle(){
			
			if(h==false){
				v--;
				p.y--;
			}	

			if(isInIt2()==true){
				h=true;
			}
			
			if(v==(currLocation-70)){
				h=true;
			}
			
			if((h==true && isInIt()==false)){
				v++;
				p.y++;
			}
			
			if(isInIt()==true){
				currLocation=v;
				done=true;
			}
				
		}
		
		int t=0;
		public boolean isInIt(){
			
			for(t=0;t<14;t++)
				if(v==y.get(t) && p.getX()<= (x.get(t)+w.get(t)) && p.getX()>=x.get(t))
					return true;
			
			return false;
		}
		int j=0;
		public boolean isInIt2(){
			
			for(j=0;j<14;j++)
				if(v==(y.get(j)+40) && p.getX()<(x.get(j)+w.get(j)) && p.getX()>x.get(j))
					return true;
			
			return false;
		}
		
		
		public void hitTheBall(int x,int y){
			
			if(p.getX()==x && v==y)
				b1=true;
		}
		
		public Boolean collision(){
			
			for(int i5=0;i5<e.size();i5++)
				if(p.getBounds(v).intersects(e.get(i5).getBounds()) || p.getBounds(v).intersects(bullet.getBounds()) ||
				p.getBounds(v).intersects(e.get(2).getBounds1()))
					return true;
			return false;
		}
		
		@Override
		public Rectangle getBounds(){
			return new Rectangle(310,180,31,12);
		}
		
		public void hitThePedal(){
			if(p.getBounds(v).intersects(getBounds()))
				hitThePedal=true;
			}
		
}