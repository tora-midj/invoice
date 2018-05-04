package jp.co.systena.tora.webjava.mid.common.enums;

/**
 * The Enum InvoiceStatus.
 */
public enum InvoiceStatus {
    /** The new. */
    NEW("10"),

    /** The sent. */
    SENT("20"),

    /** The payment done. */
    PAYMENT_DONE("30"),

    /** The disposal. */
    DISPOSAL("90");

    /** The code. */
    private String code;

    /**
     * Instantiates a new invoice status.
     *
     * @param code the code
     */
    InvoiceStatus(String code) {
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
}
