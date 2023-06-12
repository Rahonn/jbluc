package github.rahonn.jbluc.bluc.engine.codes;

import java.util.ArrayList;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.main.App;

public class FnStart extends Basecode {

    private ArrayList<Basecode> cmdList;
    private String name;
    private String text;

    public FnStart(String line, Integer index) {
        super(line, index);
        this.text = this.line.substring(6);

        this.name = this.text;

        this.cmdList = new ArrayList<>();

    }

    @Override
    public boolean run() {

        Integer cindex = this.index;

        if (this.index == null) {

            cindex = App.getvarmamager().getCmdList().indexOf(this);

        }

        int startingIndex = cindex + 1;
        int length = App.getvarmamager().getCmdList().size();

        for (int i = startingIndex; i < length; i++) {

            Basecode item = App.getvarmamager().getCmdList().get(i);

            if (item.getClass().equals(FnEnd.class)) {

                break;

            }

            this.cmdList.add(item);

        }

        App.getvarmamager().addFunction(this.name, this.cmdList);

        for (int i = 0; i < this.cmdList.size(); i++) {

            Basecode item = this.cmdList.get(i);

            App.getvarmamager().getCmdList().remove(item);

        }

        return true;

    }

}
