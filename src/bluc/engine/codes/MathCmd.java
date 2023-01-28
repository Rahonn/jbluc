package bluc.engine.codes;

import java.util.Random;
import java.util.regex.Pattern;

import bluc.engine.codes.base.Basecode;
import bluc.engine.vars.Var;
import main.App;

public class MathCmd extends Basecode {

    private String lineNOSTART;
    private String varname;
    private String op;
    private String val1;
    private String val2;

    public MathCmd(String line, Integer index) {
        super(line, index);
        this.lineNOSTART = this.line.substring(5);

        this.varname = this.lineNOSTART.split(" ")[0];
        this.op = this.lineNOSTART.split(" ")[1];
        this.val1 = this.lineNOSTART.split(" ")[2];
        this.val2 = this.lineNOSTART.split(" ")[3];
        
    }

    @Override
    public boolean run() {

        try {

            String num1s = this.val1;
            String num2s = this.val2;

            Double num1 = null;
            Double num2 = null;


            if (Pattern.compile("[^0-9]").matcher(num1s).find() && !num1s.equalsIgnoreCase("@")) {

                num1s = App.getvarmamager().getVar(this.val1).getData();

            }
            
            if (Pattern.compile("[^0-9]").matcher(num2s).find() && !num2s.equalsIgnoreCase("@")) {

                num2s = App.getvarmamager().getVar(this.val2).getData();

            }
            
            if (!num1s.equalsIgnoreCase("@") && !num2s.equalsIgnoreCase("@")) {

                num1 = Double.parseDouble(num1s);
                num2 = Double.parseDouble(num2s);

            }

            if (this.op.equals("+")) {

                App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(num1 + num2)));

            } else if (this.op.equals("-")) {

                App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(num1 - num2)));

            } else if (this.op.equals("/")) {

                App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(num1 / num2)));

            } else if (this.op.equals("*")) {

                App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(num1 * num2)));

            } else if (this.op.equals("**")) {

                App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(Math.pow(num1, num2))));

            } else if (this.op.equals("RAND")) {

                Random random = new Random();

                if (num1s.equals("@") && num2s.equals("@")) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(random.nextDouble())));

                } else if (!num1s.equals("@") && !num2s.equals("@")) {

                    App.getvarmamager().setVar(this.varname, new Var<String>(String.valueOf(random.nextInt((int) (num2 - num1 - 1)) + num1)));

                } else {

                    return false;
                    
                }

            }


            return true;

        } catch (Exception e) {
            
            return false;

        }

    }
    
}
