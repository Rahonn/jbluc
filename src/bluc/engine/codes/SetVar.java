package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.Var;
import main.App;

public class SetVar extends Basecode {

    private String text;
    private String name;
    private String value;
    private boolean isnew;

    public SetVar(String line, Integer index) {
        super(line, index);
        this.text = this.line.substring(4);
    }

    @Override
    public boolean run() {

        this.value = "";

        String[] parts = this.text.split(" ");

        boolean gettingData = false;

        for (int partIndex = 0; partIndex < parts.length; partIndex++) {

            if (partIndex == 0) {

                this.name = parts[partIndex];

            }

            if (parts[partIndex].equalsIgnoreCase("=")) {

                gettingData = true;
                continue;

            }

            if (gettingData) {

                if (partIndex == parts.length - 1) {

                    this.value += parts[partIndex];

                } else {

                    this.value += parts[partIndex] + " ";

                }

            }

        }

        if (App.getvarmamager().getVar(this.name) == null) {

            this.isnew = true;

        } else {

            this.isnew = false;

        }

        App.getvarmamager().setVar(this.name, new Var<String>(this.value));

        if (!gettingData) {

            return false;

        } else {

            return true;

        }

    }


    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isIsnew() {
        return this.isnew;
    }

    public boolean getIsnew() {
        return this.isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }


}
