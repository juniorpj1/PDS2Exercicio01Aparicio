package model.facade;

import java.util.List;

import model.domain.ItemPedido;

public interface ItemPedidoFacade {

	List<ItemPedido> getItemPedidos();

	List<ItemPedido> getItemPedidos(Integer codigo);

	ItemPedido salvar(ItemPedido ItemPedido);

	void atualizar(ItemPedido ItemPedido);

	void deletarItemPedido(Integer codigo);

}