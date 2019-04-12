package br.edu.unoesc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@ManyToOne
	private Time time1;
	@ManyToOne
	private Time time2;
	private int pontuacao1;
	private int pontuacao2;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public int getPontuacao1() {
		return pontuacao1;
	}

	public Time getTime1() {
		return time1;
	}

	public void setTime1(Time time1) {
		this.time1 = time1;
	}
	
	public Time getTime2() {
		return time2;
	}

	public void setTime2(Time time2) {
		this.time2 = time2;
	}

	public void setPontuacao1(int pontuacao1) {
		this.pontuacao1 = pontuacao1;
	}

	public int getPontuacao2() {
		return pontuacao2;
	}

	public void setPontuacao2(int pontuacao2) {
		this.pontuacao2 = pontuacao2;
	}

	public Partida(Long codigo, Time time1, Time time2, int pontuacao1, int pontuacao2) {
		super();
		this.codigo = codigo;
		this.time1 = time1;
		this.time2 = time2;
		this.pontuacao1 = pontuacao1;
		this.pontuacao2 = pontuacao2;
	}

	public Partida() {
	}

}
