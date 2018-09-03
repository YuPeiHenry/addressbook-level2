package seedu.addressbook.data.person;

/**
 * Block Number of Address
 */
public class Block {
    private final String value;

    /**
     * Constructor
     *
     * @param value
     */
    public Block(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
