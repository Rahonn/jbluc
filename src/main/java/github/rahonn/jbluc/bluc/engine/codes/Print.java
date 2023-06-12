package github.rahonn.jbluc.bluc.engine.codes;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;

public class Print extends Basecode {

    private String text;

    public Print(String line, Integer index) {
        super(line, index);

        this.text = this.line.substring(6);

    }

    @Override
    public boolean run() {
        System.out.println(this.text);
        return true;
    }

    public String getText() {
        return this.text;
    }

}
