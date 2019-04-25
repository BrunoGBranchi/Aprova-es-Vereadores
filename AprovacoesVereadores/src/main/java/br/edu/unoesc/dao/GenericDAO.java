package br.edu.unoesc.dao;

import java.util.List;

import br.edu.unoesc.conexao.HibernateUtil;

public abstract class GenericDAO <T> extends HibernateUtil implements CrudDAO<T> {
	
	@Override
	public void inserir(T dado) {
		conectar();
		et = em.getTransaction();
		et.begin();

		try {
			em.persist(dado);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			desconectar();
		}

	}
	@Override
	public T buscar(Class<T> classe, Long codigo) {
		conectar();
		try {
			return em.find(classe, codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			desconectar();
		}
	}

	@Override
	public List<T> listar(String query, Class<T> classe) {
		conectar();

		try {
			return em.createNamedQuery(query, classe).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			desconectar();
		}
	}

	@Override
	public void alterar(T dado) {
		conectar();
		et = em.getTransaction();
		et.begin();

		try {
			em.merge(dado);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			desconectar();
		}
	}

	@Override
	public void remover(Class<T> classe, Long cod) {
		conectar();
		et = em.getTransaction();
		et.begin();

		try {
			em.remove(em.find(classe, cod));
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			desconectar();
		}
	}

}
