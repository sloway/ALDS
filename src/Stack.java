
public class Stack {
	public static void Start() {
		Stack stack = new Stack(10);
		
		stack.Pop();
		
		for(int i=0 ; i<10 ; ++i) {
			stack.Push(i+100);
			stack.Show();
		}
		
		stack.Push(1111111);
		
		for(int i=0 ; i<10 ; ++i) {
			System.out.println(stack.Pop());
			stack.Show();
		}
		
		stack.Pop();
		
	}
	
	protected int size = 0;
	protected int top = -1;
	protected int[] storage = null;
	public Stack(int size) {
		this.size = size;
		storage = new int[size];
		this.top = -1;
	}
	
	public boolean IsEmpty() {
		return top == -1;
	}
	
	public boolean IsFull() {
		return top == (size-1);
	}
	
	public void Push(int value) {		
		if( IsFull() ) {
			System.out.println("Can not push. Full");
			return;
		}
		
		storage[++top] = value;		
	}
	
	public int Pop() {
		if( IsEmpty() ) {
			System.out.println("Can not pop. Empty");
			return -1;
		}
		
		return  storage[top--];		
	}
	
	public void Show() {
		for(int i=0 ; i<=top ; ++i) {
			System.out.print(storage[i] + " ");
		}
		System.out.println();
	}
}
