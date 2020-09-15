
public class BinaryTreeArray implements IBinaryTree {	
	
	public static void Start() {
		System.out.println("BinaryTreeArray");
		
		BinaryTreeArray bt = new BinaryTreeArray(5);
		bt.insert(100);
		bt.insert(50);
		bt.insert(150);
		bt.insert(70);
		bt.insert(20);
		bt.insert(60);
		bt.insert(160);
		
		bt.show();
		bt.inorder();
	}
	
	private int data[] = null;
	private int size = 0;
	private int depth = 0;
	
	public BinaryTreeArray(int depth) {
		this.depth = depth;
		this.size = (int)Math.pow(2, depth);
		data = new int[size];
		System.out.println("size is " + size);
	}
	
	@Override
	public void insert(int value) {
		// TODO Auto-generated method stub
		
		int cur = 1;
		while((cur<size) && (data[cur] != 0)) {			
			cur = cur * 2 + ((value < data[cur]) ? 0 : 1);
		}
		
		data[cur] = value;
	}

	@Override
	public void delete(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inorder() {
		// TODO Auto-generated method stub
		inorder(1);
		System.out.println();
	}
	
	public void inorder(int cur) {
		if( data[cur] == 0 ) {
			return;
		}
		
		inorder(cur*2);		
		System.out.print(data[cur] + " ");
		inorder(cur*2+1);		
	}
	
	
	//@Override
	public void show() {
		show(1, 1);		
	}
	
	public void show(int cur, int depth) {
		
		if( data[cur] == 0 ) {
			return;
		}
		
		show(cur*2+1, depth+1);
		for(int i=0 ; i<depth ; ++i) {
			System.out.print("    ");
		}
		System.out.println(data[cur]);
		show(cur*2, depth+1);
	}

}
