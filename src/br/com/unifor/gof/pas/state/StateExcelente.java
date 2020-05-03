package br.com.unifor.gof.pas.state;

public class StateExcelente extends State {
	
	private static final String DESEMPENHO = "Excelente";
	
	public StateExcelente(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public double getDesconto() {		
		return aluno.getMensalidade() * 0.3;
	}
	
	public String getDesempenho() {
		return DESEMPENHO;
	}
	
	public void mudarState() {
		if (aluno.getMedia() >= 9.0) {
			aluno.setState(new StateExcelente(aluno));
		} else if (aluno.getMedia() >= 8.0) {
			aluno.setState(new StateOtimo(aluno));
		} else if (aluno.getMedia() >= 6.0) {
			aluno.setState(new StateRegular(aluno));
		} else {
			aluno.setState(new StateRuim(aluno));
		}
	}

}