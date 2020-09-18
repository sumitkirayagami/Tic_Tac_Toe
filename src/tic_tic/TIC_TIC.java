/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tic;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TIC_TIC {
    public static void main(String[] args) {
         Front obj=new Front(); 
    }
    
}
  
class Tic extends JFrame implements ActionListener{
    JButton bt[];
    HashSet<Integer> hs;
    Font f;
    String sym,bol;
    ArrayList<Integer> playerpos=new ArrayList<>(),cpupos=new ArrayList<>();
    public Tic(String symbol){
        if(symbol.equalsIgnoreCase("0")){
            sym="0"; bol="*";
        }
        else{
            sym="*"; bol="0";
        }
        setTitle("TicTacToe");
        setLayout(new GridLayout(3,3));                                            //Layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        f=new Font("Arial",Font.BOLD,30);
        bt=new JButton[9];
        for(int i=0;i<9;i++){
            bt[i]=new JButton();
            bt[i].setFont(f);
           add(bt[i]);
           bt[i].addActionListener(this);
        }
        hs=new HashSet<>();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==bt[i]){
                if(!hs.contains(i)){
                    hs.add(i);
                    playerpos.add(i+1);
                    bt[i].setText(sym);
                    int flag=checkWinner();
                    if(flag==1){    
                        Res temp=new Res(1);
                        dispose();
                        return;
                    }
                    if(hs.size()==9){
                        Res temp=new Res(0);
                        dispose();
                        return;
                                
                    }
                    Random rnd=new Random();
                    int cpos=i+1;
                    while(playerpos.contains(cpos) || cpupos.contains(cpos)){
                        cpos=rnd.nextInt(9)+1;
                    }
                    bt[cpos-1].setText(bol);
                    cpupos.add(cpos);
                    hs.add(cpos-1);
                    flag=checkWinner();
                    if(flag==2){
                        Res temp=new Res(2);
                        dispose();
                        return;
                    }
                }
            }
        }
    }
    public int checkWinner(){
        
        List tr=Arrays.asList(1,2,3);   List mr=Arrays.asList(4,5,6);   List br=Arrays.asList(7,8,9);
        List lc=Arrays.asList(1,4,7);   List mc=Arrays.asList(2,5,8);   List rc=Arrays.asList(3,6,9);
        List dia1=Arrays.asList(1,5,9);   List dia2=Arrays.asList(3,5,7);
        
        List<List> Winning=new ArrayList<>();
        
        Winning.add(tr);    Winning.add(mr);   Winning.add(br);   Winning.add(lc);    Winning.add(mc);    Winning.add(rc);    Winning.add(dia1);  Winning.add(dia2);
        
        for(List l:Winning){
            if(playerpos.containsAll(l))
                return 1;
            if(cpupos.containsAll(l))
                return 2;
        }
        return 0;
    }
}

//Positions used
//player position
//cpu position
//winning position