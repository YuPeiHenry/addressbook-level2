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
}
