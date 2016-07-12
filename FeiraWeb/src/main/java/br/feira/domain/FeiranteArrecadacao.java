package br.feira.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class FeiranteArrecadacao extends GenericDomain{
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idarrecadacao", nullable = false, insertable = false,
	updatable = false)
	private Arrecadacao arrecadacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfeirante", nullable = false, insertable = false,
	updatable = false)
	private Feirante feirante;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataArrecadacao;
	
	@Column(nullable = false, precision = 8, scale = 2)
	private float valor;
	
	@Column(nullable = false)
	private boolean situacao;

	public Arrecadacao getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(Arrecadacao arrecadacao) {
		this.arrecadacao = arrecadacao;
	}

	public Feirante getFeirante() {
		return feirante;
	}

	public void setFeirante(Feirante feirante) {
		this.feirante = feirante;
	}

	public Date getDataArrecadacao() {
		return dataArrecadacao;
	}

	public void setDataArrecadacao(Date dataArrecadacao) {
		this.dataArrecadacao = dataArrecadacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	

}
