package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Pedido;

public interface PedidoFacade {

	List<Pedido> getPedidos();

	List<Pedido> getPedidos(Integer codigo);

	@ValidateOnExecution
	Pedido salvar(@Valid Pedido Pedido);

	@ValidateOnExecution
	void atualizar(@Valid Pedido Pedido);

	void deletarPedido(Integer codigo);

}