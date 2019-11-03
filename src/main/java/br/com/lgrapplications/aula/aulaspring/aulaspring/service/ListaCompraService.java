package br.com.lgrapplications.aula.aulaspring.aulaspring.service;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import br.com.lgrapplications.aula.aulaspring.aulaspring.mapper.ListaCompraMapper;
import br.com.lgrapplications.aula.aulaspring.aulaspring.mapper.PessoaMapper;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.ListaCompraDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ItemDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ListaCompraDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.PessoaDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.enuns.StatusListaCompra;
import br.com.lgrapplications.aula.aulaspring.aulaspring.repository.ListaCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaCompraService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ListaCompraRepository listaCompraRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListaCompraMapper listaCompraMapper;

    public ListaCompraDTO abrirListaCompra(String cpfPessoa) throws BusinessException {
        PessoaDTO pessoaDTO = pessoaService.findDTOByCpf(cpfPessoa);
        Optional<ListaCompraDoc> listaCompraDoc = findByPessoaAndStatusListaCompra(pessoaDTO,StatusListaCompra.ABERTA);
        if (listaCompraDoc.isPresent()){
            throw new BusinessException("Já existe uma lista de compra aberta para essa pessoa!");
        }

        ListaCompraDoc lista = new ListaCompraDoc();
        lista.setDtCriacao(LocalDateTime.now());
        lista.setPessoa(pessoaDTO);
        lista.setStatusListaCompra(StatusListaCompra.ABERTA);
        lista.setTotal(BigDecimal.ZERO);
        return listaCompraMapper.convertToDTO(save(lista));
    }

    public ListaCompraDTO fecharListaCompra(String cpfPessoa) throws BusinessException {
        Optional<ListaCompraDoc> listaCompraDoc = findListaCompraAberta(cpfPessoa);
        if (!listaCompraDoc.isPresent()){
            throw new BusinessException("Não existe lista de compra aberta para essa pessoa!");
        }
        listaCompraDoc.get().setTotal(calcularTotalListaCompra(listaCompraDoc.get()));
        pessoaService.atualizarTotalGasto(cpfPessoa,listaCompraDoc.get().getTotal());
        return listaCompraMapper.convertToDTO(save(listaCompraDoc.get()));
    }

    public ListaCompraDTO addItem(String cpfPessoa, String idItem) throws BusinessException {
        ItemDTO itemDTO = itemService.findDTOById(idItem);
        Optional<ListaCompraDoc> listaCompraDoc = findListaCompraAberta(cpfPessoa);
        if (!listaCompraDoc.isPresent()){
            throw new BusinessException("Não existe lista de compra aberta para essa pessoa!");
        }
        if (listaCompraDoc.get().getItens() == null){
            listaCompraDoc.get().setItens(new ArrayList<>());
        }
        listaCompraDoc.get().getItens().add(itemDTO);
        return listaCompraMapper.convertToDTO(save(listaCompraDoc.get()));
    }

    public ListaCompraDTO findListaCompraAbertaDTO(String cpfPessoa)  throws BusinessException {
        Optional<ListaCompraDoc> lista = findListaCompraAberta(cpfPessoa);
        if (!lista.isPresent()){
            return null;
        }
        return listaCompraMapper.convertToDTO(lista.get());
    }

    public List<ListaCompraDTO> findAllDTOByCpf(String cpfPessoa) throws BusinessException {
        PessoaDTO pessoaDTO = pessoaService.findDTOByCpf(cpfPessoa);
        List<ListaCompraDoc> listas = listaCompraRepository.findAllByPessoa(pessoaDTO);
        final List<ListaCompraDTO> listaDto = new ArrayList<>();
        listas.forEach( l ->{
            listaDto.add(listaCompraMapper.convertToDTO(l));
        });

        return listaDto;
    }

    private ListaCompraDoc save(ListaCompraDoc listaCompraDoc){
        return listaCompraRepository.save(listaCompraDoc);
    }

    public Optional<ListaCompraDoc> findListaCompraAberta(String cpfPessoa) throws BusinessException {
        PessoaDTO pessoaDTO = pessoaService.findDTOByCpf(cpfPessoa);
        return findByPessoaAndStatusListaCompra(pessoaDTO,StatusListaCompra.ABERTA);
    }

    public  Optional<ListaCompraDoc> findByPessoaAndStatusListaCompra(PessoaDTO pessoaDTO, StatusListaCompra statusListaCompra) throws BusinessException {
        return listaCompraRepository.findByPessoaAndStatusListaCompra(pessoaDTO, statusListaCompra);
    }

    public BigDecimal calcularTotalListaCompra(ListaCompraDoc listaCompraDoc){
        BigDecimal vlTotal = BigDecimal.ZERO;
        if (listaCompraDoc.getItens() != null){
            for (ItemDTO itemDTO : listaCompraDoc.getItens()){
                vlTotal = vlTotal.add(itemDTO.getValor());
            }
        }
        return vlTotal;
    }

}
