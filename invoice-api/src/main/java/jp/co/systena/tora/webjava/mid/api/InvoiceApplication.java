package jp.co.systena.tora.webjava.mid.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * The Class InvoiceApplication.
 */
@SpringBootApplication
@ComponentScan("jp.co.systena.tora.webjava.mid")
@PropertySource("classpath:invoice-dao.properties")
public class InvoiceApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(InvoiceApplication.class, args);
    }
}