package br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Objects;

public class PessoaDTO {

    private String id;

    private String cpf;

    private String nome;

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
        PessoaDTO dto = (PessoaDTO) o;
        return id.equals(dto.id) &&
                cpf.equals(dto.cpf) &&
                nome.equals(dto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome);
    }
}
