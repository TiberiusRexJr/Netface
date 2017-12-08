/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Client.*;
import Server.Server;
import Utilities.Util;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author Darius
 */
public class Main extends BorderPane
{
   
    private HBox mainBox;

    public HBox getMainBox() {
        return mainBox;
    }
    private HBox titleBox;
    private VBox welcomeBox;
    private Text title;
    private Text welcome;
    private Button logout;
    private final String defaultUser="N/A";
    
    
    MainUI ui=new MainUI(this);
    Util ut=new Util();
    ImageControl ic=new ImageControl();
    ClientOp cop=new ClientOp();
    Transmission t=new Transmission();
    Login li=new Login(this);
    Register r=new Register(this);
    ImageBox ib=new ImageBox("user");
   
    
    
    public Main(String defaultUser) 
    {
       setTitle();
       setWelcome(defaultUser);
       setLogout(); 
       setWelcomeBox();
       setTitleBox();
       setMainBox();
       this.setTop(mainBox);
       this.setCenter(ib);
       this.setLeft(li);
       this.setRight(ic);
    }

  
    public void setTitle() 
    {
        this.title = new Text();
        title.setText("NeTFace");
        title.setFont(Font.font("Verdana",20));
        title.setFill(Color.BLUE);
    }

    public void setWelcome(String user) 
    {
        welcome = new Text();
       welcome.setText("Welcome: "+user);     
    }

    public void setLogout() 
    {
        logout = new Button();
        logout.setText("Logout");
        
    }
      
    public void setMainBox() 
    {
        mainBox=new HBox();
        mainBox.getChildren().addAll(titleBox,welcomeBox);
   
    }
    
    public void setTitleBox() 
    {
        titleBox = new HBox();
        titleBox.getChildren().add(title);
    }

    public void setWelcomeBox() 
    {
        welcomeBox=new VBox();
        welcomeBox.getChildren().addAll(welcome,logout);
    }

}
