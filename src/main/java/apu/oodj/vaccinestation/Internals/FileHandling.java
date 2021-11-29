package apu.oodj.vaccinestation.Internals;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
    public static String getSavePath() {
        String prefixWith = "";
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            prefixWith = ".";
        };

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path savePath = Paths.get(currentPath.toString(), prefixWith + "appdata");
        try {
            Files.createDirectories(savePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savePath.toString();
    }

    public static String BuildPath(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }
        return Paths.get(getSavePath(), fileName).toString();
    }

    public static Boolean FileExist(String fileName) {
        return Files.exists(Paths.get(BuildPath(fileName)));
    }

    public static String[] ReadFile(String fileName) throws IOException {
        String path = BuildPath(fileName);
        File fp = new File(path);
        Scanner reader = new Scanner(fp);
        List<String> lines = new ArrayList<>();
        while (reader.hasNextLine()) {
            String data = reader.nextLine().trim();
            if (data == "") {
                continue;
            }
            lines.add(data);
        }
        reader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public static void WriteString(String fileName, String text) throws IOException {
        String path = BuildPath(fileName);
        FileWriter fw = new FileWriter(path, true);
        PrintWriter pl = new PrintWriter(fw);
        pl.println(text);
        pl.close();
        fw.close();
    }

    public static void WriteString(String fileName, String text, Boolean append) throws IOException {
        String path = BuildPath(fileName);
        FileWriter fw = new FileWriter(path, append);
        PrintWriter pl = new PrintWriter(fw);
        pl.println(text);
        pl.close();
        fw.close();
    }

    public static void WriteString(String fileName, String[] texts) throws IOException {
        String path = BuildPath(fileName);
        FileWriter fw = new FileWriter(path, true);
        PrintWriter pl = new PrintWriter(fw);
        for (String text : texts) {
            pl.println(text);
        }
        pl.close();
        fw.close();
    }

    public static void WriteString(String fileName, String[] texts, Boolean append) throws IOException {
        String path = BuildPath(fileName);
        FileWriter fw = new FileWriter(path, append);
        PrintWriter pl = new PrintWriter(fw);
        for (String text : texts) {
            pl.println(text);
        }
        pl.close();
        fw.close();
    }

    public static void WriteString(String fileName, List<String> texts) throws IOException {
        String path = BuildPath(fileName);
        FileWriter fw = new FileWriter(path, true);
        PrintWriter pl = new PrintWriter(fw);
        for (String text : texts) {
            pl.println(text);
        }
        pl.close();
        fw.close();
    }

    public static void WriteString(String fileName, List<String> texts, Boolean append) throws IOException {
        String path = BuildPath(fileName);
        FileWriter fw = new FileWriter(path, append);
        PrintWriter pl = new PrintWriter(fw);
        for (String text : texts) {
            pl.println(text);
        }
        pl.close();
        fw.close();
    }

    public static void ReplaceLine(String fileName, long index, String newText) throws IOException {
        String[] lines = ReadFile(fileName);
        if (index >= lines.length) {
            WriteString(fileName, newText);
            return;
        }
        lines[(int) index] = newText;
        WriteString(fileName, lines, false);
    }

    public static void ReplaceById(String fileName, String id, String newText) throws IOException {
        String[] lines = ReadFile(fileName);
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith(id)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            lines[index] = newText;
            WriteString(fileName, lines, false);
        } else {
            WriteString(fileName, newText);
        }
    }

    public static void RemoveById(String fileName, String id) throws IOException {
        String[] lines = ReadFile(fileName);
        ArrayList<String> newLines = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith(id)) {
                continue;
            }
            newLines.add(lines[i]);
        }
        WriteString(fileName, newLines, false);
    }

    public static void main(String[] args) {
        try {
            String[] data = ReadFile("test.txt");
            for (String line : data) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
