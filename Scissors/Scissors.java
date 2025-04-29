import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;


public class Scissors {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] tmp = s.split(" ");
                System.out.println(tmp[n-1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
