package bluc.engine;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import bluc.engine.codes.base.Basecode;
import main.App;
import print.PrintableColors;
import print.Printer;

public class CompileSystem implements Serializable {
    
    private ArrayList<Basecode> cmdList;

    public CompileSystem(ArrayList<Basecode> cmdList) {

        this.cmdList = cmdList;

    }

    public void load() {

        App.getvarmamager().setCmdList(this.cmdList);

    }

    public void save(ArrayList<Basecode> cmdList) {

        this.cmdList = cmdList;

    }

    public static void save(CompileSystem cs, String filename) {

        String fn = (filename == null) ? "build.cjbluc" : filename;

        try {

            FileOutputStream fos = new FileOutputStream(fn);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cs);

            fos.close();

        } catch (FileNotFoundException fnfe) {

            Printer.println("Can't find file " + fn, PrintableColors.RED);

        } catch (IOException ioe) {

            Printer.println("IOException", PrintableColors.RED);

        }

    }

    public static void load(String filename) {

        String fn = (filename == null) ? "build.cjbluc" : filename;

        try {
            
            FileInputStream fis = new FileInputStream(fn);
            
            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream ois = new ObjectInputStream(bis);

            CompileSystem cs = (CompileSystem) ois.readObject();

            ois.close();
            bis.close();
            fis.close();

            cs.load();


        } catch (FileNotFoundException fnfe) {

            Printer.println("Can't find file " + fn, PrintableColors.RED);

        } catch (IOException ioe) {

            Printer.println("IOException", PrintableColors.RED);

        } catch (ClassNotFoundException cnfe) {

            Printer.println("ClassNotFoundException", PrintableColors.RED);

        }

    }

}
