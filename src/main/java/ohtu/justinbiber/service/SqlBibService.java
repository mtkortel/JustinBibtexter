/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.justinbiber.service;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import java.util.List;
import javax.annotation.PostConstruct;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;
import org.springframework.stereotype.Service;

/**
 *
 * @author mtkortel
 */
@Service
public class SqlBibService implements BibService, BibTypeService  {
    EbeanServer server;
    
    /**
     * Starts database connection
     * If wanted then will initialize database and set basic values
     * 
     */
    @PostConstruct
    private void init(){
        boolean init = true;
        server = initializeDatabase(init);
        if (init){
            // Save FieldTypes
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
            
            server.save(author);
            server.save(title);
            server.save(booktitle);
            server.save(editor);
            server.save(year);
            server.save(publisher);
            server.save(journal);
            server.save(howpublished);
            server.save(month);
            server.save(note);
            server.save(key);
            
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
            server.save(inproceedings);
            server.save(book);
            server.save(article);
            server.save(misc);
            /*
            EntryType e1 = new EntryType();
            e1.setTypeKey("inproceedings");
            server.save(e1);
            e1 = new EntryType();
            e1.setTypeKey("book");
            server.save(e1);
            e1 = new EntryType();
            e1.setTypeKey("article");
            server.save(e1);
            e1 = new EntryType();
            e1.setTypeKey("misc");
            server.save(e1);
            */
        }
    }
    
    private EbeanServer initializeDatabase(boolean dropAndCreateDatabase) {
        ServerConfig config = new ServerConfig();
        config.setName("justinDB");

        DataSourceConfig sqLite = new DataSourceConfig();
        ///TODO: Tänne asetukset
        sqLite.setDriver("org.sqlite.JDBC");
        sqLite.setUsername("justin");
        sqLite.setPassword("bibtext");
        sqLite.setUrl("jdbc:sqlite:beer.db");
        config.setDataSourceConfig(sqLite);
        //config.setDatabasePlatform(); //new SQLitePlatform());
        //config.getDataSourceConfig().setIsolationLevel(Transaction.READ_UNCOMMITTED);

 
        if (dropAndCreateDatabase) {
            config.setDdlGenerate(true);
            config.setDdlRun(true);
        }

        config.setDefaultServer(false);
        config.setRegister(false);

        config.addClass(Entry.class);
        config.addClass(EntryType.class);

        return EbeanServerFactory.create(config);
    }

    @Override
    public List<Entry> getEntries() {
        List<Entry> entries = server.find(Entry.class).findList();
        return entries;
    }

    @Override
    public void addEntry(Entry entry) {
        server.save(entry);
    }

    @Override
    public List<EntryType> getEntryTypes() {
        List<EntryType> types = server.find(EntryType.class).findList();
        return types;
    }
    
    @Override
    public List<Entry> findEntriesByKey(String srchkey){
        List<Entry> entries = server.find(Entry.class)
                .where().eq("key", srchkey).findList();
        return entries;
    }

    @Override
    public EntryType getEntryType(String key) {
        return server.find(EntryType.class).where()
                .eq("typekey", key).findUnique();
    }
    
    
}
