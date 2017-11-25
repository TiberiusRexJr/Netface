/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 *
 * @author Darius
 */
public class Header 
{
    private byte[] name=new byte[16];
    private byte[] pass=new byte[16];
    private byte[] code=new byte[1];
    private byte[] query=new byte[31];

    public Header(String name,String pass,String code,String query)
    {
      setName(name);
      setPass(pass);
      setCode(code);
      setQuery(query);
      
    }
    
    
    public byte[] getName() 
    {
        return name;
    }

    private void setName(String name) 
    {
        this.name=name.getBytes();
    }

    public byte[] getPass() 
    {
        return pass;
    }

    private void setPass(String pass) 
    {
        this.pass=pass.getBytes();
    }

    public byte[] getCode() 
    {
        return code;
    }

    private void setCode(String code) 
    {
        this.code = code.getBytes();
    }

    public byte[] getQuery() 
    {
        return query;
    }

    private void setQuery(String query) 
    {
        this.query = query.getBytes();
    }
 
}
