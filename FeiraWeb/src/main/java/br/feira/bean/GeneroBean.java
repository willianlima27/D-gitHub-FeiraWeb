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
import br.feira.domain.Genero;
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
			generos = generoDAO.listar();
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
			generos = generoDAO.listar();
			
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
			
			generos = generoDAO.listar();
			
			Messages.addGlobalInfo("Gênero removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o Gênero");
			erro.printStackTrace();
		}
	}

}
