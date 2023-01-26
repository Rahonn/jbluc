package bluc.engine.codes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import bluc.engine.codes.base.Basecode;
import main.App;

public class WriteFile extends Basecode {

    private String text;
    private String path;
    private String varname;

    public WriteFile(String line, Integer index) {
        super(line, index);

        this.text = this.line.substring(10);

        String[] spaceSpilt = this.text.split(" ");

        this.varname = spaceSpilt[0];
        this.path = spaceSpilt[1];

    }

    @Override
    public boolean run() {

        try {

            FileWriter fw = new FileWriter(new File(this.path));

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(App.getvarmamager().getVar(this.varname).getData());

            bw.close();
            fw.close();

        } catch (Exception e) {

            return false;

        }

        return true;
    }
    
}
