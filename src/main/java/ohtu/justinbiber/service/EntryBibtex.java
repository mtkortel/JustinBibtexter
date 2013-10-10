package ohtu.justinbiber.service;

import ohtu.justinbiber.domain.Entry;

public class EntryBibtex {
    private Entry entry;
    private String bibtex;

    public EntryBibtex(Entry entry, String bibtex) {
        this.entry = entry;
        this.bibtex = bibtex;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getBibtex() {
        return bibtex;
    }

    public void setBibtex(String bibtex) {
        this.bibtex = bibtex;
    }


}
