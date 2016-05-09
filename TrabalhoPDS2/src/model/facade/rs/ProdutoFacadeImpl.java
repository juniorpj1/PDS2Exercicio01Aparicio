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

import model.dao.ProdutoDao;
import model.domain.Produto;
import model.facade.ProdutoFacade;

@Transactional
@Path("/produto")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProdutoFacadeImpl implements ProdutoFacade {

	@Inject
	private ProdutoDao ProdutoDao;
	
	@Override
	@GET
	public List<Produto> getProdutos() {
		return ProdutoDao.getProdutos(new Produto());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Produto> getProdutos(@PathParam("codigo") Integer codigo) {
		Produto Produto = new Produto();
		Produto.setCodProduto(codigo);
		return ProdutoDao.getProdutos(Produto);
	}
	

	@Override
	@POST 
	public Produto salvar(Produto Produto) { 
		Produto = ProdutoDao.salvar(Produto);
	 	return Produto;
	}
	
	@Override
	@PUT 
	public void atualizar(Produto Produto) { 
		ProdutoDao.atualizar(Produto);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarProduto(@PathParam("codigo") Integer codigo) {
		Produto Produto = new Produto();
		Produto.setCodProduto(codigo);
		ProdutoDao.excluir(Produto);
	}

}
