
public class QuickSort {
	public static void Start() { 
		System.out.println("QuickSort");		
		
		int size = 10;
		
		int[] list = new int[size];
		for(int i=0 ; i<size ; ++i) {
			list[i] = i;
		}
				
		for(int i=0; i <size; ++i) {
			int target = (int)(Math.random() * 1000) % size;
			int temp = list[i];
			list[i] = list[target];
			list[target] = temp;
		}		
		/*
		for(int i=0 ; i<list.length ; ++i) {
			System.out.print(list[i] + " ");			
		}
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		*/
		QuickSort sort = new QuickSort();
		sort.sort(list);
		sort.show(list);
	}
	
	
	public void sort(int[] list) {
		sort2(list, 0, list.length-1);
	}
	
	public void sort2(int[] list, int start, int end) {		
		if( start < end) {
			int p = partition(list, start, end);			
			sort2(list, start, p-1);
			sort2(list, p+1, end);			
		}		
	}
	
	public int partition(int[] list, int start, int end) {
		int l = start; // Left
		int r = end; // Right
		int pv = list[start]; // Pivot Vaue
		
		while( l < r) {
			while( list[r] > pv ) --r;
			while( (l<r) && (list[l] <= pv) ) l++;			

			// There must not be l > r, by (l<r) condition 
			if( l < r) {
				int temp = list[l];
				list[l] = list[r];
				list[r] = temp;
			}
		}	
		
		list[start] = list[r];
		list[r] = pv;
		
		return r;		
	}
	
	public void show(int[] list) {
		int prev = -1;
		for(int i=0 ; i<list.length ; ++i) {		
			System.out.println(list[i]);
			if( prev > list[i]) {
				System.out.println("Error");
			}
			prev = list[i];
		}
	}
}
