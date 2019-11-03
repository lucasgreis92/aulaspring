package br.com.lgrapplications.aula.aulaspring.aulaspring.repository;

import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.ListaCompraDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.PessoaDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.enuns.StatusListaCompra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListaCompraRepository extends MongoRepository<ListaCompraDoc,String> {


    Optional<ListaCompraDoc> findByPessoaAndStatusListaCompra(PessoaDTO pessoaDTO, StatusListaCompra statusListaCompra);

    List<ListaCompraDoc> findAllByPessoa(PessoaDTO pessoaDTO);
}
