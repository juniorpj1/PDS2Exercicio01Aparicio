package model.facade.ws;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.dao.PedidoDao;
import model.domain.Pedido;
import model.facade.PedidoFacade;

@WebService(serviceName = "ws/pedido")
public class PedidoFacadeImpl implements PedidoFacade {

	@Inject
	private PedidoDao pedidoDao;

	@WebMethod
	public List<Pedido> getPedidos() {
		return pedidoDao.getPedidos(new Pedido());
	}

	@Override
	@WebMethod(operationName = "getPedidoCodigo")
	public List<Pedido> getPedidos(@WebParam(name = "codigoPedido") Integer codigo) {
		Pedido pedido = new Pedido();
		pedido.setCodPedido(codigo);
		return pedidoDao.getPedidos(pedido);
	}

	@WebMethod
	public Pedido salvar(@WebParam(name = "pedido") Pedido pedido) {
		return pedidoDao.salvar(pedido);
	}

	@WebMethod
	public void atualizar(@WebParam(name = "pedido") Pedido pedido) {
		pedidoDao.atualizar(pedido);
	}

	@WebMethod
	public void deletarPedido(@WebParam(name = "codigoPedido") Integer codigo) {
		Pedido pedido = new Pedido();
		pedido.setCodPedido(codigo);
		pedidoDao.excluir(pedido);
	}

}
