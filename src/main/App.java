package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import bluc.engine.Commands;
import bluc.engine.codes.Input;
import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.VarMamager;
import print.PrintableColors;
import print.Printer;

public class App {

    public static final String VERSION = "11.0.0";
    public static final String JBLUC = "1.0.0";

    private String[] args;
    private static VarMamager varmamager = new VarMamager();

    public App(String[] args) {

        this.args = args;

    }

    public void run() {

        if (this.args.length == 0) {

            Printer.println("Welcome to JBLUC (Java BLUC)!", PrintableColors.GREEN);

            this.help();

        } else if (this.args[0].equalsIgnoreCase("-i")) {

            this.runCode(this.args[1]);

        } else if (this.args[0].equalsIgnoreCase("-h") || this.args[0].equalsIgnoreCase("-help") || this.args[0].equalsIgnoreCase("--help") || this.args[0].equalsIgnoreCase("--h")) {

            this.help();

        } else if (this.args[0].equalsIgnoreCase("-v") || this.args[0].equalsIgnoreCase("-version") || this.args[0].equalsIgnoreCase("--version") || this.args[0].equalsIgnoreCase("--v")) {

            this.version();

        } else if (this.args[0].equalsIgnoreCase("-d")) {

            Printer.println("Running code...\n", PrintableColors.BLUE);

            System.out.print(PrintableColors.GREEN.getStart());
            this.runCode(this.args[1]);
            System.out.print(PrintableColors.GREEN.getEnd());

            System.out.println();

            App.varmamager.varDump();

            Printer.print("\nIs this ok? (y or n): ", PrintableColors.BLUE);

            System.out.print(PrintableColors.BLUE.getStart());
            String res = Input.scanner.nextLine();
            System.out.print(PrintableColors.BLUE.getEnd());

            if (res.equalsIgnoreCase("y")) {

                Printer.println("Thanks for using JBLUC", PrintableColors.BLUE);

            } else {

                Printer.println("Goodbye!", PrintableColors.BLUE);

            }


        } else if (this.args.length == 1) {

            this.runCode(this.args[0]);

        }

    }

    public void help() {

        Printer.println("\tCode Help", PrintableColors.CYAN);
        Printer.println("Print\t-\tTo print something out\t-\tPRINT [string]", PrintableColors.BLUE);
        Printer.println("Print Var\t-\tTo print a var out\t-\tPRINTVAR [varname]", PrintableColors.BLUE);
        Printer.println("Set\t-\tTo set a var\t-\tSET [varname] = [value]", PrintableColors.BLUE);

        this.version();

    }

    public void version() {

        Printer.println("BLUC version: " + App.VERSION + "\nJBLUC version: " + App.JBLUC, PrintableColors.GREEN);

    }

    public void runCode(String path) {

        ArrayList<String> lines = new ArrayList<String>();
        
        try {
            
            FileReader fr = new FileReader(new File(path));
    
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                lines.add(line);

            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            Printer.println("Can't find file " + path, PrintableColors.RED);
        } catch (IOException e) {
            Printer.println(e.toString(), PrintableColors.RED);
        }

        for (int i = 0; i < lines.size(); i++) {

            Basecode cmd = Commands.getCommand(lines.get(i), null);

            App.varmamager.addCmd(cmd);

        }

        for (int i = 0; i < App.varmamager.getCmdList().size(); i++) {

            Basecode cmd = App.varmamager.getCmd(i);

            boolean good = cmd.run();

            if (!good) {

                Printer.println("\nError!!!\n", PrintableColors.RED);
                System.out.println(lines.get(i));
                Printer.println("\n^\n| Error on this line\n", PrintableColors.BLUE);
                System.exit(0);

            }

        }


    }

    public static VarMamager getvarmamager() {

        return App.varmamager;

    }

}
