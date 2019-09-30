import static org.mockito.Mockito.when;

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
		itemPedido = new ItemPedido(produto, 2);
	}
	
	@Test
	public void testaObterPreco() {
		Produto produto = new Produto(1L, 20.0);
		double valor = produto.obterPreco(3);
		Assertions.assertEquals(valor, 60.0);
	}
	
	@Test
	public void testaCalculaPreco() {
		Produto produto = new Produto(1L, 40.0);
		double valor = itemPedido.calcularPreco();
		Assertions.assertEquals(valor, 120.0);
	}
}
