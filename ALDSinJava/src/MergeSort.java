
public class MergeSort {
	public static void Start() {
		System.out.println("MergeSort");
		
		int size = 10;
		int list[] = new int[size];
		for(int i=0 ; i<size ; ++i) {
			list[i] = i*10;
		}
		
		for(int i=0 ; i<10 ; ++i) {
			int target = (int)(Math.random()*1234) % size;
			int temp = list[i];
			list[i] = list[target];
			list[target] = temp;
		}		
		
		MergeSort sort = new MergeSort();
		sort.show(list);
		sort.sort(list);
		sort.show(list);
	}
		
	protected int[] temp = null;
	public void sort(int[] list) {
		temp = new int[list.length];
		sort2(list, 0, list.length-1);
		temp = null;
	}
	
	public void sort2(int[] list, int start, int end) {
		//System.out.println(start + " " + end);
		if( start < end ) {
			int mid = (start + end) / 2;
			sort2(list, start, mid);
			sort2(list, mid + 1, end);
			merge(list, start, mid, end);
		}
	}
	
	public void merge(int[] list, int start, int mid, int end) {	
		int i = start;
		int j = mid + 1;
		int t = start;
		
		while( i<=mid && j<=end ) {
			temp[t++] = (list[i] < list[j]) ? list[i++] : list[j++];
		}
		
		if( i > mid ) {
			while( j<=end ) {
				temp[t++] = list[j++];
			}
		} else {
			while( i<=mid ) {
				temp[t++] = list[i++];
			}
		}
		
		for(i=start ; i<=end ; ++i) {
			list[i] = temp[i];
		}		
}
	
	
	public void show(int[] list) {
		System.out.println("list");
		int prev = -1;
		for(int i=0 ; i<list.length ; ++i) {			
			System.out.println(list[i]);
			if( prev > list[i]) {
				System.out.println("Error!!!");
			}
			prev = list[i];
		}
	}

}
