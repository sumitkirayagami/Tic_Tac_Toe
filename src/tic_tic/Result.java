
package tic_tic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Result {
    public static void main(String[] args) {
        Res obj=new Res(0);
    }
}
class Res extends JFrame implements ActionListener{
    JButton jb;
    JLabel jl;
    public Res(int i){
        String mess="";
        if(i==1){
            mess= "You are WINNER" ;
        }
        else if(i==0){
            mess="Match is drawn. Tough fight!" ;
        }
        else if(i==2){
            mess= "You have lost. Better Luck next time!" ;
        }
        setLayout(null); 
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        Font f=new Font("Arial",Font.ITALIC,25);
        jl=new JLabel(mess,SwingConstants.CENTER);
        jl.setFont(f);
        jl.setBounds(0,100,600,40);
        add(jl);
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("tic_tic/newgame.png"));
        JButton btn=new JButton(ic);
        btn.setBounds(200,200,ic.getIconWidth(),ic.getIconHeight());
        
        add(btn);
        btn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Front fr=new Front();
        dispose();
    }
}