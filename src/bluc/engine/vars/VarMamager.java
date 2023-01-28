package bluc.engine.vars;

import java.util.ArrayList;
import java.util.HashMap;

import bluc.engine.codes.base.Basecode;
import main.App;
import print.PrintableColors;
import print.Printer;

public class VarMamager {
    
    private HashMap<String, Var<String>> vars;
    private ArrayList<Basecode> cmdList;
    private boolean runningLoop;
    private HashMap<String, ArrayList<Basecode>> functions;

    public VarMamager() {

        this.vars = new HashMap<>();
        this.cmdList = new ArrayList<>();
        this.runningLoop = false;
        this.functions = new HashMap<>();

        this.setVar("VERSION", new Var<String>(App.VERSION));
        this.setVar("JBLUC", new Var<String>(App.JBLUC));

    }

    public Var<String> getVar(String name) {

        return this.vars.get(name);

    }

    public void setVar(String name, Var<String> val) {

        this.vars.put(name, val);

    }

    public void varDump() {

        Printer.println("////////////////", PrintableColors.CYAN);
        Printer.println("///DUMP START///", PrintableColors.CYAN);
        Printer.println("////////////////", PrintableColors.CYAN);

        String[] keys = this.vars.keySet().toArray(new String[0]);

        for (int i = 0; i < keys.length; i++) {

            Printer.println(keys[i] + ": " + this.getVar(keys[i]), PrintableColors.CYAN);

        }

        Printer.println("//////////////", PrintableColors.CYAN);
        Printer.println("///DUMP END///", PrintableColors.CYAN);
        Printer.println("//////////////", PrintableColors.CYAN);

    }

    public HashMap<String, Var<String>> getVars() {

        return this.vars;

    }

    public ArrayList<Basecode> getCmdList() {

        return this.cmdList;

    }

    public void addCmd(Basecode cmd) {

        this.cmdList.add(cmd);

    }

    public Basecode getCmd(int index) {

        return this.cmdList.get(index);

    }

    public boolean getRunningLoop() {

        return this.runningLoop;

    }

    public void setRunningLoop(boolean runningLoop) {

        this.runningLoop = runningLoop;

    }

    public HashMap<String, ArrayList<Basecode>> getFunctions() {

        return this.functions;

    }

    public void addFunction(String name, ArrayList<Basecode> cmdList) {

        this.functions.put(name, cmdList);

    }

    public ArrayList<Basecode> getFunctions(String name) {

        return this.functions.get(name);

    }

}
