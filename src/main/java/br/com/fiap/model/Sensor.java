package br.com.fiap.model;

import br.com.fiap.model.enums.StatusOperacional;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigoIdentificador;

    private String localizacaoDetalhada;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private StatusOperacional statusOperacional;

    @Column(name = "data_instalacao")
    private LocalDateTime dataInstalacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "zona_de_risco_id")
    private ZonaDeRisco zonaDeRisco;

    @OneToMany(mappedBy = "sensor")
    private List<Leitura> leituras;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigoIdentificador() { return codigoIdentificador; }
    public void setCodigoIdentificador(String codigoIdentificador) { this.codigoIdentificador = codigoIdentificador; }
    public String getLocalizacaoDetalhada() { return localizacaoDetalhada; }
    public void setLocalizacaoDetalhada(String localizacaoDetalhada) { this.localizacaoDetalhada = localizacaoDetalhada; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public StatusOperacional getStatusOperacional() { return statusOperacional; }
    public void setStatusOperacional(StatusOperacional statusOperacional) { this.statusOperacional = statusOperacional; }
    public LocalDateTime getDataInstalacao() { return dataInstalacao; }
    public void setDataInstalacao(LocalDateTime dataInstalacao) { this.dataInstalacao = dataInstalacao; }
    public ZonaDeRisco getZonaDeRisco() { return zonaDeRisco; }
    public void setZonaDeRisco(ZonaDeRisco zonaDeRisco) { this.zonaDeRisco = zonaDeRisco; }
    public List<Leitura> getLeituras() { return leituras; }
    public void setLeituras(List<Leitura> leituras) { this.leituras = leituras; }
}
