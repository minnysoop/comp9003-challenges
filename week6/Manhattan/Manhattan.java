public class Manhattan {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		double C = Double.parseDouble(args[2]);
		int x1 = Integer.parseInt(args[3]);
		int y1 = Integer.parseInt(args[4]);
		int x2 = Integer.parseInt(args[5]);
		int y2 = Integer.parseInt(args[6]);

		// (x1,y1) or (x2,y2) are not on the map
		if (x1 < 0 || x1 > N || y1 < 0 || y1 > M 
		    || x2 < 0 || x2 > N || y2 < 0 || y2 > M) {
			System.out.println("This place isn't on the map");
			return;
		} 

		int traveled = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		if (C == 0) {
			System.out.printf("You got a free ride and you will have traveled %d blocks\n", traveled);
			return;
		}
		double total_cost = C * traveled;
		System.out.printf("This trip will cost $%.2f and you will have traveled %d blocks\n", total_cost, traveled);
	}
}
