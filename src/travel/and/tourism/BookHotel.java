package travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    JLabel labeltotal, lblfood,lblac,lbldays,lbltotal,labelprice,lblusername,labelphone,labelusername,lblpackage,lblpersons,lblid,labelid,lblnumber,labelnumber,lblphone;
    String username;
    JButton checkprice,bookhotel,back;
    
    
    BookHotel(String username){
        
        this.username=username;
        setLayout(null);
        setBounds(350,200,1100,600);
        
        JLabel text=new JLabel("Book HOTEL");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        
        lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        lblusername.setBounds(40,70,200,20);
        add(lblusername);
        
        
        labelusername=new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.BOLD,16));
        labelusername.setBounds(250,70,100,20);
        add(labelusername);
        
       lblpackage=new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        
        chotel = new Choice();
        
        chotel.setFont(new Font("Tahoma",Font.BOLD,16));
        chotel.setBounds(250,110,200,20);
        add(chotel);

        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        lblpersons=new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpersons.setBounds(40,150,150,20);
        add(lblpersons);
        
         tfpersons=new JTextField();
         tfpersons.setFont(new Font("Tahoma",Font.BOLD,16));
         tfpersons.setBounds(250,150,150,20);
        add( tfpersons);
       
        
        
         lbldays=new JLabel("No. of Days");
         lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        lbldays.setBounds(40,190,100,20);
        add(lbldays);
        
        
          tfdays=new JTextField();
         tfdays.setFont(new Font("Tahoma",Font.BOLD,16));
         tfdays.setBounds(250,190,150,20);
        add( tfdays);
        
        
        
        lblac=new JLabel("AC/ Non-AC");
         lblac.setFont(new Font("Tahoma",Font.BOLD,16));
         lblac.setBounds(40,230,100,20);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setFont(new Font("Tahoma",Font.BOLD,16));
        cac.setBounds(250,230,200,20);
        add(cac);

        
        lblfood=new JLabel("Food Included");
         lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
         lblfood.setBounds(40,270,150,20);
        add(lblfood);
        
        
         cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setFont(new Font("Tahoma",Font.BOLD,16));
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        
        
        
        
        
        lblid=new JLabel("Id");
         lblid.setFont(new Font("Tahoma",Font.BOLD,16));
         lblid.setBounds(40,310,100,20);
        add(lblid);
        
        labelid=new JLabel();
         labelid.setFont(new Font("Tahoma",Font.BOLD,16));
         labelid.setBounds(250,310,100,20);
        add(labelid);
        
        
         lblnumber=new JLabel("Number");
         lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
         lblnumber.setBounds(40,350,100,20);
        add(lblnumber);
        
        labelnumber=new JLabel();
         labelnumber.setFont(new Font("Tahoma",Font.BOLD,16));
         labelnumber.setBounds(250,350,150,20);
        add(labelnumber);
        
        
         lblphone=new JLabel("Phone");
         lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
         lblphone.setBounds(40,390,100,20);
        add(lblphone);
        
        labelphone=new JLabel();
         labelphone.setFont(new Font("Tahoma",Font.BOLD,16));
         labelphone.setBounds(250,390,150,20);
        add(labelphone);
        
        
         lbltotal=new JLabel("Total Price");
         lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
         lbltotal.setBounds(40,430,100,20);
        add(lbltotal);
        
        labelprice=new JLabel();
         labelprice.setFont(new Font("Tahoma",Font.BOLD,16));
         labelprice.setBounds(250,430,150,20);
        add(labelprice);
        
         try{
            Conn c=new Conn();
            String query = "select * from customer where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                
                labelphone.setText(rs.getString("phone"));
               
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,480,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
         bookhotel=new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200,480,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
         back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,480,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(550,50,600,300);
        add(icon);
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"' ");
            while(rs.next()){
                int cost=Integer.parseInt(rs.getString("costperperson"));
                int food=Integer.parseInt(rs.getString("foodincluded"));
                int ac=Integer.parseInt(rs.getString("acroom"));
                
                
                int persons=Integer.parseInt(tfpersons.getText());
                int days=Integer.parseInt(tfdays.getText());
                
                String acselected=cac.getSelectedItem();
                String foodselected=cfood.getSelectedItem();
                
                
                if(persons * days >0){
                    int total =0;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    
                    total += cost;
                    total = total * persons * days;
                    labelprice.setText("Rs " + total);
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter a valid number");
                }
            }
            
            
            } catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }else if(ae.getSource() == bookhotel){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values( '"+labelusername.getText()+"' , '"+chotel.getSelectedItem()+"' , '"+tfpersons.getText()+"' , '"+tfdays.getText()+"' , '"+cac.getSelectedItem()+"' , '"+cfood.getSelectedItem()+"' , '"+labelid.getText()+"', '"+labelnumber.getText()+"'   , '"+labelphone.getText()+"'   ,   '"+labelprice.getText()+"') ");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookHotel("");
    }
}

