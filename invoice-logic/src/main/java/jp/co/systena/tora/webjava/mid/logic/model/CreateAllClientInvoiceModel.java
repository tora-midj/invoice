package jp.co.systena.tora.webjava.mid.logic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class GetInvoice.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateAllClientInvoiceModel {

    /** The invoice start date. */
    private String invoiceStartDate;

    /** The invoice end date. */
    private String invoiceEndDate;

    /** The create user. */
    private String createUser;

}
