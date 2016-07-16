package br.feira.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.feira.domain.Feirante;
import br.feira.domain.Presenca;

public class PresencaDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoFeirante = 3L;
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		Feirante feirante = feiranteDAO.buscar(codigoFeirante);		
		
		Presenca presenca = new Presenca();
		
		//Formatando a Data
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = f.parse("25/06/2016");
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dt2 = f.format(dt);
		java.sql.Date dataSql = null;
		try {
			dataSql = new java.sql.Date(f.parse(dt2).getTime());
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		presenca.setFeirante(feirante);
		presenca.setData(dataSql);
		presenca.setSituacao(false);
		
		PresencaDAO presencaDAO = new PresencaDAO();
		presencaDAO.salvar(presenca);
	}
	
	@Test
	@Ignore
	public void listar(){
		
		PresencaDAO presencaDAO = new PresencaDAO();
		List<Presenca> resultado = presencaDAO.listar();
		
		for(Presenca presenca : resultado){
			System.out.println("Registro Encotrado:");
			System.out.println("Código da Presenca: " + presenca.getCodigo());
			System.out.println("Nome do Feirante: " + presenca.getFeirante().getNomeFantasia());
			System.out.println("Data: " + presenca.getData());
			System.out.println("Situacao: " + presenca.isSituacao());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 4L;
		
		PresencaDAO presencaDAO = new PresencaDAO();
		Presenca presenca = presencaDAO.buscar(codigo);
		
		if(presenca == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println("Código da Presenca: " + presenca.getCodigo());
			System.out.println("Nome do Feirante: " + presenca.getFeirante().getNomeFantasia());
			System.out.println("Data: " + presenca.getData());
			System.out.println("Situacao: " + presenca.isSituacao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 7L;
		
		PresencaDAO presencaDAO = new PresencaDAO();
		Presenca presenca = presencaDAO.buscar(codigo);
		
		presencaDAO.excluir(presenca);
		
		System.out.println("Registro removido:");
		System.out.println("Código da Presenca: " + presenca.getCodigo());
		System.out.println("Nome do Feirante: " + presenca.getFeirante().getNomeFantasia());
		System.out.println("Data: " + presenca.getData());
		System.out.println("Situacao: " + presenca.isSituacao());
		
		
		
	}
	
	@Test
	//@Ignore
	public void editar(){
		Long codigoPresenca = 5L;
		Long codigoFeirante = 3L;
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		Feirante feirante = feiranteDAO.buscar(codigoFeirante);
		
		PresencaDAO presencaDAO = new PresencaDAO();
		Presenca presenca = presencaDAO.buscar(codigoPresenca);
		
		System.out.println("Presenca a ser editada:");
		System.out.println("Código da Presenca: " + presenca.getCodigo());
		System.out.println("Nome do Feirante: " + presenca.getFeirante().getNomeFantasia());
		System.out.println("Data: " + presenca.getData());
		System.out.println("Situacao: " + presenca.isSituacao());
		
		//Formatando a Data
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = null;
		try {
			dt = f.parse("12/06/2016");
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dt2 = f.format(dt);
		java.sql.Date dataSql = null;
		try {
			dataSql = new java.sql.Date(f.parse(dt2).getTime());
		} catch (ParseException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		presenca.setFeirante(feirante);
		presenca.setData(dataSql);
		presenca.setSituacao(false);
		
		presencaDAO.editar(presenca);
		
		System.out.println("Presenca editada:");
		System.out.println("Código da Presenca: " + presenca.getCodigo());
		System.out.println("Nome do Feirante: " + presenca.getFeirante().getNomeFantasia());
		System.out.println("Data: " + presenca.getData());
		System.out.println("Situacao: " + presenca.isSituacao());
	
		
	}

}
