package jp.co.systena.tora.webjava.mid.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.dao.model.Invoice;

/**
 * The Class JpaExe.
 */
@Component
@ImportResource(locations = {
        "classpath:invoice-dao-resources.xml" })
public class JpaExe {

    /** The invoice repository. */
    @Resource
    private InvoiceRepositories invoiceRepositories;

    /**
     * Hoge.
     *
     * @return the list
     */
    public List<Invoice> hoge() {

        return invoiceRepositories.getInvoiceRepository().findAll();
    }
}
