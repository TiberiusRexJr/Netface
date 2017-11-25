/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
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
    private HBox titleBox;
    private VBox welcomeBox;
    private Text title;
    private Text welcome;
    private Button logout;

    public Main(String user) 
    {
       setTitle();
       setWelcome(user);
       setLogout(); 
       setWelcomeBox();
       setTitleBox();
       setMainBox();
       this.setTop(mainBox);
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
