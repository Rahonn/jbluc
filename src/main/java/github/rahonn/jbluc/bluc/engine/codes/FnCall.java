package github.rahonn.jbluc.bluc.engine.codes;

import java.util.ArrayList;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.main.App;
import github.rahonn.jbluc.print.PrintableColors;
import github.rahonn.jbluc.print.Printer;

public class FnCall extends Basecode {

    private String name;
    private String text;

    public FnCall(String line, Integer index) {
        super(line, index);
        this.text = this.line.substring(7);

        this.name = this.text;

    }

    @Override
    public boolean run() {

        ArrayList<Basecode> cmdList = App.getvarmamager().getFunctions(this.name);

        for (int i = 0; i < cmdList.size(); i++) {

            Basecode cc = cmdList.get(i);

            boolean cmdr = cc.run();

            if (!cmdr) {

                Printer.println("\nError!!!\n", PrintableColors.RED);
                System.out.println(cc.getLine());
                Printer.println("\n^\n| Error on this line\n", PrintableColors.BLUE);
                System.exit(0);

            }

        }

        return true;
    }

}
