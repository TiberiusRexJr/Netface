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
import javafx.scene.text.Text;

/**
 *
 * @author Hellena
 */
public class MainUI extends TitledPane
{
    private Button Search ;
    private Button Search_extend;
    private Button Go;
    private GridPane searchGrid ;
    private GridPane uploadGrid;
    private Text title;
    private TextField searchField;
    private TextField search_name;
    private TextField search_email;

    public MainUI()
    {  
        setSearch();
        setTtitle();
        setSearchField();
        setSearch_email();
        setControlGrid();
        this.setText("Search");
        this.setContent(searchGrid);
        
        
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
    public void setControlGrid( ) 
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

    
}
