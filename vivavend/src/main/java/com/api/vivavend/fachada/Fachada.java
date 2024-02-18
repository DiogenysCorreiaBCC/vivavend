package com.api.vivavend.fachada;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Empresa;
import com.api.vivavend.model.Endereco;
import com.api.vivavend.model.Produto;
import com.api.vivavend.services.EmpresaService;
import com.api.vivavend.services.EnderecoService;
import com.api.vivavend.services.ProdutoService;


@Service
public class Fachada {
	//Produto---------------------------------------------------------------------------------------------------------------------------------------
	@Autowired
	private ProdutoService produtoService;
	/*try {
		return produtoService.saveProduto(produto);
	}catch(IllegalArgumentException e) {
		throw new ProdutoNaoEncontradoException("Erro ao Salvar!" + e.getMessage());
	}*/
	
    public Produto saveProduto(Produto produto) {
    	return produtoService.saveProduto(produto);
    }
    
    public List<Produto> getAllProduto() {
    	return produtoService.getAllProduto();
    }
    
    public Optional<Produto> findProdutoById(UUID id) {
    	return produtoService.findProdutoById(id);
    }
    
    public void deleteProduto(Produto Produto) {
    	 produtoService.deleteProduto(Produto);
    }
    
	//Empresa---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private EmpresaService empresaService;
    
    public Empresa saveEmpresa(Empresa empresa){	
        return empresaService.saveEmpresa(empresa);
    }
    
    public List<Empresa> getAllEmpresa() {
        return empresaService.getAllEmpresa();
    }

    public Optional<Empresa> findEmpresaById(UUID id) {
        return empresaService.findEmpresaById(id);
    }

    public void deleteEmpresa(Empresa empresa) {
        empresaService.deleteEmpresa(empresa);
    }
    
	//Endereco---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private EnderecoService enderecoService;
    
    public Endereco saveEndereco(Endereco endereco){
        return enderecoService.saveEndereco(endereco);
    }
    
    public List<Endereco> getAllEndereco() {
        return enderecoService.getAllEndereco();
    }

    public Optional<Endereco> findEnderecoById(UUID id) {
        return enderecoService.findEnderecoById(id);
    }

    public void deleteEndereco(Endereco endereco) {
        enderecoService.deleteEndereco(endereco);
    }
}














