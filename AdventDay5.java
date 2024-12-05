import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay5 {
    public static void main(String[] args) {

        ArrayList<String> fileData1 = getFileData("src/sample");
        ArrayList<String> fileData2 = getFileData("src/input");
        ArrayList<Integer> leftNum = new ArrayList<>();
        ArrayList<Integer> rightNum = new ArrayList<>();
        ArrayList<Integer> order = new ArrayList<>();
        Boolean works = true;
        int total = 0;
        for (int i = 0; i < fileData2.size(); i++) {
            leftNum.add(Integer.parseInt(fileData2.get(i).substring(0, 2)));
            rightNum.add(Integer.parseInt(fileData2.get(i).substring(3)));
        }
        for (int i = 0; i < fileData1.size(); i++) {
            for (int j = 0; j < fileData1.get(i).length(); j++) {
                String[] split_sample = fileData1.get(i).split(",");
                for (int k = 0; k < split_sample.length; k++) {
                    order.add(Integer.parseInt(split_sample[k]));
                }
                for (int k = 0; k < order.size(); k++) {
                    int num1 = order.get(k);
                    for (int m = 0; m < leftNum.size(); m++) {
                        int num2 = leftNum.get(m);
                        int num3 = rightNum.get(m);
                        if (num1 == num2) {
                            for (int x = k; x > order.size(); x--) {
                                if (order.get(x) == num3) {
                                    works = false;
                                }
                            }
                        }
                    }
                }
                if (works) {
                    total += order.get(order.size() / 2);
                }
                order = new ArrayList<>();
                works = true;
            }
        }
        System.out.println(leftNum);
        System.out.println(rightNum);
        System.out.println(total);
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