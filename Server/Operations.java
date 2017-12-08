/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Dream
 */
public class Operations  extends Server 
{
    private int status=0;

    
    private final String mainFolderAdress="C://Netface";
    private final String imageFolderAdres=mainFolderAdress+"/images";
    
    public int upload()
    {
        
        
        return status;
    };
    
    public int search(String name)
    {
        
        
        return status;
    }
    
    public int register(String info)
    {
        String[] data=info.split("\\s+");
        
        String newLine=System.getProperty("line.separator");
        try
        {
         FileWriter fw=new FileWriter(mainFolderAdress+"/access_list.txt",true);
         BufferedWriter bw=new BufferedWriter(fw);
         
         for(String s: data)
         {
             bw.write(s+newLine);
             
         }
         bw.close();
         status=1;
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
       
        return status;
    }
    
    public int validate(String q)
    {
        System.out.print(q);
        status=1;
        return status;
    }
    
    public int delete()
    {
        return status;
    }
    public int logout()
    {
        return status;
    }
    public int mkdir()
    {  
       
        File dir=new File(mainFolderAdress);
        
        
        if(!dir.exists())
        {
        new File(mainFolderAdress).mkdirs();
        new File(imageFolderAdres).mkdirs();
        
        File al= new File(mainFolderAdress+"/access_list.txt");
        try
        {
         al.createNewFile();
         BufferedWriter writer=new BufferedWriter(new FileWriter(al));
         writer.write("admin");
         writer.newLine();
         writer.write("password");
         writer.close();
         status=1;

        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
       
        
        }
        return status;
    };
   
    
    
}
