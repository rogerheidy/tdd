package tdd.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PlacarTest {
	ArmazenamentoMock armazenamentoMock;
	Placar placar;
	Pontuacao pontuacaoEsperada;
	Pontuacao pontuacaoAtual;

	@Before
	public void iniciar() {
		 armazenamentoMock = new ArmazenamentoMock();
		 placar = new Placar(armazenamentoMock);
		 pontuacaoEsperada = new Pontuacao();
		 placar.adicionaPontosUsuario("Guerra", "Estrela", 10);
	     placar.adicionaPontosUsuario("Guerra", "Topico", 5);
	     placar.adicionaPontosUsuario("Guerra", "Moeda", 20);
	     placar.adicionaPontosUsuario("Ares", "Estrela", 30);
	     placar.adicionaPontosUsuario("Ares", "Topico", 1);
	     placar.adicionaPontosUsuario("War", "Estrela", 13);
	     placar.adicionaPontosUsuario("Toco", "Estrela", 0);
	}
	
    @Test
    public void deveArmazenarPontosParaUmUsuario() {
        Integer valor = 10;
        assertEquals(valor, armazenamentoMock.recuperarPontuacaoUsuario("Estrela", "Guerra"));
    }
    
    @Test
    public void recuperarPontuacaoDoUsuario() {
    	pontuacaoEsperada.adicionarPontos("Topico", 5);
		pontuacaoEsperada.adicionarPontos("Moeda", 20);
		
	    pontuacaoAtual = placar.recuperarPontuacaoUsuario("Guerra");
		assertEquals(pontuacaoEsperada, pontuacaoAtual);
	}
    
    @Test
    public void recuperarRanking() {
		Map<String, Integer> ranking = placar.recuperarRanking("Estrela");
		
		List<String> 	rankingUsuario 		= new ArrayList<String>(ranking.keySet());
		List<Integer> 	rankingPontuacao 	= new ArrayList<Integer>(ranking.values());
		
		List<String> 	rankingUsuarioEsperado 		= new ArrayList<String>(Arrays.asList("Ares", "War", "Guerra"));
		List<Integer> 	rakingPontuacaoEsperado 	= new ArrayList<Integer>(Arrays.asList(30, 13, 10));
		
		assertEquals(rankingUsuario, rankingUsuarioEsperado);
		assertEquals(rankingPontuacao, rakingPontuacaoEsperado);
	}
    

    

    
    
	
	
}
