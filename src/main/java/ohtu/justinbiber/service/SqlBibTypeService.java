package ohtu.justinbiber.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SqlBibTypeService implements BibTypeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<EntryType> getEntryTypes() {
        return entityManager.createQuery(
                "SELECT e FROM EntryType e ORDER BY e.id")
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public EntryType getEntryType(String key) {
        return (EntryType) entityManager.createQuery(
                "SELECT e FROM EntryType e WHERE e.typeKey = :key")
                .setParameter("key", key)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void initialize(BibInitializer<BibTypeServiceManager> initializer) {
        // only initialize if there are no entry types
        if (((Number) entityManager.createQuery(
                "SELECT COUNT(e) FROM EntryType e")
                .getSingleResult())
                .intValue() == 0) {
            initializer.initialize(new BibTypeServiceManager() {
                @Override
                public EntryType addEntryType(EntryType entryType) {
                    return entityManager.merge(entryType);
                }

                @Override
                public FieldType addFieldType(FieldType fieldType) {
                    return entityManager.merge(fieldType);
                }

                @Override
                public ValueType addValueType(ValueType valueType) {
                    return entityManager.merge(valueType);
                }
            });
        }
    }
}
