package model.dao;

import java.util.List;

import model.domain.*;

public interface ItemPedidoDao {

	List<ItemPedido> getItemPedidos(ItemPedido itemPedido);
	
	public void excluir(ItemPedido itemPedido);

	ItemPedido salvar(ItemPedido itemPedido);

	void atualizar(ItemPedido itemPedido);
}

