package github.rahonn.jbluc.bluc.engine.codes;

import java.util.ArrayList;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.bluc.engine.vars.Var;
import github.rahonn.jbluc.main.App;

public class LoopStart extends Basecode {

    private ArrayList<Basecode> cmdList;
    private String timesS;
    private Integer times;
    private String indexVarname;
    private boolean isWhile;
    private String text;

    public LoopStart(String line, Integer index) {
        super(line, index);
        this.text = this.line.substring(5);

        this.cmdList = new ArrayList<>();

    }

    private boolean findData() {

        Integer cindex = this.index;

        if (this.index == null) {

            cindex = App.getvarmamager().getCmdList().indexOf(this);

        }

        this.indexVarname = this.text.split(" ")[0];
        this.timesS = this.text.split(" ")[1];
        this.isWhile = false;

        if (this.timesS.equalsIgnoreCase("@")) {

            this.isWhile = true;

        } else {

            this.isWhile = false;

            try {

                this.times = Integer.parseInt(this.timesS);

            } catch (NumberFormatException nfe) {

                this.timesS = App.getvarmamager().getVar(this.timesS).getData();

            }

        }

        int startingIndex = cindex + 1;
        int length = App.getvarmamager().getCmdList().size();

        for (int i = startingIndex; i < length; i++) {

            Basecode item = App.getvarmamager().getCmd(i);

            if (item.getClass().equals(LoopEnd.class)) {

                break;

            }

            this.cmdList.add(item);

        }

        return true;

    }

    private boolean execute() {

        if (this.timesS.equalsIgnoreCase("@")) {

            this.isWhile = true;

        }

        if (this.isWhile) {

            App.getvarmamager().setRunningLoop(true);

            double i = 0.0;

            while (true) {

                App.getvarmamager().setVar(this.indexVarname, new Var<String>(String.valueOf(i)));

                if (!App.getvarmamager().getRunningLoop()) {

                    break;

                }

                for (int cmdi = 0; cmdi < this.cmdList.size(); cmdi++) {

                    Basecode ncmd = this.cmdList.get(cmdi).clone();

                    if (!App.getvarmamager().getRunningLoop()) {

                        break;

                    }

                    boolean ncmdg = ncmd.run();

                    if (!ncmdg) {

                        return false;

                    }

                }

                i += 1.0;

            }

            App.getvarmamager().setRunningLoop(false);

        } else {

            App.getvarmamager().setRunningLoop(true);

            int ltimes = this.times == null ? Integer.parseInt(String.valueOf(this.timesS)) : this.times;

            for (int i = 0; i < ltimes; i++) {

                App.getvarmamager().setVar(this.indexVarname,
                        new Var<String>(String.valueOf(Double.parseDouble(String.valueOf(i)))));

                if (!App.getvarmamager().getRunningLoop()) {

                    break;

                }

                for (int j = 0; j < this.cmdList.size(); j++) {

                    Basecode ncmd = this.cmdList.get(j).clone();

                    if (!App.getvarmamager().getRunningLoop()) {

                        break;

                    }

                    boolean ncmdg = ncmd.run();

                    if (!ncmdg) {

                        return false;

                    }

                }

            }

            App.getvarmamager().setRunningLoop(false);

        }

        for (int i = 0; i < this.cmdList.size(); i++) {

            Basecode item = this.cmdList.get(i);

            App.getvarmamager().getCmdList().remove(item);

        }

        return true;

    }

    @Override
    public boolean run() {

        boolean isgood = false;

        try {

            isgood = this.findData();
            isgood = this.execute();

        } catch (Exception e) {

            return false;

        }

        return isgood;
    }

}
