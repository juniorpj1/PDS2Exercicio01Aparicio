package model.facade.ws;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.dao.ProdutoDao;
import model.domain.Produto;
import model.facade.ProdutoFacade;

@WebService(serviceName = "ws/produto")
public class ProdutoFacadeImpl implements ProdutoFacade {

	@Inject
	private ProdutoDao produtoDao;

	@WebMethod
	public List<Produto> getProdutos() {
		return produtoDao.getProdutos(new Produto());
	}

	@Override
	@WebMethod(operationName = "getProdutoCodigo")
	public List<Produto> getProdutos(@WebParam(name = "codigoProduto") Integer codigo) {
		Produto produto = new Produto();
		produto.setCodProduto(codigo);
		return produtoDao.getProdutos(produto);
	}

	@WebMethod
	public Produto salvar(@WebParam(name = "produto") Produto produto) {
		return produtoDao.salvar(produto);
	}

	@WebMethod
	public void atualizar(@WebParam(name = "produto") Produto produto) {
		produtoDao.atualizar(produto);
	}

	@WebMethod
	public void deletarProduto(@WebParam(name = "codigoProduto") Integer codigo) {
		Produto produto = new Produto();
		produto.setCodProduto(codigo);
		produtoDao.excluir(produto);
	}

}
