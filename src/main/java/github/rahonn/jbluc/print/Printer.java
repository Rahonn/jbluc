package github.rahonn.jbluc.print;

public class Printer {
    
    public static <T> void println(T data, PrintableColors color) {

        System.out.println(String.format("%s%s%s", color.getStart(), data.toString(), color.getEnd()));

    }

    public static <T> void print(T data, PrintableColors color) {

        System.out.print(String.format("%s%s%s", color.getStart(), data.toString(), color.getEnd()));

    }

    public static <T> String format(T data, PrintableColors color) {


        return String.format("%s%s%S", color.getStart(), data.toString(), color.getEnd());

    }

}
