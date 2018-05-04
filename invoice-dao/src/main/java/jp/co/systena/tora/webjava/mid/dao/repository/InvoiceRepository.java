package jp.co.systena.tora.webjava.mid.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.systena.tora.webjava.mid.dao.entity.InvoiceEntity;

/**
 * The Interface InvoiceRepository.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

    /* (非 Javadoc)
     * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
     */
    List<InvoiceEntity> findAll();

}