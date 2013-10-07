/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.service;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mtkortel
 */
@Repository
@Transactional
public class SqlBibService implements BibService, BibTypeService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Starts database connection
     * If wanted then will initialize database and set basic values
     *
     */
    @PostConstruct
    private void init(){
        boolean init = true;
        if (init){
            // Save FieldTypes
            /*
            FieldType author = new FieldType("author");
            FieldType title = new FieldType("title");
            FieldType booktitle = new FieldType("booktitle");
            FieldType year = new FieldType("year", ValueType.Type.NUMBER);
            FieldType editor = new FieldType("editor");
            FieldType publisher = new FieldType("publisher");
            FieldType journal = new FieldType("journal");
            FieldType howpublished = new FieldType("howpublished");
            FieldType month = new FieldType("month", ValueType.Type.NUMBER);
            FieldType note = new FieldType("note");
            FieldType key = new FieldType("key");

            entityManager.merge(author);
            entityManager.merge(title);
            entityManager.merge(booktitle);
            entityManager.merge(editor);
            entityManager.merge(year);
            entityManager.merge(publisher);
            entityManager.merge(journal);
            entityManager.merge(howpublished);
            entityManager.merge(month);
            entityManager.merge(note);
            entityManager.merge(key);

            // Save EntryTypes
            EntryType inproceedings = new EntryType("inproceedings",
                new FieldType[] {
                    author,
                    title,
                    booktitle,
                    year,
                });

            EntryType book = new EntryType("book",
                new FieldType[] {
                    author,
                    title,
                    publisher,
                    year
                });

            EntryType article = new EntryType("article",
                new FieldType[] {
                   author,
                   title,
                   journal,
                   year
                });

            EntryType misc = new EntryType("misc",
                new FieldType[] {
                   author,
                   title,
                   howpublished,
		   month,
		   year,
		   note,
		   key
                });
            entityManager.merge(inproceedings);
            entityManager.merge(book);
            entityManager.merge(article);
            entityManager.merge(misc);
            entityManager.flush();
            */
        }
    }

    @Override
    public List<Entry> getEntries() {
        return entityManager.createQuery("SELECT e FROM Entry e").getResultList();
    }

    @Override
    public void addEntry(Entry entry) {
        entityManager.merge(entry);
    }

    @Override
    public List<EntryType> getEntryTypes() {
        return entityManager.createQuery(
                "SELECT e FROM EntryType e")
                .getResultList();
    }

    @Override
    public List<Entry> findEntriesByKey(String srchkey){
        return entityManager.createQuery(
                "SELECT e FROM Entry e WHERE e.keyname = :srchkey")
                .setParameter("srchkey", srchkey)
                .getResultList();
        /*
        List<Entry> entries = server.find(Entry.class)
                .where().eq("key", srchkey).findList();
        return entries;
        */
    }

    @Override
    public EntryType getEntryType(String key) {
        return (EntryType)entityManager.createQuery(
                "SELECT e FROM EntryType e where e.typekey = :key")
                .setParameter("key", key)
                .getSingleResult();
        /*
        return server.find(EntryType.class).where()
                .eq("typekey", key).findUnique();
        */
    }


}
