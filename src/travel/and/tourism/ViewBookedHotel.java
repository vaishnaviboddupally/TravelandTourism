package travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
    JLabel labelusername,labelprice,labelphone,labelnumber,labelid,labelfood,labelac,labeldays,labelname,labelpersons;
    ViewBookedHotel(String username){
        setLayout(null);
        setBounds(400,200,1000,650);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblname=new JLabel("Hotel Name");
        lblname.setBounds(30,90,150,25);
        add(lblname);
        
        
        labelname=new JLabel();
        labelname.setBounds(220,90,150,25);
        add(labelname);

        
        JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);
        
        
        labelpersons=new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
        
         JLabel lbldays=new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
        
        labeldays=new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);
        
        
        
        
        JLabel lblac=new JLabel("AC/Non-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);
        
        
        labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);
        
        
        
        JLabel lblfood=new JLabel("Food Included?");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);
        
        
        labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);
        
        
         JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,290,150,25);
        add(lblid);
        
        
        labelid=new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);
        
        
        
         JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,330,150,25);
        add(lblnumber);
        
        
         labelnumber=new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);
        
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        
         labelphone=new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);
        
        
         JLabel lblprice=new JLabel("Total Cost");
        lblprice.setBounds(30,410,150,25);
        add(lblprice);
        
        
        labelprice=new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);
        
      
        
        
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,480,100,25);
        back.addActionListener(this);
        add(back);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(450,20,500,400);
        add(icon);
        
         
        
        try{
            
            Conn conn=new Conn();
            String query="select * from bookhotel where username= '"+username+"'  ";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewBookedHotel("");
        
    }
}


