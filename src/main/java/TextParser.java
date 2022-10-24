public final class TextParser {
    String input;
    String verb;
    String noun;
    boolean isValid;
    String[] t;

    // constructor
    public TextParser(String input) {
        t= input.split("\\s+"); // split user input for parsing
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
        setVerb(this.verb);
        return verb;
    }

    private void setVerb(String verb) {
        verb = t[0];
        this.verb = verb;
    }

    public String getNoun() {
        setNoun(this.noun);
        return noun;
    }

    private void setNoun(String noun) {

        if (t.length < 2) {
            noun = "";
        } else {
            noun = t[1];
        }

        this.noun = noun;
    }

    public Boolean getValid() {
        setValid(true);
        return isValid;
    }

    private void setValid(Boolean valid) {
        switch (getVerb()) {
            case "go":
            case "take":
            case "look":
                valid = true;
                break;
            default:
                valid = false;
        }

        //TODO: validate input against item/locations JSON - maybe use list
        switch (getNoun()) {

        }

        isValid = valid;
    }
}
