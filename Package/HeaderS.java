/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 *
 * @author Dream
 */
public class HeaderS extends Header 
{
    private byte[] from=new byte[16];
    private byte[] status=new byte[16];
    private byte[] code=new byte[1];
    private byte[] codedsc=new byte[31];

    public HeaderS(String n, String p, String c, String q) 
    {
        super(n,p,c,q);
        
        from=n.getBytes();
        status=p.getBytes();
        code=c.getBytes();
        codedsc=q.getBytes();
        
    }

    public byte[] getFrom()
    {
        return from;
    }

    public byte[] getCo() 
    {
        return code;
    }

    public byte[] getStatus() {
        return status;
    }

    public byte[] getCodedsc() 
    {
        return codedsc;
    }
  
}
