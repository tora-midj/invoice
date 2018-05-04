package jp.co.systena.tora.webjava.mid.api.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.api.excepiton.InvoiceException;
import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.InvoiceError;
import jp.co.systena.tora.webjava.mid.common.InvoiceConst;
import jp.co.systena.tora.webjava.mid.common.enums.DelFlg;
import jp.co.systena.tora.webjava.mid.common.enums.InvoiceStatus;
import jp.co.systena.tora.webjava.mid.dao.InvoiceRepositories;
import jp.co.systena.tora.webjava.mid.dao.entity.InvoiceEntity;
import jp.co.systena.tora.webjava.mid.dao.entity.InvoicePriceByClient;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class CreateInvoice.
 */
@Component
@Slf4j
public class InvoiceLogic {

    /** The invoice repositories. */
    @Resource
    private InvoiceRepositories invoiceRepositories;

    /**
     * Gets the invoices.
     *
     * @return the invoices
     */
    public List<InvoiceEntity> getInvoices() {

        return invoiceRepositories.getInvoiceRepository().findAll();
    }

    public InvoiceEntity createInvoiceByClient(
            @NonNull final RequestPostInvoice requestPostInvoice) {

        InvoicePriceByClient invoicePriceByClient = null;
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = new SimpleDateFormat(InvoiceConst.YYYY_MM_DD_HH_MM_SS)
                    .parse(requestPostInvoice.getInvoiceStartDate());
            endDate = new SimpleDateFormat(InvoiceConst.YYYY_MM_DD_HH_MM_SS)
                    .parse(requestPostInvoice.getInvoiceEndDate());

            invoicePriceByClient = invoiceRepositories.getDirectSqlRepository().getInvoiceByClient(
                    Integer.parseInt(requestPostInvoice.getClientNo()),
                    startDate,
                    endDate);
        } catch (NumberFormatException e) {
            throw new InvoiceException(new InvoiceError(), e);
        } catch (ParseException e) {
            throw new InvoiceException(new InvoiceError(), e);
        }

        final InvoiceEntity invoice = new InvoiceEntity();

        invoice.setInvoiceStatus(InvoiceStatus.NEW.getCode());
        invoice.setInvoiceAmt(invoicePriceByClient.getInvoiceAmt());
        invoice.setInvoiceCreateDate(new Date());
        invoice.setInvoiceEndDate(endDate);
        invoice.setInvoiceStartDate(startDate);
        invoice.setInvoiceNote("note");
        invoice.setInvoiceTitle("title");
        invoice.setCreateUser("createUser");
        invoice.setUpdateUser("updateUser");
        invoice.setDelFlg(DelFlg.FLASE.getValue());

        invoiceRepositories.getInvoiceRepository().save(invoice);

        return invoice;

    }
}
