package jp.co.systena.tora.webjava.mid.logic;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.common.enums.DelFlg;
import jp.co.systena.tora.webjava.mid.dao.InvoiceRepositories;
import jp.co.systena.tora.webjava.mid.dao.model.Invoice;
import jp.co.systena.tora.webjava.mid.logic.model.CreateClientInvoiceModel;
import lombok.NonNull;

/**
 * The Class CreateInvoice.
 */
@Component
public class InvoiceLogic {

    /** The invoice repositories. */
    @Resource
    private InvoiceRepositories invoiceRepositories;

    public List<Invoice> getInvoices() {
        return invoiceRepositories.getInvoiceRepository().findAll();
    }

    public void createClientInvoice(
            @NonNull final CreateClientInvoiceModel createClientInvoiceModel) {

        final Invoice invoice = new Invoice();

        invoice.setClientNo(10);
        invoice.setInvoiceStatus("20");

        invoice.setInvoiceAmt(100);
        invoice.setInvoiceCreateDate(new Date());
        invoice.setInvoiceEndDate(new Date());
        invoice.setInvoiceStartDate(new Date());
        invoice.setInvoiceNote("note");
        invoice.setInvoiceTitle("title");

        invoice.setCreateUser("createUser");
        invoice.setUpdateUser("updateUser");
        invoice.setDelFlg(DelFlg.FLASE.getValue());

        invoiceRepositories.getInvoiceRepository().save(invoice);
    }

}
