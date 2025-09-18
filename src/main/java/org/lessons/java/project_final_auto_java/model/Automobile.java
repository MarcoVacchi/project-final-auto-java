package org.lessons.java.project_final_auto_java.model;

import java.util.List;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "automobili")
public class Automobile {

    // VARIABILI D ISTANZA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String modello;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String marca;

    @NonNull
    private Double prezzo;

    @NotNull
    private Integer anno_produzione;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String carburante;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String trasmissione;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String immagine_url;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String descrizione;

    // RELAZIONI

    // uno a piu

    @OneToMany(mappedBy = "automobile", cascade = { CascadeType.REMOVE })
    private List<Recensione> recensioni;

    // piu a piu

    @ManyToMany
    @JoinTable(name = "automobile_optional", joinColumns = @JoinColumn(name = "automobile_id"), inverseJoinColumns = @JoinColumn(name = "optionalAuto_id"))
    private List<OptionalAuto> optionalList;

    // GETTER E SETTER

    public List<Recensione> getRecensioni() {
        return this.recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    public List<OptionalAuto> getOptionalList() {
        return this.optionalList;
    }

    public void setOptionalList(List<OptionalAuto> optionalList) {
        this.optionalList = optionalList;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModello() {
        return this.modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getAnno_produzione() {
        return this.anno_produzione;
    }

    public void setAnno_produzione(Integer anno_produzione) {
        this.anno_produzione = anno_produzione;
    }

    public String getCarburante() {
        return this.carburante;
    }

    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

    public String getTrasmissione() {
        return this.trasmissione;
    }

    public void setTrasmissione(String trasmissione) {
        this.trasmissione = trasmissione;
    }

    public String getImmagine_url() {
        return this.immagine_url;
    }

    public void setImmagine_url(String immagine_url) {
        this.immagine_url = immagine_url;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return this.modello + this.marca + this.prezzo + this.anno_produzione + this.carburante + this.trasmissione
                + this.immagine_url + this.descrizione;
    }

}
