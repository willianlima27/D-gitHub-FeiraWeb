package br.feira.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.feira.dao.FeiranteDAO;
import br.feira.dao.PresencaDAO;
import br.feira.domain.Feirante;
import br.feira.domain.Presenca;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class PresencaBean implements Serializable{

	private Presenca presenca;
	
	private List<Presenca> presencas;
	private List<Feirante> feirantes;
	public Presenca getPresenca() {
		return presenca;
	}
	public void setPresenca(Presenca presenca) {
		this.presenca = presenca;
	}
	public List<Presenca> getPresencas() {
		return presencas;
	}
	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}
	public List<Feirante> getFeirantes() {
		return feirantes;
	}
	public void setFeirantes(List<Feirante> feirantes) {
		this.feirantes = feirantes;
	}
	
	@PostConstruct
	public void listar() {
		try {
			PresencaDAO presencaDAO = new PresencaDAO();
			presencas = presencaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Presenças");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			presenca = new Presenca();

			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feirantes = feiranteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova Presença");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			PresencaDAO presencaDAO = new PresencaDAO();
			presencas = presencaDAO.listar();
			
			presenca = new Presenca();
			
			FeiranteDAO feiranteDAO = new FeiranteDAO();
			feirantes = feiranteDAO.listar();
			
			presencas = presencaDAO.listar();
			
			Messages.addGlobalInfo("Presença salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar uma nova Presença");
			erro.printStackTrace();
		}
	}
	

}
