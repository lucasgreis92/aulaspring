package br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class PessoaDoc {

    @Id
    private String id;

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtCriacao;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private LocalDateTime dtUltAlteracao;

    @NotNull
    private BigDecimal totalGasto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public BigDecimal getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(BigDecimal totalGasto) {
        this.totalGasto = totalGasto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDoc pessoaDoc = (PessoaDoc) o;
        return id.equals(pessoaDoc.id) &&
                cpf.equals(pessoaDoc.cpf) &&
                nome.equals(pessoaDoc.nome) &&
                dtCriacao.equals(pessoaDoc.dtCriacao) &&
                dtUltAlteracao.equals(pessoaDoc.dtUltAlteracao) &&
                totalGasto.equals(pessoaDoc.totalGasto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome, dtCriacao, dtUltAlteracao, totalGasto);
    }
}
