package br.feira.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain{

	@Column(length = 50, nullable = false)
	private String nomeProduto;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Genero genero;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private Set<FeiranteProduto> feiranteProduto = new HashSet<>();
	
	/*Métodos acessores*/
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Set<FeiranteProduto> getFeiranteProduto() {
		return feiranteProduto;
	}

	public void setFeiranteProduto(Set<FeiranteProduto> feiranteProduto) {
		this.feiranteProduto = feiranteProduto;
	}

	

	

}
