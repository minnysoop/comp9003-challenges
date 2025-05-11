import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Palette {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No Filename Specified");
            return;
        }
        
        File file = new File(args[0]);
        try {
            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            try {
                fis.read(bytes);

                byte[] width = new byte[4];
                width[0] = bytes[3];
                width[1] = bytes[2];
                width[2] = bytes[1];
                width[3] = bytes[0];
                BigInteger big_int_width = new BigInteger(1, width);

                byte[] height = new byte[4];
                height[0] = bytes[7];
                height[1] = bytes[6];
                height[2] = bytes[5];
                height[3] = bytes[4];
                BigInteger big_int_height = new BigInteger(1, height);

                byte[] magic = new byte[2];
                magic[0] = bytes[9];
                magic[1] = bytes[8];
                BigInteger magic_number_in_decimal = new BigInteger(1, magic);
                if (!magic_number_in_decimal.equals(BigInteger.valueOf(60535))) {
                    System.out.println("Invalid Image Header");
                    System.exit(1);
                }

                int w = big_int_width.intValue();
                int h = big_int_height.intValue();

                if (w*h*4 != file.length()-10) {
                    System.out.println("Invalid Image Data");
                    System.exit(1);
                }

                Map<BigInteger, Integer> color_map = new HashMap<>();
                Integer value = 0;
                Integer[][] matrix = new Integer[w][h];

                int t1 = 0;
                int t2 = 0;
                for (int i = 10; i < w*h*4+10; i += 4) {
                    byte[] img_data = new byte[4];
                    img_data[3] = bytes[i];
                    img_data[2] = bytes[i+1];
                    img_data[1] = bytes[i+2];
                    img_data[0] = bytes[i+3];
                    BigInteger pixel = new BigInteger(1, img_data);

                    if (!color_map.containsKey(pixel)) {
                        color_map.put(pixel, value);
                        value++;  
                    } 

                    matrix[t1][t2] = color_map.get(pixel);
                    t2++;
                    if (t2 == w) {
                        t1++;
                        t2=0;
                    }

                }

                // Print Output 
                for (int i = 0; i < w; i++) {
                    System.out.print("[ ");
                    for (int j = 0; j < h; j++) {
                        if (j < h-1) System.out.print(matrix[i][j] + ", ");
                        else System.out.print(matrix[i][j]);
                    }
                    System.out.println(" ]");
                }
               
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Does Not Exist");
        }
    }
    
}
