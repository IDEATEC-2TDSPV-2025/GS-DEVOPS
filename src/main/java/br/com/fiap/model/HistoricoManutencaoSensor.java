package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HistoricoManutencaoSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    private String descricao;

    @Column(name = "data_manutencao")
    private LocalDateTime dataManutencao;

    private String realizadoPor;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDateTime dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getRealizadoPor() {
        return realizadoPor;
    }

    public void setRealizadoPor(String realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    // Getters, setters, construtores
}
