package seedu.addressbook.data.person;

/**
 * Street of Address
 */
public class Street {
    private final String value;

    /**
     * Constructor
     *
     * @param value
     */
    public Street(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.getValue().equals(((Street) other).getValue())); // state check
    }
}
