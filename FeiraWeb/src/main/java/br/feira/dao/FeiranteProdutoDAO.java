package br.feira.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.feira.domain.FeiranteProduto;
import br.feira.util.HibernateUtil;


public class FeiranteProdutoDAO extends GenericDAO<FeiranteProduto> {
	
	@SuppressWarnings("unchecked")
	public List<FeiranteProduto> buscaPorFeirante(Long feiranteCodigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(FeiranteProduto.class);
			consulta.add(Restrictions.eq("feirante.codigo", feiranteCodigo));
			consulta.addOrder(Order.asc("unidade"));
			List<FeiranteProduto> resultado = consulta.list();
			return resultado;
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
	}
}
