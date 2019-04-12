package br.edu.unoesc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.PartidaDAO;
import br.edu.unoesc.dao.TimeDAO;
import br.edu.unoesc.model.Partida;

@Controller
@Path("/partida")
public class PartidaController {
	@Inject
	private Result result;

	@Inject
	private PartidaDAO partidaDao;
	
	@Inject
	private TimeDAO timeDao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected PartidaController() {
		this(null);
	}

	@Inject
	public PartidaController(Result result) {
		this.result = result;
	}

	@Get("/cadastro")
	public void cadastro() {
		result.include("times", timeDao.listar());
	}
	
	@Get("/mostrar")
	public void mostrar() {
		result.include("partidas", partidaDao.listar());
		result.include("times", timeDao.listar());
	}
	
	@Post("/enviar")
	public void mostrar(Partida partida) {
		partidaDao.inserir(partida);
		result.include("partidas", partidaDao.listar());
		result.include("times", timeDao.listar());

	}
	
	@Post("/editando")
	public void alterar(Partida partida){
		partidaDao.alterar(partida);
		result.redirectTo(this).mostrar();
	}

	@Get("/editar/{codigo}")
	public void editar(Long codigo) {
		Partida p = partidaDao.buscar(codigo);
		result.include("partidas", p);
		result.include("times", timeDao.listar());
	}

	@Get("/excluir/{codigo}")
	public void mostrar(Long codigo) {
		Partida p = partidaDao.buscar(codigo);
		partidaDao.excluir(p);
		result.include("partidas", partidaDao.listar());

	}
	
}

