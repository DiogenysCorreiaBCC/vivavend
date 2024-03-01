package com.api.vivavend.fachada;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vivavend.model.Avaliacao;
import com.api.vivavend.model.Credenciais;
import com.api.vivavend.model.Empresa;
import com.api.vivavend.model.Endereco;
import com.api.vivavend.model.Produto;
import com.api.vivavend.model.Venda;
import com.api.vivavend.services.AutenticacaoService;
import com.api.vivavend.services.AvaliacaoService;
import com.api.vivavend.services.CredenciaisService;
import com.api.vivavend.services.EmpresaService;
import com.api.vivavend.services.EnderecoService;
import com.api.vivavend.services.ProdutoService;
import com.api.vivavend.services.VendaService;


/**
 * Fachada que encapsula e gerencia o acesso aos serviços relacionados às entidades do sistema.
 * @author Ismael
 */


@Service
public class Fachada {
	//Produto---------------------------------------------------------------------------------------------------------------------------------------
	@Autowired
	private ProdutoService produtoService;
	
    public Produto salvarProduto(Produto produto) {
    	return produtoService.saveProduto(produto);
    }
    
    public List<Produto> retornarTodosProduto() {
    	return produtoService.getAllProduto();
    }
    
    public Optional<Produto> buscarProdutoPorId(UUID id) {
    	return produtoService.findProdutoById(id);
    }
    
    public void deletarProduto(Produto Produto) {
    	 produtoService.deleteProduto(Produto);
    }
    
	//Empresa---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private EmpresaService empresaService;
    
    public Empresa salvarEmpresa(Empresa empresa){	
        return empresaService.saveEmpresa(empresa);
    }
    
    public List<Empresa> retornarTodasEmpresa() {
        return empresaService.getAllEmpresa();
    }

    public Optional<Empresa> findEmpresaById(UUID id) {
        return empresaService.findEmpresaById(id);
    }

    public void deletarEmpresa(Empresa empresa) {
        empresaService.deleteEmpresa(empresa);
    }
    
	//Endereço---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private EnderecoService enderecoService;
    
    public Endereco salvarEndereco(Endereco endereco){
        return enderecoService.saveEndereco(endereco);
    }
    
    public List<Endereco> retornarTodosEndereco() {
        return enderecoService.getAllEndereco();
    }

    public Optional<Endereco> buscarEnderecoPorId(UUID id) {
        return enderecoService.findEnderecoById(id);
    }

    public void deletarEndereco(Endereco endereco) {
        enderecoService.deleteEndereco(endereco);
    }
    
	//Credenciais---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private CredenciaisService credenciaisService;
    
    public Credenciais salvarCredenciais(Credenciais credenciais) {
    	return credenciaisService.saveCredenciais(credenciais);
    }
    
    public void deletarCredenciais(Credenciais credenciais) {
    	credenciaisService.deleteCredenciais(credenciais);
    }
    
    public Optional<Credenciais> buscarPorNomeDeUsuario(String nomeDeUsuario){
    	return credenciaisService.findByNomeDeUsuario(nomeDeUsuario);
    }
    
    public Optional<Credenciais> buscarCredenciaisPorId(UUID id){
    	return credenciaisService.findById(id);
    }

	//Autenticação---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private AutenticacaoService autenticacaoService;
    
    public boolean autenticar(String nomeDeUsuario, String senha) {
    	return autenticacaoService.autenticar(nomeDeUsuario, senha);
    }
    
	//Avaliação---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private AvaliacaoService avaliacaoService;
    
    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
    	return avaliacaoService.salvarAvaliacao(avaliacao);
    }
    
    public void deletarAvaliacao(Avaliacao avaliacao) {
    	avaliacaoService.deletarAvaliacao(avaliacao);
    }
    
    public Optional<Avaliacao> buscarAvaliacaoPorId(UUID id) {
    	return avaliacaoService.buscarAvaliacaoPorId(id);
    }
    
	//Venda---------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    private VendaService vendaService;
    
    public Venda salvarVenda(Venda venda) {
    	return vendaService.saveVenda(venda);
    }
    
    public List<Venda> retornarTodasAsVendas() {
        return vendaService.getAllVenda();
    }
    
    public void deletarVenda(Venda venda) {
    	vendaService.deleteVenda(venda);
    }
    
    public Optional<Venda> buscarVendaPorId(UUID id) {
    	return vendaService.findVendaById(id);
    }
}















