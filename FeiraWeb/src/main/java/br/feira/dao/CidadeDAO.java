package br.feira.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.feira.domain.Cidade;
import br.feira.util.HibernateUtil;

public class CidadeDAO extends GenericDAO<Cidade>{
	@SuppressWarnings("unchecked")
	public List<Cidade> buscaPorEstado(Long estadoCodigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", estadoCodigo));
			consulta.addOrder(Order.asc("nomeCidade"));
			List<Cidade> resultado = consulta.list();
			return resultado;
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
	}

}
