package br.edu.unoesc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.edu.unoesc.model.Partida;

public class PartidaJDBC implements PartidaDAO {

	@Override
	public Partida buscar(Long codigo) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		TypedQuery<Partida> query = em.createQuery("select p from Partida p where codigo = ?1", Partida.class);
		query.setParameter(1, codigo);
		try{
			return query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}finally {
			em.close();
			h.desconectar();
		}
	}

	@Override
	public List<Partida> listar() {

		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		try {
			TypedQuery<Partida> query = em.createQuery("select p from Partida p", Partida.class);
			return query.getResultList();
		} finally {
			em.close();
			h.desconectar();
		}

	}

	@Override
	public void inserir(Partida dado) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(dado);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		} finally {
			em.close();
			h.desconectar();
		}

	}

	@Override
	public void alterar(Partida dado) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(dado);

			et.commit();
		} catch (Exception e) {
			System.out.println("Erro ao editar: " + e);
			et.rollback();
		} finally {
			em.close();
			h.desconectar();
		}

	}

	@Override
	public void excluir(Partida dado) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			Partida p = em.find(Partida.class, dado.getCodigo());
			em.remove(p);
			et.commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e);
			et.rollback();
		} finally {
			em.close();
			h.desconectar();
		}

	}

}
