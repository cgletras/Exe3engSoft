import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class PedidoServiceTest {

	private PedidoService pedidoService;
	private List<ItemPedido> itemPedidoList = new ArrayList<>();
	
	@Mock
	private ItemPedido itemPedido1;
	
	@Mock
	private ItemPedido itemPedido2;
	
	@Mock
	private Cliente cliente;
	
	@Mock
	private Pedido pedido;
	
	@Mock
	private Produto produto;

	@Before
	public void initPedidoService() {
		MockitoAnnotations.initMocks(this);
		pedidoService = new PedidoService(cliente, pedido);
		itemPedidoList.add(itemPedido1);
		itemPedidoList.add(itemPedido2);
	}
	
	@Test
	public void testaPedidoSemDesconto() {
		when(pedido.getValorPedido()).thenReturn(200.45);
		when(cliente.getPercentualDesconto()).thenReturn(0.0);
		double valor = pedidoService.getValorPedidoComDesconto();
		Assert.assertEquals(valor, 200.45, 0.000001);	
	}
	
	@Test
	public void testaPedidoComDescontoDezPorcento() {
		when(pedido.getValorPedido()).thenReturn(100.00);
		when(cliente.getPercentualDesconto()).thenReturn(10.0);
		double valor = pedidoService.getValorPedidoComDesconto();
		Assert.assertEquals(valor, 90.0, 0.000001);
	}
	
	@Test
	public void testarObterValorBase() {
		Mockito.when(itemPedido1.calcularPreco()).thenReturn(30.00);
		Mockito.when(itemPedido2.calcularPreco()).thenReturn(70.00);
		when(cliente.getPercentualDesconto()).thenReturn(0.0);
		double valor = pedido.calcularPreco();
		Assertions.assertEquals(valor ,100.0);
	}
}
