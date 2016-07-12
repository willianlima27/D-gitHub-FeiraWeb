package br.feira.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Presenca extends GenericDomain{

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable = false)
	private boolean situacao;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Feirante feirante;
	
	/*Métodos acessores*/
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	public Feirante getFeirante() {
		return feirante;
	}
	public void setFeirante(Feirante feirante) {
		this.feirante = feirante;
	}
}
