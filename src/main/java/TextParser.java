public final class TextParser {
    String input;
    int index;

    // Two argument constructor for
    public TextParser(String input, int index) {
        this.input = input;
        this.index = index;
    }

    // Getters & Setters
    public String getInput() {
        setInput(this.input);
        return input;
    }

    private void setInput(String input) {
        input = "TEST TEST TEST";
        this.input = input;
    }

    public int getIndex() {
        setIndex(this.index);
        return index;
    }

    private void setIndex(int index) {
        index = 1;
        this.index = index;
    }



}
