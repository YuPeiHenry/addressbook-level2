package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address implements Printable {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private static final String FIELD_DELIMITER = ",";
    private static final int NUM_FIELDS = 4;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] fields = trimmedAddress.split(FIELD_DELIMITER);
        if (fields.length != NUM_FIELDS) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        block = new Block(fields[0]);
        street = new Street(fields[1]);
        unit = new Unit(fields[2]);
        postalCode = new PostalCode(fields[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    public String getValue() {
        return block.getValue() + FIELD_DELIMITER + street.getValue() + FIELD_DELIMITER + unit.getValue()
                + FIELD_DELIMITER + postalCode.getValue();
    }

    public Block getBlock() {
        return block;
    }

    public Street getStreet() {
        return street;
    }

    public Unit getUnit() {
        return unit;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        if (other != this // short circuit if same object
                && !(other instanceof Address)) {
            return false;
        }
        Address otherAddress = (Address) other;
        return block.equals(otherAddress.getBlock()) && street.equals(otherAddress.getStreet()) &&
                unit.equals(otherAddress.getUnit()) && postalCode.equals(otherAddress.getPostalCode());
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String getPrintableString() {
        String representation = getValue();
        if (isPrivate) {
            representation += "(private) ";
        }
        return representation;
    }

}
