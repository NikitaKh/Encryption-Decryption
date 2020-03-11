package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String mode = "enc";
        char[] data = "".toCharArray();
        Boolean isFile = false;
        int key = 0;
        String fileName = "";

        for (int i = 0; i < args.length; i += 2) {
            if (args.length % 2 != 0 || args[i + 1].charAt(0) == '-') {
                System.out.println("Error! Specify arguments!");
                return;
            }

            if ("-mode".equals(args[i])) {
                mode = args[i + 1];

            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);

            } else if ("-data".equals(args[i])) {
                data = args[i + 1].toCharArray();

            } else if ("-in".equals(args[i]) && !Arrays.asList(args).contains("-data")) {
                data = fromFile(data, args[i + 1]);
                if (data.length == 0) {
                    return;
                }

            } else if ("-out".equals(args[i])) {
                fileName = args[i + 1];
                isFile = true;
            }

        }

        if (isFile) {
            mode(data, mode, key);
            toFile(data, fileName);
            return;
        }

        mode(data, mode, key);
        System.out.println(data);
    }

    static void mode(char[] data, String mode, int key) {
        for (int i = 0; i < data.length; i++) {
            if ("enc".equals(mode)) {
                data[i] = (char) (data[i] + key);
            } else if ("dec".equals(mode)) {
                data[i] = (char) (data[i] - key);
            }
        }
    }

    static char[] fromFile(char[] data, String fileName) throws IOException {
        File file = new File(fileName);

        if (file.isFile() || file.isHidden()) {
            try (Scanner tmp = new Scanner(file)) {
                while (tmp.hasNext()) {
                    data = tmp.nextLine().toCharArray();
                }
            }
        } else {
            System.out.println("Error! File not found.");
            return new char[0];
        }
        return data;
    }

    static void toFile(char[] data, String fileName) throws IOException {
        File file = new File(fileName);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(data);
        }
    }
}