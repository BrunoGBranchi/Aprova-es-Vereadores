package br.edu.unoesc.dao;

import java.util.List;

public interface CrudDAO<T> {

	T buscar(Long codigo);
    
    List<T> listar();
     
    void inserir(T dado);
     
    void alterar(T dado);
     
    void excluir(T dado);
}
