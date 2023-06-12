package github.rahonn.jbluc.bluc.engine.codes;

import java.util.regex.Pattern;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.bluc.engine.vars.Var;
import github.rahonn.jbluc.main.App;

public class ConcatString extends Basecode {

    private String arg1;
    private String arg2;
    private String varname;
    private String text;
    private boolean arg1IsStr;
    private boolean arg2IsStr;
    private boolean arg1IsVar;
    private boolean arg2IsVar;

    public ConcatString(String line, Integer index) {
        super(line, index);

        this.text = this.line.substring(7);

        String[] spaceSplit = this.text.split(" ");

        String[] conSplit = this.text.split("\\|");

        this.varname = spaceSplit[0];
        this.arg1 = String.valueOf(conSplit[1]);
        this.arg2 = String.valueOf(conSplit[2]);

        this.varTest();

    }

    private void varTest() {

        if (!Pattern.compile("^\\$", Pattern.MULTILINE).matcher(String.valueOf(this.arg1)).find()) {

            this.arg1IsStr = true;
            this.arg1IsVar = false;

        } else {

            this.arg1IsStr = false;
            this.arg1IsVar = true;

        }

        if (!Pattern.compile("^\\$", Pattern.MULTILINE).matcher(String.valueOf(this.arg2)).find()) {

            this.arg2IsStr = true;
            this.arg2IsVar = false;

        } else {

            this.arg2IsStr = false;
            this.arg2IsVar = true;

        }

    }

    private void varTestFinal() {

        if (this.arg1IsVar) {

            this.arg1 = App.getvarmamager().getVar(this.arg1.substring(1)).getData();

        } else if (this.arg1IsStr) {

            this.arg1 = String.valueOf(this.arg1);

        }

        if (this.arg2IsVar) {

            this.arg2 = App.getvarmamager().getVar(this.arg2.substring(1)).getData();

        } else if (this.arg2IsStr) {

            this.arg2 = String.valueOf(this.arg2);

        }

    }

    @Override
    public boolean run() {

        try {

            this.varTestFinal();
            this.varTest();
            this.varTestFinal();

        } catch (Exception e) {

            return false;

        }

        this.arg1 = this.arg1.replace("\\n", "\n");
        this.arg2 = this.arg2.replace("\\n", "\n");

        App.getvarmamager().setVar(this.varname, new Var<String>(this.arg1 + this.arg2));

        return true;
    }

    @Override
    public String toString() {
        return "ConcatString [arg1=" + arg1 + ", arg2=" + arg2 + ", varname=" + varname + ", text=" + text
                + ", arg1IsStr=" + arg1IsStr + ", arg2IsStr=" + arg2IsStr + ", arg1IsVar=" + arg1IsVar + ", arg2IsVar="
                + arg2IsVar + "]";
    }

}
