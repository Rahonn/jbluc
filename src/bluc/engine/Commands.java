package bluc.engine;

import java.util.regex.Pattern;

import bluc.engine.codes.Comment;
import bluc.engine.codes.ErrorOut;
import bluc.engine.codes.Print;
import bluc.engine.codes.base.Basecode;

public class Commands {

    public static Basecode getCommand(String line, Integer index) {

        if (Pattern.compile("^PRINT", Pattern.MULTILINE).matcher(line).find()) {

            return new Print(line, index);

        }

        if (Pattern.compile("^" + Comment.COMMENT_CHAR, Pattern.MULTILINE).matcher(line).find() || line.trim().equals("")) {

            return new Comment(line, index);

        }

        return new ErrorOut(line, index);

    }


}
