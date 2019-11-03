package br.com.lgrapplications.aula.aulaspring.aulaspring.service;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import br.com.lgrapplications.aula.aulaspring.aulaspring.mapper.ItemMapper;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.ItemDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ItemDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    public ItemDTO saveDTO(ItemDTO itemDTO){
        ItemDoc itemDoc = null;
        if (itemDTO.getId() != null){
            itemDoc = itemRepository.findById(itemDTO.getId()).get();
            itemDoc.setDtUltAlteracao(LocalDateTime.now());
        }
        itemDoc = itemMapper.convertToDOC(itemDTO,itemDoc);
        itemDoc = save(itemDoc);
        return itemMapper.convertToDTO(itemDoc);
    }

    public void delete(String id) throws BusinessException {
        Optional<ItemDoc> item = findById(id);
        itemRepository.delete(item.get());
    }

    private ItemDoc save(ItemDoc itemDoc){
        return itemRepository.save(itemDoc);
    }

    public ItemDTO findDTOById(String id) throws BusinessException {
        Optional<ItemDoc> itemDoc = findById(id);
        return itemMapper.convertToDTO(itemDoc.get());
    }

    public  Optional<ItemDoc> findById(String id) throws BusinessException {
        Optional<ItemDoc> itemDoc = itemRepository.findById(id);
        if (!itemDoc.isPresent()){
            throw new BusinessException("Item não encontrado!");
        }
        return itemDoc;
    }

    public List<ItemDTO> findAllDTO(){
        List<ItemDoc> itensDoc = itemRepository.findAll();
        final List<ItemDTO> itensDto = new ArrayList<>(itensDoc.size());
        itensDoc.forEach(id ->{
            itensDto.add(itemMapper.convertToDTO(id));
        });
        return itensDto;
    }
}
