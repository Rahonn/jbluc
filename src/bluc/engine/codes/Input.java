package bluc.engine.codes;

import java.util.Scanner;

import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.Var;
import main.App;

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
