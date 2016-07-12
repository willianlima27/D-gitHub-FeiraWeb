package br.feira.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.feira.domain.Cidade;
import br.feira.domain.Estado;

public class CidadeDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		Cidade cidade = new Cidade();
		
		cidade.setNomeCidade("Clevelandia");
		cidade.setEstado(estado);
		
		CidadeDAO cidadedao = new CidadeDAO();
		cidadedao.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado){
			System.out.println("Registro Encotrado:");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNomeCidade());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNomeEstado());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNomeCidade());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNomeEstado());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		
		System.out.println("Registro removido:");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNomeCidade());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNomeEstado());
		
		
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoCidade = 4L;
		Long codigoEstado = 3L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNomeEstado());
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Cidade a ser editada:");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNomeCidade());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNomeEstado());
		
		cidade.setNomeCidade("Cacador");
		cidade.setEstado(estado);
		
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade editada:");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNomeCidade());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNomeEstado());
	
		
	}

}
