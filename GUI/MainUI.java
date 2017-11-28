/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Hellena
 */
public class MainUI extends GridPane
{
    private Button Search ;
    private Button Search_extend;
    private Button Go;
            
    private TextField searchField;
    private TextField search_name;
    private TextField search_email;

    public MainUI()
    {
        setSearch();
        setSearchField();
        
        this.add(searchField,0,2);
        this.add(Search, 0, 3);
        
        
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

    
}
