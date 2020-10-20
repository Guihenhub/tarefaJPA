package tarefajpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Modelo {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idModelo;
	
	@Column(nullable = false)
	private String descricao;
	
	private Integer potencia;
	
	@OneToOne
	@JoinColumn(name = "idMarca")
	private Marca marca;
	
	@OneToOne(mappedBy = "modelo")
	private Automovel automovel;
	
	public Modelo() {
		
	}
	
	public Modelo(Integer id, String descricao, int potencia) {
		super();
		this.idModelo = id;
		this.descricao = descricao;
		this.potencia = potencia;
	}
	
	public void addMarca(Marca marca) {
		this.marca = marca;
	}
	
	public void removeMarca(Marca marca) {
		this.marca = null;
	}
	
	public int getId() {
		return idModelo;
	}
	public void setId(int id) {
		this.idModelo = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idModelo;
		result = prime * result + potencia;
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
		Modelo other = (Modelo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idModelo != other.idModelo)
			return false;
		if (potencia != other.potencia)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Modelo [id=" + idModelo + ", descricao=" + descricao + ", potencia=" + potencia + ", marca_id="
				+ "]";
	}
	
	
}
