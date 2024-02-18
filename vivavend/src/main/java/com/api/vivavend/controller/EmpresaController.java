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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private Fachada fachada;

    @PostMapping
    public ResponseEntity<Object> saveEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO) {
        var empresa = new Empresa();
        BeanUtils.copyProperties(empresaDTO, empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(fachada.saveEmpresa(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getTodasEmpresas(){
        return ResponseEntity.status(HttpStatus.OK).body(fachada.getAllEmpresa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUmaEmpresa(@PathVariable(value = "id") UUID id){
        Optional<Empresa> empresaOptional = fachada.findEmpresaById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpresa(@PathVariable(value = "id") UUID id){
        Optional<Empresa> empresaOptional = fachada.findEmpresaById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        fachada.deleteEmpresa(empresaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Empresa removida com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpresa(@PathVariable(value = "id") UUID id, @RequestBody @Valid EmpresaDTO empresaDTO){
        Optional<Empresa> empresaOptional = fachada.findEmpresaById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        var empresa = new Empresa();
        BeanUtils.copyProperties(empresaDTO, empresa);
        empresa.setId(empresaOptional.get().getId());
        //Empresa.setRegistrationDate(EmpresaOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(fachada.saveEmpresa(empresa));
    }
}












