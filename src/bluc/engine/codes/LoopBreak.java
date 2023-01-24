package bluc.engine.codes;

import bluc.engine.codes.base.Basecode;
import main.App;

public class LoopBreak extends Basecode {

    public LoopBreak(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        App.getvarmamager().setRunningLoop(false);
        return true;
    }
    
}
