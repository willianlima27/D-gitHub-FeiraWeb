package br.feira.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.feira.domain.Genero;
import br.feira.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoGenero = 1L;
		
		GeneroDAO generoDAO = new GeneroDAO();
		Genero genero = generoDAO.buscar(codigoGenero);
		
		Produto produto = new Produto();
		
		produto.setNomeProduto("Produto 1");
		produto.setGenero(genero);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}

}
