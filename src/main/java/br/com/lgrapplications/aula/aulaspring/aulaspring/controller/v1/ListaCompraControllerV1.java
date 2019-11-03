package br.com.lgrapplications.aula.aulaspring.aulaspring.controller.v1;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ListaCompraDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.service.ListaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rs/v1/listascompras")
public class ListaCompraControllerV1 {

    @Autowired
    private ListaCompraService listaCompraService;

    @PostMapping("abrir/{cpf}")
    public ListaCompraDTO abrirListaCompra(@PathVariable("cpf") String cpfPessoa) throws BusinessException {
        return listaCompraService.abrirListaCompra(cpfPessoa);
    }

    @PutMapping("{cpf}/item/{idItem}")
    public ListaCompraDTO addItem(@PathVariable("cpf") String cpfPessoa, @PathVariable("idItem") String idItem) throws BusinessException {
        return listaCompraService.addItem(cpfPessoa,idItem);
    }

    @PutMapping("fechar/{cpf}")
    public ListaCompraDTO fecharListaCompra(@PathVariable("cpf") String cpfPessoa) throws BusinessException {
        return listaCompraService.fecharListaCompra(cpfPessoa);
    }

    @GetMapping("aberta/{cpf}")
    public ListaCompraDTO findListaCompraAberta(@PathVariable("cpf") String cpfPessoa) throws BusinessException{
        return listaCompraService.findListaCompraAbertaDTO(cpfPessoa);
    }

    @GetMapping("{cpf}")
    public List<ListaCompraDTO> findAllByCpf(@PathVariable("cpf") String cpfPessoa) throws BusinessException {
        return listaCompraService.findAllDTOByCpf(cpfPessoa);
    }
}
