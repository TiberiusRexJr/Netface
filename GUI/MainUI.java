/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fc, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Package.*;
import Utilities.Util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;

/**
 *
 * @author Hellena
 */
public class MainUI extends GridPane
{
    private Button Search ;
    private Button Search_extend;
    private Button Go;
    private GridPane searchGrid ;
    private GridPane uploadGrid;
    
    private TitledPane searchDropDown;

  
    private TitledPane uploadDropDown;
   
    private Text title;
    private VBox serverRsp;
    private VBox clientAction;
    private TextField firstName;
    private TextField lastName;
    private TextField search_email;
    private TextField fileURL;
    private Button uploadButton;
    private Button select;
    private String fileDir;
   
    public Text fromT=new Text("N/A");
    public Text actionT=new Text("N/A");
    public Text statusT=new Text("N/A");
      
    
    private GridPane statusBox;
    private final Main  main;

    

    public MainUI(Main ma)
    {  
        setSelect(); 
        setSearch();
        setTtitle();
        setStatusBox();
        setUploadButton();
        setFirstName();
        setLastName();
        setSearchEmail();
        setSearchGrid();
        setUploadGrid();
        setUploadDropDown( );
        setSearchDropDown( ); 
        this.add(searchDropDown, 0, 0);
        this.add(uploadDropDown,0,1);
        this.add(statusBox,0,6);
        main=ma;

    }   
     public void setSelect() 
    {
        DirectoryChooser dir=new DirectoryChooser();
        FileChooser fc=new FileChooser();
        fc.setTitle("Choose a Image: .jpg,.png");
        fc.getExtensionFilters().addAll(new ExtensionFilter("Image Files","*.png","*.jpg"));
        select=new Button("Select");
        select.setOnAction((ActionEvent event)->
        {
            File file=fc.showOpenDialog(main.stage);
            
            if(file!=null)
            {
             String fileURL=file.getName();
             fileDir=file.getAbsolutePath();
            main.ui.fileURL.setText(fileURL);
            }
           
        });
    }
      public void setStatusBox() 
      {
        statusBox = new GridPane();
        Text title=new Text("Message Center");
        
        statusBox.setVgap(4);
        statusBox.setPadding(new Insets(5, 5, 5, 5));
        statusBox.add(title,1,0);
        statusBox.add(new Label("From:"), 0, 1);
        statusBox.add(new Label("Action:"),0,2);
        statusBox.add(new Label("Status:"),0,3);
        
        statusBox.add(fromT, 1, 1); 
        statusBox.add(actionT,1,2);
        statusBox.add(statusT,1,3);
      }
      
      public void updateStatusBox(Packet p)
      {
          statusBox.getChildren().remove(fromT);
          statusBox.getChildren().remove(actionT);
          statusBox.getChildren().remove(statusT);
          
        
          statusBox.add(new Text(new String(p.getHeaderS().getFrom())), 1, 1);
          statusBox.add(new Text(new String(p.getHeaderS().getCodedsc())), 1, 2);
          statusBox.add(new Text(new String(p.getHeaderS().getStatus())), 1, 3);
      }

    
    public void setSearchDropDown( ) 
    {
        searchDropDown=new TitledPane();
        searchDropDown.setText("Search");
        searchDropDown.setContent(searchGrid);
        searchDropDown.expandedProperty().setValue(Boolean.FALSE);
        
    }

    public void setUploadDropDown( ) 
    {
        uploadDropDown = new TitledPane();
        uploadDropDown.setText("Upload");
        uploadDropDown.setContent(uploadGrid);
        uploadDropDown.expandedProperty().setValue(Boolean.FALSE);
    }
    


    public void setUploadButton() 
    {
        uploadButton=new Button("Upload");
        String code="u";
        
        uploadButton.setOnAction((ActionEvent event)->
        {
             
             
             String query=main.cop.getUsrname();
        
             try
             {
              
             
             BufferedImage img=ImageIO.read(new File(fileDir));
             ByteArrayOutputStream baos=new ByteArrayOutputStream();
             ImageIO.write(img,"png",baos);
             byte[] iData=baos.toByteArray();
             
             
             Header h=new Header(main.cop.getUsrname(),main.cop.getPassword(),code,query);
             System.out.println("username is: "+main.cop.getUsrname());
             Packet p=new Packet(h,iData);
             byte[] pack=main.ut.toByte(p);
             main.t.Send(pack);
             Packet recieved=main.t.recieve();
             main.ui.updateStatusBox(recieved);
             
           }
             catch(IOException e)
             {
                 System.out.println(e.getClass());
                 System.out.println(e.getMessage());
             }
              catch(ClassNotFoundException cnf)
             {
                 System.out.println(cnf.getClass());
             }
        });
    }

    private void setTtitle()
    {
        title=new Text("Search");
    }
    public void setSearch() 
    {
        Search = new Button("Search"); 
        Search.setOnAction((ActionEvent event)->
        { 
            String code="0001";
            String query=lastName.getText()+firstName.getText();
            String name,pass;
            name=main.cop.getUsrname();
            pass=main.cop.getPassword();
            Header h=new Header(name,pass,code,query);
            Packet p=new Packet(h);
            
            Util u=new Util();
           
            byte[] pack=u.toByte(p);
   
        });
    }

    public void setSearch_extend() 
    { 
        this.Search_extend = new Button("More");
    }

    public void setGo( )
    {
        this.Go = new Button("Go");
    }

    public void setFirstName()
    {
        this.firstName = new TextField();
        
    }

    public void setLastName() 
    {
        this.lastName = new TextField();
        
        
    }

    public void setSearchEmail()
    {
        this.search_email=new TextField();
        
    }
    public void setSearchGrid( ) 
    {
        searchGrid=new GridPane();
        searchGrid.setVgap(4);
        searchGrid.setPadding(new Insets(5, 5, 5, 5));
        searchGrid.add(new Label("First Name: "), 0, 0);
        searchGrid.add(firstName, 1, 0);
        searchGrid.add(new Label("Last Name: "), 0, 1);
        searchGrid.add(lastName, 1, 1);
        
        searchGrid.add(Search, 1, 2);  
        
    }
     public void setUploadGrid() 
     {
         
        fileURL=new TextField();
        uploadGrid=new GridPane();
        uploadGrid.setVgap(4);
        uploadGrid.setPadding(new Insets(5,5,5,5));
        uploadGrid.add(new Label("File:"),0,0);
        uploadGrid.add(fileURL,1,0);
        uploadGrid.add(select,0,2);
        uploadGrid.add(uploadButton,1,2);
        
    }

    
}
