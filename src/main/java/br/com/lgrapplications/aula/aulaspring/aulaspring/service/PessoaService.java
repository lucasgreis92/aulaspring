package br.com.lgrapplications.aula.aulaspring.aulaspring.service;

import br.com.lgrapplications.aula.aulaspring.aulaspring.base.exceptions.BusinessException;
import br.com.lgrapplications.aula.aulaspring.aulaspring.mapper.PessoaMapper;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.documents.PessoaDoc;
import br.com.lgrapplications.aula.aulaspring.aulaspring.model.dto.PessoaDTO;
import br.com.lgrapplications.aula.aulaspring.aulaspring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;


    public PessoaDTO findDTOByCpf(String cpf) throws BusinessException {
        Optional<PessoaDoc> pessoaDoc = pessoaRepository.findByCpf(cpf);
        if (!pessoaDoc.isPresent()){
            throw new BusinessException("Pessoa não encontrada!");
        }
        return pessoaMapper.convertToDto(pessoaDoc.get());
    }

    public PessoaDTO saveDTO(PessoaDTO pessoaDTO){
        PessoaDoc pessoaDoc = null;
        if (pessoaDTO.getId() != null){
            pessoaDoc = pessoaRepository.findById(pessoaDTO.getId()).get();
            pessoaDoc.setDtUltAlteracao(LocalDateTime.now());
        }
        pessoaDoc = pessoaMapper.convertToDOC(pessoaDTO,pessoaDoc);
        pessoaDoc = save(pessoaDoc);
        return pessoaMapper.convertToDto(pessoaDoc);
    }

    public void deleteByCpf(String cpf) throws BusinessException {
        Optional<PessoaDoc> pessoaDoc = findByCpf(cpf);
        pessoaRepository.delete(pessoaDoc.get());
    }

    public void atualizarTotalGasto(String cpf, BigDecimal value) throws BusinessException {
        Optional<PessoaDoc> pessoaDoc = findByCpf(cpf);
        pessoaDoc.get().setTotalGasto(pessoaDoc.get().getTotalGasto().add(value));
        save(pessoaDoc.get());
    }

    public Optional<PessoaDoc> findByCpf(String cpf) throws BusinessException {
        Optional<PessoaDoc> pessoaDoc = pessoaRepository.findByCpf(cpf);
        if (!pessoaDoc.isPresent()){
            throw new BusinessException("Pessoa não encontrada!");
        }
        return pessoaDoc;
    }

    private PessoaDoc save(PessoaDoc pessoaDoc){
        return pessoaRepository.save(pessoaDoc);
    }

    public List<PessoaDTO> findAllDTO(){
        List<PessoaDoc> pessoasDoc = pessoaRepository.findAll();
        final List<PessoaDTO> pessoasDto = new ArrayList<>(pessoasDoc.size());
        pessoasDoc.forEach(pd ->{
            pessoasDto.add(pessoaMapper.convertToDto(pd));
        });
        return pessoasDto;
    }
}
