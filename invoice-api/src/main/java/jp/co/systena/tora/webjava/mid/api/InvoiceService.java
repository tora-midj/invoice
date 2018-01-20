package jp.co.systena.tora.webjava.mid.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.systena.tora.webjava.mid.api.converter.ResponseGetInvoiceConverter;
import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponseGetInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponsePostInvoice;
import jp.co.systena.tora.webjava.mid.logic.InvoiceLogic;
import jp.co.systena.tora.webjava.mid.logic.model.CreateClientInvoiceModel;
import lombok.NonNull;

/**
 * The Class InvoiceService.
 */
@Service
@Transactional
@ImportResource(locations = {
        "classpath:invoice-logic-resources.xml",
        })
public class InvoiceService {

    /** The invoice repository. */
    @Resource
    private InvoiceLogic invoiceLogic;

    /** The response get invoice converter. */
    @Resource
    private ResponseGetInvoiceConverter responseGetInvoiceConverter;

    /**
     * Gets the invoices.
     *
     * @return the invoices
     */
    public List<ResponseGetInvoice> getInvoices() {

        final List<ResponseGetInvoice> responseGetInvoiceList = new ArrayList<ResponseGetInvoice>();

        invoiceLogic.getInvoices().forEach(invoice -> responseGetInvoiceList
                .add(responseGetInvoiceConverter.convert(invoice)));
        return responseGetInvoiceList;
    }

    /**
     * Creates the invoices.
     *
     * @param requestPostInvoice the request post invoice
     * @return the response post invoice
     */
    public ResponsePostInvoice createInvoices(
            @NonNull final RequestPostInvoice requestPostInvoice) {

        invoiceLogic.createClientInvoice(new CreateClientInvoiceModel());

        ResponsePostInvoice responsePostInvoice = new ResponsePostInvoice();
        responsePostInvoice.setInvoiceNo("12345");

        return responsePostInvoice;
    }
}
