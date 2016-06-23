package model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Transactional
@Entity
@Table(name="tb_produtos")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;
	
	@NotNull(message="O campo nome é obrigatório")
	@Size(min=2, max=99,message="Nome do produto precisa ter pelo menos 2 caracteres e no máximo 99")
	private String nome;
	
	@NotNull(message="O campo preco é obrigatório")
	@DecimalMin("0.01")
	private BigDecimal preco;
	
	//@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itens;
	
	public Produto() {
		itens = new ArrayList<>();
	}

	public Produto(Integer codProduto, String nome, BigDecimal d) {
		super();
		this.codProduto = codProduto;
		this.nome = nome;
		this.preco = d;
		itens = new ArrayList<>();
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@XmlTransient
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	
	
}
