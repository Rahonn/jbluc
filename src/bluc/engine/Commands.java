package bluc.engine;

import java.util.regex.Pattern;

import bluc.engine.codes.Comment;
import bluc.engine.codes.ErrorOut;
import bluc.engine.codes.Input;
import bluc.engine.codes.Print;
import bluc.engine.codes.PrintVar;
import bluc.engine.codes.SetVar;
import bluc.engine.codes.base.Basecode;

public class Commands {

    public static Basecode getCommand(String line, Integer index) {

        if (Pattern.compile("^PRINT ", Pattern.MULTILINE).matcher(line).find()) {

            return new Print(line, index);

        }

        if (Pattern.compile("^" + Comment.COMMENT_CHAR, Pattern.MULTILINE).matcher(line).find() || line.trim().equals("")) {

            return new Comment(line, index);

        }

        if (Pattern.compile("^SET ", Pattern.MULTILINE).matcher(line).find()) {

            return new SetVar(line, index);

        }

        if (Pattern.compile("^PRINTVAR ", Pattern.MULTILINE).matcher(line).find()) {

            return new PrintVar(line, index);

        }

        if (Pattern.compile("^INPUT ", Pattern.MULTILINE).matcher(line).find()) {

            return new Input(line, index);

        }

        return new ErrorOut(line, index);

    }


}
