package br.feira.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.feira.dao.GeneroDAO;
import br.feira.dao.ProdutoDAO;
import br.feira.domain.Genero;
import br.feira.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable{
	
	private Produto produto;
	
	private List<Produto> produtos;
	private List<Genero> generos;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Genero> getGeneros() {
		return generos;
	}
	
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	@PostConstruct
	public void listar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os produtos");
			erro.printStackTrace();
		}
		
	}
	
	public void novo() {
		try {
			produto = new Produto();

			GeneroDAO generoDAO = new GeneroDAO();
			generos = generoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo produto");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
			
			produto = new Produto();
			
			GeneroDAO generoDAO = new GeneroDAO();
			generos = generoDAO.listar();
			
			produtos = produtoDAO.listar();
			
			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Produto");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try{
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			
			GeneroDAO generoDAO = new GeneroDAO();
			generos = generoDAO.listar();
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao listar os gêneros");
			erro.printStackTrace();
		}	
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			
			produtos = produtoDAO.listar();
			
			Messages.addGlobalInfo("Produto removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o Produto");
			erro.printStackTrace();
		}
	}

}
