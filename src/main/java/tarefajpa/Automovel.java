package tarefajpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Automovel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idAutomovel;
	
	@Column(nullable = false)
	private Integer anoFabricacao;
	
	@Column(nullable = false)
	private Integer anoModelo;
	
	private String observacoes;
	
	@Column(nullable = false)
	private Float preco;
	
	private Integer kilometragem ;
	
	@OneToOne
	@JoinColumn(name = "idModelo")
	private Modelo modelo;
	
	public Automovel() {
		
	}
	
	public Automovel(Integer id, int anoFabricacao, int anoModelo, String observacoes, float preco, int kilometragem,
			Modelo modelo) {
		super();
		this.idAutomovel = id;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.observacoes = observacoes;
		this.preco = preco;
		this.kilometragem = kilometragem;
		this.modelo = modelo;
	}
	
	public void trocaModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Automovel [id="  + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo
				+ ", observacoes=" + observacoes + ", preco=" + preco + ", kilometragem=" + kilometragem
				+ ", modelo_id="  + "]";
	}
	public int getId() {
		return idAutomovel;
	}
	public void setId(int id) {
		this.idAutomovel = id;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getKilometragem() {
		return kilometragem;
	}
	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoFabricacao;
		result = prime * result + anoModelo;
		result = prime * result + idAutomovel;
		result = prime * result + kilometragem;
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + Float.floatToIntBits(preco);
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
		Automovel other = (Automovel) obj;
		if (anoFabricacao != other.anoFabricacao)
			return false;
		if (anoModelo != other.anoModelo)
			return false;
		if (idAutomovel != other.idAutomovel)
			return false;
		if (kilometragem != other.kilometragem)
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		return true;
	}
}
