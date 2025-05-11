import java.util.Scanner;

public class Greet {
    public static void main(String[] args){
        System.out.print("Enter your name: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
