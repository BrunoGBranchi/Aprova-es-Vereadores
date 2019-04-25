package br.edu.unoesc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.PartidoJDBC;
import br.edu.unoesc.dao.ProjetoJDBC;
import br.edu.unoesc.dao.VereadorJDBC;
import br.edu.unoesc.model.Partido;
import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.model.Vereador;

@Controller
@Path("/vereador")
public class VereadorController {
	
	@Inject 
	private Result result;
	
	@Inject
	private VereadorJDBC vereadorJdbc;
	
	@Inject
	private PartidoJDBC partidoJdbc;

	/**
	 * @deprecated CDI eyes only
	 */
	
	@Get("/cadastro")
	public void cadastro() {
		result.include("partidos", partidoJdbc.listar(Partido.listarTodosPartidos, Partido.class));
	}
	
	@Get("/mostrar")
	public void mostrar() {
		result.include("vereadores", vereadorJdbc.listar(Vereador.listarTodosVereadores, Vereador.class));
		result.include("partidos", partidoJdbc.listar(Partido.listarTodosPartidos, Partido.class));
	}
	
	@Post("/enviar")
	public void mostrar(Vereador vereador) {
		vereadorJdbc.inserir(vereador);
		result.include("vereadores", vereadorJdbc.listar(Vereador.listarTodosVereadores, Vereador.class));
	}
	
	@Post("/editando")
	public void alterar(Vereador vereador){
		vereadorJdbc.alterar(vereador);
		result.redirectTo(this).mostrar();
	}
	
	@Get("/editar/{codigo}")
	public void editar(Long codigo){
		Vereador v = vereadorJdbc.buscar(Vereador.class, codigo);
		result.include("vereadores", v);		
	}
	
	@Get("/excluir/{codigo}")
	public void mostrar(Long codigo) {
		//Vereador v = vereadorJdbc.buscar(Vereador.class, codigo);
		vereadorJdbc.remover(Vereador.class, codigo);
		result.include("vereadores", vereadorJdbc.listar(Vereador.listarTodosVereadores, Vereador.class));

	}
	
	@Get("/filtrar")
	public void mostrar(String filtro) {
		List<Vereador> filtrados = new ArrayList<>();
		List<Vereador> vereadores = vereadorJdbc.listar(Vereador.listarTodosVereadores, Vereador.class);
		for(int i =0; i< vereadores.size(); i++) {
			Vereador v = vereadores.get(i);
			if(v.getNome().contentEquals(filtro)){
				filtrados.add(v);
			}
		}
		result.include("vereadores", filtrados);
	}
}
