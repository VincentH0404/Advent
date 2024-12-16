import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay13 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day13Input");
        for (int i = 0; i < fileData.size(); i+=3) {
            String[] sampleA = new String[4];
            String[] sampleB = new String[4];
            String[] sampleP = new String[3];
            sampleA = fileData.get(i).split(" ");
            sampleB = fileData.get(i+1).split(" ");
            sampleP = fileData.get(i+2).split(" ");

            int Ax = Integer.parseInt(sampleA[2].substring(2, 4));
            int Bx = Integer.parseInt(sampleB[2].substring(2, 4));
            int Ay = Integer.parseInt(sampleA[3].substring(2, 4));
            int By = Integer.parseInt(sampleB[3].substring(2, 4));
            int Px = Integer.parseInt(sampleP[1].substring(sampleP[1].indexOf("=") + 1, sampleP[1].indexOf(",")));
            int Py = Integer.parseInt(sampleP[2].substring(sampleP[2].indexOf("=") + 1));

            System.out.println(Ax);
            System.out.println(Bx);
            System.out.println(Px);
        }




        System.out.println(fileData.get(0));
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