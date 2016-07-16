package br.feira.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.feira.dao.ArrecadacaoDAO;
import br.feira.domain.Arrecadacao;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class ArrecadacaoBean implements Serializable{
	
	private Arrecadacao arrecadacao;
	
	private List<Arrecadacao> arrecadacoes;

	public Arrecadacao getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(Arrecadacao arrecadacao) {
		this.arrecadacao = arrecadacao;
	}

	public List<Arrecadacao> getArrecadacoes() {
		return arrecadacoes;
	}

	public void setArrecadacoes(List<Arrecadacao> arrecadacoes) {
		this.arrecadacoes = arrecadacoes;
	}
	
	public void novo(){
		arrecadacao = new Arrecadacao();
	}
	
	@PostConstruct
	public void listar(){
		try{
			ArrecadacaoDAO arrecadacaoDAO = new ArrecadacaoDAO();
			arrecadacoes = arrecadacaoDAO.listar();
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Arrecadações");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try{
			
			ArrecadacaoDAO arrecadacaoDAO = new ArrecadacaoDAO();
			arrecadacaoDAO.salvar(arrecadacao);
			
			arrecadacao = new Arrecadacao();
			arrecadacoes = arrecadacaoDAO.listar();
			
			novo();
			
			Messages.addGlobalInfo("Arrecação salva com sucesso");
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a Arrecadação.");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		arrecadacao = (Arrecadacao) evento.getComponent().getAttributes().get("arrecadacaoSelecionada");
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			
			arrecadacao = (Arrecadacao) evento.getComponent().getAttributes().get("arrecadacaoSelecionada");
			
			ArrecadacaoDAO arrecadacaoDAO = new ArrecadacaoDAO();
			arrecadacaoDAO.excluir(arrecadacao);
			
			arrecadacoes = arrecadacaoDAO.listar();
			
			Messages.addGlobalInfo("Arrecadação removida com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir a Arrecadação");
			erro.printStackTrace();
		}
	}
	
}
