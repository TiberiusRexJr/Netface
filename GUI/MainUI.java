/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    private Text respMssge=new Text("N/A");
    private TextField searchField;
    private TextField search_name;
    private TextField search_email;
    private Button uploadButton;
    private Button select;
    
    private VBox statusBox;


    public MainUI()
    {  
        setSearch();
        setTtitle();
        setStatusBox();
        setUploadButton();
        setSelectButton();
        setSearchField();
        setSearch_email();
        setSearchGrid();
        setUploadGrid();
        setUploadDropDown( );
        setSearchDropDown( ); 
        this.add(searchDropDown, 0, 0);
        this.add(uploadDropDown,0,1);
        this.add(statusBox,0,6);
        
       
        
        
    }    
      public void setStatusBox() 
      {
        statusBox = new VBox();
        Text status=new Text("Server Response:");
        statusBox.getChildren().addAll(status,respMssge);

    }
    
    
    public void setSelectButton() 
    {
        this.select=new Button();
        
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
    
    public void setSelect()
    {
     select=new Button("Select");
    }

    public void setUploadButton() 
    {
        uploadButton=new Button("Upload");
    }

    private void setTtitle()
    {
        title=new Text("Search");
    }
    public void setSearch() 
    {
        Search = new Button("Search");
    }

    public void setSearch_extend() 
    {
        this.Search_extend = new Button("More");
    }

    public void setGo( )
    {
        this.Go = new Button("Go");
    }

    public void setSearchField()
    {
        this.searchField = new TextField();
        searchField.setText("First Last");
    }

    public void setSearch_name() 
    {
        this.search_name = new TextField();
        search_name.setText("First Last");
        
    }

    public void setSearch_email()
    {
        this.search_email=new TextField();
        search_email.setText("email@yahoo");
    }
    public void setSearchGrid( ) 
    {
        searchGrid=new GridPane();
        searchGrid.setVgap(4);
        searchGrid.setPadding(new Insets(5, 5, 5, 5));
        searchGrid.add(new Label("First Name: "), 0, 0);
        searchGrid.add(new TextField(), 1, 0);
        searchGrid.add(new Label("Last Name: "), 0, 1);
        searchGrid.add(new TextField(), 1, 1);
        searchGrid.add(new Label("Email: "), 0, 2);
        searchGrid.add(new TextField(), 1, 2);  
        searchGrid.add(Search,0,3);
    }
     public void setUploadGrid() 
     {
        uploadGrid=new GridPane();
        uploadGrid.setVgap(4);
        uploadGrid.setPadding(new Insets(5,5,5,5));
        uploadGrid.add(new Label("File:"),0,0);
        uploadGrid.add(new TextField(),2,1);
        uploadGrid.add(select,0,1);
        uploadGrid.add(uploadButton,0,2);
    }

    
}
