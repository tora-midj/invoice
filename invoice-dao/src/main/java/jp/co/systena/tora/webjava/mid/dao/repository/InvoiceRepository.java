package jp.co.systena.tora.webjava.mid.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.systena.tora.webjava.mid.dao.model.Invoice;

/**
 * The Interface InvoiceRepository.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    /* (非 Javadoc)
     * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
     */
    List<Invoice> findAll();

}