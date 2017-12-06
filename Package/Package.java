/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darius
 */
public class Package 
{
    private Header header;
    private ArrayList<BufferedImage> payload;
    
    public Package(Header h,ArrayList<BufferedImage> p)
    {
        setHeader(h);
        setPayload(p);
    }
    public Package(Header h)
    {
        setHeader(h);
    }
    
     public Header getHeader() 
     {
        return header;
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


