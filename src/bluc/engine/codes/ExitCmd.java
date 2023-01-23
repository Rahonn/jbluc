package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;

public class ExitCmd extends Basecode {

    public ExitCmd(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        System.exit(0);
        return true;
    }
    
}
