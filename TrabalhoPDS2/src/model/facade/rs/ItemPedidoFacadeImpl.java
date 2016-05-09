package model.facade.rs;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.ItemPedidoDao;
import model.domain.ItemPedido;
import model.facade.ItemPedidoFacade;

@Transactional
@Path("/ItemPedido")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ItemPedidoFacadeImpl implements ItemPedidoFacade {

	@Inject
	private ItemPedidoDao ItemPedidoDao;

	@Override
	@GET
	public List<ItemPedido> getItemPedidos() {
		return ItemPedidoDao.getItemPedidos(new ItemPedido());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<ItemPedido> getItemPedidos(@PathParam("codigo") Integer codigo) {
		ItemPedido ItemPedido = new ItemPedido();
		ItemPedido.setCodItemPedido(codigo);
		return ItemPedidoDao.getItemPedidos(ItemPedido);
	}

	@Override
	@POST
	public ItemPedido salvar(ItemPedido ItemPedido) {
		ItemPedido = ItemPedidoDao.salvar(ItemPedido);
		return ItemPedido;
	}

	@Override
	@PUT
	public void atualizar(ItemPedido ItemPedido) {
		ItemPedidoDao.atualizar(ItemPedido);
	}

	@Override
	@Transactional
	@DELETE
	@Path("/{codigo}")
	public void deletarItemPedido(@PathParam("codigo") Integer codigo) {
		ItemPedido ItemPedido = new ItemPedido();
		ItemPedido.setCodItemPedido(codigo);
		ItemPedidoDao.excluir(ItemPedido);
	}

}
