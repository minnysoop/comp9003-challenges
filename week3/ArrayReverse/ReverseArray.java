import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;

public class ReverseArray {
    public static void main(String[] args) {
        File file = new File(args[0]);
        try {
            Scanner scanner = new Scanner(file);
            String s = scanner.nextLine();
            char[] c = s.toCharArray();

            int n = c.length/2;
            int m = c.length-1;
            for (int i = 0; i < n; i++) {
                char t = c[i];
                c[i] = c[m];
                c[m] = t;
                m--; 
            }
            String res = "";
            for (int i = 0; i < c.length; i++) {
                res += c[i];
            }

            try {
                FileWriter myWriter = new FileWriter(args[1]);
                myWriter.write(res);
                myWriter.write("\n");
                myWriter.close();
            System.out.println();
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
