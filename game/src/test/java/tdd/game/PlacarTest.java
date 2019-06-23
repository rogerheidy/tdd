package tdd.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    
    @Test
    public void recuperarRanking() {
    	ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);
    	placar.adicionaPontosUsuario("Guerra", "Estrela", 10);
        placar.adicionaPontosUsuario("Guerra", "Topico", 5);
        placar.adicionaPontosUsuario("Guerra", "Moeda", 20);
        placar.adicionaPontosUsuario("Ares", "Estrela", 30);
        placar.adicionaPontosUsuario("Ares", "Topico", 1);
        placar.adicionaPontosUsuario("War", "Estrela", 13);
        placar.adicionaPontosUsuario("Toco", "Estrela", 0);
		Map<String, Integer> ranking = placar.recuperarRanking("Estrela");
		
		List<String> 	rankingUsuario 		= new ArrayList<String>(ranking.keySet());
		List<Integer> 	rankingPontuacao 	= new ArrayList<Integer>(ranking.values());
		
		List<String> 	rankingUsuarioEsperado 		= new ArrayList<String>(Arrays.asList("Ares", "War", "Guerra"));
		List<Integer> 	rakingPontuacaoEsperado 	= new ArrayList<Integer>(Arrays.asList(30, 13, 10));
		
		assertEquals(rankingUsuario, rankingUsuarioEsperado);
		assertEquals(rankingPontuacao, rakingPontuacaoEsperado);
	}
    

    

    
    
	
	
}
