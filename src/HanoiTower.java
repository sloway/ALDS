
public class HanoiTower {
	public static void Start() {
		
		Move(5, 'A', 'B', 'C');
	}
	
	public static void Move(int disk, char from, char by, char to) {
		if( disk == 1 ) {
			System.out.println(">>> Move " + disk + " from " + from + " to " + to);
			return;
		}		
		
		Move(disk-1, from, to, by);
		System.out.println(">>> Move " + disk + " from " + from + " to " + to);
		Move(disk-1, by, from, to);
		
	}
}
