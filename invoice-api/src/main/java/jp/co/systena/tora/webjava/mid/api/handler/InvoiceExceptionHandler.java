package jp.co.systena.tora.webjava.mid.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.systena.tora.webjava.mid.api.excepiton.InvoiceException;
import jp.co.systena.tora.webjava.mid.api.response.model.InvoiceError;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponseInvoice;

@RestController
public class InvoiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ InvoiceException.class })
    public ResponseInvoice InvoiceExceptionHandle(final InvoiceException e) {

        ResponseInvoice rs = new ResponseInvoice();
        rs.getInvoiceErrorList().addAll(e.getInvoiceErrorList());
        return rs;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseInvoice handleException(final Exception e) {

        ResponseInvoice rs = new ResponseInvoice();
        rs.getInvoiceErrorList().add(new InvoiceError());
        return rs;
    }

}