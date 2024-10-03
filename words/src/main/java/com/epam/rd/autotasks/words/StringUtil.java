package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringUtil {

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if((words == null || words.length == 0) || (sample == null) || sample.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for(String word : words) {
            if(word.trim().equalsIgnoreCase(sample.trim())) {
                sum += 1;
            }
        }
        return sum;
    }

    public static String[] splitWords(String text) {
        if(text == null || text.isEmpty()) {
            return null;
        }
        if (text.matches("[,.;:!?\\s]+")) {
            return null;
        }

        String[] output = text.trim().split("[,.;:!?\\s]+");

        if(output.length == 0) {
            return null;
        }

        if(output[0].equals("")) {
            return Arrays.copyOfRange(output, 1, output.length);
        }
        return output;
    }

        public static String convertPath (String path,boolean toWin){
            if (path == null || path.isEmpty()) {
                return null;
            }

            if (!isValidPath(path)) {
                return null;
            }

            boolean isUnix = isUnixPath(path);
            boolean isWindows = isWindowsPath(path);


            if (isWindows && toWin) {
                return path;
            }
            if (isUnix && !toWin) {
                return path;
            }

            if (toWin) {
                return unixToWindows(path);
            } else {
                return windowsToUnix(path);
            }
        }
    private static boolean isValidPath(String path) {

        if (path.contains("/~/") || path.contains("\\~") || path.contains("~~")) {
            return false;
        }
        if ((path.startsWith("~\\") || path.endsWith("~")) && path.length() > 1) {
            return false;
        }
        if (path.contains("C:") && (path.startsWith("/") || path.contains("/C:"))) {
            return false;
        }
        if (path.contains("\\") && path.contains("/")) {
            return false;
        }
        if (path.matches(".*[\\\\/]{2,}.*")) {
            return false;
        }

        if (path.matches(".*C:.*C:.*")) {
            return false;
        }

        return true;
    }

    private static String  windowsToUnix(String path) {
        if (path.startsWith("C:\\User")) {
            path = path.replaceFirst("C:\\\\User", "~");
        }
        if (path.startsWith("C:\\")) {
            path = path.replaceFirst("C:\\\\", "/");
        }
        path = path.replace("\\", "/");
        return path;
    }

    public static String unixToWindows(String path) {
        if (path.startsWith("~")) {
            path = path.replaceFirst("~", "C:\\\\User");
        } else if (path.startsWith("/")) {
            path = path.replaceFirst("/", "C:\\\\");
        }
        path = path.replace("/", "\\");
        return path;
    }

    private static boolean isWindowsPath(String path) {
        if (path.startsWith("C:") || path.startsWith("\\")) {
            String[] parts = path.split("\\\\");
            for (String part : parts) {
                if (!part.isEmpty() && !part.equals(".") && !part.equals("..")) {
                    if (part.contains("/")) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isUnixPath(String path) {
        if (path.startsWith("/") || path.startsWith("~")) {
            String[] parts = path.split("/");
            for (String part : parts) {
                if (!part.isEmpty() && !part.equals(".") && !part.equals("..")) {
                    if (part.contains("\\")) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static String joinWords(String[] words) {
        if(words == null || words.length == 0) {
            return null;
        }
        int emptyWords = 0;
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for(String word : words) {
            if(!word.isEmpty()) {
                joiner.add(word);
            }else {
                emptyWords++;
            }
        }
        if(emptyWords == words.length) {
            return null;
        }

        return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "~";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}