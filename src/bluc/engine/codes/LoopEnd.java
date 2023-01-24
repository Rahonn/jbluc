package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;

public class LoopEnd extends Basecode {

    public LoopEnd(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        return true;
    }
    
}
