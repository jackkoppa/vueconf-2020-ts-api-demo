package candidate;

public enum Party {
    DEMOCRAT("Democrat"),
    REPUBLICAN("Republican"),
    INDEPENDENT("Independent");

    private final String value;

    Party(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

