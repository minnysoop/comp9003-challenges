// your code here
import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = s.nextInt();
        if (n%2==0) {
            System.out.printf("The number %d is even.\n",n);
            return;
        }
        System.out.printf("The number %d is odd.\n",n);
    }
}
