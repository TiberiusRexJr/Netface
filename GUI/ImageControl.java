/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Hellena
 */
public class ImageControl  extends VBox
{
    private HBox titleBox=new HBox();
    private ScrollPane scrollBox=new ScrollPane();
    private Button rm=new Button("Remove");
    
    public ImageControl()
    {
          this.getChildren().addAll(titleBox,scrollBox);
    }
    public void  update()
    {
        
    }
    
}
