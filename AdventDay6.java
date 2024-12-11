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
        Boolean move_up = true;
        Boolean move_down = false;
        Boolean move_right = false;
        Boolean move_left = false;
        String str = "";
        str += fileData.get(y).substring(0, x);
        str += "X";
        str += fileData.get(y).substring(x + 1);
        fileData.set(y, str);
        while (y != fileData.size() - 1 && y != 0 && x != fileData.get(0).length() && x != 0) {
            if (move_up) {
                if (fileData.get(y - 1).charAt(x) == '#') {
                    move_up = false;
                    move_right = true;
                } else {
                    str = "";
                    str += fileData.get(y-1).substring(0, x);
                    str += "X";
                    str += fileData.get(y-1).substring(x + 1);
                    fileData.set(y-1, str);
                    y--;
                }
            }
            if (move_right) {
                if (fileData.get(y).charAt(x+1) == '#') {
                    move_right = false;
                    move_down = true;
                }
                else {
                    str = "";
                    str += fileData.get(y).substring(0, x+1);
                    str += "X";
                    str += fileData.get(y).substring(x+2);
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
                    str = "";
                    str += fileData.get(y+1).substring(0, x);
                    str += "X";
                    str += fileData.get(y+1).substring(x+1);
                    fileData.set(y+1, str);
                    y++;
                }
            }
            if (move_left) {
                if (fileData.get(y).charAt(x-1) == '#') {
                    move_left = false;
                    move_up = true;
                }
                else {
                    str = "";
                    str += fileData.get(y).substring(0, x-1);
                    str += "X";
                    str += fileData.get(y).substring(x);
                    fileData.set(y, str);
                    x--;
                }
            }
        }
        int count = 0;
        for (int k = 0; k < fileData.size(); k++) {
            for (int m = 0; m < fileData.get(k).length(); m++) {
                if (fileData.get(k).charAt(m) == 'X') {
                    count++;
                }
            }
        }
        System.out.println(count);
        fileData = getFileData("src/Day6Input");
        count = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).charAt(j) == '^') {
                    x = j;
                    y = i;
                }
            }
        }
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                str = "";
                str += fileData.get(i).substring(0, j);
                str += "#";
                str += fileData.get(i).substring(j+1);
                fileData.set(i, str);
                if (doesLoop(x, y, fileData)) {
                    count++;
                }
                fileData = getFileData("src/Day6Input");
            }
        }
        System.out.println(count);
    }

    public static Boolean doesLoop(int x, int y, ArrayList<String> fileData) {
        Boolean move_up = true;
        Boolean move_down = false;
        Boolean move_right = false;
        Boolean move_left = false;
        int retry = 0;
        int original_x = x;
        int original_y = y;
        String str = "";
        str += fileData.get(y).substring(0, x);
        str += "X";
        str += fileData.get(y).substring(x + 1);
        fileData.set(y, str);
        while (y != fileData.size() - 1 && y != 0 && x != fileData.get(0).length() - 1 && x != 0 && retry != 500000) {
            if (move_up) {
                if (fileData.get(y - 1).charAt(x) == '#') {
                    move_up = false;
                    move_right = true;
                } else {
                    str = "";
                    str += fileData.get(y-1).substring(0, x);
                    str += "X";
                    str += fileData.get(y-1).substring(x + 1);
                    fileData.set(y-1, str);
                    y--;
                }
            }
            if (move_right) {
                if (fileData.get(y).charAt(x+1) == '#') {
                    move_right = false;
                    move_down = true;
                }
                else {
                    str = "";
                    str += fileData.get(y).substring(0, x+1);
                    str += "X";
                    str += fileData.get(y).substring(x+2);
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
                    str = "";
                    str += fileData.get(y+1).substring(0, x);
                    str += "X";
                    str += fileData.get(y+1).substring(x+1);
                    fileData.set(y+1, str);
                    y++;
                }
            }
            if (move_left) {
                if (fileData.get(y).charAt(x-1) == '#') {
                    move_left = false;
                    move_up = true;
                }
                else {
                    str = "";
                    str += fileData.get(y).substring(0, x-1);
                    str += "X";
                    str += fileData.get(y).substring(x);
                    fileData.set(y, str);
                    x--;
                }
            }
            retry++;
        }
        if (retry == 500000) {
            return true;
        }
        return false;
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
