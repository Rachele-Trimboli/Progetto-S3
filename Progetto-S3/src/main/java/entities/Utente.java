package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {

    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String cognome;
    @Column(name = "annodinascita")
    private LocalDate annoDiNascita;
    @Column(name = "numeroditessera")
    private int numeroditessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate annoDiNascita, int numeroditessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoDiNascita = annoDiNascita;
        this.numeroditessera = numeroditessera;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getAnnoDiNascita() {
        return annoDiNascita;
    }

    public void setAnnoDiNascita(LocalDate annoDiNascita) {
        this.annoDiNascita = annoDiNascita;
    }

    public int getNumeroditessera() {
        return numeroditessera;
    }

    public void setNumeroditessera(int numeroditessera) {
        this.numeroditessera = numeroditessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", annoDiNascita=" + annoDiNascita +
                ", numeroditessera=" + numeroditessera +
                '}';
    }
}
