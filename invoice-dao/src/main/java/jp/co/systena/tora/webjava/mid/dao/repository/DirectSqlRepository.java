package jp.co.systena.tora.webjava.mid.dao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.common.InvoiceConst;
import jp.co.systena.tora.webjava.mid.dao.entity.InvoicePriceByClient;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class DirectSqlRepository.
 *
 * @author reo
 */
@Component
@Slf4j
public class DirectSqlRepository {

    /** The named parameter jdbc template. */
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /** The Constant SELECT_INVOUCE_PRICE_BY_CLIENT. */
    private static final String SELECT_INVOUCE_PRICE_BY_CLIENT = ""
            + "SELECT "
            + "    c.client_no as client_no, "
            + "    SUM(o.item_count * o.item_price) as invoice_amt "
            + "FROM "
            + "    ord as o, "
            + "    client as c "
            + "WHERE "
            + "    o.client_no = c.client_no AND "
            + "o.del_flg='0' AND "
            + "c.del_flg='0' AND "
            + "o.create_datetime BETWEEN :create_datetime_from AND :create_datetime_to AND "
            + "c.client_no = :client_no "
            + "GROUP BY "
            + "    c.client_no";

    /**
     * Gets the invoice by client.
     *
     * @return the invoice by client
     */
    public InvoicePriceByClient getInvoiceByClient(int clientNo, Date createDatetimeFrom, Date createDatetimeTo) {

        InvoicePriceByClient invoicePriceByClient = namedParameterJdbcTemplate.queryForObject(
                // Query
                SELECT_INVOUCE_PRICE_BY_CLIENT,
                // BindParams
                new MapSqlParameterSource()
                        .addValue("client_no", clientNo)
                        .addValue("create_datetime_from",
                                new SimpleDateFormat(InvoiceConst.YYYY_MM_DD_HH_MM_SS).format(createDatetimeFrom))
                        .addValue("create_datetime_to",
                                new SimpleDateFormat(InvoiceConst.YYYY_MM_DD_HH_MM_SS).format(createDatetimeTo)),
                // Mapper
                new RowMapper<InvoicePriceByClient>() {
                    @Override
                    public InvoicePriceByClient mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        return new InvoicePriceByClient(
                                rs.getInt("client_no"),
                                rs.getInt("invoice_amt"));
                    }
                });

        return invoicePriceByClient;
    }
}
