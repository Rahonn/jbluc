package main;

import print.PrintableColors;
import print.Printer;

public class App {

    private String[] args;


    public App(String[] args) {

        this.args = args;


    }

    public void run() {

        Printer.println("Hello World!", PrintableColors.RED);
        Printer.println("Hello World!", PrintableColors.GREEN);
        Printer.println("Hello World!", PrintableColors.BLACK);
        Printer.println("Hello World!", PrintableColors.YELLOW);
        Printer.println("Hello World!", PrintableColors.BLUE);
        Printer.println("Hello World!", PrintableColors.PURPLE);
        Printer.println("Hello World!", PrintableColors.CYAN);
        Printer.println("Hello World!", PrintableColors.WHITE);


    }


}
