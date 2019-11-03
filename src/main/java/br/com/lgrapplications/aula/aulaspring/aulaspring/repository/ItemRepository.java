package br.com.lgrapplications.aula.aulaspring.aulaspring.repository;


import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.ItemDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<ItemDoc,String> {


}
