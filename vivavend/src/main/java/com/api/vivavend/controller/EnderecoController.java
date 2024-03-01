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

import com.api.vivavend.dto.EnderecoDTO;
import com.api.vivavend.fachada.Fachada;
import com.api.vivavend.model.Endereco;

import jakarta.validation.Valid;

/**
 * Controlador responsável por lidar com operações relacionadas a endereços.
 * 
 * Todas as operações neste controlador estão mapeadas para o endpoint "/endereco".
 * Ressalta-se que uma empresa tem um endereço e um endereço tem uma empresa.
 * @author Ismael
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private Fachada fachada;

    /**
     * Salva um novo endereço com base nos dados fornecidos.
     * 
     * @param enderecoDTO O objeto EnderecoDTO contendo os dados do endereço a ser criado
     * @return ResponseEntity contendo o status da operação e o endereço criado
     */
    @PostMapping
    public ResponseEntity<Object> salvarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.salvarEndereco(endereco));
    }

    /**
     * Retorna todos os endereços cadastrados no sistema.
     * 
     * @return ResponseEntity contendo o status da operação e a lista de todos os endereços
     */
    @GetMapping
    public ResponseEntity<List<Endereco>> exibirTodosEnderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.retornarTodosEndereco());
    }

    /**
     * Retorna um endereço específico com base no ID fornecido.
     * 
     * @param id O ID do endereço a ser recuperado
     * @return ResponseEntity contendo o status da operação e o endereço encontrado, se existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> exibirUmEndereco(@PathVariable(value = "id") UUID id){
        Optional<Endereco> enderecoOptional = fachada.buscarEnderecoPorId(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoOptional.get());
    }
    
    /**
     * Exclui um endereço com base no ID fornecido.
     * 
     * @param id O ID do endereço a ser excluído
     * @return ResponseEntity contendo o status da operação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarEndereco(@PathVariable(value = "id") UUID id){
        Optional<Endereco> enderecoOptional = fachada.buscarEnderecoPorId(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado!");
        }
        fachada.deletarEndereco(enderecoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereço removido com sucesso!");
    }

    /**
     * Atualiza os dados de um endereço com base no ID fornecido.
     * 
     * @param id O ID do endereço a ser atualizado
     * @param enderecoDTO O objeto EnderecoDTO contendo os novos dados do endereço
     * @return ResponseEntity contendo o status da operação e o endereço atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEndereco(@PathVariable(value = "id") UUID id, @RequestBody @Valid EnderecoDTO enderecoDTO){
        Optional<Endereco> enderecoOptional = fachada.buscarEnderecoPorId(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        endereco.setId(enderecoOptional.get().getId());
        //endereco.setRegistrationDate(enderecoOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.salvarEndereco(endereco));
    }
}
























