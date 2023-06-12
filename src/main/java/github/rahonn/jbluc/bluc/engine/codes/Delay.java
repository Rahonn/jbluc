package github.rahonn.jbluc.bluc.engine.codes;

import java.util.regex.Pattern;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.main.App;

public class Delay extends Basecode {

    private String timeS;
    private double time;

    public Delay(String line, Integer index) {
        super(line, index);

        this.timeS = this.line.substring(6);

    }

    @Override
    public boolean run() {

        if (Pattern.compile("^\\$").matcher(this.timeS).find()) {

            this.time = Double.parseDouble(App.getvarmamager().getVar(this.timeS.substring(1)).getData());

        } else {

            this.time = Double.parseDouble(this.timeS);

        }

        try {

            Thread.sleep((long) (this.time * 1000));

        } catch (InterruptedException e) {
            return false;
        }

        return true;
    }

}
