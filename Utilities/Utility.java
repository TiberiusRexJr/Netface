/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

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
public class Utility 
{
    public byte[] toByte(Package p)
    {
        byte[] packet=null;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutput out=null;
        try
        {
            out=new ObjectOutputStream(bos);
            out.writeObject(p);
            out.flush();
            packet=bos.toByteArray();
        }
        catch(IOException ex)
        {
            
        }
        finally
        {
            try
            {
                bos.close();
            }
             catch(IOException ex)
            {
            
            }
        }
        return packet;
       
    }
}
