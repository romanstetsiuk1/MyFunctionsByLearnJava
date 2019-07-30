package ReadWriteFromFile;

import java.io.File;

public class AnalizeDatasFromFiles {

    public static void main(String[] args) {

        String filesDirectory = "C:\\Users\\roman.stetsiuk\\Documents\\VK\\XTB_raports";

        //        Get list of file in PC directory
        File directory = new File(filesDirectory);
        File[] filesList = directory.listFiles();

        for (File file : filesList){
            System.out.println(file);
        }

    }

}
