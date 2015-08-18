/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smith.tech;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Samuel
 */
public class Users {
    //declare initial variables
    private String userName; //username
    private String name; //full name
    private String firstN;
    private String lastN;
    private String status;
    private boolean added;
    private int ID;
    
    /*
    *Constructor - create initial class
    */
    public Users() {
        userName = new String();
        name = new String();
        status = new String();
        added = false;
        status = "Not Checked";
        //next = null;
    }
    
    /**
     * Sets username for user
     * @param UN 
     */
    public void setID(int i) {
        ID = i;
    }
    
    public void setUsername(String UN) {
        userName = UN; 
    }
    
    /**
     * Sets name for user
     * @param FN 
     */
    public void setName(String FN) {
        String delims = "[ ]";
        String sep[] = FN.split(delims);
        name = FN;
        firstN = sep[0];
        lastN = sep[(sep.length-1)];
        
        System.out.println("First name: " + firstN);
        System.out.println("Last name: " + lastN);
    }
    
    public String getLast() {
        return lastN;
    }
    
    public void setAdd(){
        added = true;
    }
    
    public void reAdd() {
        added = false;
    }
            
    
    public void setStatus(String ST) {
        status = ST;
    }
    
    public String getUN() {
        return userName;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getStatus() {
        return status;
    }
    
    public static String[] loader(String file) throws IOException
    {
        FileWork data = new FileWork(file);
        String[] dataLines = data.OpenFile();
        return dataLines;
    }
    
    
    /*public static void get(int j) {
        Users travel;
        travel = this;
        
    }*/
    
    public boolean notChecked() {
        if (status.equals("Not Checked"))
                return true;
        else
            return false;
    }
    
    public boolean current() {
        if (status.equals("Current"))
            return true;
        else
            return false;
    }
    
    public boolean checked() {
        if (status.equals("-") || status.equals("x"))
            return true;
        else
            return false;
    }
    
    public boolean toAdd() {
        if((status.equals("-") || status.equals("x")) && added == false)
            return true;
        else
            return false;
    }
    
    public void setCurrent() {
        status = "Current";
        if (Guillotine.mode == Guillotine.USERNAME)
            Clip.copy(userName);
        else if (Guillotine.mode == Guillotine.NAME)
            Clip.copy(name);
        else
            Clip.copy(lastN);
    }
            
    public static void printList(List<Users> head) {
        int iterations = head.size();
        
        for (int i = 0; i<(iterations); i++)
        {
            System.out.println("Username: " + head.get(i).userName);
            System.out.println("Name: " + head.get(i).name);
            System.out.println("Status: " + head.get(i).status);
        }
    }
    
    /*public static void main (String args[]) {
        List<Users> head = new LinkedList<>();
        Users sample = new Users();
        sample.setUsername("test");
        sample.setName("Test name");
        //sample.setStatus("Test Status");
        head.add(sample);
        
        System.out.println("Original");
        System.out.println(sample.getUN());
        System.out.println(sample.getName());
        System.out.println(sample.getStatus());
        
        System.out.println("List");
        printList(head);
    }*/
    
    
}
