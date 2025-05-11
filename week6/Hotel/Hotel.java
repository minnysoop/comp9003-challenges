import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.StringBuilder;

public class Hotel {

    private static void printRoom(HashMap<String, String[]>hm, String key) {
        String[] doors = hm.get(key);
        System.out.println(key);
        // NORTH
        if (doors[0] != null) { System.out.println(" ---N--- ");
        } else {System.out.println(" ------- ");}

        // EAST AND WEST
        System.out.println("|       |\n|       |");
        if (doors[2] != null && doors[3] != null) {System.out.println("W       E");}
        else if (doors[2] != null) {System.out.println("|       E");}
        else if (doors[3] != null) {System.out.println("W       |");}
        else {System.out.println("|       |");}
        System.out.println("|       |\n|       |");

        // SOUTH 
        if (doors[1] != null) { System.out.println(" ---S--- ");
        } else {System.out.println(" ------- ");}
    }
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No Level File Specified");
            System.exit(1);
        }
        HashMap<String, Integer>directions = new HashMap<String, Integer>();
        directions.put("NORTH", 0);
        directions.put("SOUTH", 1);
        directions.put("EAST", 2);
        directions.put("WEST", 3);

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            HashMap<String, String[]>hm = new HashMap<String, String[]>();
            String[] levels = scanner.nextLine().split(" ");
            for (int i = 0; i < levels.length; i++) {
                hm.put(levels[i], new String[4]);
            }

            while (scanner.hasNextLine()) {
                String[] in = scanner.nextLine().split(" ");
                String[] tmp = hm.get(in[0]);
                tmp[directions.get(in[2])] = in[4];
                hm.put(in[0], tmp);
            }

            Scanner scanner1 = new Scanner(System.in);
            String user_in_room = levels[0];
            System.out.println();
            printRoom(hm, user_in_room);
            System.out.println();
            while (true) {
                String[] can_get_to = hm.get(user_in_room);

                String user_in = scanner1.next();
                if (user_in.equals("QUIT")) { return; }

                if (user_in.equals("NORTH")) {
                    if (can_get_to[0] != null) {
                        user_in_room = can_get_to[0];
                    } else {
                        System.out.println("No Path This Way");
                    }
                } else if (user_in.equals("SOUTH")) {
                    if (can_get_to[1] != null) {
                        user_in_room = can_get_to[1];
                    } else {
                        System.out.println("No Path This Way");
                    }
                } else if (user_in.equals("EAST")) {
                    if (can_get_to[2] != null) {
                        user_in_room = can_get_to[2];
                    } else {
                        System.out.println("No Path This Way");
                    }
                } else if (user_in.equals("WEST")) {
                    if (can_get_to[3] != null) {
                        user_in_room = can_get_to[3];
                    } else {
                        System.out.println("No Path This Way");
                    }
                } else {
                    System.out.println("What?");
                }

                System.out.println();
                printRoom(hm, user_in_room);
                System.out.println();
            }
            

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
