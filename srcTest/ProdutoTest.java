import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProdutoTest {
	
	@Mock
	private ItemPedido itemPedido;
	
	@Mock
	private Produto produto;

	@Before
	public void initPedidoService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testaObterPreco() {
		Produto produto = new Produto(1L, 20.0);
		double valor = produto.obterPreco(3);
		Assert.assertEquals(valor, 60.0, 0.0);
	}
	
	@Test
	public void testaCalculaPreco() {
		when(produto.obterPreco(3)).thenReturn(120.0);
		double valor = itemPedido.calcularPreco();
		Assert.assertEquals(valor, 120.0, 0.0);
	}
}
