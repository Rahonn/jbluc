package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;

public class PassCmd extends Basecode {

    public PassCmd(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        return true;
    }
    
}
