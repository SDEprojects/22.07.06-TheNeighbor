public final class TextParser {
    String input;
    String verb;
    String noun;
    boolean isValid;

    // constructor
    public TextParser(String input) {
        this.input = input;
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
        String[] v = input.split("\\s+");
        verb = v[0];

        this.verb = verb;
    }

    public String getNoun() {
        setNoun(this.noun);
        return noun;
    }

    private void setNoun(String noun) {

        String[] n = input.split("\\s+");
        if (n.length < 2) {
            noun = "";
        } else {
            noun = n[1];
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

        //TODO: validate input against item/locations JSON
        switch (getNoun()){

        }

        isValid = valid;
    }
}
