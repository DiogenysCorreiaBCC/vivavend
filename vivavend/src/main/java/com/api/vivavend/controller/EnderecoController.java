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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private Fachada fachada;

    @PostMapping
    public ResponseEntity<Object> saveendereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.saveEndereco(endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getTodasenderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.getAllEndereco());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUmaendereco(@PathVariable(value = "id") UUID id){
        Optional<Endereco> enderecoOptional = fachada.findEnderecoById(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoOptional.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteendereco(@PathVariable(value = "id") UUID id){
        Optional<Endereco> enderecoOptional = fachada.findEnderecoById(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
        fachada.deleteEndereco(enderecoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereco removidO com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id") UUID id, @RequestBody @Valid EnderecoDTO enderecoDTO){
        Optional<Endereco> enderecoOptional = fachada.findEnderecoById(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        endereco.setId(enderecoOptional.get().getId());
        //endereco.setRegistrationDate(enderecoOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.saveEndereco(endereco));
    }
}
























