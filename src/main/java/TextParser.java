package main.java;

public final class TextParser {
    String input, verb, noun;
    boolean isValid, help;
    String[] t;

    // constructor
    public TextParser(String input) {
        t = input.split("\\s"); // split user input for parsing
    }

    // Getters & Setters
    public String getInput() {
        setInput(this.input);
        return input;
    }

    private void setInput(String input) {
        this.input = input;
    }

    public String getVerb() {
        return setVerb();
    }

    private String setVerb() {
        for (int i = 0; i < t.length; i++) {
            switch (t[i]) {
                case "go":
                    this.verb = "go";
                    break;
                case "take":
                    this.verb = "take";
                    break;
                case "look":
                    this.verb = "look";
                    break;
                default:
            }
        }
        if (this.verb == null) {
            this.verb = "invalid";
        }
        return this.verb;
    }

    public String getNoun() {
        return setNoun();
    }

    private String setNoun() {
        for (int i = 0; i < t.length; i++) {
            switch (t[i]) {
                case "north":
                    this.noun = "north";
                    break;
                case "south":
                    this.noun = "south";
                    break;
                case "east":
                    this.noun = "east";
                    break;
                case "west":
                    this.noun = "west";
                    break;
                case "stairs":
                    this.noun = "stairs";
                    break;
                default:
            }
        }
        if (this.noun == null) {
            this.noun = "invalid";
        }

        return this.noun;
    }

    public Boolean getHelp() {
        for (int i = 0; i < t.length; i++) {
            switch (t[i]) {
                case "help":
                    this.help = true;
                    break;
                default:
                    this.help = false;
            }
        }
        return this.help;
    }

    public Boolean getValid() {
        return setValid();
    }

    private Boolean setValid() {
        switch (getVerb()) {
            case "invalid":
                this.isValid = false;
                break;
            default:
                this.isValid = true;
        }

        switch (getNoun()) {
            case "invalid":
                isValid = false;
                break;
            default:
                isValid = true;
        }

        return this.isValid;
    }
}
