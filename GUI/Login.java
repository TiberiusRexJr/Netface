/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
/**
 *
 * @author Dream
 */
public class Login extends GridPane
{
    private TextField usrnm=new TextField();
    private TextField usrpswrd=new TextField();
    private Button submit;
    private Main main;
    private MainUI mainui;
    
    
    public Login(Main m,MainUI mu)
    {
         
        this.setVgap(4);
        this.setSubmit();
        this.setPadding(new Insets(5, 5, 5, 5));
        this.add(new Label("Username:"), 0, 0);
        this.add(usrnm,1,0);
        this.add(new Label("Password:"), 0, 1);
        this.add(usrpswrd,1,1);
        this.add(submit,1,2);
        main=m;
        mainui=mu;
    }
    
    public void setSubmit()
    {
        submit=new Button("Submit");
        submit.setOnAction( (ActionEvent event)->
        {
            
            main.setLeft(mainui);
        }
        );
    }
    
}
