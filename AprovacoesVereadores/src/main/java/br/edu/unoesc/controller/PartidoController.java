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
import br.edu.unoesc.model.Partido;

@Controller
@Path("/partido")
public class PartidoController {
	
	@Inject 
	private Result result;
	
	@Inject
	private PartidoJDBC partidoJdbc;

	/**
	 * @deprecated CDI eyes only
	 */
	
	@Get("/cadastro")
	public void cadastro() {
		
	}
	
	@Get("/mostrar")
	public void mostrar() {
		result.include("partidos", partidoJdbc.listar(Partido.listarTodosPartidos, Partido.class));
	}
	
	@Post("/enviar")
	public void mostrar(Partido partido) {
		partidoJdbc.inserir(partido);
		result.include("partidos", partidoJdbc.listar(Partido.listarTodosPartidos, Partido.class));
	}
	
	@Post("/editando")
	public void alterar(Partido partido){
		partidoJdbc.alterar(partido);
		result.redirectTo(this).mostrar();
	}
	
	@Get("/editar/{codigo}")
	public void editar(Long codigo){
		Partido v = partidoJdbc.buscar(Partido.class, codigo);
		result.include("partidos", v);		
	}
	
	@Get("/excluir/{codigo}")
	public void mostrar(Long codigo) {
		//Partido v = partidoJdbc.buscar(Partido.class, codigo);
		partidoJdbc.remover(Partido.class, codigo);
		result.include("partidos", partidoJdbc.listar(Partido.listarTodosPartidos, Partido.class));

	}
	
	@Get("/filtrar")
	public void mostrar(String filtro) {
		List<Partido> filtrados = new ArrayList<>();
		List<Partido> partidos = partidoJdbc.listar(Partido.listarTodosPartidos, Partido.class);
		for(int i =0; i< partidos.size(); i++) {
			Partido v = partidos.get(i);
			if(v.getNome().contentEquals(filtro)){
				filtrados.add(v);
			}
		}
		result.include("partidos", filtrados);
	}
}
