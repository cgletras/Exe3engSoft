
public class Produto {

	private Long id;
	private Double preco;

    public Produto(Long id, Double preco) {
		super();
		this.id = id;
		this.preco = preco;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double obterPreco(Integer quantidade) {
        return this.preco * quantidade;
    }
}
