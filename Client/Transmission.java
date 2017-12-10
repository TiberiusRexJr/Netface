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
import Package.Packet;
import Utilities.Util;
import java.io.*;
import java.net.*;
import java.lang.ClassNotFoundException;

public class Transmission
{
    private static InetAddress host;
    private static final int port=1234;
    private static DatagramSocket dgramSocket;
    Util u=new Util();
    
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
              System.out.println(e.getClass());
              System.out.println(e.getClass());
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
        System.out.println(packet.length+"  packet length");
        DatagramPacket outbound=new DatagramPacket
                (
                        packet,packet.length,host,port
                );
        try
        {
            System.out.println(dgramSocket.getSendBufferSize());
            dgramSocket.send(outbound);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public Packet recieve() throws ClassNotFoundException
    {
        byte[] buffer=new byte[1000];
        byte[] data=null;
        String mssg=null;
        Packet p=null;
        DatagramPacket inbound = new DatagramPacket
        (buffer, buffer.length); 
        try
        {
          dgramSocket.receive(inbound);
          data=inbound.getData();
          p=(Packet) u.toObject(data);
          System.out.println(new String(p.getHeaderS().getFrom()));
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
            
        }
        
         return p;
    }
 
}
