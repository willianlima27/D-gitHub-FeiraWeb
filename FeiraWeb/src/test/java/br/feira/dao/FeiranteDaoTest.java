package br.feira.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.feira.domain.Cidade;
import br.feira.domain.Feirante;

public class FeiranteDaoTest {
	
	@Test
	//@Ignore
	public void salvar(){
		
		Long codigoCidade = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();	
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		Feirante feirante = new Feirante();
		
		feirante.setRegistro(1090);;
		feirante.setSituacao(true);
		feirante.setRazaoSocial("Feirante 4");
		feirante.setNomeFantasia("Feirante 4 Fantasia");
		feirante.setTipoPessoa("J");
		feirante.setRg_ie("48595869");
		feirante.setCpf_cnpj("47.987.586/0001-56");
		feirante.setLogradouro("Av");
		feirante.setNomeLogradouro("Brasil");
		feirante.setNumero("2081");
		feirante.setComplemento("Complemento 3");
		feirante.setBairro("Centro");
		feirante.setCep("85555-000");
		feirante.setCidade(cidade);
		feirante.setTelefoneFixo("46 4758-3948");
		feirante.setTelefoneCelular("46 3748-3948");
		feirante.setEmail("feirante4@email.com.br");
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		feiranteDAO.salvar(feirante);
	}
	
	@Test
	@Ignore
	public void listar(){
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		List<Feirante> resultado = feiranteDAO.listar();
		
		for(Feirante feirante : resultado){
			System.out.println("Registro Encotrado:");
			System.out.println("Código do Feirante: " + feirante.getCodigo());
			System.out.println("Registro: " + feirante.getRegistro());
			System.out.println("Razão Social: " + feirante.getRazaoSocial());
			System.out.println("Fantasia: " + feirante.getNomeFantasia());
			System.out.println("Tipo Pessoa: " + feirante.getTipoPessoa());
			System.out.println("RG_CPF: " + feirante.getRg_ie());
			System.out.println("CPF_CNPJ: " + feirante.getCpf_cnpj());
			System.out.println("Logradouro: " + feirante.getLogradouro());
			System.out.println("Nome Logradouro: " + feirante.getNomeLogradouro());
			System.out.println("Numero: " + feirante.getNumero());
			System.out.println("Complemento: " + feirante.getComplemento());
			System.out.println("Bairro: " + feirante.getBairro());
			System.out.println("CEP: " + feirante.getCep());
			System.out.println("Cod Cidade: " + feirante.getCidade().getCodigo());
			System.out.println("Cidade: " + feirante.getCidade().getNomeCidade());
			System.out.println("Estado: " + feirante.getCidade().getEstado().getSigla());
			System.out.println("Telefone Fixo: " + feirante.getTelefoneFixo());
			System.out.println("Celular: " + feirante.getTelefoneCelular());
			System.out.println("Email: " + feirante.getEmail());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		Feirante feirante = feiranteDAO.buscar(codigo);
		
		if(feirante == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println("Código do Feirante: " + feirante.getCodigo());
			System.out.println("Registro: " + feirante.getRegistro());
			System.out.println("Razão Social: " + feirante.getRazaoSocial());
			System.out.println("Fantasia: " + feirante.getNomeFantasia());
			System.out.println("Tipo Pessoa: " + feirante.getTipoPessoa());
			System.out.println("RG_CPF: " + feirante.getRg_ie());
			System.out.println("CPF_CNPJ: " + feirante.getCpf_cnpj());
			System.out.println("Logradouro: " + feirante.getLogradouro());
			System.out.println("Nome Logradouro: " + feirante.getNomeLogradouro());
			System.out.println("Numero: " + feirante.getNumero());
			System.out.println("Complemento: " + feirante.getComplemento());
			System.out.println("Bairro: " + feirante.getBairro());
			System.out.println("CEP: " + feirante.getCep());
			System.out.println("Cod Cidade: " + feirante.getCidade().getCodigo());
			System.out.println("Cidade: " + feirante.getCidade().getNomeCidade());
			System.out.println("Estado: " + feirante.getCidade().getEstado().getSigla());
			System.out.println("Telefone Fixo: " + feirante.getTelefoneFixo());
			System.out.println("Celular: " + feirante.getTelefoneCelular());
			System.out.println("Email: " + feirante.getEmail());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		Feirante feirante = feiranteDAO.buscar(codigo);
		
		feiranteDAO.excluir(feirante);
		
		System.out.println("Registro removido:");
		System.out.println("Código do Feirante: " + feirante.getCodigo());
		System.out.println("Registro: " + feirante.getRegistro());
		System.out.println("Razão Social: " + feirante.getRazaoSocial());
		System.out.println("Fantasia: " + feirante.getNomeFantasia());
		System.out.println("Tipo Pessoa: " + feirante.getTipoPessoa());
		System.out.println("RG_CPF: " + feirante.getRg_ie());
		System.out.println("CPF_CNPJ: " + feirante.getCpf_cnpj());
		System.out.println("Logradouro: " + feirante.getLogradouro());
		System.out.println("Nome Logradouro: " + feirante.getNomeLogradouro());
		System.out.println("Numero: " + feirante.getNumero());
		System.out.println("Complemento: " + feirante.getComplemento());
		System.out.println("Bairro: " + feirante.getBairro());
		System.out.println("CEP: " + feirante.getCep());
		System.out.println("Cod Cidade: " + feirante.getCidade().getCodigo());
		System.out.println("Cidade: " + feirante.getCidade().getNomeCidade());
		System.out.println("Estado: " + feirante.getCidade().getEstado().getSigla());
		System.out.println("Telefone Fixo: " + feirante.getTelefoneFixo());
		System.out.println("Celular: " + feirante.getTelefoneCelular());
		System.out.println("Email: " + feirante.getEmail());
		
		
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoFeirante = 3L;
		Long codigoCidade = 3L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		Feirante feirante = feiranteDAO.buscar(codigoFeirante);
		
		System.out.println("Feirante a ser editado:");
		System.out.println("Código do Feirante: " + feirante.getCodigo());
		System.out.println("Registro: " + feirante.getRegistro());
		System.out.println("Razão Social: " + feirante.getRazaoSocial());
		System.out.println("Fantasia: " + feirante.getNomeFantasia());
		System.out.println("Tipo Pessoa: " + feirante.getTipoPessoa());
		System.out.println("RG_CPF: " + feirante.getRg_ie());
		System.out.println("CPF_CNPJ: " + feirante.getCpf_cnpj());
		System.out.println("Logradouro: " + feirante.getLogradouro());
		System.out.println("Nome Logradouro: " + feirante.getNomeLogradouro());
		System.out.println("Numero: " + feirante.getNumero());
		System.out.println("Complemento: " + feirante.getComplemento());
		System.out.println("Bairro: " + feirante.getBairro());
		System.out.println("CEP: " + feirante.getCep());
		System.out.println("Cod Cidade: " + feirante.getCidade().getCodigo());
		System.out.println("Cidade: " + feirante.getCidade().getNomeCidade());
		System.out.println("Estado: " + feirante.getCidade().getEstado().getSigla());
		System.out.println("Telefone Fixo: " + feirante.getTelefoneFixo());
		System.out.println("Celular: " + feirante.getTelefoneCelular());
		System.out.println("Email: " + feirante.getEmail());
		
		feirante.setRegistro(1089);;
		feirante.setSituacao(true);
		feirante.setRazaoSocial("Feirante Editado");
		feirante.setNomeFantasia("Feirante Editado Fantasia");
		feirante.setTipoPessoa("F");
		feirante.setRg_ie("23432929");
		feirante.setCpf_cnpj("089.761.569.09");
		feirante.setLogradouro("Rua");
		feirante.setNomeLogradouro("Jose Ferreira dos Santos");
		feirante.setNumero("2931");
		feirante.setComplemento("Complemento Editado");
		feirante.setBairro("Lagoão Editado");
		feirante.setCep("85555-000");
		feirante.setCidade(cidade);
		feirante.setTelefoneFixo("46 3262-6787");
		feirante.setTelefoneCelular("46 8899-0900");
		feirante.setEmail("feiranteEditado@email.com.br");
		
		feiranteDAO.editar(feirante);
		
		System.out.println("Feirante editado:");
		System.out.println("Código do Feirante: " + feirante.getCodigo());
		System.out.println("Registro: " + feirante.getRegistro());
		System.out.println("Razão Social: " + feirante.getRazaoSocial());
		System.out.println("Fantasia: " + feirante.getNomeFantasia());
		System.out.println("Tipo Pessoa: " + feirante.getTipoPessoa());
		System.out.println("RG_CPF: " + feirante.getRg_ie());
		System.out.println("CPF_CNPJ: " + feirante.getCpf_cnpj());
		System.out.println("Logradouro: " + feirante.getLogradouro());
		System.out.println("Nome Logradouro: " + feirante.getNomeLogradouro());
		System.out.println("Numero: " + feirante.getNumero());
		System.out.println("Complemento: " + feirante.getComplemento());
		System.out.println("Bairro: " + feirante.getBairro());
		System.out.println("CEP: " + feirante.getCep());
		System.out.println("Cod Cidade: " + feirante.getCidade().getCodigo());
		System.out.println("Cidade: " + feirante.getCidade().getNomeCidade());
		System.out.println("Estado: " + feirante.getCidade().getEstado().getSigla());
		System.out.println("Telefone Fixo: " + feirante.getTelefoneFixo());
		System.out.println("Celular: " + feirante.getTelefoneCelular());
		System.out.println("Email: " + feirante.getEmail());
	
		
	}

}
