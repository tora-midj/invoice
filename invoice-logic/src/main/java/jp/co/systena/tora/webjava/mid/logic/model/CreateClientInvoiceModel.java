package jp.co.systena.tora.webjava.mid.logic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class GetInvoice.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateClientInvoiceModel extends CreateAllClientInvoiceModel {

    /** The client no. */
    @Getter
    @Setter
    private String clientNo;

}
