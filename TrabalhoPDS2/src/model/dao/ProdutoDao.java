package model.dao;

import java.util.List;

import model.domain.*;

public interface ProdutoDao {

	List<Produto> getProdutos(Produto produto);
	
	public void excluir(Produto produto);

	Produto salvar(Produto produto);

	void atualizar(Produto produto);

	
}

