package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Libro extends ElementoEditoriale {

    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int pagine, String autore, String genere) {
        super(titolo, annoPubblicazione, pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} " + super.toString();
    }
}
