package br.feira.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.feira.dao.EstadoDAO;
import br.feira.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class EstadoBean implements Serializable{
	
	private Estado estado;
	
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void novo(){
		estado = new Estado();
	}
	
	@PostConstruct
	public void listar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarOrdenado("nomeEstado");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);
			
			estado = new Estado();
			estados = estadoDAO.listarOrdenado("nomeEstado");
			
			novo();
			
			Messages.addGlobalInfo("Estado salvo com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o registro");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listarOrdenado("nomeEstado");
			
			Messages.addGlobalInfo("Estado removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o estado");
			erro.printStackTrace();
		}
	}

}
