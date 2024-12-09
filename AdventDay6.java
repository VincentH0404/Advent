import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay6 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input");
        int x = 0;
        int y = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).charAt(j) == '^') {
                    x = j;
                    y = i;
                }
            }
        }
        System.out.println(fileData.get(y).charAt(x));
        Boolean move_up = true;
        Boolean move_down = false;
        Boolean move_right = false;
        Boolean move_left = false;
        while (x != 0 || x != fileData.size() - 1 || y != 0 || y != fileData.get(0).length()) {
            if (move_up) {
                if (fileData.get(y - 1).charAt(x) == '#') {
                    move_up = false;
                    move_right = true;
                } else {
                    String str = "";
                    str += fileData.get(y).substring(0, x);
                    str += "X";
                    str += fileData.get(y).substring(x + 1);
                    fileData.set(y, str);
                    y--;
                }
            }
            if (move_right) {
                if (fileData.get(y).charAt(x+1) == '#') {
                    move_right = false;
                    move_down = true;
                }
                else {
                    String str = "";
                    str += fileData.get(y).substring(0, x);
                    str += "X";
                    str += fileData.get(y).substring(x+1);
                    fileData.set(y, str);
                    x++;
                }
            }
            if (move_down) {
                if (fileData.get(y+1).charAt(x) == '#') {
                    move_down = false;
                    move_left = true;
                }
                else {
                    String str = "";
                    str += fileData.get(y).substring(0, x);
                    str += "X";
                    str += fileData.get(y).substring(x+1);
                    fileData.set(y, str);
                    y++;
                }
            }
            if (move_left) {
                if (fileData.get(y).charAt(x-1) == '#') {
                    move_left = false;
                    move_up = true;
                }
                else {
                    String str = "";
                    str += fileData.get(y).substring(0, x);
                    str += "X";
                    str += fileData.get(y).substring(x+1);
                    fileData.set(y, str);
                    x--;
                }
            }
            for (int k = 0; k < fileData.size(); k++) {
                System.out.println(fileData.get(k));
            }
        }
        for (int k = 0; k < fileData.size(); k++) {
            System.out.println(fileData.get(k));
        }

    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
