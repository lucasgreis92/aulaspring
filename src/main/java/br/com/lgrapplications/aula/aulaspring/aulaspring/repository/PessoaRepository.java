package br.com.lgrapplications.aula.aulaspring.aulaspring.repository;

import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.PessoaDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends MongoRepository<PessoaDoc,String> {

    Optional<PessoaDoc> findByCpf(String cpf);

}
