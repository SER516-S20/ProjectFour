/**
 * @author Kairui Hsu
**/
public class Compile extends Thread {
	
	public void run() { 
        try { 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
            
            System.out.println ("Thread " + Thread.currentThread().getId() + " is finished"); 
        } 
        catch (Exception e) { 
            System.out.println ("Exception is caught"); 
        } 
    } 
}
