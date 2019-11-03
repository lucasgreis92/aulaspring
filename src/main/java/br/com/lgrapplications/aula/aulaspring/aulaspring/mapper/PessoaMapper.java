package br.com.lgrapplications.aula.aulaspring.aulaspring.mapper;

import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.PessoaDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.PessoaDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class PessoaMapper {

    public PessoaDTO convertToDto(PessoaDoc doc){
        PessoaDTO dto = new PessoaDTO();
        dto.setId(doc.getId());
        dto.setCpf(doc.getCpf());
        dto.setNome(doc.getNome());
        return dto;
    }

    public PessoaDoc convertToDOC(PessoaDTO dto,PessoaDoc doc){
        if (doc == null){
            doc = new PessoaDoc();
            doc.setDtCriacao(LocalDateTime.now());
            doc.setDtUltAlteracao(LocalDateTime.now());
            doc.setTotalGasto(BigDecimal.ZERO);
        }
        doc.setId(dto.getId());
        doc.setCpf(dto.getCpf());
        doc.setNome(dto.getNome());
        return doc;
    }

}
