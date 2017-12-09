/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Package.Header;
import Package.Packet;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
/**
 *
 * @author Dream
 */
public class Login extends GridPane
{
    
    private Main main;
    private Hyperlink register;

   
    private TextField userName=new TextField();
    private TextField password=new TextField();
    private Button submit=new Button("Submit");
    
    public Login(Main m)
    {
        main=m;
        setSubmit();
        setUserName();
        setRegister();
        this.setVgap(4);
        this.setPadding(new Insets(5, 5, 5, 5));
        this.add(new Label("User Name:"), 0, 0);
        this.add(new Label("Password: "),0,1);
        
        this.add(userName,1,0);
        this.add(password,1,1);
        this.add(submit,0,2);
        this.add(register,1,2);
    }
    public void setSubmit( )
    {
        submit.setOnAction((ActionEvent event)->
        {
            String code="v";
            String q="validate";
            Packet recieved=null;
            main.cop.setUsrname(userName.getText().toString());
            main.cop.setPassword(password.getText().toString());
            Header h=new Header(userName.getText(),password.getText(),code,q);
            Packet p=new Packet(h);
            byte[] pack=main.ut.toByte(p);
            main.t.Send(pack);
            try 
            {
                recieved=main.t.recieve();
                String status=new String((recieved.getHeaderS().getStatus()));
                main.ui.updateStatusBox(recieved);
                System.out.println("Server status is : "+status);
                if(Objects.equals("Success", status))
                {
                    main.setLeft(main.ui);
                }
                else
                {
                    main.li.add(new Text("Login Failed:"), 1, 3);
                }
          
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
     public void setRegister( ) 
     {
         register=new Hyperlink("Register");
        register.setOnAction((ActionEvent event)->
        {
            main.setLeft(main.r);
        });
    }
    
       public void setUserName() 
       {
        userName.setPromptText("FirstnameLastname");
       }
    
    }
    

