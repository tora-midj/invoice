package jp.co.systena.tora.webjava.mid.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class InvoiceApplication {

    public static void main(String[] args) {
        SpringApplication
                .run(InvoiceApplication.class, args);
        //        ConfigurableApplicationContext con = SpringApplication
        //                .run(InvoiceApplication.class, args);
        //        InvoiceService invoiceService = con.getBean(InvoiceService.class);
        //        List<Invoice> invoiceList = invoiceService.findInvoices();
        //
        //        log.info(invoiceList.get(0).toString());
    }
}