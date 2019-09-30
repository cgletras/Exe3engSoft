
public class Cliente {
	
	private Long id;
	private String name;
	private Double percentualDesconto;
	
	public Cliente () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	
	public Double obterValorComDesconto(Pedido pedido) {
		return pedido.obterValorBase() - (pedido.obterValorBase()*(percentualDesconto/100.0));
    }
}
