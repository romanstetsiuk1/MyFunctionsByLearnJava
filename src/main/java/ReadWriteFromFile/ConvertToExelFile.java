package ReadWriteFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ConvertToExelFile {

    private static String PathToFolderWithFiles = "C:\\Users\\roman.stetsiuk\\Desktop\\ConvertTest";

    public static void main(String[] args) {

        List<String> fileToConvertList = listOfFilesToConvert();

        for (String file : fileToConvertList) {
            System.out.println(file);

//            Read lines from files
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String currentLine;

                while ((currentLine = bufferedReader.readLine()) != null) {
                    System.out.println(currentLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //        Get list all files to convert from directory
    private static List<String> listOfFilesToConvert() {
        List<String> errorList = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get(PathToFolderWithFiles))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorList;
    }
}