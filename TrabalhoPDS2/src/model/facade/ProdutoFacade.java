package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Produto;

public interface ProdutoFacade {

	List<Produto> getProdutos();

	List<Produto> getProdutos(Integer codigo);

	@ValidateOnExecution
	Produto salvar(@Valid Produto produto);

	@ValidateOnExecution
	void atualizar(@Valid Produto produto);

	void deletarProduto(Integer codigo);

}