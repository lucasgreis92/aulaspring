package br.com.lgrapplications.aula.aulaspring.aulaspring.controller.v1;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.PessoaDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rs/v1/pessoas")
public class PessoaControllerV1 {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaDTO save(@RequestBody  PessoaDTO pessoaDTO){
        return pessoaService.saveDTO(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> findAll(){
        return pessoaService.findAllDTO();
    }

    @DeleteMapping("{cpf}")
    public void deleteByCpf(@PathVariable("cpf") String cpf) throws BusinessException {
        pessoaService.deleteByCpf(cpf);
    }

}
