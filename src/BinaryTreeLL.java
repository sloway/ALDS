

public class BinaryTreeLL implements IBinaryTree {

	public static void Start() {
		System.out.println("BinaryTreeLL");
		
		BinaryTreeLL bt = new BinaryTreeLL();
		bt.insert(100);
		bt.insert(50);
		bt.insert(150);
		bt.insert(70);
		bt.insert(20);
		//bt.insert(60);
		bt.insert(160);
		bt.insert(40);
		bt.insert(10);
		bt.insert(5);
		bt.insert(15);
		bt.insert(13);
		
		bt.show();
		bt.inorder();
		
		//bt.delete(60);
		bt.delete(20);
		//bt.delete(40);
		//bt.delete(10);
		
		bt.show();
		bt.inorder();
	}

	public class Node {
		int data = -1;
		Node left = null;
		Node right = null;
		
		public Node(int value) {
			data = value; 
		}
	}
	
	private Node head = null;
	
	@Override
	public void insert(int value) {		
		if( head == null ) {
			head = new Node(value);
			return;
		}	
		
		Node parent = null;
		Node node = head;
		while(node != null) {
			parent = node;
			node = ( value < node.data ) ? node.left : node.right;						
		}		
				
		node = new Node(value);
		if( value < parent.data ) {
			parent.left = node;
		} else {
			parent.right = node;
		}
	}
	
	@Override
	public void delete(int value) {
		Node parentNode = null;
		Node node = head;
		while( node != null ) {
			if( node.data == value) {
				break;
			}
			
			parentNode = node;
			node = (value < node.data) ? node.left : node.right;
		}		
				
		boolean isLeftChild = (node.data < parentNode.data ) ? true : false;
		int childCount = (node.left == null) ? 0 : 1;
		childCount += (node.right == null) ? 0 : 2;
				
		switch(childCount) {
		case 0: // has none
			if(isLeftChild) {
				parentNode.left = null;
			} else {
				parentNode.right = null;
			}
			break;
		case 1: // has Left only			
			if(isLeftChild) {
				parentNode.left = node.left;
			} else {
				parentNode.right = node.left;
			}			
			break;
		case 2: // has Right only
			if(isLeftChild) {
				parentNode.left = node.right;
			} else {
				parentNode.right = node.right;
			}			
			break;
		case 3: // has both			
			if( node.left.right == null ) {
				node.data = node.left.data;
				node.left = node.left.left;
			} else {
				parentNode = node.left;
				Node maxNode = node.left.right;
				while( maxNode.right != null ) {
					parentNode = maxNode;
					maxNode = maxNode.right;
				}
				
				node.data = maxNode.data;
				parentNode.right = maxNode.left;				
			}		 
			
			break;
		default:
			System.out.println("Invalid path");
		}						
	}

	@Override
	public void inorder() {		
		inorder(head);
		System.out.println();
	}
	
	public void inorder(Node node) {
		if( node == null ) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub	
		show(head, 1);
	}  
	
	public void show(Node node, int depth) {
		if( node == null ) {
			return;
		}
		
		show(node.right, depth+1);
		for(int i=0 ; i<depth ; ++i) {
			System.out.print("    ");
		}
		System.out.println(node.data);
		show(node.left, depth+1);
		
	}

}
