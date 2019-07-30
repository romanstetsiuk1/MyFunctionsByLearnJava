package ReadWriteFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalizeDatasFromFiles {

    public static void main(String[] args) {

        String filesDirectory = "C:\\Users\\roman.stetsiuk\\Documents\\VK\\XTB_raports";
        String filesDoneDirectory = "C:\\Users\\roman.stetsiuk\\Documents\\VK\\XTB_raports\\DONE\\";

        //        Get list of file in PC directory
        File directory = new File(filesDirectory);
        File[] filesList = directory.listFiles();

        for (File file : filesList) {
            if (file.isFile()) {
                //            Read lines from files
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    String currentLine;

                    while ((currentLine = bufferedReader.readLine()) != null) {
                        System.out.println(currentLine);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //            move file on new Directory
                try {
                    file.renameTo(new File(filesDoneDirectory + "DONE_" + file.getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
