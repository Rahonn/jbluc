package github.rahonn.jbluc.bluc.engine.codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;
import github.rahonn.jbluc.bluc.engine.vars.Var;
import github.rahonn.jbluc.main.App;

public class ReadFile extends Basecode {

    private String varname;
    private String path;
    private String text;

    public ReadFile(String line, Integer index) {
        super(line, index);

        this.text = this.line.substring(9);

        String[] spaceSplit = this.text.split(" ");

        this.varname = spaceSplit[0];
        this.path = spaceSplit[1];

    }

    @Override
    public boolean run() {

        try {

            FileReader fr = new FileReader(new File(this.path));

            BufferedReader br = new BufferedReader(fr);

            String filedata = String.valueOf("");

            ArrayList<String> lines = new ArrayList<>();

            String line;

            while ((line = br.readLine()) != null) {

                lines.add(line);

            }

            for (int i = 0; i < lines.size(); i++) {

                if (i == lines.size() - 1) {

                    filedata += lines.get(i);

                } else {

                    filedata += lines.get(i) + '\n';

                }

            }

            App.getvarmamager().setVar(this.varname, new Var<String>(filedata));

            br.close();
            fr.close();

        } catch (Exception e) {

            return false;

        }

        return true;

    }

}
