package jp.co.systena.tora.webjava.mid.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.dao.repository.ClientRepository;
import jp.co.systena.tora.webjava.mid.dao.repository.InvoiceRepository;
import jp.co.systena.tora.webjava.mid.dao.repository.OrderRepository;
import lombok.Getter;

/**
 * The Class InvoiceRepositories.
 */
@Component
@Getter
public class InvoiceRepositories {

    /** The client repository. */
    @Resource
    private ClientRepository clientRepository;

    /** The invoice repository. */
    @Resource
    private InvoiceRepository invoiceRepository;

    /** The order repository. */
    @Resource
    private OrderRepository orderRepository;

    /** The jdbc template. */
    @Resource
    private JdbcTemplate jdbcTemplate;

}
