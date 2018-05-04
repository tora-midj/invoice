package jp.co.systena.tora.webjava.mid.dao.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InvoicePriceByClient.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class InvoicePriceByClient implements Serializable {

    /** The client no. */
    private int clientNo;

    /** The invoice amt. */
    private int invoiceAmt;

}