package github.rahonn.jbluc.bluc.engine.codes;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;

public class PassCmd extends Basecode {

    public PassCmd(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        return true;
    }

}
