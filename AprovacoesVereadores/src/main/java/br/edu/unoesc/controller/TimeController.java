package br.edu.unoesc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.TimeDAO;
import br.edu.unoesc.model.Time;

@Controller
@Path("/time")
public class TimeController {

	@Inject
	private Result result;

	@Inject
	private TimeDAO timeDao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected TimeController() {
		this(null);
	}

	@Inject
	public TimeController(Result result) {
		this.result = result;
	}

	@Get("/cadastro")
	public void cadastro() {
	}
	
	@Get("/mostrar")
	public void mostrar() {
		result.include("times", timeDao.listar());
	}
	
	
	@Post("/enviar")
	public void mostrar(Time time) {
		timeDao.inserir(time);
		result.include("times", timeDao.listar());
	}

	@Post("/editando")
	public void alterar(Time time) {
		timeDao.alterar(time);
		result.redirectTo(this).mostrar();
	}

	@Get("/editar/{codigo}")
	public void editar(Long codigo) {
		Time t = timeDao.buscar(codigo);
		result.include("times", t);
	}

	@Get("/excluir/{codigo}")
	public void mostrar(Long codigo) {
		Time t = timeDao.buscar(codigo);
		timeDao.excluir(t);
		result.include("times", timeDao.listar());

	}
}
