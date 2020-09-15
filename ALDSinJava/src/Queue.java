
public class Queue {

	public static void Start() {
		System.out.println("Queue");
		
		int size = 10;
		Queue queue = new Queue(size+1);
		
		queue.Dequeue();
		
		for(int i=0 ; i<size ; ++i) {
			queue.Enqueue(i+100);
			queue.Show();
		}
				
		queue.Enqueue(1111111);
		queue.Show();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		for(int i=0 ; i<size ; ++i) {
			System.out.println(queue.Dequeue());
			queue.Show();
		}
		
		queue.Dequeue();
		
		queue.Enqueue(345345);
		queue.Show();
}	
	
	protected int size = 0;
	protected int front = 0; 
	protected int end = 0;   
	protected int data[] = null;
	
	public Queue(int size) {
		this.size = size;
		data = new int[this.size];
		front = 0;
		end = 0;
	}
	
	public boolean IsFull() {		
		return (end+1)%this.size == front;
	}
	
	public boolean IsEmpty() {
		return front == end;		
	}
	
	public void Enqueue(int value) {
		if( IsFull() ) {
			System.out.println("Can not enqueue. Full");
			return;
		}
		
		end = (++end)%this.size; 
		data[end] = value;
	}
	
	public int Dequeue() {
		if( IsEmpty() ) {
			System.out.println("Can not dequeue. Empty");
			return -1;
		}
		
		front = (++front)%this.size;
		return data[front];		
	}
	
	public void Show() {
		if( IsEmpty() ) {
			System.out.println("Can not show. Empty");
			return;
		}
		
		System.out.print("[" + front + "/" + end + "]");
		for(int i=(front+1)%this.size ; i != (end+1)%this.size ; i = ++i % this.size) {
			System.out.print("(" + i + ")" + data[i] + " ");
		}		
		
		System.out.println();		
	}	
}
