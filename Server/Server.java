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
public class Server extends Thread
{
    private static final int PORT = 1234;
    private static DatagramSocket dgramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;
    private static byte[] dataIn=null;
    private InetAddress clientAddress=null;
    private int clientPort=0;
    
   @Override
   public void run()
    {
        Start();
    }
        
    public void Start() 
    {
        System.out.println("Opening port...\n");
        try {
            dgramSocket = new DatagramSocket(PORT);//Step 1.
        } catch (SocketException e) {
            System.out.println("Unable to attach to port!");
            System.out.println(e.getClass());
            System.exit(1);
        }
        controller();
    }

    private void controller() 
    {
        try {
            String messageIn, messageOut;
            int numMessages = 0;

            do {
                buffer = new byte[256]; 		//Step 2.
                inPacket = new DatagramPacket(
                        buffer, buffer.length); //Step 3.
                dgramSocket.receive(inPacket);	//Step 4.

                InetAddress clientAddress
                        = inPacket.getAddress();	//Step 5.
                int clientPort
                        = inPacket.getPort();		//Step 5.

                messageIn = new String(inPacket.getData(), 0,
                        inPacket.getLength());	//Step 6.

                System.out.println("Message received.");
                System.out.println(clientAddress);
                numMessages++;
                messageOut = ("Message " + numMessages
                        + ": " + messageIn);
                outPacket = new DatagramPacket(
                        messageOut.getBytes(),
                        messageOut.length(),
                        clientAddress,
                        clientPort);		//Step 7.
                dgramSocket.send(outPacket);	//Step 8.
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally //If exception thrown, close connection.
        {
            System.out.println("\n* Closing connection... *");
            dgramSocket.close();				//Step 9.
        }
    }
    
    
    
  /*  private static byte[] buffer = new byte[15000]; 
    
    public Server()
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
            System.out.println(ex.getClass());
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
        
        
    }*/
    
    
}
