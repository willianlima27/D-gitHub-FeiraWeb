package br.feira.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Genero extends GenericDomain{

	@Column(length = 30, nullable = false)
	private String nomeGenero;

	public String getNomeGenero() {
		return nomeGenero;
	}

	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}
	
	
}
