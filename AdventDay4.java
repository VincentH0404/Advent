import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/sample");
        int count = 0;
        System.out.println(fileData);
        for (int i = 0; i < fileData.size(); i++) {
            String line = fileData.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'X') {
                    if (j <= line.length() - 4) {
                        if (line.charAt(j+1) == 'M' && line.charAt(j+2) == 'A' && line.charAt(j+3) == 'S') {
                            count++;
                        }
                    }
                    if (j >= 3) {
                        if (line.charAt(j-1) == 'M' && line.charAt(j-2) == 'A' && line.charAt(j-3) == 'S') {
                            count++;
                        }
                    }
                    if (i <= fileData.size() - 4) {
                        if (fileData.get(i + 1).charAt(j) == 'M' && fileData.get(i + 2).charAt(j) == 'A' && fileData.get(i + 3).charAt(j) == 'S') {
                            count++;
                        }
                        if (j <= line.length() - 4) {
                            if (fileData.get(i + 1).charAt(j+1) == 'M' && fileData.get(i + 2).charAt(j+2) == 'A' && fileData.get(i + 3).charAt(j+3) == 'S') {
                                count++;
                            }
                        }
                        if (j >= 3) {
                            if (fileData.get(i + 1).charAt(j-1) == 'M' && fileData.get(i + 2).charAt(j-2) == 'A' && fileData.get(i + 3).charAt(j-3) == 'S') {
                                count++;
                            }
                        }
                    }
                    if (i >= 3) {
                        if (fileData.get(i - 1).charAt(j) == 'M' && fileData.get(i - 2).charAt(j) == 'A' && fileData.get(i - 3).charAt(j) == 'S') {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
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