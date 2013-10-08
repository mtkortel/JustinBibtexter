/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ohtu.justinbiber.domain.Entry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mtkortel
 */
@Repository
public class SqlBibService implements BibService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Entry> getEntries() {
        return entityManager.createQuery(
                "SELECT e FROM Entry e")
                .getResultList();
    }

    @Override
    @Transactional
    public void addEntry(Entry entry) {
        entityManager.merge(entry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entry> findEntriesByKey(String srchkey) {
        return entityManager.createQuery(
                "SELECT e FROM Entry e WHERE e.entryKey = :srchkey")
                .setParameter("srchkey", srchkey)
                .getResultList();
    }

}
