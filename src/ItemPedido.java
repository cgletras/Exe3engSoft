
public class ItemPedido {

	private Produto produto;
	private Integer quantidade;
	
	public ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double calcularPreco() {
        return produto.obterPreco(getQuantidade());
    }
    
    // Não consegui Mockar o ItemProduto no teste. Mas esta funcional. Estava retornando valor zero no mock, não entendi o porque
    public static void main(String[] args) {
		
    	Produto produto = new Produto(1L, 20.0);
    	ItemPedido item = new ItemPedido(produto, 3);
    	
    	System.out.println(item.calcularPreco());
	}
	
}
