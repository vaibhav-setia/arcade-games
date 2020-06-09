package games;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Ships extends JFrame implements ActionListener{

    private JPanel contentPane;
    Timer timer;
    Timer timer2;
    int flag=0;
    static boolean miss,hit,k=false;
    public int count=0,counta=0,countb=0,countc=0,countd=0,level=1,lives=20,xbullet=85;
    int x=418;
    public int p=75,l=10;
    public int y=5,a=-100,b=-100,c=-100,d=-100;
    
    Thread t1;
    /**
    * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ships frame = new Ships();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
    }
    
    JLabel lblNewLabel = new JLabel();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JPanel p1= new JPanel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l9 = new JLabel();
    JPanel infoPanel;
    JLabel levelon = new JLabel("On Level : "+level, SwingConstants.CENTER);
    JLabel livesleft = new JLabel("Lives left : "+lives, SwingConstants.CENTER);
    public int vai=0;
  
    public Ships() {
         //Container container= getContentPane();


    	Image back = new ImageIcon(this.getClass().getResource("/resources/splash.jpg"))
    			.getImage();
    		
    	this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               //g.drawImage(back, 0, 0, getWidth(), getHeight(), null);
               g.drawImage(back, 0, 0, 1363, 770, null);
               
            }
         });	
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBounds(0, 0, 1363, 770);
        //contentPane = new JPanel();
        //contentPane.setBackground(Color.CYAN);
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //setContentPane(contentPane);
        this.getContentPane().setLayout(null);
        setVisible(true);
        //lblNewLabel.setBackground(new Color(199, 21, 133));
        lblNewLabel.setBackground(Color.BLUE);
        lblNewLabel.setBounds(1326, 5, 20, 65);
        
        lblNewLabel.setOpaque(true);
        this.getContentPane().add(lblNewLabel);


        levelon.setBounds(0, 688, 1400, 20);
        levelon.setBackground(Color.gray);
        levelon.setOpaque(true);

        livesleft.setBounds(0, 708, 1400, 25);
        livesleft.setBackground(Color.gray);
        livesleft.setOpaque(true);

      /*  JLabel infoPanel = new JLabel();
        infoPanel.setBounds(0, 688, 1400, 80);
        infoPanel.setBackground(Color.gray);
        infoPanel.setOpaque(true);
        contentPane.add(infoPanel);*/

        //textpanel.add(infoPanel);

        this.getContentPane().add(levelon);
        this.getContentPane().add(livesleft);
        setVisible(true);
       // System.out.print("INFO Panel:" + textpanel.getBounds());
        
        
        
        l1.setBackground(Color.BLACK);
        l1.setOpaque(true);
        l1.setBounds(1226, 50, 20, 65);
        //DO-NOT ADD THE LABELS IF YOU DONT WANT THEM ON SCREEN i.e. FOR LEVELS. It means don't write the following line.
        l2.setBackground(Color.BLACK);
        l2.setOpaque(true);
        l2.setBounds(1126, 150, 20, 65);
        //contentPane.add(l2);
        l3.setBackground(Color.BLACK);
        l3.setOpaque(true);
        l3.setBounds(1026, 250, 20, 65);
        //contentPane.add(l3);
        l4.setBackground(Color.BLACK);
        l4.setOpaque(true);
        l4.setBounds(926, 350, 20, 65);
        //contentPane.add(l4);
        this.getContentPane().add(p1);
        p1.setBounds(0,5,85,20);
        p1.add(l5);
        p1.setLayout(null);
        l5.setBackground(Color.RED);
        l5.setOpaque(true);
        l5.setBounds(0, 0, 65, 20);
        p1.add(l6);
        l6.setBackground(new Color(255, 165, 0));
        l6.setOpaque(true);
        l6.setBounds(65, 0, 20, 20);
        /* 
         * addition of JPanel on the bottom
         * */
        
        
        
        
        this.getContentPane().addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0){}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
               if(k==false)
               {
                k=true;
                flag=1;
                vai=l;
                p1.add(l6);
                l6.setBounds(65, 0, 20, 20);
                add(l6); 
                l6.setBounds(85,l,20,20);

                System.out.println(k);
            }}
        });
        timer = new Timer(10,this);
        timer.start();
        
    }
    
    void drawing(int y,int a,int b,int c,int d)
    {
        lblNewLabel.setBounds(1326, y, 20, 65);
        l1.setBounds(1226, a, 20, 65);
        l2.setBounds(1126, b, 20, 65);
        l3.setBounds(1026, c, 20, 65);
        l4.setBounds(926, d, 20, 65);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

            //System.out.println("hello");
    	this.getContentPane().addMouseMotionListener(new MouseAdapter(){ 
            public void mouseMoved(MouseEvent e){
                //if(k==false)
           // {
                
                p = e.getX();
                l = e.getY();
                p1.setBounds(0,l,85,20);
                repaint();
           // }
            }
        });
        
        if(level==2)
        {
        	this.getContentPane().add(l1);
            a=625;
        }
        if(level==5)
        {
        	this.getContentPane().add(l2);
            b=0;
        }
        if(level==10)
        {
        	this.getContentPane().add(l3);
            c=625;
        }
        if(level==15)
        {
        	this.getContentPane().add(l4);
            d=0;
        }
        
        if(count%2==0)
            y=y+1;
        else
            y=y-1;
        if(y==625 || y==0)
            count++;
        if(counta%2==0)
            a=a-3;
        else
            a=a+3;
        if(a>=625 || a<=0)
            counta++;
        if(countb%2==0)
            b=b+4;
        else
            b=b-4;
        if(b>=625 || b<=0)
            countb++;
        if(countc%2==0)
            c=c-3;
        else
            c=c+3;
        if(c>=625 || c<=0)
            countc++;
        if(countd%2==0)
            d=d+4;
        else
            d=d-4;
        if(d>=625 || d<=0)
            countd++;
        drawing(y,a,b,c,d);
        if(k==true)
        {
                int ybullet=vai;
                if((xbullet>=906 && xbullet<=946) && (ybullet>=d && ybullet<= (d+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1006 && xbullet<=1046) && (ybullet>=c && ybullet<=(c+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1106 && xbullet<=1146) && (ybullet>=b && ybullet<=(b+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1206 && xbullet<=1246) && (ybullet>=a && ybullet<=(a+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1306 && xbullet<=1363) && (ybullet>=y && ybullet<=(y+65)))
                {
                    hit=true;
                }
                add(l6);
                l6.setBounds(xbullet,ybullet,20,20);
                xbullet+=25;
            if(hit==true)
                {
                level++;
                    levelon.setText("On Level : "+level);//"On Level : "+level
                System.out.println("Its a hit!! "+level+" "+lives);
                ((Timer)e.getSource()).stop();
                }
            else if(miss==true)
                {
                lives--;
                livesleft.setText("Lives left : "+lives);
                System.out.println("It's a miss :("+level+" "+lives);
                ((Timer)e.getSource()).stop();
                }
            else if(xbullet>1346)
                {
                lives--;
                livesleft.setText("Lives left : "+lives);
                System.out.println("It's a miss :("+level+" "+lives);
                ((Timer)e.getSource()).stop();
                }            
        if(hit==true || miss==true || xbullet > 1346)
            {
        //((Timer)e.getSource()).stop();
            k=false;
            hit=false;
            miss=false;
            xbullet=85;
            p1.add(l6);
            l6.setBounds(65, 0, 20, 20);
            
            timer.start();
            }
        if(level==20 )
        {
            Object[] options = { "Exit", "Play Again" };
            int choice = JOptionPane.showOptionDialog(null, 
                "Player wins", 
                "Quit?", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

            // interpret the user's choice
            if (choice == JOptionPane.YES_OPTION)
            {
              System.exit(0);
            }
            if (choice == JOptionPane.NO_OPTION)
            {
                 dispose();
                 count=0;counta=0;countb=0;countc=0;countd=0;level=1;lives=20;xbullet=85;
                 x=418;flag=0;
                 p=75;l=10;
                 y=5;a=-100;b=-100;c=-100;d=-100;
                 ((Timer)e.getSource()).stop();
                 timer.start();
                  Ships obj=new Ships();  
               
            }
             
        }
        if(lives==0 )
        {
            Object[] options = { "Exit", "Play Again" };
            int choice = JOptionPane.showOptionDialog(null, 
                "Player lost", 
                "Quit?", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);
            // interpret the user's choice
            if (choice == JOptionPane.YES_OPTION)
            {
              System.exit(0);
            }
            if (choice == JOptionPane.NO_OPTION)
            {
               dispose();
               count=0;counta=0;countb=0;countc=0;countd=0;level=1;lives=20;xbullet=85;
               x=418;flag=0;
               p=75;l=10;
               y=5;a=-100;b=-100;c=-100;d=-100;
               ((Timer)e.getSource()).stop();
               timer.start();
                Ships obj=new Ships(); 
               
            }
             
        }
    }
    }
}
