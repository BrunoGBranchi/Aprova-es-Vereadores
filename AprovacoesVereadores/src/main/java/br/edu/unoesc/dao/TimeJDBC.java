package br.edu.unoesc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.edu.unoesc.model.Time;

public class TimeJDBC implements TimeDAO {

	@Override
	public Time buscar(Long codigo) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		TypedQuery<Time> query = em.createQuery("select t from Time t where codigo = ?1", Time.class);
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
	public List<Time> listar() {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		try {
			TypedQuery<Time> query = em.createQuery("select t from Time t", Time.class);
			return query.getResultList();
		} finally {
			em.close();
			h.desconectar();
		}

	}

	@Override
	public void inserir(Time dado) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(dado);
			et.commit();
		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e);
			et.rollback();
		} finally {
			em.close();
			h.desconectar();
		}

	}

	@Override
	public void alterar(Time dado) {
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
	public void excluir(Time dado) {
		HibernateUtil h = new HibernateUtil();
		EntityManager em = h.getConexao();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			Time t = em.find(Time.class, dado.getCodigo());
			em.remove(t);
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
