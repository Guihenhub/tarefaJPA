package application;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tarefajpa.Automovel;
import tarefajpa.Marca;
import tarefajpa.Modelo;

public class Program {
	public static void main(String[] args) throws ParseException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadejpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Marca Volkswagen = new Marca(null, "Volkswagen");
		
		Modelo fusca = new Modelo(null, "Fusca", 200);
		Modelo gol = new Modelo(null, "gol", 400);
		
		fusca.addMarca(Volkswagen);
		gol.addMarca(Volkswagen);
		
		Automovel carro1 = new Automovel(null, 1980, 2010, "Amarelo e conservado", 30000f, 0, fusca);
		Automovel carro2 = new Automovel(null, 2000, 2013, "Prata seminovo", 20000f, 10, gol);

		em.persist(Volkswagen);
		em.persist(fusca);
		em.persist(carro1);
		
		em.persist(gol);
		em.persist(carro2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}