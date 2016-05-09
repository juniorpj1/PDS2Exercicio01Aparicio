package model.facade.ws;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.dao.ItemPedidoDao;
import model.domain.ItemPedido;
import model.facade.ItemPedidoFacade;

@WebService(serviceName = "ws/itemPedido")
public class ItemPedidoFacadeImpl implements ItemPedidoFacade {

	@Inject
	private ItemPedidoDao itemPedidoDao;

	@WebMethod
	public List<ItemPedido> getItemPedidos() {
		return itemPedidoDao.getItemPedidos(new ItemPedido());
	}

	@Override
	@WebMethod(operationName = "getItemPedidoCodigo")
	public List<ItemPedido> getItemPedidos(@WebParam(name = "codigoItemPedido") Integer codigo) {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setCodItemPedido(codigo);
		return itemPedidoDao.getItemPedidos(itemPedido);
	}

	@WebMethod
	public ItemPedido salvar(@WebParam(name = "itemPedido") ItemPedido itemPedido) {
		return itemPedidoDao.salvar(itemPedido);
	}

	@WebMethod
	public void atualizar(@WebParam(name = "itemPedido") ItemPedido itemPedido) {
		itemPedidoDao.atualizar(itemPedido);
	}

	@WebMethod
	public void deletarItemPedido(@WebParam(name = "codigoItemPedido") Integer codigo) {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setCodItemPedido(codigo);
		itemPedidoDao.excluir(itemPedido);
	}

}
