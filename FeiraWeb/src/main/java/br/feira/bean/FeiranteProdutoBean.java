package br.feira.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.feira.dao.FeiranteDAO;
import br.feira.dao.FeiranteProdutoDAO;
import br.feira.dao.ProdutoDAO;
import br.feira.domain.Feirante;
import br.feira.domain.FeiranteProduto;
import br.feira.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class FeiranteProdutoBean implements Serializable{
	
	private FeiranteProduto feiranteProduto;
	private Feirante feirante;
	private Produto produto;
		
	private List<FeiranteProduto> feirantesProdutos;
	private List<FeiranteProduto> produtoPorFeirante;
	private List<Feirante> feirantes;
	private List<Produto> produtos;

	public List<FeiranteProduto> getProdutoPorFeirante() {
		return produtoPorFeirante;
	}
	public void setProdutoPorFeirante(List<FeiranteProduto> produtoPorFeirante) {
		this.produtoPorFeirante = produtoPorFeirante;
	}
	public FeiranteProduto getFeiranteProduto() {
		return feiranteProduto;
	}
	public void setFeiranteProduto(FeiranteProduto feiranteProduto) {
		this.feiranteProduto = feiranteProduto;
	}
	public Feirante getFeirante() {
		return feirante;
	}
	public void setFeirante(Feirante feirante) {
		this.feirante = feirante;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<FeiranteProduto> getFeirantesProdutos() {
		return feirantesProdutos;
	}
	public void setFeirantesProdutos(List<FeiranteProduto> feirantesProdutos) {
		this.feirantesProdutos = feirantesProdutos;
	}
	public List<Feirante> getFeirantes() {
		return feirantes;
	}
	public void setFeirantes(List<Feirante> feirantes) {
		this.feirantes = feirantes;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	@PostConstruct
	public void listar() {
		try {
			FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
			feirantesProdutos = feiranteProdutoDAO.listar();
			//feirantesProdutos = feiranteProdutoDAO.buscaPorFeirante(feirante.getCodigo());
			//System.out.println("codigo Feirante Retorno: "+feirantesProdutos.get(0).getCodigo());
			System.out.println("codigo listar:"+feirantesProdutos.get(0).getCodigo());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Produtos do Feirante");
			erro.printStackTrace();
		}
	}
	
	public void popular(){
		try{
			produtoPorFeirante = feirantesProdutos;
			FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
			System.out.print(feirante.getCodigo());
			produtoPorFeirante = feiranteProdutoDAO.buscaPorFeirante(feirante.getCodigo());
			System.out.println("codigo popular: "+produtoPorFeirante.get(0).getCodigo());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Produtos do Feirante");
			erro.printStackTrace();
		}
		
	}
	
	public Feirante selecionaFeirante(ActionEvent evento){
		feirante = new Feirante();
		feirante = (Feirante) evento.getComponent().getAttributes().get("feiranteSelecionado");
		listar();
		popular();
		return feirante;
		
	}
	
	/*@PostConstruct
	public void listarPorFeirante(){
		try{
			FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
			feirantesProdutos = feiranteProdutoDAO.buscaPorFeirante(feirante.getCodigo());
			if(feirantesProdutos == null){
				System.out.println("Não veio Lista ");	
			}else{
				System.out.println("Veio Lista");
				for(int i = 0; i < feirantesProdutos.size(); i++){
					System.out.println("Valor:"+feirantesProdutos.get(i).getValor());
				}
			}
				
			//System.out.println("codigo no Bean: "+feirante.getCodigo());
			
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Produtos do Feirante");
			erro.printStackTrace();
		}
		
	}*/
	
	public void novo() {
		try {
			feiranteProduto = new FeiranteProduto();
			produto = new Produto();

			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feirantes = feiranteDAO.listar();
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listarOrdenado("nomeProduto");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova Adição de Produto");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			
			System.out.println(feirante.getCodigo());
			feiranteProduto.setFeirante(feirante);
			
			System.out.println(feiranteProduto.getUnidade());
			System.out.println(feiranteProduto.getValor());
			System.out.println(feiranteProduto.getProduto().getCodigo());
			
			FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
			feiranteProdutoDAO.salvar(feiranteProduto);
			feirantesProdutos = feiranteProdutoDAO.listar();
			
			feiranteProduto = new FeiranteProduto();
			produto = new Produto();
			feirante = new Feirante();
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listarOrdenado("nomeProduto");
			
			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feirantes = feiranteDAO.listarOrdenado("nomeFantasia");
			
			Messages.addGlobalInfo("Produto adicionado com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar adicionar um novo produto");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try{
			feiranteProduto = (FeiranteProduto) evento.getComponent().getAttributes().get("feiranteProdutoSelecionado");
			
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listarOrdenado("nomeProduto");
			
			FeiranteDAO feiranteDAO = new  FeiranteDAO();
			feirantes = feiranteDAO.listarOrdenado("nomeFantasia");
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao editar o Produto");
			erro.printStackTrace();
		}	
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			feiranteProduto = (FeiranteProduto) evento.getComponent().getAttributes().get("feiranteProdutoSelecionado");
			
			FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
			feiranteProdutoDAO.excluir(feiranteProduto);
			
			feirantesProdutos = feiranteProdutoDAO.listar();
			
			Messages.addGlobalInfo("Produto removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Produto");
			erro.printStackTrace();
		}
	}

}
