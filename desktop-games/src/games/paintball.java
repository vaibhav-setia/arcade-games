package games;

import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
public class paintball extends JFrame implements ActionListener {


    Timer timer;
    public JPanel contentPane;
    //public JLabel time2;

    /**
    * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    paintball frame = new paintball();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
  
     /*time2 = new JLabel("time left " + time);
    time2.setOpaque();
    JLabel score = new JLabel("score " + hit);*/
    int p,l;
    static int x,y,hit=0;
    static int time=100;
    JLabel hitme = new JLabel("");
    JLabel hitsLeft, timesLeft;
    Container container;
    static int maxHits = 10;
    /**
    * Create the frame.
    */
    public paintball() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 600, 600);
      
      container = this.getContentPane();
      
      contentPane = new JPanel(){  
          public void paintComponent(Graphics g) {  
               Image img = Toolkit.getDefaultToolkit().getImage(  
                         this.getClass().getResource("/resources/unsplash.jpg"));  
               g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
          }  
     };  ;
      contentPane.setBackground(Color.GRAY);
      contentPane.setBorder(new LineBorder(Color.BLACK));
      contentPane.setPreferredSize(new Dimension(this.getContentPane().getWidth(), 480));
      container.add(contentPane, BorderLayout.CENTER);
      
//      setContentPane(contentPane);
      contentPane.setLayout(null);
      JLabel l1 = new JLabel("");
      l1.setBackground(Color.ORANGE);
      l1.setBounds(37, 170, 69, 69);
      l1.setOpaque(true);
      contentPane.add(l1);
      
      JLabel l2 = new JLabel("");
      l2.setBackground(Color.ORANGE);
      l2.setBounds(182, 92, 62, 57);
      l2.setOpaque(true);
      contentPane.add(l2);
      
      JLabel l3 = new JLabel("");
      l3.setBackground(Color.ORANGE);
      l3.setBounds(330, 24, 55, 47);
      l3.setOpaque(true);
      contentPane.add(l3);
      
      JLabel l4 = new JLabel("");
      l4.setBackground(Color.ORANGE);
      l4.setBounds(319, 188, 46, 32);
      l4.setOpaque(true);
      contentPane.add(l4);
      
      hitme.setBackground(Color.MAGENTA);
      hitme.setBounds(59, 80, 20, 20);
      hitme.setOpaque(true);
      contentPane.add(hitme);
      
      JPanel info = new JPanel();
      info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
      hitsLeft = new JLabel("HITS TO WIN: " + (maxHits - hit));
      hitsLeft.setAlignmentX(CENTER_ALIGNMENT);
      info.add(hitsLeft);
      timesLeft = new JLabel("TIME LEFT: " + time);
      timesLeft.setAlignmentX(CENTER_ALIGNMENT);
      info.add(timesLeft);
      info.setPreferredSize(new Dimension(this.getContentPane().getWidth(), 50));
      info.setBackground(Color.CYAN);
      info.setAlignmentY(JComponent.CENTER_ALIGNMENT);
      container.add(info, BorderLayout.PAGE_END);
      
      timer = new Timer(2000, this);
      timer.start();
            
    }
    

    public void actionPerformed(ActionEvent e) {
         x = (int)(480*Math.random())+1;
         y = (int)(480*Math.random())+1;
         time--;
         /**/
         if(time==0) {
         	Object[] options = { "Exit", "Play Again" };
         int choice = JOptionPane.showOptionDialog(null, 
                 "Player lost", 
                 "Quit?", 
                 JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE, 
                 null, 
                 options, 
                 options[0]);
             if (choice == JOptionPane.YES_OPTION) {
               System.exit(0);
             }
             if (choice == JOptionPane.NO_OPTION){
                dispose();
                 paintball obj=new paintball(); 
                
             }
     	
     }
         System.out.println("coord:" + x + " -- " + y);
         timesLeft.setText("TIME LEFT: " + time);
         hitme.setBounds(x, y, 20, 20);
         contentPane.addMouseMotionListener(new MouseAdapter(){ 
            public void mouseMoved(MouseEvent e){
                p = e.getX();
                l = e.getY();
                                  
            }
        });
        contentPane.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0){}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
//            	System.out.println("coord:" + p + " -- " + l);
                if((p>=x && p<=x+20) && (l>=y && l<=y+20 )) {
                    hit++; // no of successful hits 
                    hitsLeft.setText("HITS TO WIN: " + (maxHits - hit));
                }
                System.out.println("hit: " + hit + ", time: " + time);
                if(hit==maxHits) {
                	Object[] options = { "Exit", "Play Again" };
                int choice = JOptionPane.showOptionDialog(null, 
                        "Player won", 
                        "Quit?", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        options, 
                        options[0]);
                    if (choice == JOptionPane.YES_OPTION)
                    {
                      System.exit(0);
                    }
                    if (choice == JOptionPane.NO_OPTION)
                    {
                       dispose();
                        paintball obj=new paintball(); 
                       
                    }
                	
                }
                if(time==0) {
                	dispose();
	                	Object[] options = { "Exit", "Play Again" };
	                int choice = JOptionPane.showOptionDialog(null, 
	                        "Player lost", 
	                        "Quit?", 
	                        JOptionPane.YES_NO_OPTION, 
	                        JOptionPane.QUESTION_MESSAGE, 
	                        null, 
	                        options, 
	                        options[0]);
	                    if (choice == JOptionPane.YES_OPTION) {
	                      System.exit(0);
	                    }
	                    if (choice == JOptionPane.NO_OPTION){
	                       dispose();
	                        paintball obj=new paintball(); 
	                       
	                    }
                	
                }
                
                x = (int)(480*Math.random())+1;
                y = (int)(480*Math.random())+1;
                time--;
                timesLeft.setText("TIME LEFT: " + time);
                
               hitme.setBounds(x, y, 20, 20);
            }
        

    });
    }
}
