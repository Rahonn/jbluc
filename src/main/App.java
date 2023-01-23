package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import bluc.engine.Commands;
import bluc.engine.codes.base.Basecode;
import print.PrintableColors;
import print.Printer;

public class App {

    private String[] args;

    public App(String[] args) {

        this.args = args;

    }

    public void run() {

        if (this.args.length == 0) {

            this.help();

        } else if (this.args[0].equalsIgnoreCase("-i")) {

            this.runCode();

        }

    }

    public void help() {

        Printer.println("This mode has not been writen yet...", PrintableColors.RED);

    }

    public void runCode() {

        ArrayList<String> lines = new ArrayList<String>();
        
        try {
            
            FileReader fr = new FileReader(new File(this.args[1]));
    
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                lines.add(line);

            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            Printer.println("Can't find file " + this.args[1], PrintableColors.RED);
        } catch (IOException e) {
            Printer.println(e.toString(), PrintableColors.RED);
        }

        for (int i = 0; i < lines.size(); i++) {

            Basecode cmd = Commands.getCommand(lines.get(i), null);

            boolean good = cmd.run();

            if (!good) {

                Printer.println("\nError!!!\n", PrintableColors.RED);
                System.out.println(lines.get(i));
                Printer.println("\n^\n| Error on this line\n", PrintableColors.BLUE);
                System.exit(0);

            }

        }


    }

}
