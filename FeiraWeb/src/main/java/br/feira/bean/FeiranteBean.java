package br.feira.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.feira.dao.CidadeDAO;
import br.feira.dao.EstadoDAO;
import br.feira.dao.FeiranteDAO;
import br.feira.domain.Cidade;
import br.feira.domain.Estado;
import br.feira.domain.Feirante;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class FeiranteBean implements Serializable{
	
	private Feirante feirante;
	private Estado estado;
	
	private List<Feirante> feirantes;
	private List<Estado> estados;
	private List<Cidade> cidades;
	
	public Feirante getFeirante() {
		return feirante;
	}
	
	public void setFeirante(Feirante feirante) {
		this.feirante = feirante;
	}
	
	public List<Feirante> getFeirantes() {
		return feirantes;
	}
	
	public void setFeirantes(List<Feirante> feirantes) {
		this.feirantes = feirantes;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
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
			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feirantes = feiranteDAO.listarOrdenado("nomeFantasia");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Feirantes");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			feirante = new Feirante();
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarOrdenado("nomeEstado");
			
			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar o novo Feirante");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			
			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feiranteDAO.salvar(feirante);
			feirantes = feiranteDAO.listarOrdenado("nomeFantasia");
			
			feirante = new Feirante();
			estado = new Estado();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarOrdenado("nomeEstado");
			
			cidades = new ArrayList<>();
			
			Messages.addGlobalInfo("Feirante salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Feirante");
			erro.printStackTrace();
		}
	}
	
	public void popular(){
		try{
			if(estado != null){
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscaPorEstado(estado.getCodigo());
			}else{
				cidades = new ArrayList<>();
			}
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar filtras as Cidades");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try{
			feirante = (Feirante) evento.getComponent().getAttributes().get("feiranteSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarOrdenado("nomeEstado");
			
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarOrdenado("nomeCidade");
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao editar o Feirante");
			erro.printStackTrace();
		}	
		
	}
	
	public void excluir(ActionEvent evento){
		try{
			feirante = (Feirante) evento.getComponent().getAttributes().get("feiranteSelecionado");
			
			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feiranteDAO.excluir(feirante);
			
			feirantes = feiranteDAO.listar();
			
			Messages.addGlobalInfo("Feirante removido com sucesso");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o Feirante");
			erro.printStackTrace();
		}
	}

}
