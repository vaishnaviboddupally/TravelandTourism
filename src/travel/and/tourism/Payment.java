
package travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    
    
    JButton pay,back;
    Payment(){
        
        
        
        
        setLayout(null);
        
        
        setBounds(500,200,800,600);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(0,0,800,600);
        add(icon);
        
        
        pay=new JButton("Pay");
        pay.setBounds(420,0,80,40);
        pay.addActionListener(this);
        icon.add(pay);
        
        
        
        back=new JButton("Back");
        back.setBounds(520,0,80,40);
        back.addActionListener(this);
        icon.add(back);
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==  pay){
            setVisible(false);
            new Paytm();
            
        }else{
            setVisible(false);
        }
    }
            
    public static void main(String[] args){
        new Payment();
    }
    
    
}
