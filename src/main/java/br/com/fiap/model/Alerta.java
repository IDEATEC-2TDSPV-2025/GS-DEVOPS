package br.com.fiap.model;

import br.com.fiap.model.enums.StatusAlerta;
import br.com.fiap.model.enums.TipoAlerta;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zona_de_risco_id")
    private ZonaDeRisco zonaDeRisco;

    @Enumerated(EnumType.STRING)
    private StatusAlerta status;

    @Enumerated(EnumType.STRING)
    private TipoAlerta tipoAlerta;

    private String mensagem;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ZonaDeRisco getZonaDeRisco() { return zonaDeRisco; }
    public void setZonaDeRisco(ZonaDeRisco zonaDeRisco) { this.zonaDeRisco = zonaDeRisco; }
    public StatusAlerta getStatus() { return status; }
    public void setStatus(StatusAlerta status) { this.status = status; }
    public TipoAlerta getTipoAlerta() { return tipoAlerta; }
    public void setTipoAlerta(TipoAlerta tipoAlerta) { this.tipoAlerta = tipoAlerta; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
