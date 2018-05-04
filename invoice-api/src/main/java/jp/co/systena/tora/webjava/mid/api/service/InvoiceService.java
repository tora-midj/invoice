package jp.co.systena.tora.webjava.mid.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.systena.tora.webjava.mid.api.converter.InvoiceResultConverter;
import jp.co.systena.tora.webjava.mid.api.logic.InvoiceLogic;
import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.InvoiceResult;
import lombok.NonNull;

/**
 * The Class InvoiceService.
 */
@Service
@Transactional
public class InvoiceService {

    @Resource
    private InvoiceLogic invoiceLogic;

    @Resource
    private InvoiceResultConverter invoiceResultConverter;

    public List<InvoiceResult> getInvoices() {

        final List<InvoiceResult> invoiceResultList = new ArrayList<InvoiceResult>();

        // 請求書を全検索して結果リストを返却
        invoiceLogic.getInvoices().forEach(invoice -> invoiceResultList
                .add(invoiceResultConverter.convert(invoice)));

        return invoiceResultList;
    }

    public InvoiceResult createInvoices(
            @NonNull final RequestPostInvoice requestPostInvoice) {

        return invoiceResultConverter.convert(invoiceLogic.createInvoiceByClient(requestPostInvoice));

    }
}
