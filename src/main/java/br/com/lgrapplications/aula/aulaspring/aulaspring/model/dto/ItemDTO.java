package br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto;

import java.math.BigDecimal;

public class ItemDTO {

    private String id;

    private String descricao;

    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
