
package travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar bar;
    String username;
    JLabel lblusername;
    
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        
        setLayout(null);
        
        
        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        
        JLabel loading=new JLabel("Loading, please wait...");
        loading.setBounds(200,140,200,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,14));
        add(loading);
        
        
        lblusername=new JLabel("Welcome " + username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblusername);
        
        
        
        
        
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
        setVisible(true);
        
    }
    
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int value=bar.getValue();
                
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                
                Thread.sleep(50);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Loading("");
    }
}
