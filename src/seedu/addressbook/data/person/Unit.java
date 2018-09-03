package seedu.addressbook.data.person;

/**
 * Unit number of Address
 */
public class Unit {
    private final String value;

    /**
     * Constructor
     *
     * @param value
     */
    public Unit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.getValue().equals(((Unit) other).getValue())); // state check
    }
}
