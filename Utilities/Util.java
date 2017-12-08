/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Dream
 */
public class Util 
{
    public byte[] toByte(Object obj) 
    {
        
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try
        {
         ObjectOutputStream os=new ObjectOutputStream(out);
         os.writeObject(obj);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
       
        
        return out.toByteArray();
     
    }
    public Object toObject(byte[] b) throws ClassNotFoundException
    {
        ByteArrayInputStream in=new ByteArrayInputStream(b);
        Object o=null;
        try
        {
          ObjectInputStream is=new ObjectInputStream(in); 
          o=is.readObject();
        }
        catch(IOException ioe)
        {
            
        }
        return o;
        
       
    }
}
