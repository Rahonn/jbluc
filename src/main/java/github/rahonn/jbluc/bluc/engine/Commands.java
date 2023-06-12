package github.rahonn.jbluc.bluc.engine;

import java.util.regex.Pattern;

import github.rahonn.jbluc.bluc.engine.codes.Comment;
import github.rahonn.jbluc.bluc.engine.codes.ConcatString;
import github.rahonn.jbluc.bluc.engine.codes.Delay;
import github.rahonn.jbluc.bluc.engine.codes.ErrorOut;
import github.rahonn.jbluc.bluc.engine.codes.ExitCmd;
import github.rahonn.jbluc.bluc.engine.codes.FnCall;
import github.rahonn.jbluc.bluc.engine.codes.FnEnd;
import github.rahonn.jbluc.bluc.engine.codes.FnStart;
import github.rahonn.jbluc.bluc.engine.codes.IfCmd;
import github.rahonn.jbluc.bluc.engine.codes.ImportCmd;
import github.rahonn.jbluc.bluc.engine.codes.Input;
import github.rahonn.jbluc.bluc.engine.codes.Interp;
import github.rahonn.jbluc.bluc.engine.codes.LoopBreak;
import github.rahonn.jbluc.bluc.engine.codes.LoopEnd;
import github.rahonn.jbluc.bluc.engine.codes.LoopStart;
import github.rahonn.jbluc.bluc.engine.codes.MathCmd;
import github.rahonn.jbluc.bluc.engine.codes.PassCmd;
import github.rahonn.jbluc.bluc.engine.codes.Print;
import github.rahonn.jbluc.bluc.engine.codes.PrintVar;
import github.rahonn.jbluc.bluc.engine.codes.ReadFile;
import github.rahonn.jbluc.bluc.engine.codes.RunIfCmd;
import github.rahonn.jbluc.bluc.engine.codes.SetVar;
import github.rahonn.jbluc.bluc.engine.codes.TimeCmd;
import github.rahonn.jbluc.bluc.engine.codes.WriteFile;
import github.rahonn.jbluc.bluc.engine.codes.base.Basecode;

public class Commands {

    public static Basecode getCommand(String line, Integer index) {

        if (Pattern.compile("^PRINT ", Pattern.MULTILINE).matcher(line).find()) {

            return new Print(line, index);

        }

        if (Pattern.compile("^" + Comment.COMMENT_CHAR, Pattern.MULTILINE).matcher(line).find()
                || line.trim().equals("")) {

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

        if (Pattern.compile("^WRITEFILE", Pattern.MULTILINE).matcher(line).find()) {

            return new WriteFile(line, index);

        }

        if (Pattern.compile("^TIME", Pattern.MULTILINE).matcher(line).find()) {

            return new TimeCmd(line, index);

        }

        if (Pattern.compile("^FNDEF", Pattern.MULTILINE).matcher(line).find()) {

            return new FnStart(line, index);

        }

        if (Pattern.compile("^FNEND", Pattern.MULTILINE).matcher(line).find()) {

            return new FnEnd(line, index);

        }

        if (Pattern.compile("^FNCALL", Pattern.MULTILINE).matcher(line).find()) {

            return new FnCall(line, index);

        }

        if (Pattern.compile("^INTERP", Pattern.MULTILINE).matcher(line).find()) {

            return new Interp(line, index);

        }

        return new ErrorOut(line, index);

    }

}
