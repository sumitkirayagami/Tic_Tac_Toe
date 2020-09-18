
package tic_tic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Begin{
    
    public static void main(String[] args) {
        Front obj=new Front();                    
}
}
class Front extends JFrame implements ActionListener{
    Container c;
    JLabel wel,opt;
    JButton zero,cross;
    public Front(){
        c=getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700, 700);
        c.setBackground(Color.CYAN);
        setTitle("tictactoe");
        wel=new JLabel("Welcome Champ!");    wel.setBounds(200,100,200,30);
        opt=new JLabel("What would you choose");    opt.setBounds(200,200,200,30);
        Font f1=new Font("Arial",Font.BOLD,20);
        Font f2=new Font("Arial",Font.ITALIC,15);
        wel.setFont(f1);
        opt.setFont(f2);
        c.add(wel);   c.add(opt);
        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("tic_tic/zer.png"));
        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("tic_tic/star.png"));
        zero=new JButton(ic1);    zero.setBounds(200,300,100,100);
        cross=new JButton(ic2);     cross.setBounds(400,300,100,100);
        c.add(zero);     c.add(cross);
       
        validate();
        repaint();
        zero.addActionListener(this);
        cross.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==zero){
            Tic tt=new Tic("0");
            dispose();
        }
        else{
            Tic tt=new Tic("*");
            dispose();
        }
    }
}
