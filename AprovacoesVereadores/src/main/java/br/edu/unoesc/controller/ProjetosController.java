package br.edu.unoesc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.ProjetoJDBC;
import br.edu.unoesc.dao.VereadorJDBC;
import br.edu.unoesc.model.Projeto;
import br.edu.unoesc.model.Vereador;

@Controller
@Path("/projetos")
public class ProjetosController {
	
	@Inject 
	private Result result;
	
	@Inject
	private ProjetoJDBC projetoJdbc;
	
	@Inject
	private VereadorJDBC vereadorJdbc;
	
	@Get("/cadastro")
	public void cadastro() {
		result.include("vereadores", vereadorJdbc.listar(Vereador.listarTodosVereadores, Vereador.class));
	}
	
	@Get("/mostrar")
	public void mostrar() {
		result.include("projetos", projetoJdbc.listar(Projeto.listarTodosProjetos, Projeto.class));
		result.include("vereadores", vereadorJdbc.listar(Vereador.listarTodosVereadores, Vereador.class));
	}
	
	@Post("/enviar")
	public void mostrar(Projeto projeto) {
		projetoJdbc.inserir(projeto);
		result.include("projetos", projetoJdbc.listar(Projeto.listarTodosProjetos, Projeto.class));
	}
	
	@Post("/editando")
	public void alterar(Projeto projeto){
		projetoJdbc.alterar(projeto);
		result.redirectTo(this).mostrar();
	}
	
	@Get("/editar/{codigo}")
	public void editar(Long codigo){
		Projeto v = projetoJdbc.buscar(Projeto.class, codigo);
		result.include("projetos", v);		
	}
	
	@Get("/excluir/{codigo}")
	public void mostrar(Long codigo) {
		//Projeto v = projetoJdbc.buscar(Projeto.class, codigo);
		projetoJdbc.remover(Projeto.class, codigo);
		result.include("projetos", projetoJdbc.listar(Projeto.listarTodosProjetos, Projeto.class));

	}
	
	@Get("/filtrar")
	public void mostrar(String filtro) {
		List<Projeto> filtrados = new ArrayList<>();
		List<Projeto> projetos = projetoJdbc.listar(Projeto.listarTodosProjetos, Projeto.class);
		for(int i =0; i< projetos.size(); i++) {
			Projeto v = projetos.get(i);
			if(v.getNome().contentEquals(filtro)){
				filtrados.add(v);
			}
		}
		result.include("projetos", filtrados);
	}
}
