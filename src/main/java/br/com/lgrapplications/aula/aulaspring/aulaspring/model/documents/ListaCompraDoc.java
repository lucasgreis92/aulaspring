package br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents;

import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ItemDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.PessoaDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.enuns.StatusListaCompra;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document
public class ListaCompraDoc {

    @Id
    private String id;

    @NotNull
    private PessoaDTO pessoa;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtCriacao;

    private List<ItemDTO> itens;

    @NotNull
    private StatusListaCompra statusListaCompra;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtFechamento;

    @NotNull
    private BigDecimal total;

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public StatusListaCompra getStatusListaCompra() {
        return statusListaCompra;
    }

    public void setStatusListaCompra(StatusListaCompra statusListaCompra) {
        this.statusListaCompra = statusListaCompra;
    }

    public LocalDateTime getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(LocalDateTime dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaCompraDoc that = (ListaCompraDoc) o;
        return id.equals(that.id) &&
                pessoa.equals(that.pessoa) &&
                dtCriacao.equals(that.dtCriacao) &&
                Objects.equals(itens, that.itens) &&
                statusListaCompra == that.statusListaCompra &&
                Objects.equals(dtFechamento, that.dtFechamento) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pessoa, dtCriacao, itens, statusListaCompra, dtFechamento, total);
    }
}
