package br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class ItemDoc {

    @Id
    private String id;

    @NotNull
    private String descricao;

    @NotNull
    @Min(0)
    private BigDecimal valor;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtCriacao;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtUltAlteracao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDateTime getDtUltAlteracao() {
        return dtUltAlteracao;
    }

    public void setDtUltAlteracao(LocalDateTime dtUltAlteracao) {
        this.dtUltAlteracao = dtUltAlteracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDoc itemDoc = (ItemDoc) o;
        return id.equals(itemDoc.id) &&
                descricao.equals(itemDoc.descricao) &&
                valor.equals(itemDoc.valor) &&
                dtCriacao.equals(itemDoc.dtCriacao) &&
                dtUltAlteracao.equals(itemDoc.dtUltAlteracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, dtCriacao, dtUltAlteracao);
    }
}
