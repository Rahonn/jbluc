package github.rahonn.jbluc.bluc.engine.codes;

import java.util.Scanner;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.bluc.engine.vars.Var;
import github.rahonn.jbluc.main.App;

public class Input extends Basecode {

    public static Scanner scanner = new Scanner(System.in);

    private String varname;

    public Input(String line, Integer index) {
        super(line, index);
        this.varname = this.line.substring(6);
    }

    @Override
    public boolean run() {

        App.getvarmamager().setVar(this.varname, new Var<String>(Input.scanner.nextLine()));

        return true;
    }

}
