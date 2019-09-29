import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Long id;
	private Double valorBase;
	private List<ItemPedido> itemPedidoList = new ArrayList<>();
	
	private Cliente cliente;
	private Produto produto;
	
	public Pedido() {}
	
	public Pedido(List<ItemPedido> itemPedidoList, Cliente cliente) {
        this.itemPedidoList = itemPedidoList;
        this.cliente = cliente;
    }
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorPedido() {
		return valorBase;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorBase = valorPedido;
	}
	
	public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }
	
	public Double calcularPreco() {
        itemPedidoList.forEach(item -> valorBase += item.calcularPreco());
        return cliente.obterValorComDesconto(this);
    }
	
    public Double obterValorBase() {
        return this.valorBase;
    }
	
}
