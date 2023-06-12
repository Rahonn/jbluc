package github.rahonn.jbluc.print;

public enum PrintableColors {

    RED("\033[31m", "\033[0m"),
    BLACK("\033[30m", "\033[0m"),
    GREEN("\033[32m", "\033[0m"),
    BLUE("\033[34m", "\033[0m"),
    PURPLE("\033[35m", "\033[0m"),
    CYAN("\033[36m", "\033[0m"),
    WHITE("\033[37m", "\033[0m"),
    YELLOW("\033[33m", "\033[0m"),
    LIGHT_RED("\033[91m", "\033[0m"),
    LIGHT_BLACK("\033[90m", "\033[0m"),
    LIGHT_GREEN("\033[92m", "\033[0m"),
    LIGHT_BLUE("\033[94m", "\033[0m"),
    LIGHT_PURPLE("\033[95m", "\033[0m"),
    LIGHT_CYAN("\033[96m", "\033[0m"),
    LIGHT_WHITE("\033[97m", "\033[0m"),
    LIGHT_YELLOW("\033[93m", "\033[0m");

    private String start;
    private String end;

    private PrintableColors(String start, String end) {

        this.start = start;
        this.end = end;

    }

    public String getStart() {

        return this.start;

    }

    public String getEnd() {

        return this.end;

    }

}
