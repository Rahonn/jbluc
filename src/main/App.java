package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import bluc.engine.Commands;
import bluc.engine.CompileSystem;
import bluc.engine.codes.Input;
import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.VarMamager;
import print.PrintableColors;
import print.Printer;

public class App {

    public static final String VERSION = "12.0.0";
    public static final String JBLUC = "1.0.1";

    private String[] args;
    private static VarMamager varmamager = new VarMamager();

    public App(String[] args) {

        this.args = args;

    }

    public void run() {

        if (this.args.length == 0) {

            Printer.println("Welcome to JBLUC (Java BLUC)!", PrintableColors.LIGHT_GREEN);

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


        } else if (this.args[0].equalsIgnoreCase("-c")) {

            if (this.args.length >= 3) {

                this.compileCode(this.args[1], this.args[2]);

            } else {

                this.compileCode(this.args[1], null);

            }

        } else if (this.args[0].equalsIgnoreCase("-rc")) {

            this.runCompileCode(this.args[1]);

        } else if (this.args[0].equalsIgnoreCase("-drc")) {

            Printer.println("Running code...\n", PrintableColors.BLUE);

            System.out.print(PrintableColors.GREEN.getStart());

            this.runCompileCode(this.args[1]);

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
        Printer.println("Input\t-\tTo get user input\t-\tINPUT [varname]", PrintableColors.BLUE);
        Printer.println("Math\t-\tOperators +, -, *, /, **, RAND and store the result to a new var. If you are using RAND you can make num1 and num2 @ for no set range\t-\tMATH [varname] [operator] [num1] [num2]", PrintableColors.BLUE);
        Printer.println("Delay\t-\tAdd a delay to your code. You can use a var just place a varname in it but put a $ at the start\t-\tDELAY [seconds]", PrintableColors.BLUE);
        Printer.println("Comments\t-\tUse # for comments\t-\t# [comment]", PrintableColors.BLUE);
        Printer.println("If\t-\tAn if system. Replace varname with the name of the outvar, replace args with the args use for string with this put a ! at the start and end and if you are using a var as a arg put a $ at the start of it's name\t-\tIF [varname] [arg1] [op] [arg2] :[outiftrue]:   [outiffalse]:", PrintableColors.BLUE);
        Printer.println(
            "Run If\t-\tAn if system. Replace args with the args use for string with this put a ! at the start and end and if you are using a var as a arg put a $ at the start of it's name, replace [outcmdiftrue] with the command to run if the if is true same for the [outcmdiffalse] but for false instead\t-\tRUNIF [arg1] [op] [arg2] |[outcmdiftrue]|[outcmdiffalse]|", PrintableColors.BLUE);
        Printer.println("Exit\t-\tExit the app\t-\tEXIT", PrintableColors.BLUE);
        Printer.println("Import\t-\tUse the import command to load code from a different file. Replace [path] with the path to the bluc file include the file extension\t-\tIMPORT [path]", PrintableColors.BLUE);
        Printer.println("Pass\t-\tThis command does not do anything!\t-\tPASS", PrintableColors.BLUE);
        Printer.println(
            "Loops\t-\tUse LOOPSTART [index varname] [times] replace [times] with @ for a infinite number of times. Use BREAKLOOP to break out of a loop. Use ENDLOOP to end a loop\t-\t\n\tLOOP index 5\n\tPRINTVAR index\n\tRUNIF $index == 3 |BREAKLOOP|PASS|\n\tENDLOOP", PrintableColors.BLUE);
        Printer.println("Read file\t-\tUse to read files\t-\tREADFILE [outputvar] [filepath]", PrintableColors.BLUE);
        Printer.println("Write file\t-\tUse to write files\t-\tWRITEFILE [inputvar] [filepath]", PrintableColors.BLUE);
        Printer.println("String Concat\t-\tUse to add 2 vars to together as text. If you add 2 and 3 you will get 23. If your add Hello and World you will get Hello World. Replace [arg1] or [arg2] with plain text or for a var put a $ at the start of the name\t-\tCONCAT [outputvarname] |   [arg1]|[arg2]|", PrintableColors.BLUE);
        Printer.println("Time Get\t-\tGet the current system time and store the result in a var\t-\tTIME GET [outputvar]", PrintableColors.BLUE);
        Printer.println(
                "Functions\t-\tUse FNDEF [functionname]. Use FNEND to end a function. Use FNCALL [functionname] to call a function!\t-\t\n\tFNDEF myFunc\n\tPRINT This is my func\n\tFNEND\n\tFNCALL myFunc\n\tFNCALL myFunc", PrintableColors.BLUE);
        Printer.println("", PrintableColors.BLUE);
        Printer.println("\tComands Options", PrintableColors.RED);
        Printer.println("Interpret\t-\tTo run code\t-\t./BLUC -i [filename]", PrintableColors.PURPLE);
        Printer.println("Debug\t-\tInterprets and Compiles your code\t-\t./BLUC -d [filename]", PrintableColors.PURPLE);
        Printer.println("Help\t-\tTo get this info\t-\t./BLUC --help", PrintableColors.PURPLE);
        Printer.println("Run\t-\tUse to run your code\t-\t./BLUC [filename]", PrintableColors.PURPLE);
        Printer.println("Version\t-\tTo get the BLUC version number\t-\t./BLUC --version", PrintableColors.PURPLE);

        this.version();

    }

    public void version() {

        Printer.println("BLUC version: " + App.VERSION + "\nJBLUC version: " + App.JBLUC, PrintableColors.LIGHT_GREEN);

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

    public void compileCode(String path, String output) {

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

        String of = (output == null) ? "build.cjbluc" : output;

        CompileSystem cs = new CompileSystem(App.getvarmamager().getCmdList());

        CompileSystem.save(cs, of);

    }

    public void runCompileCode(String path) {

        String of = (path == null) ? "build.cjbluc" : path;

        CompileSystem.load(of);

        for (int i = 0; i < App.varmamager.getCmdList().size(); i++) {

            Basecode cmd = App.varmamager.getCmd(i);

            boolean good = cmd.run();

            if (!good) {

                Printer.println("\nError!!!\n", PrintableColors.RED);
                System.exit(0);

            }

        }

    }

    public static VarMamager getvarmamager() {

        return App.varmamager;

    }

}
