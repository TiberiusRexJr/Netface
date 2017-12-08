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
    public boolean b=false;
    private final String mainFolderAdress="C://Netface";
    private final String imageFolderAdres=mainFolderAdress+"/images";
    
    public boolean upload()
    {
        
        
        return b;
    };
    
    public boolean search(String name)
    {
        
        
        return b;
    }
    
    public boolean register(String info)
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
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
       
        return b;
    }
    
    public boolean validate(String q)
    {
        System.out.print(q);
        return b;
    }
    
    public boolean delete()
    {
        return b;
    }
    public boolean logout()
    {
        return b;
    }
    public boolean mkdir()
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
         
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
       
        b=true;
        }
        return b;
    };
    
    
}
