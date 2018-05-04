package jp.co.systena.tora.webjava.mid.api.excepiton;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

import jp.co.systena.tora.webjava.mid.api.response.model.InvoiceError;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class InvoiceException extends RuntimeException {
    //    private InvoiceErrorCode invoiceError;
    private List<InvoiceError> invoiceErrorList = new ArrayList<InvoiceError>();

    public InvoiceException(final List<InvoiceError> invoiceErrorList, final Throwable cause) {
        log.error(ExceptionUtils.getStackTrace(cause));
        //        this.invoiceError = invoiceError;
        this.invoiceErrorList.addAll(invoiceErrorList);
    }

    public InvoiceException(final InvoiceError invoiceErrorList, final Throwable cause) {
        log.error(ExceptionUtils.getStackTrace(cause));
        //        this.invoiceError = invoiceError;
        this.invoiceErrorList.add(invoiceErrorList);
    }
}
