import java.util.*;

public class user implements Runnable
{								
  private int id;
  private int num_elements;
  public static Buffer buf;
		  
  public user(int i, int el, Buffer b)	        			//User arguments: User ID, number of elements to add, and buffer
		  {id = i; num_elements = el; buf = b;}
  
  public void add_elements() //wasn't set to void
  {   										//Add element to buffer, element value iterates from 0, 1, 2 .... num_elements
	  int n = 0;
	  while (num_elements > 0)
    {
     buf.add(new Integer(n),id);			
	   n++;
	   num_elements--;
	  }			
  }
  public void run()
  {
    this.add_elements();
  }
}  