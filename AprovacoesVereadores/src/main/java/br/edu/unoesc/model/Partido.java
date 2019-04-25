package br.edu.unoesc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = Partido.listarTodosPartidos, query = "select pt from Partido pt") })
public class Partido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long codigo;
	private Long numero;
	private String nome;
	
	@OneToMany(mappedBy = "partido", targetEntity = Vereador.class, cascade = CascadeType.ALL)
	private Set<Vereador> vereadores = new HashSet<Vereador>();
	
	public static final String listarTodosPartidos = "buscarTodosPartidos";

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Vereador> getVereadores() {
		return vereadores;
	}

	public void setVereadores(Set<Vereador> vereadores) {
		this.vereadores = vereadores;
	}

	public Partido(Long codigo, Long numero, String nome, Set<Vereador> vereadores) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.nome = nome;
		this.vereadores = vereadores;
	}

	public Partido() {
	}	
		
}
