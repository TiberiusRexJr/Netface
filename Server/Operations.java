/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Dream
 */
public class Operations  extends Server 
{
    private int status=0;

    
    private final String mainFolderAdress="C://Netface";
    private final String imageFolderAdres=mainFolderAdress+"/images";
    
    public int upload(String u,byte[] i)
    {
        status=validate(u);
        if(status==1)
        {
            try
            {
            BufferedImage image=ImageIO.read(new ByteArrayInputStream(i));
            File f=new File(imageFolderAdres+"/"+u);
            File[] list=f.listFiles();
            System.out.println(list.length);
            File img=new File(imageFolderAdres+"/"+u+"/"+"image"+list.length+".png");
            System.out.println(imageFolderAdres+"/"+u+"/"+"image"+list.length+".png");
            ImageIO.write(image, "png", img);
            
            if(!f.exists())
            {
                status=0;
            }
            
            }
            catch(IOException ie)
            {
                System.out.println(ie.getMessage());
            }
        }
     
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
         status=makeUserImageDirectory(data[0]+data[1]);
         
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
       
        return status;
    }
    
    public int validate(String q)
    {
        
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
    
    public int makeUserImageDirectory(String name)
    {
        int status=1;
        File f=new File(imageFolderAdres);
        File[] paths=f.listFiles();
        
        new File(imageFolderAdres+"/"+name).mkdirs();
        
        File file=new File(imageFolderAdres+"/"+name);
        if(!(file.exists()))
        {
            status=0;
        }
        return status;
    }
   
    
    
}
