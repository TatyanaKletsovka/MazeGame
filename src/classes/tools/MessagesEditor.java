package classes.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MessagesEditor {

    private static final int MESSAGE_LENGTH = 120;

    public static void printInCommandFrame(String[] messages) {
        printMessagesInFrame(messages, '=', ':');
    }

    public static void printInInformationFrame(String[] messages) {
        printMessagesInFrame(messages, '-', '|');

    }

    public static void printInEventFrame(String[] messages) {
        printMessagesInFrame(messages, '+', '+');

    }

    private static void printMessagesInFrame(String[] messages, char line, char column) {
        printFrame(line);
        for (String message:messages) {
            int correction = 0;
            if (message.length() % 2 == 1) {
                correction = 1;
            }
            int count = (MESSAGE_LENGTH - 2 - message.length()) / 2;

            System.out.print(column);
            IntStream.range(0, count + correction).forEach(n -> System.out.print(" "));
            System.out.print(message);
            IntStream.range(0, count).forEach(n -> System.out.print(" "));
            System.out.print(column);
            System.out.println();
        }
        printFrame(line);
    }

    private static void printFrame(char symbol) {
        IntStream.range(0, MESSAGE_LENGTH).forEach(n -> System.out.print(symbol));
        System.out.println();
    }

    public static void printInputSymbols(){
        System.out.print("---> ");
    }

    public static String[] joinArrays(String[]... messages) {
        List<String> list = new ArrayList<>();
        for(String[] message : messages){
            list.addAll(Arrays.asList(message));
        }
        return list.toArray(String[]::new);
    }
}
