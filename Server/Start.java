/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.io.*;
import java.net.*;
/**
 *
 * @author Dream
 */
public class Start 
{
    private static final int PORT = 0001;
    private static DatagramSocket dgramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] dataIn=null;
    private InetAddress clientAddress=null;
    private int clientPort=0;
    
    private static byte[] buffer = new byte[15000]; 
    
    public Start()
    {
        startup();
    }
    
    public void startup()
    {
        try
        {
            dgramSocket=new DatagramSocket(PORT);
        }
        catch(IOException ex)
        {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
       
    }
    
    public void recieve()
    {
        buffer = new byte[256]; 
        
        inPacket = new DatagramPacket( buffer, buffer.length); 
        try
        {
            dgramSocket.receive(inPacket);
        }
        catch(IOException ex)
        {
            
        }
        
        InetAddress clientAddress = inPacket.getAddress();
        int clientPort = inPacket.getPort();
        dataIn=inPacket.getData(); 
    }
    
    public void respond()
    {
        
        
    }
    
    
}
