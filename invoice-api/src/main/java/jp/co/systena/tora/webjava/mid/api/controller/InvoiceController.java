package jp.co.systena.tora.webjava.mid.api.controller;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponseInvoice;
import jp.co.systena.tora.webjava.mid.api.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class InvoiceController.
 */
@RestController
@RequestMapping("/api/inovice")
@CrossOrigin
@Slf4j
public class InvoiceController {

    /** The invoice service. */
    @Resource
    InvoiceService invoiceService;

    /**
     * Gets the invoice.
     *
     * @return the invoice
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseInvoice getInvoice() {
        ResponseInvoice rs = new ResponseInvoice();
        rs.getInvoiceResultList().addAll(invoiceService.getInvoices());
        return rs;
    }

    /**
     * Post invoice.
     *
     * @param requestPostInvoice the request post invoice
     * @param result the result
     * @return the response post invoice
     */
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseInvoice postInvoice(
            @Validated @RequestBody final RequestPostInvoice requestPostInvoice, final BindingResult result) {

        log.info(requestPostInvoice.toString());

        if (result.hasErrors()) {
            result.getFieldErrors()
                    .forEach(error -> log.info(error.getCode() + " " + error.getDefaultMessage()));
            result.getGlobalErrors().forEach(error -> log.info(error.getCode()));
        }

        ResponseInvoice rs = new ResponseInvoice();
        rs.getInvoiceResultList().add(invoiceService.createInvoices(requestPostInvoice));
        return rs;
    }
}
