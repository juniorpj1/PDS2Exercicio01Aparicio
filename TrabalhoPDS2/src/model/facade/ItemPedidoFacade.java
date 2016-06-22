package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.ItemPedido;

public interface ItemPedidoFacade {

	List<ItemPedido> getItemPedidos();

	List<ItemPedido> getItemPedidos(Integer codigo);

	@ValidateOnExecution
	ItemPedido salvar(@Valid ItemPedido ItemPedido);

	@ValidateOnExecution
	void atualizar(@Valid ItemPedido ItemPedido);

	void deletarItemPedido(Integer codigo);

}