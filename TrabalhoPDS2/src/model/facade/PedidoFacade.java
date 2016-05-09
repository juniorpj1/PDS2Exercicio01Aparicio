package model.facade;

import java.util.List;

import model.domain.Pedido;

public interface PedidoFacade {

	List<Pedido> getPedidos();

	List<Pedido> getPedidos(Integer codigo);

	Pedido salvar(Pedido Pedido);

	void atualizar(Pedido Pedido);

	void deletarPedido(Integer codigo);

}