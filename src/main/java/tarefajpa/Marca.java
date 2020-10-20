package tarefajpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Marca {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToOne(mappedBy = "marca")
	private Modelo modelo;
	
	public Marca() {
		
	}
	
	public Marca(Integer id, String nome) {
		super();
		this.idMarca = id;
		this.nome = nome;
	}
	public int getId() {
		return idMarca;
	}
	public void setId(int id) {
		this.idMarca = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMarca;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Marca other = (Marca) obj;
		if (idMarca != other.idMarca)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Marca [id=" + idMarca + ", nome=" + nome + "]";
	}
	
	
}
