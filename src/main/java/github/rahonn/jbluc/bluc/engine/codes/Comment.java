package github.rahonn.jbluc.bluc.engine.codes;

import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;

public class Comment extends Basecode {

    public static final char COMMENT_CHAR = '#';

    public Comment(String line, Integer index) {
        super(line, index);
    }

    @Override
    public boolean run() {
        return true;
    }

}
