package github.rahonn.jbluc.bluc.engine.codes;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.main.App;

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
