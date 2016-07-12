package br.feira.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.feira.domain.Estado;

public class EstadoDaoTest {
	
	@Test
	@Ignore
	public void salvar(){

		Estado estado = new Estado();

		estado.setNomeEstado("Paraná");
		estado.setSigla("PR");

		EstadoDAO edao = new EstadoDAO();

		edao.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Estado estado : resultado){
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNomeEstado());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNomeEstado());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNomeEstado());
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 4L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		System.out.println("Estado a ser editado:");
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNomeEstado());
		
		estado.setNomeEstado("Rio de Janeiro");
		estado.setSigla("RJ");
		
		estadoDAO.editar(estado);
		
		System.out.println("Estado Editado:");
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNomeEstado());
		
	}

}
