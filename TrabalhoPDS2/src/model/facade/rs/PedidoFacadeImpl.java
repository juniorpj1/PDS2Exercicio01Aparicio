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

import model.dao.PedidoDao;
import model.domain.Pedido;
import model.facade.PedidoFacade;

@Transactional
@Path("/pedido")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PedidoFacadeImpl implements PedidoFacade {

	@Inject
	private PedidoDao PedidoDao;
	
	@Override
	@GET
	public List<Pedido> getPedidos() {
		return PedidoDao.getPedidos(new Pedido());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Pedido> getPedidos(@PathParam("codigo") Integer codigo) {
		Pedido Pedido = new Pedido();
		Pedido.setCodPedido(codigo);
		return PedidoDao.getPedidos(Pedido);
	}
	

	@Override
	@POST 
	public Pedido salvar(Pedido Pedido) { 
		Pedido = PedidoDao.salvar(Pedido);
	 	return Pedido;
	}
	
	@Override
	@PUT 
	public void atualizar(Pedido Pedido) { 
		PedidoDao.atualizar(Pedido);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarPedido(@PathParam("codigo") Integer codigo) {
		Pedido Pedido = new Pedido();
		Pedido.setCodPedido(codigo);
		PedidoDao.excluir(Pedido);
	}

}
