package br.edu.unoesc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Projeto.listarTodosProjetos, query = "select pr from Projeto pr") })
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer codigo;
	private String nome;
	private boolean apresentado;
	private boolean aprovado;
	public static final String listarTodosProjetos = "buscarTodosProjetos";
	
	@ManyToOne
	private Vereador vereador;
	
	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isApresentado() {
		return apresentado;
	}

	public void setApresentado(boolean apresentado) {
		this.apresentado = apresentado;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Projeto(Integer codigo, String nome, boolean apresentado, boolean aprovado, Vereador vereador) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.apresentado = apresentado;
		this.aprovado = aprovado;
		this.vereador = vereador;
	}

	public Projeto() {

	}

}
