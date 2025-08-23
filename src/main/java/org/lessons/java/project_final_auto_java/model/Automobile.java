package org.lessons.java.project_final_auto_java.model;

// import java.util.ArrayList;
// import java.util.List;

import io.micrometer.common.lang.NonNull;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "automobili")
public class Automobile {

    // VARIABILI D ISTANZA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String modello;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String marca;

    @NonNull
    private Double prezzo;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private Integer anno_produzione;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String carburante;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String trasmissione;

    @NotBlank(message = "Questo campo non può essere NULL, BLANK o EMPTY")
    private String immagine_url;

    // RELAZIONI

    // @OneToMany(mappedBy = "automobile", cascade = CascadeType.ALL, orphanRemoval
    // = true)
    // private List<Recensione> recensioni = new ArrayList<>();

    // @ManyToMany
    // @JoinTable(name = "auto_optional", joinColumns = @JoinColumn(name =
    // "auto_id"), inverseJoinColumns = @JoinColumn(name = "optional_id"))
    // private List<OptionalAuto> optionalList = new ArrayList<>();

    // GETTER E SETTER

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return this.modello + this.marca + this.prezzo + this.anno_produzione + this.carburante + this.trasmissione
                + this.immagine_url;
    }

}
