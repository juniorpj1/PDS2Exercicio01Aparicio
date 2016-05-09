package model.dao;

import java.util.List;

import model.domain.Pedido;

public interface PedidoDao {

	public List<Pedido> getPedidos(Pedido pedido);
	
	//public List<Pedido> getPedidosComItens(Pedido pedido);
	
	public void excluir(Pedido pedido);

	Pedido salvar(Pedido pedido);

	void atualizar(Pedido pedido);

}