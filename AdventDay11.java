import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay11 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day11Input");
        String[] split_sample = fileData.get(0).split(" ");
        ArrayList<Long> stones = new ArrayList<>();
        for (int i = 0; i < split_sample.length; i++) {
            stones.add(Long.parseLong(split_sample[i]));
        }
        int count = 0;
        while (count != 25) {
            stones = changeStone(stones);
            count++;
        }
        System.out.println(stones.size());
        System.out.println(fileData);
    }

    public static ArrayList<Long> changeStone(ArrayList<Long> stones) {
        for (int i = 0; i < stones.size(); i++) {
            if (stones.get(i) == 0) {
                stones.set(i, 1L);
            }
            else if (stones.get(i).toString().length() % 2 == 0) {
                Long num1 = Long.parseLong(stones.get(i).toString().substring(0, stones.get(i).toString().length() / 2));
                Long num2 = Long.parseLong(stones.get(i).toString().substring(stones.get(i).toString().length() / 2));
                stones.set(i, num1);
                stones.add(i + 1, num2);
                i++;
            }
            else {
                stones.set(i, stones.get(i) * 2024);
            }
        }
        return stones;
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