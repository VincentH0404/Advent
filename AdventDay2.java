import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventDay2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input");
        int safe = 0;
        Boolean isIncrease = true;
        int inc = 0;
        int dec = 0;
        Boolean checked = false;
        Boolean isSafe = true;
        for (int i = 0; i < fileData.size(); i++) {
            String[] split_sample = fileData.get(i).split(" ");
            isSafe = true;
            checked = false;
            for (int j = 1; j < split_sample.length; j++) {
                int difference = Integer.parseInt(split_sample[j-1]) - Integer.parseInt(split_sample[j]);
                if (!checked) {
                    if (difference > 0) {
                        isIncrease = true;
                    }
                    if (difference < 0) {
                        isIncrease = false;
                    }
                    checked = true;
                }
                if (difference > 0) {
                    inc++;
                }
                if (difference < 0) {
                    dec++;
                }
                if ((isIncrease && difference < 0) || difference < -3 || difference == 0) {
                    isSafe = false;
                }
                if ((!isIncrease && difference > 0) || difference > 3 || difference == 0) {
                    isSafe = false;
                }
            }
            if (isSafe) {
                safe++;
            }
        }
        System.out.println(safe);
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
