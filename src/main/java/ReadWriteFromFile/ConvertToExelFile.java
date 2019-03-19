package ReadWriteFromFile;

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

        listOfFilesToConvert();

    }

//        Get list all files to convert from directory
    private static List<String> listOfFilesToConvert() {
        List<String> errorList = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get(PathToFolderWithFiles))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorList;
    }
}