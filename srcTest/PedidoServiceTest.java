import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class PedidoServiceTest {

	private PedidoService pedidoService;
	
	@Mock
	private Cliente cliente;
	
	@Mock
	private Pedido pedido;
	
	@Mock
	private Produto produto;
	
	@Mock
	private ItemPedido ItemPedido;

	@Before
	public void initPedidoService() {
		MockitoAnnotations.initMocks(this);
		pedidoService = new PedidoService(cliente, pedido);
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
}
