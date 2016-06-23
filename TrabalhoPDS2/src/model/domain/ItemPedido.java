
package model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Transactional
@Entity
@Table(name = "tb_itenspedido")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codItemPedido;

	@NotNull(message="O campo quantidade é obrigatório")
	@Size(min=1, message="A quantidade precisa ser maior que zero")
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "pedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produto")
	private Produto produto;

	public ItemPedido() {
	}

	public ItemPedido(Integer codItemPedido, Integer quantidade, Pedido pedido, Produto produto) {
		super();
		this.codItemPedido = codItemPedido;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getCodItemPedido() {
		return codItemPedido;
	}

	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	// @XmlTransient
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemPedido == null) ? 0 : codItemPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (codItemPedido == null) {
			if (other.codItemPedido != null)
				return false;
		} else if (!codItemPedido.equals(other.codItemPedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [codItemPedido=" + codItemPedido + ", quantidade=" + quantidade + "]";
	}

}
