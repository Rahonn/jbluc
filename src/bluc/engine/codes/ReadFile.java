package bluc.engine.codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.Var;
import main.App;

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

            String line;

            while ((line = br.readLine()) != null) {

                filedata += line + '\n';

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
