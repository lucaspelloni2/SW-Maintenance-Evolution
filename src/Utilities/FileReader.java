package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by LuckyP on 29.09.17.
 */
public abstract class FileReader {

    public static List<String> readFile(String filepath) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
            list = stream
                    //.filter(line -> !line.startsWith("line3"))
                    //.map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
