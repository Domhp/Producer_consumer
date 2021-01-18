import java.util.*;

public class listCount {

public static void main(String[] args)
  {
    int num_users = 0;
    int elements = 0;
    int bufferSize = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter number of users:");			//Specify number of users			
    num_users = scanner.nextInt();
    System.out.println("Enter number of elements per user:");		//Specify number of elements submitted per user	
    elements = scanner.nextInt();
    bufferSize = elements * num_users;
    Buffer b; 	
    b = new Buffer(bufferSize);						//Create buffer
    
    user[] users = new user [num_users];
    for(int i = 0; i < num_users; i++){
      users[i] = new user(i, elements, b);
      Thread x = new Thread(users[i]);
      x.start();
    }
    //Create X users that will concurrently add elements to the Buffer object b
    //This can be performed by using an add() method within the Buffer class that needs to be completed.
    
    b.finalSummation();							//Calculate SUM of elements in buffer
  }
}

