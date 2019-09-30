import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Long id;
	private Double valorBase;
	private List<ItemPedido> itemPedidoLista = new ArrayList<>();
	
	private Cliente cliente;
	
	public Pedido() {}
	
	public Pedido(List<ItemPedido> itemPedidoList, Cliente cliente) {
        super();
		this.itemPedidoLista = itemPedidoList;
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
        return itemPedidoLista;
    }
	
	public Double calcularPreco() {
       
		for (ItemPedido itemPedido : itemPedidoLista) {
			valorBase += itemPedido.calcularPreco();
		}
        return cliente.obterValorComDesconto(this);
    }
	
    public Double obterValorBase() {
        return this.valorBase;
    }
}
