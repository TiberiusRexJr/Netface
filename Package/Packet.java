/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Darius
 */
public class Packet implements Serializable
{
    private Header header;
    private HeaderS headers;
    private ArrayList<BufferedImage> payload;
    
    public Packet(Header h,ArrayList<BufferedImage> p)
    {
        setHeader(h);
        setPayload(p);
    }
    public Packet(Header h)
    {
        setHeader(h);
    }
   
    public Packet(HeaderS hs)
    {
        setHeaderS(hs);
    }
    public HeaderS getHeaderS()
    {
        return headers;
    }
   
    
     public Header getHeader() 
     {
        return header;
    }
      public void setHeaderS(HeaderS hs)
    {
        headers=hs;
    }
    public void setHeader(Header header) 
    {
        this.header = header;
    }

    public ArrayList<BufferedImage> getPayload() 
    {
        return payload;
    }

    public void setPayload(ArrayList<BufferedImage> payload) 
    {
        this.payload = payload;
    }

}


