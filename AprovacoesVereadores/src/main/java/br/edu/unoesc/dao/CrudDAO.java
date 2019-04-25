package br.edu.unoesc.dao;

import java.util.List;

public interface CrudDAO<T> {

	void inserir(T dado);
	void alterar(T dado);
	void remover(Class<T> classe,Long codigo);
	List<T> listar(String query, Class<T> classe);
	T buscar(Class<T> classe, Long codigo);
}
