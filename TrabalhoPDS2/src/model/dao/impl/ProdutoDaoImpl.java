package model.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.domain.*;
import model.dao.*;

public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext(unitName="TrabalhoPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos(Produto produto) {
		StringBuffer hql = new StringBuffer("from Produto c" + " where 1 = 1");		
		if (produto.getCodProduto() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (produto.getCodProduto() != null) {
			query.setParameter("codigo",produto.getCodProduto());
		} 
		return query.getResultList();
	}
		
	@Override
	@Transactional
	public void excluir(Produto produto) {
		produto = entityManager.merge(produto);
		entityManager.remove(produto);
	}

	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		entityManager.persist(produto);
		return produto;
	}

	@Override
	@Transactional
	public void atualizar(Produto produto) {
		produto = entityManager.merge(produto);
		entityManager.persist(produto);		
	}

}
