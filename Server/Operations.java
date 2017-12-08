/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;

/**
 *
 * @author Dream
 */
public class Operations  extends Server 
{
    public boolean b=false;
    
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
        System.out.println(info);
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
        File dir=new File("C:/Users/All Users/Desktop/Netface");
        if(!dir.exists())
        {
        new File("C:/Users/All Users/Desktop/Netface").mkdirs();
        b=true;
        }
        
       
        return b;
    };
    
    
}
