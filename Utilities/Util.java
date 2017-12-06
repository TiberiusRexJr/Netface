/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Package.Packet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

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
}
