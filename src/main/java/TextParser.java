package main.java;

public final class TextParser {
    String input, verb, noun;
    boolean isValid, help, exit;
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
                case "help":
                    this.verb = "help";
                    break;
                case "quit":
                case "exit":
                    this.verb = "exit";
                    break;

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
            }
        }
        if (this.noun == null) {
            this.noun = "invalid";
        }

        return this.noun;
    }

    public Boolean getHelp() {
        switch (getVerb()) {
            case "help":
                this.help = true;
                break;
            default:
                this.help = false;
        }
        return this.help;
    }


    public Boolean getExit() {
        switch (getVerb()) {
            case "exit":
                this.help = true;
                break;
            default:
                this.help = false;
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
                this.isValid = false;
                break;
            default:
                this.isValid = true;
        }

        return this.isValid;
    }

    public String[] getT() {
        return t;
    }

    private void setT(String[] t) {
        this.t = t;
    }
}
