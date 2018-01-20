package jp.co.systena.tora.webjava.mid.api.request.model;

import javax.validation.constraints.NotNull;

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
public class RequestPostInvoice {

    /** The client no. */
    @NotNull
    private String clientNo;

    /** The invoice start date. */
    @NotNull
    private String invoiceStartDate;

    /** The invoice end date. */
    @NotNull
    private String invoiceEndDate;

    /** The create user. */
    @NotNull
    private String createUser;

}
