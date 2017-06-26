
public class Heap {
	public static void Start() {
		System.out.println("Heap");
		
		Heap heap = new Heap(10);
		heap.push(10);
		heap.push(20);
		heap.push(30);
		heap.push(5);		
		heap.push(50);
		heap.push(40);
		heap.push(15);
		heap.push(1);
		heap.push(2);
		heap.push(3);
		heap.push(4);
		//heap.show2();
		heap.show();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0 ; i<10 ; ++i) {
			System.out.println(heap.pop());
		}
			
		heap.show2();
	}
	
	protected int fullSize = 0;
	protected int size = 0;
	protected int[] list = null;
	public Heap(int size) {
		this.fullSize = size + 1;
		list = new int[this.fullSize];
		this.size = 0;
	}
	
	public void push(int value) {
		if( isFull() == true) {
			System.out.println("Can not push. Full");
			return;
		}
		int cur = ++size;
		
		while( (cur>0) && (value < list[cur/2]) ) {
			list[cur] = list[cur/2];
			cur /= 2;
		}
		
		list[cur] = value;
	}
	
	public int pop() {
		if( isEmpty() == true ) {
			System.out.println("Can not pop. Empty");
			return -1;
		} 
		
		int ret = list[1];
		int item = list[size];
		list[size--] = 0;
		
		if( size == 0) {
			return item;
		}
		
		int parent = 1;
		int child = 2;
		while( child <= size) {
			if( (child < size) && (list[child] > list[child+1]) ) {
				++child;
			}
			
			if( item < list[child]) {
				break;				
			}
			
			list[parent] = list[child];
			parent = child;
			child *= 2;
		}
		
		list[parent] = item;
		return ret;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == (fullSize-1);
	}
	
	public void show() {
		show(1, 1);
	}
 	
	public void show(int cur, int depth) {
		if( cur > size) {
			return;
		}
			
		show(cur*2 + 1, depth+1);
		for(int i=0 ; i<depth ; ++i) {
			System.out.print("   ");
		}
		System.out.println(list[cur]);
		show(cur*2, depth+1);
	}
	
	public void show2() {
		for(int i=1 ; i<=10 ; ++i) {
			System.out.println(i + " : " + list[i]);
		}
	}

}
