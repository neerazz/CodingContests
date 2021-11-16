package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class MyTool {

    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Time Needed to Buy Tickets3\n" +
                        "Reverse Nodes in Even Length Groups4\n" +
                        "Decode the Slanted Ciphertext5\n" +
                        "Process Restricted Friend Requests"
        );
//        printCamelCase(
//                "Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold"
////                "Product of Array Except Self",
//        );
        getReplaced(
                Arrays.asList("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]"),
                Arrays.asList("[", "{"),
                Arrays.asList("\"", "'"),
                Arrays.asList("]", "}")
        ).forEach(System.out::println);
    }

    static int getMax(int[] counts){
        return Arrays.stream(counts).max().getAsInt();
    }

    private static List<String> getContest(String input) {
        String[] strings = input.split("\n");
        List<String> names = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            names.add(getCamelCase(i != strings.length - 1 ? strings[i].substring(0, strings[i].length() - 1) : strings[i]));
        }
        names.forEach(System.out::println);
        return names;
    }

    private static void printCamelCase(String... input) {
        Arrays.stream(input).map(MyTool::getCamelCase).forEach(System.out::println);
    }

    private static String getCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (sb.length() == 0 && Character.isDigit(c)) {
                    continue;
                } else if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(c);
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    private static List<String> getReplaced(List<String> input, List<String>... replaces) {
        return input.parallelStream().map(val -> getReplaced(val, replaces)).collect(Collectors.toList());
    }

    private static String getReplaced(String input) {
        return input
                .replace("[", "{")
                .replace("]", "}")
                .replace("\"", "'");
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
