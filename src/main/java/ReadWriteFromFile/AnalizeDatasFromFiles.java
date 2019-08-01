package ReadWriteFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AnalizeDatasFromFiles {

    public static void main(String[] args) {

        String endOfDay = "";

        String balance = "";
        String equity = "";
        String margin = "";
        String freeMargin = "";

        int actionNumber = 0;
        int closedTransactions = 0;
        int openTransactions = 0;


        String filesDirectory = "C:\\Users\\roman.stetsiuk\\Documents\\VK\\XTB_raports";
        String filesDoneDirectory = "C:\\Users\\roman.stetsiuk\\Documents\\VK\\XTB_raports\\DONE\\";

        //        Get list of file in PC directory
        File directory = new File(filesDirectory);
        File[] filesList = directory.listFiles();

//        Logfile
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            fh = new FileHandler("C:\\Users\\roman.stetsiuk\\IdeaProjects\\MyFunctionsByLearnJava\\logs\\LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (File file : filesList) {
            if (file.isFile()) {
                //            Read lines from files
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    String currentLine;

                    while ((currentLine = bufferedReader.readLine()) != null) {
//                        Get Date raport and write this information in LogFile
                        if (currentLine.contains("End of day")) {
                            endOfDay = currentLine;
                            endOfDay.trim();
                            logger.info("\n**********************************************************\n" +
                                    endOfDay +
                                    "\n**********************************************************\n");
                        }
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
