
package travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener{
    JButton back;
    
    String username;
    DeleteDetails(String username){
        this.username=username;
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,100,150,25);
        add(lblid);
        
        
        JLabel labelid=new JLabel();
        labelid.setBounds(220,100,150,25);
        add(labelid);

        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,150,150,25);
        add(lblnumber);
        
        
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,150,150,25);
        add(labelnumber);
        
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,200,150,25);
        add(lblname);
        
        
        JLabel labelname=new JLabel();
        labelname.setBounds(220,200,150,25);
        add(labelname);
        
        
        
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,250,150,25);
        add(lblgender);
        
        
        JLabel labelgender=new JLabel();
        labelgender.setBounds(220,250,150,25);
        add(labelgender);
        
        
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);
        
        
        JLabel labelcountry=new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);
        
        
         JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(500,100,150,25);
        add(lbladdress);
        
        
        JLabel labeladdress=new JLabel();
        labeladdress.setBounds(690,100,150,25);
        add(labeladdress);
        
        
        
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(500,150,150,25);
        add(lblphone);
        
        
        JLabel labelphone=new JLabel();
        labelphone.setBounds(690,150,150,25);
        add(labelphone);
        
        
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(500,200,150,25);
        add(lblemail);
        
        
        JLabel labelemail=new JLabel();
        labelemail.setBounds(690,200,150,25);
        add(labelemail);
        
        
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,300,100,25);
        back.addActionListener(this);
        add(back);
        
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(20,350,800,300);
        add(icon);
        
        try{
            
            Conn conn=new Conn();
            String query="select * from customer where username= '"+username+"'  ";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            Conn c=new Conn();
            c.s.executeUpdate("delete from account where username =  '"+username+"'  ");
            c.s.executeUpdate("delete from customer where username =  '"+username+"'  ");
            c.s.executeUpdate("delete from bookpackage where usename =  '"+username+"'  ");
            c.s.executeUpdate("delete from bookhotel where username =  '"+username+"'  ");
            
            JOptionPane.showMessageDialog(null,"Data Deleted Successfullt");
            
            System.exit(0);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new DeleteDetails("");
        
    }
}

