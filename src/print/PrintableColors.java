package print;

public enum PrintableColors {
    
    RED("\033[31m", "\033[0m"),
    BLACK("\033[30m", "\033[0m"),
    GREEN("\033[32m", "\033[0m"),
    BLUE("\033[34m", "\033[0m"),
    PURPLE("\033[35m", "\033[0m"),
    CYAN("\033[36m", "\033[0m"),
    WHITE("\033[37m", "\033[0m"),
    YELLOW("\033[33m", "\033[0m");

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
