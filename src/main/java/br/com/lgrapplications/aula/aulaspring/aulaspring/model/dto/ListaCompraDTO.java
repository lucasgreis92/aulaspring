package br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListaCompraDTO {

    @Id
    private String id;

    @NotNull
    private PessoaDTO pessoa;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtFechamento;

    @NotNull
    private BigDecimal total;

    private List<ItemDTO> itens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDateTime getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(LocalDateTime dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }


}
