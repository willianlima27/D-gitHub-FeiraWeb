package br.feira.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Arrecadacao extends GenericDomain{

	@Column(length = 20, nullable = false)
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "arrecadacao")
	private Set<FeiranteArrecadacao> feiranteArrecadacao = new
	HashSet<FeiranteArrecadacao>(0);

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<FeiranteArrecadacao> getFeiranteArrecadacao() {
		return feiranteArrecadacao;
	}

	public void setFeiranteArrecadacao(Set<FeiranteArrecadacao> feiranteArrecadacao) {
		this.feiranteArrecadacao = feiranteArrecadacao;
	}
	
	

}
