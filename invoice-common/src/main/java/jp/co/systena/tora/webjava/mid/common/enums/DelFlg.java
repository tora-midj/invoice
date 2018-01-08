package jp.co.systena.tora.webjava.mid.common.enums;

/**
 * The Enum DelFlg.
 */
public enum DelFlg {
    /** The true. */
    TRUE("1"),

    /** The flase. */
    FLASE("0");

    /**
     * Instantiates a new del flg.
     *
     * @param value the value
     */
    DelFlg(String value) {
        this.value = value;
    }

    /** The value. */
    private String value;

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /* (非 Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.getValue();
    }

    public static DelFlg parse(String delflg) {
        for (DelFlg delFlg : DelFlg.values()) {
            if (delFlg.getValue().equals(delflg)) {
                return delFlg;
            }
        }
        throw new IllegalArgumentException();
    }
}
