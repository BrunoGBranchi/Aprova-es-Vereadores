package br.edu.unoesc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import br.edu.unoesc.dao.VereadorJDBC;

@Entity
@NamedQueries({ @NamedQuery(name = Vereador.listarTodosVereadores, query = "select v from Vereador v") })
public class Vereador extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate dataAssociacao;
	private float desempenho = 0;

	@OneToMany(targetEntity = Projeto.class)
	private Set<Projeto> projetos = new HashSet<Projeto>();

	@ManyToOne
	private Partido partido;

	private Integer qtdeProjetosApresentados = 0;
	private Integer qtdeProjetosAprovados = 0;
	
/*-----------------------------------------------------*/
	
	public LocalDate getDataAssociacao() {
		return dataAssociacao;
	}

	public void setDataAssociacao(LocalDate dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
	}

	public float getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(float desempenho) {
		this.desempenho = desempenho;
	}

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Integer getQtdeProjetosApresentados() {
		return qtdeProjetosApresentados;
	}

	public void setQtdeProjetosApresentados(Integer qtdeProjetosApresentados) {
		this.qtdeProjetosApresentados = qtdeProjetosApresentados;
	}

	public Integer getQtdeProjetosAprovados() {
		return qtdeProjetosAprovados;
	}

	public void setQtdeProjetosAprovados(Integer qtdeProjetosAprovados) {
		this.qtdeProjetosAprovados = qtdeProjetosAprovados;
	}

	public Vereador(Long codigo, String nome, LocalDate dataAssociacao, float desempenho, Set<Projeto> projetos,
			Partido partido, Integer qtdeProjetosApresentados, Integer qtdeProjetosAprovados) {
		super(codigo, nome);
		this.dataAssociacao = dataAssociacao;
		this.desempenho = desempenho;
		this.projetos = projetos;
		this.partido = partido;
		this.qtdeProjetosApresentados = qtdeProjetosApresentados;
		this.qtdeProjetosAprovados = qtdeProjetosAprovados;
	}

	public Vereador() {

	}

	public Vereador(Long codigo, String nome) {

	}

}
