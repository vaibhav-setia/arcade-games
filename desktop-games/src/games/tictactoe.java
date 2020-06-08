package games;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class tictactoe extends JFrame implements MouseListener
{
    private static final Color COLOR_UNCLICKED = Color.white;
    private static final Color COLOR_HITT= Color.CYAN;
    private static final Color COLOR_HIT = Color.red;
    private static final int UNCLICKED = 5;
    private static final int HIT = 7;
    private static final int HIT1 = 6;
    private JLabel title;
    private JPanel titlePanel;
    private JButton[][] gridButton;
    private JPanel gridPanel;
    private final int ROWS = 3;
    private final int COLS = 3;
    private int[][] board;
    ImageIcon cross,o;
    int count=0;
    GridListener gridListener = new GridListener();
    
    Dimension boardSize = new Dimension(340, 400);
    public tictactoe()
    {
        cross = new ImageIcon(getClass().getClassLoader().getResource("resources/crop.png"));
         o = new ImageIcon(getClass().getClassLoader().getResource("resources/o .png"));

        title = new JLabel("TIC TAC TOE");
        titlePanel = new JPanel();
        titlePanel.add(title);
        gridButton = new JButton[ROWS][COLS];
        board= new int [ROWS][COLS];
        gridPanel = new JPanel();
        gridPanel.setPreferredSize(boardSize);
        gridPanel.setLayout(new GridLayout(3, 3));
        for (int r = 0; r < gridButton.length; r++)
            for (int c = 0; c < gridButton[r].length; c++)
            {
            gridButton[r][c] = new JButton();
            gridButton[r][c].setEnabled(true);
            gridButton[r][c].addActionListener(gridListener);
            gridPanel.add(gridButton[r][c]);
            }
        again();
        this.setLayout(new BorderLayout());
        this.add(titlePanel, "North");
        this.add(gridPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(400, 400));
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

     class GridListener implements ActionListener
    {


    
    public void actionPerformed(ActionEvent evt) {
            
    for (int r = 0; r < gridButton.length; r++)
    for(int c = 0; c < gridButton[r].length; c++)
    {
        
    if (evt.getSource() != gridButton[r][c])
    continue;
    handleGridButton(r,c);
    gridButton[r][c].setEnabled(false);
    check();
    return;
    }
        }
    }
     public void handleGridButton(int r, int c)
     {
     if (board[r][c] == UNCLICKED)
     {
         if(count%2==0)
         {
             board[r][c] = HIT;
             
             gridButton[r][c].setIcon(cross);
             gridButton[r][c].setEnabled(false);
             
         }
     
     else
     {

         board[r][c] = HIT1;
         gridButton[r][c].setIcon(o);
        
         gridButton[r][c].setEnabled(false);
     }
     ++count;
     }
     }
     public void check()
     {
         if(board[0][0]==HIT && board[0][1]==HIT && board[0][2]==HIT) // H - X
             message(0, 0);
         else if (board[0][0]==HIT1 && board[0][1]==HIT1 && board[0][2]==HIT1) // H - O
             message(0, 0);
         else if (board[1][0]==HIT && board[1][1]==HIT && board[1][2]==HIT) // H - X
             message(0, 1);
         else if (board[1][0]==HIT1 && board[1][1]==HIT1 && board[1][2]==HIT1) // H - O
             message(0, 1);
         else if (board[2][0]==HIT && board[2][1]==HIT && board[2][2]==HIT) // H - X
             message(0, 2);
         else if (board[2][0]==HIT1 && board[2][1]==HIT1 && board[2][2]==HIT1) // H - O
             message(0, 2);
         else if(board[0][0]==HIT && board[1][0]==HIT && board[2][0]==HIT) // V - X
             message(1, 0);
         else if(board[0][0]==HIT1 && board[1][0]==HIT1 && board[2][0]==HIT1) // V - O
             message(1, 0);
         else if(board[0][1]==HIT && board[1][1]==HIT && board[2][1]==HIT) // V - X
             message(1, 1);
         else if(board[0][1]==HIT1 && board[1][1]==HIT1 && board[2][1]==HIT1) // V - O
             message(1, 1);
         else if(board[0][2]==HIT && board[1][2]==HIT && board[2][2]==HIT) // V - X
             message(1, 2);
         else if(board[0][2]==HIT1 && board[1][2]==HIT1 && board[2][2]==HIT1) // V - O 
             message(1, 2); 
         else if(board[0][0]==HIT && board[1][1]==HIT && board[2][2]==HIT) // D1 - X
             message(2, -1);
         else if(board[0][0]==HIT1 && board[1][1]==HIT1 && board[2][2]==HIT1) // D1 - O 
             message(2, -1);
         else if(board[0][2]==HIT && board[1][1]==HIT && board[2][0]==HIT) // D2 - X
             message(3, -1);
         else if(board[0][2]==HIT1 && board[1][1]==HIT1 && board[2][0]==HIT1) // D2 - O
             message(3, -1);
         else if(count==9)
         {
             Object[] options = { "Exit", "Play Again" };
             int choice = JOptionPane.showOptionDialog(null, 
                 "It's a tie", 
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
                 count=0;
                 again(); 
                 
             }
         }
         
         
         
     }
     public void message(int direction, int index) 
     {
    	 if(direction == 0) {
    		 // horizontal
    		 // set background of gridButton[index][0|1|2]
    		 gridButton[index][0].setBackground(Color.orange);
    		 gridButton[index][1].setBackground(Color.orange);
    		 gridButton[index][2].setBackground(Color.orange);
    	 } else if(direction == 1) {
    		 // vertical
    		// set background of gridButton[0|1|2][index]
    		 gridButton[0][index].setBackground(Color.orange);
    		 gridButton[1][index].setBackground(Color.orange);
    		 gridButton[2][index].setBackground(Color.orange);
    	 }  else if(direction == 2) {
    		 // diagonal 1
    		// set background of gridButton[00 || 11 || 22]
    		 gridButton[0][0].setBackground(Color.orange);
    		 gridButton[1][1].setBackground(Color.orange);
    		 gridButton[2][2].setBackground(Color.orange);
    	
    	 } else {
    		 // diagonal 3 
    		// set background of gridButton[20 || 11 || 02]
    		 gridButton[2][0].setBackground(Color.orange);
    		 gridButton[1][1].setBackground(Color.orange);
    		 gridButton[0][2].setBackground(Color.orange);
    	 }
    	 
    	 
    	 
         if(count%2==1)
         { Object[] options = { "Exit", "Play Again" };
         int choice = JOptionPane.showOptionDialog(null, 
             "Player 1 wins", 
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
             count=0;
             again(); 
              } 
         }
         else
         {
             Object[] options = { "Exit", "Play Again" };
             int choice = JOptionPane.showOptionDialog(null, 
                 "Player 2 wins", 
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
                 count=0;
                 again(); 
                 
             }
         }
     }

//     public void message()
//     {
//         if(count%2==1)
//         { Object[] options = { "Exit", "Play Again" };
//         int choice = JOptionPane.showOptionDialog(null, 
//             "Player 1 wins", 
//             "Quit?", 
//             JOptionPane.YES_NO_OPTION, 
//             JOptionPane.QUESTION_MESSAGE, 
//             null, 
//             options, 
//             options[0]);
//
//         
//         if (choice == JOptionPane.YES_OPTION)
//         {
//           System.exit(0);
//         }
//         if (choice == JOptionPane.NO_OPTION)
//         {
//             count=0;
//             again(); 
//              } 
//         }
//         else
//         {
//             Object[] options = { "Exit", "Play Again" };
//             int choice = JOptionPane.showOptionDialog(null, 
//                 "Player 2 wins", 
//                 "Quit?", 
//                 JOptionPane.YES_NO_OPTION, 
//                 JOptionPane.QUESTION_MESSAGE, 
//                 null, 
//                 options, 
//                 options[0]);
//
//             
//             if (choice == JOptionPane.YES_OPTION)
//             {
//               System.exit(0);
//             }
//             if (choice == JOptionPane.NO_OPTION)
//             {
//                 count=0;
//                 again(); 
//                 
//             }
//         }
//     }

     
     
     public void again()
     {
         for (int r = 0; r < board.length; r++) 
             for (int c = 0; c < board.length; c++) 
             { board[r][c] = UNCLICKED; 
             gridButton[r][c].setEnabled(true); 
             gridButton[r][c].setBackground(COLOR_UNCLICKED);
             gridButton[r][c].setIcon(null);
             }
     }
     public static void main(String[] args) {
            tictactoe n= new tictactoe();
            n.pack();
            n.setVisible(true);
            n.setResizable(true);

        }
}
