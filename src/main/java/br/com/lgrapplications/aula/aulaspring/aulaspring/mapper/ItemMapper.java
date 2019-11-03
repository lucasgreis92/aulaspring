package br.com.lgrapplications.aula.aulaspring.aulaspring.mapper;

import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.ItemDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ItemDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ItemMapper {

    public ItemDTO convertToDTO(ItemDoc item){
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setDescricao(item.getDescricao());
        dto.setValor(item.getValor());
        return dto;
    }

    public ItemDoc convertToDOC(ItemDTO dto,ItemDoc doc){
        if (doc == null){
            doc = new ItemDoc();
            doc.setDtCriacao(LocalDateTime.now());
            doc.setDtUltAlteracao(LocalDateTime.now());
        }
        doc.setDescricao(dto.getDescricao());
        doc.setValor(dto.getValor());
        return doc;
    }
}
