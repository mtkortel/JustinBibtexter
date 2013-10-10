package ohtu.justinbiber.service;

import javax.annotation.PostConstruct;
import ohtu.justinbiber.domain.Entry;
import ohtu.justinbiber.domain.EntryType;
import ohtu.justinbiber.domain.Field;
import ohtu.justinbiber.domain.FieldType;
import ohtu.justinbiber.domain.ValueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BibInitialize {

    @Autowired
    private BibTypeService bibTypeService;
    @Autowired
    private BibService bibService;

    @PostConstruct
    void init() {
        bibTypeService.initialize(new BibInitializer<BibTypeServiceManager>() {
            @Override
            public void initialize(BibTypeServiceManager manager) {
                initTypeData(manager);
            }
        });
        bibService.initialize(new BibInitializer<BibServiceManager>() {
            @Override
            public void initialize(BibServiceManager manager) {
                initData(manager);
            }
        });
    }

    private void initTypeData(BibTypeServiceManager manager) {
        ValueType text = manager.addValueType(new ValueType(ValueType.Type.TEXT));
        ValueType number = manager.addValueType(new ValueType(ValueType.Type.NUMBER));

        FieldType author = manager.addFieldType(new FieldType("author", text));
        FieldType title = manager.addFieldType(new FieldType("title", text));
        FieldType booktitle = manager.addFieldType(new FieldType("booktitle", text));
        FieldType year = manager.addFieldType(new FieldType("year", number));
        FieldType editor = manager.addFieldType(new FieldType("editor", text));
        FieldType publisher = manager.addFieldType(new FieldType("publisher", text));
        FieldType journal = manager.addFieldType(new FieldType("journal", text));
        FieldType howpublished = manager.addFieldType(new FieldType("howpublished", text));
        FieldType month = manager.addFieldType(new FieldType("month", text));
        FieldType note = manager.addFieldType(new FieldType("note", text));
        FieldType key = manager.addFieldType(new FieldType("key", text));

        EntryType inproceedings = manager.addEntryType(new EntryType("inproceedings",
                new FieldType[]{
            author,
            title,
            booktitle,
            year
        }));
        EntryType book = manager.addEntryType(new EntryType("book",
                new FieldType[]{
            author,
            title,
            publisher,
            year
        }));
        EntryType article = manager.addEntryType(new EntryType("article",
                new FieldType[]{
            author,
            title,
            journal,
            year
        }));
        EntryType misc = manager.addEntryType(new EntryType("misc",
                new FieldType[]{
            author,
            title,
            howpublished,
            month,
            year,
            note,
            key
        }));
    }

    private void initData(BibServiceManager manager) {
        EntryType inproceedings = bibTypeService.getEntryType("inproceedings");
        EntryType book = bibTypeService.getEntryType("book");
        EntryType article = bibTypeService.getEntryType("article");
        EntryType misc = bibTypeService.getEntryType("misc");

        manager.addEntry(new Entry(book, "SWEBOK", new Field[] {
            new Field("publisher", "IEEE Computer Society"),
            new Field("editor", "Abram, Aman and More, James W. and Bourgue Pierre and Dupuis Robert"),
            new Field("year", "2004"),
            new Field("title", "Guide to the Software Engineering Body of Knownledge")
        }));
        manager.addEntry(new Entry(book, "BA04", new Field[] {
            new Field("author", "Beck, Kent and Andres, Cynthia"),
            new Field("title", "Extreme Programming Explained: Embrace Change (2nd Edition)"),
            new Field("year", "2004"),
            new Field("publisher", "Addison-Wesley Professional")
        }));
        manager.addEntry(new Entry(book, "Martin09", new Field[] {
            new Field("author", "Martin, Robert"),
            new Field("title", "Clean Code: A Handbook of Agile Software Craftsmanship"),
            new Field("year", "2008"),
            new Field("publisher", "Prentice Hall")
        }));
        manager.addEntry(new Entry(inproceedings, "PSMM07", new Field[] {
            new Field("author", "Pears, Arnold and Seidman, Stephen and Malmi, Lauri and Mannila, Linda and Adams, Elizabeth and Bennedsen, Jens and Devlin, Marie and Paterson, James"),
            new Field("title", "A survey of literature on the teaching of introductory programming"),
            new Field("booktitle", "ITiCSE-WGR '07: Working group reports on ITiCSE on Innovation and technology in computer science education"),
            new Field("year", "2007"),
            new Field("pages", "204--223"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(inproceedings, "GvG00", new Field[] {
            new Field("author", "Grissom, Scott and Van Gorp, Mark J."),
            new Field("title", "A practical approach to integrating active and collaborative learning into the introductory computer science curriculum"),
            new Field("booktitle", "Proceedings of the seventh annual consortium on Computing in small colleges midwestern conference"),
            new Field("year", "2000"),
            new Field("pages", "95--100"),
            new Field("publisher", "Consortium for Computing Sciences in Colleges"),
            new Field("address", "USA")
        }));
        manager.addEntry(new Entry(article, "W04", new Field[] {
            new Field("author", "Whittington, Keith J."),
            new Field("title", "Infusing active learning into introductory programming courses"),
            new Field("journal", "J. Comput. Small Coll."),
            new Field("volume", "19"),
            new Field("number", "5"),
            new Field("year", "2004"),
            new Field("pages", "249--259"),
            new Field("publisher", "Consortium for Computing Sciences in Colleges"),
            new Field("address", "USA")
        }));
        manager.addEntry(new Entry(book, "V78", new Field[] {
            new Field("AUTHOR", "L. S. Vygotsky"),
            new Field("TITLE", "Mind in Society: The Development of Higher Psychological Processes"),
            new Field("PUBLISHER", "Harvard University Press"),
            new Field("YEAR", "1978"),
            new Field("ADDRESS", "Cambridge, MA")
        }));
        manager.addEntry(new Entry(inproceedings, "AR95", new Field[] {
            new Field("author", "Astrachan, Owen and Reed, David"),
            new Field("title", "AAA and CS 1: the applied apprenticeship approach to CS 1"),
            new Field("booktitle", "SIGCSE '95: Proceedings of the twenty-sixth SIGCSE technical symposium on Computer science education"),
            new Field("year", "1995"),
            new Field("pages", "1--5"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(article, "CBH91", new Field[] {
            new Field("author", "Allan Collins and John Seely Brown and Ann Holum"),
            new Field("title", "Cognitive apprenticeship: making thinking visible"),
            new Field("journal", "American Educator"),
            new Field("year", "1991"),
            new Field("volume", "6"),
            new Field("pages", "38--46")
        }));
        manager.addEntry(new Entry(article, "RRR03", new Field[] {
            new Field("author", "Anthony Robins and Janet Rountree and Nathan Rountree"),
            new Field("title", "Learning and teaching programming: A review and discussion"),
            new Field("journal", "Computer Science Education"),
            new Field("year", "2003"),
            new Field("volume", "13"),
            new Field("pages", "137--172")
        }));
        manager.addEntry(new Entry(inproceedings, "KB04", new Field[] {
            new Field("author", "Kölling Michael and Barnes, David J."),
            new Field("title", "Enhancing apprentice-based learning of Java"),
            new Field("booktitle", "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education"),
            new Field("year", "2004"),
            new Field("pages", "286--290"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(article, "B06", new Field[] {
            new Field("author", "Black, Toni R."),
            new Field("title", "Helping novice programming students succeed"),
            new Field("journal", "J. Comput. Small Coll."),
            new Field("volume", "22"),
            new Field("number", "2"),
            new Field("year", "2006"),
            new Field("pages", "109--114"),
            new Field("publisher", "Consortium for Computing Sciences in Colleges"),
            new Field("address", "USA")
        }));
        manager.addEntry(new Entry(inproceedings, "CB07", new Field[] {
            new Field("author", "Caspersen, Michael E. and Bennedsen, Jens"),
            new Field("title", "Instructional design of a programming course: a learning theoretic approach"),
            new Field("booktitle", "ICER '07: Proceedings of the third international workshop on Computing education research"),
            new Field("year", "2007"),
            new Field("pages", "111--122"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(article, "BB03", new Field[] {
            new Field("author", "Bruhn, Russel E. and Burton, Philip J."),
            new Field("title", "An approach to teaching Java using computers"),
            new Field("journal", "SIGCSE Bull."),
            new Field("volume", "35"),
            new Field("number", "4"),
            new Field("year", "2003"),
            new Field("pages", "94--99"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(inproceedings, "R02", new Field[] {
            new Field("author", "Roumani, Hamzeh"),
            new Field("title", "Design guidelines for the lab component of objects-first CS1"),
            new Field("booktitle", "SIGCSE '02: Proceedings of the 33rd SIGCSE technical symposium on Computer science education"),
            new Field("year", "2002"),
            new Field("pages", "222--226"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(article, "SS86", new Field[] {
            new Field("author", "Spohrer, James C. and Soloway, Elliot"),
            new Field("title", "Novice mistakes: are the folk wisdoms correct?"),
            new Field("journal", "Commun. ACM"),
            new Field("volume", "29"),
            new Field("number", "7"),
            new Field("year", "1986"),
            new Field("pages", "624--632"),
            new Field("publisher", "ACM")
        }));
        manager.addEntry(new Entry(inproceedings, "HM06", new Field[] {
            new Field("author", "Hassinen, Marko and Mäyrä, Hannu"),
            new Field("title", "Learning programming by programming: a case study"),
            new Field("booktitle", "Baltic Sea '06: Proceedings of the 6th Baltic Sea conference on Computing education research: Koli Calling 2006"),
            new Field("year", "2006"),
            new Field("pages", "117--119"),
            new Field("publisher", "ACM")
        }));
    }
}
