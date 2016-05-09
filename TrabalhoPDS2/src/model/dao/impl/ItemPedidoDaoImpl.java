package model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.domain.*;
import model.dao.*;

public class ItemPedidoDaoImpl implements ItemPedidoDao {
	
	@PersistenceContext(unitName="TrabalhoPU")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPedido> getItemPedidos(ItemPedido itemPedido) {
		StringBuffer hql = new StringBuffer("from ItemPedido i " + "where 1 = 1");		
		if (itemPedido.getCodItemPedido() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (itemPedido.getCodItemPedido() != null) {
			query.setParameter("codigo",itemPedido.getCodItemPedido());
		} 
		return query.getResultList();
	}

	@Override
	public void excluir(ItemPedido itemPedido) {
		itemPedido = entityManager.merge(itemPedido);
		entityManager.remove(itemPedido);
		
	}

	@Override
	public ItemPedido salvar(ItemPedido itemPedido) {
		entityManager.merge(itemPedido);
		return itemPedido;
	}

	@Override
	public void atualizar(ItemPedido itemPedido) {
		itemPedido = entityManager.merge(itemPedido);
		entityManager.persist(itemPedido);
		
	}

}
