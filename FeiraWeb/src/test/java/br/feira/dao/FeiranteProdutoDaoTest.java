package br.feira.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.feira.domain.Feirante;
import br.feira.domain.FeiranteProduto;
import br.feira.domain.Produto;

public class FeiranteProdutoDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoFeirante = 1L;
		Long codigoProduto = 1L;
		
		FeiranteDAO feiranteDAO = new FeiranteDAO();
		Feirante feirante = feiranteDAO.buscar(codigoFeirante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		FeiranteProduto feiranteProduto = new FeiranteProduto();
		
		System.out.println("Codigo Feirante: "+feirante.getCodigo());
		feiranteProduto.setFeirante(feirante);
		feiranteProduto.setProduto(produto);
		feiranteProduto.setUnidade("KG");
		feiranteProduto.setValor(new BigDecimal(19.90));
		
		
		FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
		feiranteProdutoDAO.salvar(feiranteProduto);
		
	}
	
	@Test
	//@Ignore
	public void listar(){
		FeiranteProdutoDAO feiranteProdutoDAO = new FeiranteProdutoDAO();
		List<FeiranteProduto> resultado = feiranteProdutoDAO.listar();
		
		for(FeiranteProduto feiranteProduto : resultado){
			System.out.println(feiranteProduto.getFeirante().getCodigo());
		}


		
	}
	
}
