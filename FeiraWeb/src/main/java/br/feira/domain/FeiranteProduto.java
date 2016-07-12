package br.feira.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class FeiranteProduto extends GenericDomain{
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproduto", nullable = false)
	private Produto produto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfeirante", nullable = false)
	private Feirante feirante;
	
	@Column(nullable = true, precision = 8, scale = 2)
	private BigDecimal valor;
	
	@Column(length = 20)
	private String unidade;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Feirante getFeirante() {
		return feirante;
	}

	public void setFeirante(Feirante feirante) {
		this.feirante = feirante;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

}
