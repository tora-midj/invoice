package jp.co.systena.tora.webjava.mid.api.response.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ResponseInvoice.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter // 参照を更新させてバグとなるのを防ぐため参照のみとする
public class ResponseInvoice implements Responce {

    /** The errors. */
    @JsonProperty("errors")
    private List<InvoiceError> invoiceErrorList = new ArrayList<InvoiceError>();

    /** The results. */
    @JsonProperty("results")
    private List<InvoiceResult> invoiceResultList = new ArrayList<InvoiceResult>();

}
