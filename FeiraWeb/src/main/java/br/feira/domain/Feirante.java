package br.feira.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Feirante extends GenericDomain{

	@Column(nullable = false)
	private int registro;
	
	@Column(nullable = false)
	private boolean situacao = true;

	@Column(length = 50, nullable = false)
	private String razaoSocial;
	
	@Column(length = 30, nullable = false)
	private String nomeFantasia;
	
	@Column(length = 1, nullable = false)
	private String tipoPessoa;
	
	@Column(length = 18, nullable = false)
	private String cpf_cnpj;
	
	@Column(length = 12, nullable = true)
	private String rg_ie;
	
	@Column(length = 20, nullable = false)
	private String logradouro;
	
	@Column(length = 50, nullable = false)
	private String nomeLogradouro;
	
	@Column(length = 6, nullable = false)
	private String numero;
	
	@Column(length = 30, nullable = true)
	private String complemento;
	
	@Column(length = 30, nullable = false)
	private String bairro;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;
	
	@Column(length = 14, nullable = true)
	private String telefoneFixo;
	
	@Column(length = 14, nullable = false)
	private String telefoneCelular;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feirante")
	private Set<FeiranteArrecadacao> feiranteArrecadacao = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feirante")
	private Set<FeiranteProduto> feiranteProduto = new  HashSet<>();
	
	@Column(nullable = true)
	private int controle;

	/*Métodos acessores*/
	public int getRegistro() {
		return registro;
	}
	
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	
	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getRg_ie() {
		return rg_ie;
	}
	
	public void setRg_ie(String rg_ie) {
		this.rg_ie = rg_ie;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}
	
	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getControle() {
		return controle;
	}

	public void setControle(int controle) {
		this.controle = controle;
	}

	public Set<FeiranteArrecadacao> getFeiranteArrecadacao() {
		return feiranteArrecadacao;
	}

	public void setFeiranteArrecadacao(Set<FeiranteArrecadacao> feiranteArrecadacao) {
		this.feiranteArrecadacao = feiranteArrecadacao;
	}

	public Set<FeiranteProduto> getFeiranteProduto() {
		return feiranteProduto;
	}

	public void setFeiranteProduto(Set<FeiranteProduto> feiranteProduto) {
		this.feiranteProduto = feiranteProduto;
	}

	
	
	

}
