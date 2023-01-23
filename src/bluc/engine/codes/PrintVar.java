package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;
import main.App;

public class PrintVar extends Basecode {
    
    private String varName;
    
    public PrintVar(String line, Integer index) {
        super(line, index);
        this.varName = this.line.substring(9);
    }

    @Override
    public boolean run() {

        try {

            System.out.println(App.getvarmamager().getVar(this.varName).getData());

        } catch (Exception e) {

            return false;

        }

        return true;

    }



}
