package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Rivista extends ElementoEditoriale{


    private Periodicità periodicità;

    public Rivista() {
    }

    public Rivista(String titolo, int annoPubblicazione, int pagine, Periodicità periodicità) {
        super(titolo, annoPubblicazione, pagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                "} " + super.toString();
    }
}
