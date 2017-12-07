/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Dream
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Transmission
{
    private static InetAddress host;
    private static final int port=1234;
    private static DatagramSocket dgramSocket;
   
    
    public  Transmission()
    {
        setDgramSocket();
        setHost();
        
    }
      public  void setDgramSocket() 
      {
          try
          {
            dgramSocket = new DatagramSocket();  
          }
          catch(IOException e)
          {
          
          }
        
      }
    public  void setHost()
    {
        try
        {
            host=InetAddress.getLocalHost();
            System.out.println(host.getHostName());
        }
        catch(UnknownHostException e)
        {
            System.out.println("host id not found");
            System.out.println(e.getClass());
        }
    }
    
    public void Send(byte[] packet)
    {
        
        DatagramPacket outbound=new DatagramPacket
                (
                        packet,packet.length,host,port
                );
        try
        {
            
            dgramSocket.send(outbound);
        }
        catch(IOException e)
        {
            
        }
        
    }
    
    public String recieve()
    {
        byte[] buffer=new byte[256];
        byte[] data=null;
        String mssg=null;
        
        DatagramPacket inbound = new DatagramPacket
        (buffer, buffer.length); 
        try
        {
          dgramSocket.receive(inbound);
          data=inbound.getData();

        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        
         return mssg;
    }
 
}
