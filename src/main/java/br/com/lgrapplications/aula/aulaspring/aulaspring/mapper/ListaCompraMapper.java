package br.com.lgrapplications.aula.aulaspring.aulaspring.mapper;

import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.ListaCompraDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ListaCompraDTO;
import org.springframework.stereotype.Component;

@Component
public class ListaCompraMapper {


    public ListaCompraDTO convertToDTO(ListaCompraDoc listaCompraDoc){
        ListaCompraDTO dto = new ListaCompraDTO();
        dto.setDtFechamento(listaCompraDoc.getDtFechamento());
        dto.setId(listaCompraDoc.getId());
        dto.setItens(listaCompraDoc.getItens());
        dto.setPessoa(listaCompraDoc.getPessoa());
        dto.setTotal(listaCompraDoc.getTotal());
        return dto;
    }
}
