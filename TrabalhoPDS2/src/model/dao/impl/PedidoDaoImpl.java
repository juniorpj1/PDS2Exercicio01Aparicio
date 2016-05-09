package model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.domain.*;
import model.dao.*;

public class PedidoDaoImpl implements PedidoDao {

	@PersistenceContext(unitName="TrabalhoPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos(Pedido pedido) {
		StringBuffer hql = new StringBuffer("from Pedido p "
				+ "where 1 = 1");		
		if (pedido.getCodPedido() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (pedido.getCodPedido() != null) {
			query.setParameter("codigo",pedido.getCodPedido());
		} 
		return query.getResultList();
	}
		
	@Override
	@Transactional
	public void excluir(Pedido pedido) {
		pedido = entityManager.merge(pedido);
		entityManager.remove(pedido);
	}

	@Override
	@Transactional
	public Pedido salvar(Pedido pedido) {
		entityManager.persist(pedido);
		return pedido;
	}

	@Override
	@Transactional
	public void atualizar(Pedido pedido) {
		pedido = entityManager.merge(pedido);
		entityManager.persist(pedido);		
	}

}
