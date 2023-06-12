package github.rahonn.jbluc.bluc.engine.codes.base;

import java.io.Serializable;

public abstract class Basecode implements Cloneable, Serializable {

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

    @Override
    public Basecode clone() {

        try {
            return (Basecode) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }

    }

}
