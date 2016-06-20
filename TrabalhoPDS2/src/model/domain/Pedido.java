	package model.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Transactional
@Table(name="tb_pedidos")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPedido;
	
	private Date data;
	
	//@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itens;
	
	public Pedido() {
		itens = new ArrayList<>();
	}

	public Pedido(Integer codPedido, Date data) {
		super();
		this.codPedido = codPedido;
		this.data = data;
		itens = new ArrayList<>();
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@XmlTransient
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPedido == null) ? 0 : codPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codPedido == null) {
			if (other.codPedido != null)
				return false;
		} else if (!codPedido.equals(other.codPedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String info = "";
		
		info += "Código: " + this.codPedido;
		info += "Data: " + this.data;
		
		return info;
		
	}
	
	

	
}
