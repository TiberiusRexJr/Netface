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
    
    public void makeQuery(ArrayList<String> l)
    {
       Iterator<String> it=l.iterator();
       while(it.hasNext())
       {
           System.out.println(it.next());
       }
    }
    
    public void reglocal(String usr,String pass)
    {
        this.usrname=usr;
        this.password=pass;
    }
}
