package jp.co.systena.tora.webjava.mid.common.enums;

/**
 * The Enum ItemType.
 */
public enum ItemType {

    /** The book. */
    BOOK("10"),

    /** The pc. */
    PC("20"),

    /** The other. */
    OTHER("30");

    /** The code. */
    private String code;

    /**
     * Instantiates a new invoice status.
     *
     * @param code the code
     */
    ItemType(String code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /* (非 Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.getCode();
    }

}
