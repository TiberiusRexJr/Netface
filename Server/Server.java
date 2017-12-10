/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import Utilities.Util;
import Package.*;
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
    private File dir;
   
   @Override
   public void run()
    {
        Start();
        Operations o=new Operations();
        o.mkdir();
        
    }
        
    public void Start() 
    {
        System.out.println("Opening port...\n");
        try 
        {
            dgramSocket = new DatagramSocket(PORT);
        } catch (SocketException e) 
        {
            System.out.println("Unable to attach to port!");
            System.out.println(e.getClass());
            System.exit(1);
        }
        Operations o=new Operations();
        o.mkdir();
        controller();
    }

    private void controller() 
    {
        try {    
            String messageIn, messageOut;
            

            do {
                buffer = new byte[10000]; 		//Step 2.
                inPacket = new DatagramPacket(buffer, buffer.length); //Step 3.
                dgramSocket.receive(inPacket);	//Step 4.

                clientAddress= inPacket.getAddress();	//Step 5.
                clientPort= inPacket.getPort();		//Step 5.

                messageIn = new String(inPacket.getData(), 0,inPacket.getLength());	//Step 6.

                System.out.println("Message received.");
                byte[] data=inPacket.getData();
                Packet o=null;
                        Util u=new Util();
                        try
                        {
                             o=(Packet) u.toObject(data);
                             switchBoard(o);     
                        }
                        catch(ClassNotFoundException cnf)
                         {
                             System.out.println(cnf.getClass());
                         }
                        
                        
                        
               
            } while (true);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } finally //If exception thrown, close connection.
        {
            System.out.println("\n* Closing connection... *");
            dgramSocket.close();				//Step 9.
        }
   
    }
    
    private void switchBoard(Packet p)
    {
        System.out.println("in switchboard");
        Operations o=new Operations();
        String code=new String(p.getHeader().getCode());
        int status=0;
        String codeDesc="";
        
        switch(code)
        {
            case "v": status=o.validate(new String(p.getHeader().getQuery()));
                      codeDesc="Validate";
                      response(code,codeDesc,status);
               break;
            case "u":status=o.upload(new String(p.getHeader().getName()),p.getPayload());
                     codeDesc="Upload";
                     response(code,codeDesc,status);
               break;
            case "s":
                break;
            case "n":
                break;
            case "d":
                break;
            case "g":
                break;
            case "l":
                break;
            case "r":status=o.register(new String(p.getHeader().getQuery()));
                     codeDesc="Register";
                     response(code,codeDesc,status);
                break;
            default: break;
            
        }
        
        

    }
    
    private void response(String c,String cd,int st)
    {
        System.out.println("In Server Response");
        String status="";
        if(st==1)
        {
            status="Success";
        }
        else if(st==0)
        {
            status="Failure";
        }
 
        String from="Server";

        HeaderS hs=new HeaderS(from,status,c,cd);
        Packet p=new Packet(hs);
        Util u=new Util();
        byte[] pack=u.toByte(p);
        
        
        outPacket = new DatagramPacket(pack,pack.length,clientAddress,clientPort);
        
        try
        {
            dgramSocket.send(outPacket);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getClass());
        }
                	
    }
}
    
    