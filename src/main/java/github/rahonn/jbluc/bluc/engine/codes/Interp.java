package github.rahonn.jbluc.bluc.engine.codes;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.print.PrintableColors;
import github.rahonn.jbluc.print.Printer;

public class Interp extends Basecode {

    private String using;
    private String text;

    public Interp(String line, Integer index) {
        super(line, index);
        this.text = this.line.substring(7);

        this.using = this.text;

    }

    @Override
    public boolean run() {

        if (!this.using.equalsIgnoreCase("JBLUC")) {

            Printer.println(String.format("NOTE: This code was made for %s but this is JBLUC!", this.using),
                    PrintableColors.RED);
            Printer.print("Do you want to run this code anyway? (y or n): ", PrintableColors.BLUE);
            System.out.print(PrintableColors.BLUE.getStart());
            String dorun = Input.scanner.nextLine();
            System.out.print(PrintableColors.BLUE.getEnd());

            if (dorun.equalsIgnoreCase("y")) {

                return true;

            } else {

                System.exit(0);

            }

        }

        return true;
    }

}
