package model.facade;

import java.util.List;

import model.domain.Produto;

public interface ProdutoFacade {

	List<Produto> getProdutos();

	List<Produto> getProdutos(Integer codigo);

	Produto salvar(Produto produto);

	void atualizar(Produto produto);

	void deletarProduto(Integer codigo);

}