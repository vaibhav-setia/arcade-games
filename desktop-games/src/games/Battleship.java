package games;
//import games.play;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.swing.event.MouseInputAdapter;
import javax.swing.*;

// battleship.MainPanel.GridListener;

public class Battleship extends JFrame implements MouseListener, MouseMotionListener
{
    public JLayeredPane layeredPane=null;
    private static final int UNCLICKED = 6;
    private static final int EMPTY = 7;
    private static final int HIT = 8;
    private static final int MISS = 9;
    private static final Color COLOR_UNCLICKED = Color.white;
    private static final Color COLOR_MISS = Color.blue;
    private static final Color COLOR_HIT = Color.red;
    private static final int SHIP = 5;
    private JLabel title,blank;
    private JPanel titlePanel;
    private JButton[][] gridButton,gridButton1;
    private JPanel gridPanel,gridPanel1;
    private int[][] board,board1;
    JLabel l1 = new JLabel("Player 1's turn", SwingConstants.CENTER);;
    Dimension boardSize = new Dimension(340, 400);
    GridListener gridListener = new GridListener();
    static int count=0,count1=0,count2=0;
    int xAdjustment;
    int yAdjustment;






    public Battleship()
    {

        title = new JLabel("BATTLESHIP!");

        titlePanel = new JPanel();
        titlePanel.add(title);
        gridButton = new JButton[10][10];
        gridButton1 = new JButton[10][10];
        gridPanel = new JPanel();
        gridPanel.setPreferredSize(boardSize);
        gridPanel1= new JPanel();
        gridPanel1.setPreferredSize(boardSize);
        gridPanel.setLayout(new GridLayout(10, 10));
        gridPanel1.setLayout(new GridLayout(10, 10));
        l1.setBackground(Color.WHITE);
        l1.setOpaque(true);
        l1.setBounds(500, 150, 20, 65);
        for (int r = 0; r < gridButton.length; r++)
            for (int c = 0; c < gridButton[r].length; c++)
            {
                gridButton[r][c] = new JButton();
                gridButton[r][c].setBackground(COLOR_UNCLICKED);
                gridButton[r][c].setEnabled(true);
                gridButton[r][c].addActionListener(gridListener);
                gridPanel.add(gridButton[r][c]);
            }
        gridPanel1.setLayout(new GridLayout(10, 10));
        for (int r = 0; r < gridButton1.length; r++)
            for (int c = 0; c < gridButton1[r].length; c++)
            {
                gridButton1[r][c] = new JButton();
                gridButton1[r][c].setBackground(COLOR_UNCLICKED);
                gridButton1[r][c].setEnabled(true);
                gridButton1[r][c].addActionListener(gridListener);
                gridPanel1.add(gridButton1[r][c]);
            }
        this.setLayout(new BorderLayout());
        this.add(titlePanel, "North");
        this.add(gridPanel, BorderLayout.LINE_START);
        this.add(gridPanel1, BorderLayout.LINE_END);
        this.setPreferredSize(new Dimension(1100, 400));
        this.add(l1, BorderLayout.CENTER);
        //l1.setText("new Value");
        board = new int[10][10];
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board.length; c++)
            {
                board[r][c] = UNCLICKED;
                gridButton[r][c].setEnabled(true);
            }
        board1 = new int[10][10];
        for (int r = 0; r < board1.length; r++)
            for (int c = 0; c < board1.length; c++)
            {
                board1[r][c] = UNCLICKED;
                gridButton1[r][c].setEnabled(false);
            }
        ship();


    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseDragged(MouseEvent me)
    {

    }

    public void mouseReleased(MouseEvent e)
    {

    }


    class GridListener implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent evt) {

            if(count%2==0)
            {
                //System.out.println(count);

                for (int r = 0; r < gridButton.length; r++)
                    for(int c = 0; c < gridButton[r].length; c++)
                    {

                        if (evt.getSource() != gridButton[r][c])
                            continue;
                        handleGridButton(r,c);
                        return;
                    }
            }

            else
            {
                //System.out.println(count);


                for (int r = 0; r < gridButton1.length; r++)
                    for(int c = 0; c < gridButton1[r].length; c++)
                    {
                        if (evt.getSource() != gridButton1[r][c])
                            continue;
                        handleGridButton(r,c);
                        return;
                    }


            }
        }


    }
    public void handleGridButton(int r, int c)
    {

        if(count%2==0)
        {
            l1.setText("Player 2's turn");
            if (board[r][c] == UNCLICKED || board[r][c] == SHIP)
            {
                ++count;
                if(board[r][c] == SHIP)
                {gridButton[r][c].setBackground(COLOR_HIT);
                    count1++;
                    message();
                }

                else
                    gridButton[r][c].setBackground(COLOR_MISS);


            }
            board[r][c]=HIT;

        }
        else
        {
            l1.setText("Player 1's turn");
            ++count;
            if (board1[r][c] == UNCLICKED || board1[r][c] == SHIP)
            {

                if(board1[r][c] == SHIP)
                {gridButton1[r][c].setBackground(COLOR_HIT);
                    count2++;
                    message();
                }
                else
                    gridButton1[r][c].setBackground(COLOR_MISS);



            }
            board1[r][c]=HIT;
        }
        gridenable();
        System.out.println(count);
    }
    public void gridenable()
    {
        if(count%2==0)
        {
            for (int r = 0; r < gridButton.length; r++)
            {
                for(int c = 0; c < gridButton[r].length; c++)
                    gridButton1[r][c].setEnabled(false);
            }
            for (int r = 0; r < gridButton.length; r++)
            {
                for(int c = 0; c < gridButton[r].length; c++)
                    if(board[r][c]!=HIT)
                        gridButton[r][c].setEnabled(true);
            }
        }
        else
        {
            for (int r = 0; r < gridButton.length; r++)
            {
                for(int c = 0; c < gridButton[r].length; c++)
                    gridButton[r][c].setEnabled(false);
            }
            for (int r = 0; r < gridButton.length; r++)
            {
                for(int c = 0; c < gridButton[r].length; c++)
                    if(board1[r][c]!=HIT)
                        gridButton1[r][c].setEnabled(true);
            }
        }
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    public void ship()
    {
        for(int i=0;i<3;i++)
            board[0][i]=SHIP;
        for(int i=6;i<10;i++)
            board[3][i]=SHIP;
        for(int i=3;i<8;i++)
            board[i][2]=SHIP;
        for(int i=7;i<9;i++)
            board[8][i]=SHIP;
        for(int i=5;i<7;i++)
            board[i][6]=SHIP;
        for(int i=5;i<8;i++)
            board1[i][0]=SHIP;
        for(int i=1;i<5;i++)
            board1[i][5]=SHIP;
        for(int i=4;i<9;i++)
            board1[6][i]=SHIP;
        for(int i=1;i<3;i++)
            board1[7][i]=SHIP;
        for(int i=8;i<10;i++)
            board1[8][i]=SHIP;
    }

    public void message()
    {
        if(count1==16 )
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
                for (int r = 0; r < gridButton1.length; r++)
                    for (int c = 0; c < gridButton1[r].length; c++)
                    {

                        gridButton1[r][c].setBackground(COLOR_UNCLICKED);
                        gridButton1[r][c].setEnabled(true);

                    }
                for (int r = 0; r < gridButton.length; r++)
                    for (int c = 0; c < gridButton[r].length; c++)
                    {

                        gridButton[r][c].setBackground(COLOR_UNCLICKED);
                        gridButton[r][c].setEnabled(true);

                    }
                for (int r = 0; r < board.length; r++)
                    for (int c = 0; c < board.length; c++)
                    {
                        board[r][c] = UNCLICKED;
                        gridButton[r][c].setEnabled(true);
                    }
                board1 = new int[10][10];
                for (int r = 0; r < board1.length; r++)
                    for (int c = 0; c < board1.length; c++)
                    {
                        board1[r][c] = UNCLICKED;
                        gridButton1[r][c].setEnabled(false);
                    }
                ship();
                count=0;count1=0;count2=0;

            }
        }
        if(count2==16 )
        {
            Object[] options = { "Exit", "Play Again" };
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

                for (int r = 0; r < gridButton1.length; r++)
                    for (int c = 0; c < gridButton1[r].length; c++)
                    {

                        gridButton1[r][c].setBackground(COLOR_UNCLICKED);
                        gridButton1[r][c].setEnabled(true);

                    }
                for (int r = 0; r < gridButton.length; r++)
                    for (int c = 0; c < gridButton[r].length; c++)
                    {

                        gridButton[r][c].setBackground(COLOR_UNCLICKED);
                        gridButton[r][c].setEnabled(true);

                    }
                for (int r = 0; r < board.length; r++)
                    for (int c = 0; c < board.length; c++)
                    {
                        board[r][c] = UNCLICKED;
                        gridButton[r][c].setEnabled(true);
                    }
                board1 = new int[10][10];
                for (int r = 0; r < board1.length; r++)
                    for (int c = 0; c < board1.length; c++)
                    {
                        board1[r][c] = UNCLICKED;
                        gridButton1[r][c].setEnabled(false);
                    }
                ship();
                count=0;count1=0;count2=0;

            }
        }
    }
    public static void main(String args[])
    {
        Battleship n= new Battleship();
        n.pack();
        n.setVisible(true);
        n.setResizable(false);
    }
}
