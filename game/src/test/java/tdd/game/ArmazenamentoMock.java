package tdd.game;

import java.util.Set;

public class ArmazenamentoMock implements ArmazenadorPontos {

	   private String nomeUsuarioArmazenado;
	   private String tipoPontuacaoArmazenada;
	   private int quantidadePontuacaoArmazenada;

	   private String argumentoPontosPorUsuario;
	   private Set<Ponto> retornoPontosPorUsuario;
	
	public void adicionaPontosUsuario(String nomeUsuario, String tipoPontuacao, int quantidadePontuacao) {
        this.nomeUsuarioArmazenado = nomeUsuario;
        this.tipoPontuacaoArmazenada = tipoPontuacao;
        this.quantidadePontuacaoArmazenada = quantidadePontuacao;
    }
	@Override
    public Set<Ponto> pontosPorUsuario(String nomeUsuario) {
        if (nomeUsuario.equals(argumentoPontosPorUsuario)) {
            return retornoPontosPorUsuario;
        }

        return null;
    }

	public ArmazenamentoMock quandoChamarPontosPorUsuarioCom(String nomeUsuario) {
        this.argumentoPontosPorUsuario = nomeUsuario;

        return this;
    }
	public void retornar(Set<Ponto> pontos) {
        this.retornoPontosPorUsuario = pontos;
    }

}
