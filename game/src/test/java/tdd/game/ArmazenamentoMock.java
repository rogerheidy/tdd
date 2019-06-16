package tdd.game;

public class ArmazenamentoMock implements ArmazenadorPontos {

	 private String nomeUsuarioArmazenado;
	 private String tipoPontuacaoArmazenada;
	 private int quantidadePontuacaoArmazenada;

	
	public void adicionaPontosUsuario(String nomeUsuario, String tipoPontuacao, int quantidadePontuacao) {
        this.nomeUsuarioArmazenado = nomeUsuario;
        this.tipoPontuacaoArmazenada = tipoPontuacao;
        this.quantidadePontuacaoArmazenada = quantidadePontuacao;
    }

}
