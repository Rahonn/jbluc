package bluc.engine.codes;

import java.util.regex.Pattern;

import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.Var;
import main.App;

public class IfCmd extends Basecode {

    private String varname;
    private String arg1;
    private String arg2;
    private String op;
    private String iftrue;
    private String iffalse;
    private String text;
    private boolean arg1isNum;
    private boolean arg2isNum;
    private boolean arg1isVar;
    private boolean arg2isVar;
    private boolean arg1isStr;
    private boolean arg2isStr;

    public IfCmd(String line, Integer index) {
        super(line, index);
        this.text = this.line.substring(3);

        String[] spaceSpilt = this.text.split(" ");


        this.varname = spaceSpilt[0];
        this.arg1 = spaceSpilt[1];
        this.op = spaceSpilt[2];
        this.arg2 = spaceSpilt[3];

        String[] conSplit = this.text.split(":");

        this.iftrue = conSplit[1];
        this.iffalse = conSplit[2];

        this.iftest();


    }

    private void iftest() {

        try {

            Double.parseDouble(this.arg1);
            this.arg1isNum = true;
            this.arg1isVar = false;


        } catch (Exception e) {

            this.arg1isNum = false;

        }

        try {

            Double.parseDouble(this.arg2);
            this.arg2isNum = true;
            this.arg2isVar = false;

        } catch (Exception e) {

            this.arg2isNum = false;

        }

        if (Pattern.compile("^\\$").matcher(this.arg1).find()) {

            this.arg1isVar = true;

        } else {

            this.arg1isVar = false;

        }

        if (Pattern.compile("^\\$").matcher(this.arg2).find()) {

            this.arg2isVar = true;

        } else {

            this.arg2isVar = false;

        }

        if (Pattern.compile("!.+$").matcher(this.arg1).find()) {

            this.arg1isStr = true;

        } else {

            this.arg1isStr = false;

        }

        if (Pattern.compile("!.+$").matcher(this.arg2).find()) {

            this.arg2isStr = true;

        } else {

            this.arg2isStr = false;

        }

        if (Pattern.compile("^[!]").matcher(this.arg1).find() && Pattern.compile("^[!]").matcher(this.arg1).find()) {

            this.arg1isStr = true;

        } else {

            this.arg1isStr = false;

        }

        if (Pattern.compile("^[!]").matcher(this.arg2).find() && Pattern.compile("^[!]").matcher(this.arg2).find()) {

            this.arg2isStr = true;

        } else {

            this.arg2isStr = false;

        }

        if (this.arg1isNum) {

            this.arg1isNum = true;
            this.arg1isVar = false;
            this.arg1isStr = false;

        }

        if (this.arg1isVar) {

            this.arg1isNum = false;
            this.arg1isVar = true;
            this.arg1isStr = false;

        }

        if (this.arg1isStr) {

            this.arg1isNum = false;
            this.arg1isVar = false;
            this.arg1isStr = true;

        }

        if (this.arg2isNum) {

            this.arg2isNum = true;
            this.arg2isVar = false;
            this.arg2isStr = false;

        }

        if (this.arg2isVar) {

            this.arg2isNum = false;
            this.arg2isVar = true;
            this.arg2isStr = false;

        }

        if (this.arg2isStr) {

            this.arg2isNum = false;
            this.arg2isVar = false;
            this.arg2isStr = true;

        }


    }

    private void iftestfinal() {

        if (this.arg1isVar) {

            this.arg1 = App.getvarmamager().getVar(this.arg1.substring(1)).getData();

        }

        if (this.arg1isStr) {

            this.arg1 = App.getvarmamager().getVar(this.arg1.substring(1, this.arg1.length() - 1)).getData();

        }

        if (this.arg1isNum) {

            this.arg1 = String.valueOf(Double.parseDouble(this.arg1));

        }

        if (this.arg2isVar) {

            this.arg2 = App.getvarmamager().getVar(this.arg2.substring(1)).getData();

        }

        if (this.arg2isStr) {

            this.arg2 = App.getvarmamager().getVar(this.arg2.substring(1, this.arg2.length() - 1)).getData();

        }

        if (this.arg2isNum) {

            this.arg2 = String.valueOf(Double.parseDouble(this.arg2));

        }

    }

    @Override
    public boolean run() {

        try {

            this.iftestfinal();
            this.iftest();
            this.iftestfinal();

        } catch (Exception e) {

            return false;

        }
        
        boolean didIf = false;

        try {

            if (this.op.equals("<")) {

                if (Double.parseDouble(this.arg1) < Double.parseDouble(this.arg2)) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iftrue));
                    didIf = true;

                } else {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iffalse));
                    didIf = true;

                }

            } else if (this.op.equals(">")) {

                if (Double.parseDouble(this.arg1) > Double.parseDouble(this.arg2)) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iftrue));
                    didIf = true;

                } else {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iffalse));
                    didIf = true;

                }

            } else if (this.op.equals("==")) {

                if (this.arg1.equals(this.arg2)) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iftrue));
                    didIf = true;

                } else {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iffalse));
                    didIf = true;

                }

            } else if (this.op.equals("!=")) {

                if (!this.arg1.equals(this.arg2)) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iftrue));
                    didIf = true;

                } else {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iffalse));
                    didIf = true;

                }

            } else if (this.op.equals(">=")) {

                if (Double.parseDouble(this.arg1) >= Double.parseDouble(this.arg2)) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iftrue));
                    didIf = true;

                } else {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iffalse));
                    didIf = true;

                }

            } else if (this.op.equals("<=")) {

                if (Double.parseDouble(this.arg1) <= Double.parseDouble(this.arg2)) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iftrue));
                    didIf = true;

                } else {

                    App.getvarmamager().setVar(this.varname, new Var<String>(this.iffalse));
                    didIf = true;

                }

            }

        } catch (Exception e) {

            return false;

        }

        return didIf;
    }

    
}
