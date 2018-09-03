package seedu.addressbook.data.person;

/**
 * Postal code of Address
 */
public class PostalCode {
    private final String value;

    /**
     * Constructor
     *
     * @param value
     */
    public PostalCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.getValue().equals(((PostalCode) other).getValue())); // state check
    }
}
