package jp.co.systena.tora.webjava.mid.api.response.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ResponseErrors.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceError {

    private String errorCode;
    private String errorMessage;
    private String errorDetail;
}
