package github.rahonn.jbluc.bluc.engine.codes;

import java.util.Date;
import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.bluc.engine.vars.Var;
import github.rahonn.jbluc.main.App;

public class TimeCmd extends Basecode {

    private String text;
    private String mode;
    private String varname;

    public TimeCmd(String line, Integer index) {
        super(line, index);

        this.text = this.line.substring(5);

        this.finddata();

    }

    private void finddata() {

        String[] spanceSplit = this.text.split(" ");

        this.mode = spanceSplit[0];

        if (String.valueOf(this.mode).equalsIgnoreCase("get")) {

            this.varname = spanceSplit[1];

        }

    }

    @Override
    public boolean run() {

        if (String.valueOf(this.mode).equalsIgnoreCase("get")) {

            Date date = new Date();

            App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf((int) (date.getTime() / 1000))));

        }

        return true;
    }

}
