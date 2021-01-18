import java.util.*;
public class semaphore {
	private boolean state = false;

	public synchronized void acquire() {
		state = true;
		notify();
	}
	public synchronized void release() throws InterruptedException{
		while(!state) {
			wait();
		}
		state = false;
	}
}

