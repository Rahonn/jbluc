package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;

public class ErrorOut extends Basecode {

    public ErrorOut(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        return false;
    }
    
    

}
