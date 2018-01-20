package jp.co.systena.tora.webjava.mid.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class InvoiceApplication.
 */
@SpringBootApplication
@ImportResource(locations = {
        "classpath:invoice-dao-resources.xml",
})
@Slf4j
public class InvoiceDaoApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        ConfigurableApplicationContext con = SpringApplication
                .run(InvoiceDaoApplication.class, args);
        InvoiceRepositories invoiceRepositories = con
                .getBean(InvoiceRepositories.class);

        log.info(invoiceRepositories.getInvoiceRepository().findAll().get(0)
                .toString());
    }
}