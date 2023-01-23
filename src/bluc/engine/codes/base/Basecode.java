package bluc.engine.codes.base;

public abstract class Basecode {
    
    protected String line;
    protected Integer index;

    public Basecode(String line, Integer index) {

        this.line = line;
        this.index = index;

    }

    public Basecode(String line) {


        this.line = line;
        this.index = null;

    }

    public abstract boolean run();

    public String getLine() {

        return this.line;

    }

    public Integer getIndex() {


        return this.index;

    }

}
