/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import GUI.Main;
import Server.Server;

/**
 *
 * @author Darius
 */
public class NetFace extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        String name="red";
        Main m=new Main(name);
        
        Scene scene = new Scene(m, 500, 500);
        
        primaryStage.setTitle("NetFace");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Server s=new Server();
        s.start();
        launch(args);
        
       
    }
    
}
