/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Hellena
 */
public class ImageBox  extends VBox
{
    private ImageView mainPic;
    private Text user;

   public ImageBox(String un)
   {
       setMainPic();
       setUser(un);
      this.getChildren().addAll(user,mainPic);
   }

    public void setMainPic() 
    {
        this.mainPic = new ImageView();
    }

    public void setUser(String name) 
    {
        user=new Text(name);
    }

}   
