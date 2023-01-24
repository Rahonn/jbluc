package bluc.engine.codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import bluc.engine.Commands;
import bluc.engine.codes.base.Basecode;
import main.App;

public class ImportCmd extends Basecode {

    private String path;
    private ArrayList<String> lines;
    private ArrayList<Basecode> cmdList;

    public ImportCmd(String line, Integer index) {
        super(line, index);
        this.path = this.line.substring(7);

        this.lines = new ArrayList<>();
        this.cmdList = new ArrayList<>();

    }

    private boolean loadFile() {


        try {

            FileReader fr = new FileReader(new File(this.path));

            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                this.lines.add(line);

            }

            br.close();
            fr.close();


        } catch (FileNotFoundException e) {
            
            return false;

        } catch (IOException e) {

            return false;

        }

        return true;


    }

    private boolean addToCommandList() {

        for (int i = 0; i < this.lines.size(); i++) {

            Basecode cmd = Commands.getCommand(this.lines.get(i), null);

            this.cmdList.add(cmd);

        }

        Integer cindex = this.index;

        if (this.index == null) {
            
            cindex = App.getvarmamager().getCmdList().indexOf(this);
            
        }
        
        
        cindex += 1;
        
        for (int i = 0; i < this.cmdList.size(); i++) {
            
            Basecode cc = this.cmdList.get(i);
            
            App.getvarmamager().getCmdList().add(cindex, cc);
            
            cindex += 1;

        }

        return true;

    }

    @Override
    public boolean run() {

        boolean ran = false;

        try {

            ran = this.loadFile();
            ran = this.addToCommandList();
            
        } catch (Exception e) {

            return false;

        }


        return ran;
    }
    
}
