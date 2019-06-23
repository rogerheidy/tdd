package tdd.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlacarTest {

    @Test
    public void deveArmazenarPontosParaUmUsuario() {
        ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);

        placar.adicionaPontosUsuario("Guerra", "Estrela", 10);
        Integer valor = 10;
        assertEquals(valor, armazenamentoMock.recuperarPontuacaoUsuario("Estrela", "Guerra"));
       }
    
    @Test
    public void recuperarPontuacaoDoUsuario() {
    	ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);
        placar.adicionaPontosUsuario("Guerra", "Estrela", 10);
        placar.adicionaPontosUsuario("Guerra", "Topico", 10);
        placar.adicionaPontosUsuario("Guerra", "Moeda", 10);
		
		
		Pontuacao pontuacaoEsperada = new Pontuacao();

		pontuacaoEsperada.adicionarPontos("Topico", 10);
		pontuacaoEsperada.adicionarPontos("Moeda", 10);
		
		Pontuacao pontuacaoAtual = placar.recuperarPontuacaoUsuario("Guerra");
		assertEquals(pontuacaoEsperada, pontuacaoAtual);
	}
    

    

    
    
	
	
}
