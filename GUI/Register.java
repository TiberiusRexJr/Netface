/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Package.Header;
import Package.Packet;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Dream
 */
public class Register extends GridPane
{
    
    TextField firstName=new TextField();
    TextField lastName=new TextField();
    TextField id=new TextField();
    TextField email=new TextField();
    TextField password=new TextField();
    Button Register=new Button("Register");
    Main main;
    
    
    public Register(Main m)
    {
        main=m;
        setRegister(); 
        this.setVgap(4);
        this.setPadding(new Insets(5,5,5,5));
        this.add(new Label("First Name:"), 0, 0);
        this.add(new Label("Last Name: "), 0, 1);
        this.add(new Label("Student ID:"),0,2);
        this.add(new Label("Email:"),0,3);
        this.add(new Label("Password:"),0,4);
        
        
        this.add(firstName,1,0);
        this.add(lastName,1,1);
        this.add(id,1,2);
        this.add(email,1,3);
        this.add(password,1,4);
        this.add(Register,0,5);
    }
    
    public void setRegister() 
    {
        Register.setOnAction((ActionEvent event)->
        {
           
           String name="admin";
           String pass="password";
           String code="r";
           String query=firstName.getText()+" "+lastName.getText()+" "+id.getText()+" "+email.getText()+" "+password.getText();
           
           Header h=new Header(name,pass,code,query);
           Packet p=new Packet(h);
           
            byte[] pack=main.ut.toByte(p);
            System.out.println(pack.length);
            main.t.Send(pack);
            try 
            {
                p=main.t.recieve();
                String status=new String((p.getHeaderS().getStatus()));
                main.ui.updateStatusBox(p);
                System.out.println("Server status is : "+status);
                if(Objects.equals("Success", status))
                {
                    main.setLeft(main.li);
                }
                else
                {
                    main.r.add(new Text("Registration Failed:"), 0, 6);
                }
            } catch (ClassNotFoundException ex) 
            {
               System.out.println(ex.getClass());
            }

        });
    }
    
    
    
}
