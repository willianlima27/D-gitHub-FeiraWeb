package br.feira.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.feira.dao.FeiranteDAO;
import br.feira.dao.FeiranteProdutoDAO;
import br.feira.dao.ProdutoDAO;
import br.feira.domain.Feirante;
import br.feira.domain.FeiranteProduto;
import br.feira.domain.Produto;
import br.feira.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

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
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Produtos do Feirante");
			erro.printStackTrace();
		}
	}
	
	public void popular(){
		try{
			produtoPorFeirante = feirantesProdutos;
			FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
			produtoPorFeirante = feiranteProdutoDAO.buscaPorFeirante(feirante.getCodigo());
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
			
			feiranteProduto.setFeirante(feirante);
			
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
	
	public void imprimir(){
		try{
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagemProduto:tabelaProduto");
			Map<String, Object> parametros = tabela.getFilters();		
		
			String caminho = Faces.getRealPath("/reports/feirantesprodutos.jasper");
					
			Connection conexao = HibernateUtil.getConexao();
					
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			
			JasperPrintManager.printReport(relatorio, true);
		}catch (JRException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}

}
