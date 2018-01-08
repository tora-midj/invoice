package jp.co.systena.tora.webjava.mid.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.systena.tora.webjava.mid.dao.model.Client;

/**
 * The Interface ClientRepository.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /* (非 Javadoc)
     * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
     */
    List<Client> findAll();

}