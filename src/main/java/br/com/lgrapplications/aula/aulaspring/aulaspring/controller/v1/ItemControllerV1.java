package br.com.lgrapplications.aula.aulaspring.aulaspring.controller.v1;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.ItemDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rs/v1/itens")
public class ItemControllerV1 {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ItemDTO save(@RequestBody ItemDTO itemDTO){
        return itemService.saveDTO(itemDTO);
    }

    @GetMapping
    public List<ItemDTO> findAll(){
        return itemService.findAllDTO();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) throws BusinessException {
        itemService.delete(id);
    }
}
