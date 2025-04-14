public class StringLength {

	public static void main(String[] args) {
		if(args.length < 1) {
			return;
		}
		String str = args[0];
		System.out.println(str + " is " + str.length() +  " characters long");
	}

}
