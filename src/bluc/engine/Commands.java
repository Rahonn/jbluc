package bluc.engine;

import java.util.regex.Pattern;

import bluc.engine.codes.Comment;
import bluc.engine.codes.ConcatString;
import bluc.engine.codes.Delay;
import bluc.engine.codes.ErrorOut;
import bluc.engine.codes.ExitCmd;
import bluc.engine.codes.IfCmd;
import bluc.engine.codes.ImportCmd;
import bluc.engine.codes.Input;
import bluc.engine.codes.LoopBreak;
import bluc.engine.codes.LoopEnd;
import bluc.engine.codes.LoopStart;
import bluc.engine.codes.MathCmd;
import bluc.engine.codes.PassCmd;
import bluc.engine.codes.Print;
import bluc.engine.codes.PrintVar;
import bluc.engine.codes.ReadFile;
import bluc.engine.codes.RunIfCmd;
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

        if (Pattern.compile("^MATH", Pattern.MULTILINE).matcher(line).find()) {

            return new MathCmd(line, index);

        }

        if (Pattern.compile("^DELAY", Pattern.MULTILINE).matcher(line).find()) {

            return new Delay(line, index);

        }

        if (Pattern.compile("^IF", Pattern.MULTILINE).matcher(line).find()) {

            return new IfCmd(line, index);

        }

        if (Pattern.compile("^RUNIF", Pattern.MULTILINE).matcher(line).find()) {

            return new RunIfCmd(line, index);

        }

        if (Pattern.compile("^EXIT", Pattern.MULTILINE).matcher(line).find()) {

            return new ExitCmd(line, index);

        }

        if (Pattern.compile("^IMPORT", Pattern.MULTILINE).matcher(line).find()) {

            return new ImportCmd(line, index);

        }

        if (Pattern.compile("^PASS", Pattern.MULTILINE).matcher(line).find()) {

            return new PassCmd(line, index);

        }

        if (Pattern.compile("^LOOP", Pattern.MULTILINE).matcher(line).find()) {

            return new LoopStart(line, index);

        }

        if (Pattern.compile("^ENDLOOP", Pattern.MULTILINE).matcher(line).find()) {

            return new LoopEnd(line, index);

        }

        if (Pattern.compile("^BREAKLOOP", Pattern.MULTILINE).matcher(line).find()) {

            return new LoopBreak(line, index);

        }

        if (Pattern.compile("^READFILE", Pattern.MULTILINE).matcher(line).find()) {

            return new ReadFile(line, index);

        }

        if (Pattern.compile("^CONCAT", Pattern.MULTILINE).matcher(line).find()) {

            return new ConcatString(line, index);

        }

        return new ErrorOut(line, index);

    }


}
