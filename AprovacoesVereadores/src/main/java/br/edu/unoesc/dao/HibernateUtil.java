package br.edu.unoesc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinhaPersistencia");
	
	public HibernateUtil() {
	
	}
	
	public EntityManager getConexao() {
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public void desconectar() {
		emf.close();
	}

	
}
