package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Column(name = "nivel_agua_cm")
    private Double nivelAguaCm;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getNivelAguaCm() {
        return nivelAguaCm;
    }

    public void setNivelAguaCm(Double nivelAguaCm) {
        this.nivelAguaCm = nivelAguaCm;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // Getters, setters, construtores
}
