import java.util.*;
import java.util.concurrent.*;
public class Buffer 						//Provides data and operations onto the fixed-length queue
 {     									
  private LinkedList<Object> buf_list;		
  private int elements;						//Number of elements currently on the queue
  private int buf_size;						//Maximum number of elements allowed on queue
  private Semaphore buf_count = new Semaphore(0);
  public Buffer(int n)						//Queue creation, with n indicating the maximum capacity
   {
     buf_list = new LinkedList<Object>();
     elements = 0;
     buf_size = n;
   }

  public synchronized void add(int element, int id)						//Add element to queue
   {	   	
    buf_list.add(element);
    this.elements++;
    System.out.println("User " + id + " adds element " + elements + "/" + buf_size);
    buf_count.release();
   }   


    public void finalSummation()				
    {								//Calculates the total sum of element value within the buffer
    
    int sum = 0;
    int i = 0;
    while(i < buf_size){
        try {
            buf_count.acquire();
            sum = sum + (int) buf_list.get(i);
            i++;            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    System.out.println("--------------------------");
    System.out.println("Count total: " + sum); 
    System.out.println("--------------------------");
    }
 }	
