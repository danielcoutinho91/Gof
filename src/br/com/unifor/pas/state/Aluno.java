package br.com.unifor.pas.state;

public class Aluno {
	
	private String nome;
	private double media;
	private double mensalidade;
	private State state;
	
	public Aluno(String nome, double media, double mensalidade) {
		this.nome = nome;
		this.media = media;
		this.mensalidade = mensalidade;
		if (media >= 9.0) {
			this.setState(new StateExcelente(this));
		} else if (media >= 8.0) {
			this.setState(new StateOtimo(this));
		} else if (media >= 6.0) {
			this.setState(new StateRegular(this));
		} else {
			this.setState(new StateRuim(this));
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
		this.state.mudarState();
	}
	
	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	private double getDesconto() {
		return getState().getDesconto();
	}
	
	private String getDesempenho() {
		return getState().getDesempenho();
	}

}
