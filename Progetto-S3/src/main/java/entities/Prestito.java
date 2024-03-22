package entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Prestito {

    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente;

    @OneToOne(mappedBy = "prestito")
    private ElementoEditoriale elementoprestato;

    private LocalDate inizioprestito;
    private LocalDate restituzioneprevista;
    private LocalDate datarestituzioneeffettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, ElementoEditoriale elementoprestato, LocalDate inizioprestito, LocalDate restituzioneprevista, LocalDate datarestituzioneeffettiva) {
        this.utente = utente;
        this.elementoprestato = elementoprestato;
        this.inizioprestito = inizioprestito;
        this.restituzioneprevista = restituzioneprevista;
        this.datarestituzioneeffettiva = datarestituzioneeffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoEditoriale getElementoprestato() {
        return elementoprestato;
    }

    public void setElementoprestato(ElementoEditoriale elementoprestato) {
        this.elementoprestato = elementoprestato;
    }

    public LocalDate getInizioprestito() {
        return inizioprestito;
    }

    public void setInizioprestito(LocalDate inizioprestito) {
        this.inizioprestito = inizioprestito;
    }

    public LocalDate getRestituzioneprevista() {
        return restituzioneprevista;
    }

    public void setRestituzioneprevista(LocalDate restituzioneprevista) {
        this.restituzioneprevista = restituzioneprevista;
    }

    public LocalDate getDatarestituzioneeffettiva() {
        return datarestituzioneeffettiva;
    }

    public void setDatarestituzioneeffettiva(LocalDate datarestituzioneeffettiva) {
        this.datarestituzioneeffettiva = datarestituzioneeffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoprestato=" + elementoprestato +
                ", inizioprestito=" + inizioprestito +
                ", restituzioneprevista=" + restituzioneprevista +
                ", datarestituzioneeffettiva=" + datarestituzioneeffettiva +
                '}';
    }
}
