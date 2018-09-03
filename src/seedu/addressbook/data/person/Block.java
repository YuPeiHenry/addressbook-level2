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

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.getValue().equals(((Block) other).getValue())); // state check
    }
}
