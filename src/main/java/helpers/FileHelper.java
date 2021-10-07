package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper {
    private static File file;
    private static FileWriter fileWriter;

    public static String generateAndGetCurrentDate() {
        DateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return dataFormat.format(date).replace(":", "_").replace("-", "_");
    }

    public static void createFile(String path) {
        file = new File(path + generateAndGetCurrentDate() + ".txt");
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String textToWrite) {
        try {
            fileWriter.write(textToWrite + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWriter() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileWriter getFileWriter() {
        return fileWriter;
    }
}
