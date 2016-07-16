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

import br.feira.dao.GeneroDAO;
import br.feira.domain.Genero;
import br.feira.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class GeneroBean implements Serializable{
	
	private Genero genero;
	
	private List<Genero> generos;
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	public void novo(){
		genero = new Genero();
	}
	
	@PostConstruct
	public void listar(){
		try{
			GeneroDAO generoDAO = new GeneroDAO();
			generos = generoDAO.listarOrdenado("nomeGenero");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Gêneros");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try{
			GeneroDAO generoDAO = new GeneroDAO();
			generoDAO.salvar(genero);
			
			genero = new Genero();
			generos = generoDAO.listarOrdenado("nomeGenero");
			
			novo();
			
			Messages.addGlobalInfo("Gênero salvo com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Gênero");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		genero = (Genero) evento.getComponent().getAttributes().get("generoSelecionado");
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			
			genero = (Genero) evento.getComponent().getAttributes().get("generoSelecionado");
			
			GeneroDAO generoDAO = new GeneroDAO();
			generoDAO.excluir(genero);
			
			generos = generoDAO.listarOrdenado("nomeGenero");
			
			Messages.addGlobalInfo("Gênero removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o Gênero");
			erro.printStackTrace();
		}
	}
	
	public void imprimir(){
		try{
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
			Map<String, Object> parametros = tabela.getFilters();		
		
			String caminho = Faces.getRealPath("/reports/generos.jasper");
					
			Connection conexao = HibernateUtil.getConexao();
					
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			
			JasperPrintManager.printReport(relatorio, true);
		}catch (JRException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}

}
