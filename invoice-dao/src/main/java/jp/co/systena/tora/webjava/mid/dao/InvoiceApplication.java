package jp.co.systena.tora.webjava.mid.dao;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.systena.tora.webjava.mid.dao.model.Invoice;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class InvoiceApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext con = SpringApplication
                .run(InvoiceApplication.class, args);
        JpaExe jpaExe = con.getBean(JpaExe.class);

        List<Invoice> invoiceList = jpaExe.hoge();
        Invoice i = invoiceList.get(0);

        log.info(i.toString());
    }

}