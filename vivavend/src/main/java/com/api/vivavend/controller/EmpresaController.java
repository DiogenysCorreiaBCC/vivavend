package com.api.vivavend.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vivavend.dto.EmpresaDTO;
import com.api.vivavend.fachada.Fachada;
import com.api.vivavend.model.Empresa;

import jakarta.validation.Valid;

/**
 * Controlador responsável por lidar com operações relacionadas às empresas.
 * 
 * Todas as operações neste controlador estão mapeadas para o endpoint "/empresa".
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private Fachada fachada;

    /**
     * Cria uma nova empresa com base nos dados fornecidos.
     * 
     * @param empresaDTO O objeto EmpresaDTO contendo os dados da empresa a ser criada
     * @return ResponseEntity contendo o status da operação e a empresa criada
     */
    @PostMapping
    public ResponseEntity<Object> salvarEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO) {
        var empresa = new Empresa();
        BeanUtils.copyProperties(empresaDTO, empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.salvarEmpresa(empresa));
    }

    /**
     * Retorna todas as empresas cadastradas no sistema.
     * 
     * @return ResponseEntity contendo o status da operação e a lista de todas as empresas
     */
    @GetMapping
    public ResponseEntity<List<Empresa>> exibirTodasEmpresas(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.retornarTodasEmpresa());
    }

    /**
     * Retorna uma empresa específica com base no ID fornecido.
     * 
     * @param id O ID da empresa a ser recuperada
     * @return ResponseEntity contendo o status da operação e a empresa encontrada, se existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> exibirUmaEmpresa(@PathVariable(value = "id") UUID id){
        Optional<Empresa> empresaOptional = fachada.findEmpresaById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaOptional.get());
    }
    
    /**
     * Exclui uma empresa com base no ID fornecido.
     * 
     * @param id O ID da empresa a ser excluída
     * @return ResponseEntity contendo o status da operação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEmpresa(@PathVariable(value = "id") UUID id){
        Optional<Empresa> empresaOptional = fachada.findEmpresaById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        fachada.deletarEmpresa(empresaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Empresa removida com sucesso");
    }

    /**
     * Atualiza os dados de uma empresa com base no ID fornecido.
     * 
     * @param id O ID da empresa a ser atualizada
     * @param empresaDTO O objeto EmpresaDTO contendo os novos dados da empresa
     * @return ResponseEntity contendo o status da operação e a empresa atualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEmpresa(@PathVariable(value = "id") UUID id, @RequestBody @Valid EmpresaDTO empresaDTO){
        Optional<Empresa> empresaOptional = fachada.findEmpresaById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        var empresa = new Empresa();
        BeanUtils.copyProperties(empresaDTO, empresa);
        empresa.setId(empresaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.salvarEmpresa(empresa));
    }
}












