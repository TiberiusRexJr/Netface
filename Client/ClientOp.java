/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dream
 */
public class ClientOp 
{
    private String Querey=null;
    private String usrname;

   
    private String password;
    
    public ClientOp()
    {
    
    }
    
    public void reglocal(String usr,String pass)
    {
        this.usrname=usr;
        this.password=pass;
    }
    
     public String getUsrname() 
     {
        return usrname;
    }

    public void setUsrname(String usrname)
    {
        this.usrname = usrname;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
}
