package br.feira.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.feira.dao.CidadeDAO;
import br.feira.dao.EstadoDAO;
import br.feira.domain.Cidade;
import br.feira.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CidadeBean implements Serializable{
	
	private Cidade cidade;
	
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as cidades");
			erro.printStackTrace();
		}
		
	}

	public void novo() {
		try {
			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);
			
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			cidades = cidadeDAO.listar();
			
			Messages.addGlobalInfo("Cidade salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar uma nova cidade");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try{
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao listar os estados");
			erro.printStackTrace();
		}	
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			
			cidades = cidadeDAO.listar();
			
			Messages.addGlobalInfo("Cidade removida com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir a cidade");
			erro.printStackTrace();
		}
	}

}
