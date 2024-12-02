import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input");
        ArrayList<Integer> leftNum = new ArrayList<>();
        ArrayList<Integer> rightNum = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] split_sample = fileData.get(i).split("   ");
            leftNum.add(Integer.parseInt(split_sample[0]));
            rightNum.add(Integer.parseInt(split_sample[1]));

        }
        Collections.sort(leftNum);
        Collections.sort(rightNum);
        for (int i = 0; i < leftNum.size(); i++) {
            total += Math.abs(leftNum.get(i) - rightNum.get(i));
        }
        System.out.println(total);
        System.out.println(leftNum);
        System.out.println(rightNum);
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