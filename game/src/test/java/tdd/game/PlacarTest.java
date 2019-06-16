package tdd.game;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PlacarTest {

    @Test
    public void deveArmazenarPontosParaUmUsuario() {
        ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);

        placar.adicionaPontosUsuario("Guerra", "Estrela", 10);

        armazenamentoMock.adicionaPontosUsuario("Guerra", "Estrela", 10);
     }
    
    @Test
    public void pontosPorUsuario() {
        ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);
        Set<Ponto> pontosDoGuerra = new HashSet<>(Arrays.asList(new Ponto("estrela", 1)));
        armazenamentoMock.quandoChamarPontosPorUsuarioCom("Guerra").retornar(pontosDoGuerra);

        Set<Ponto> resultado = placar.pontosPorUsuario("Guerra");

        assertEquals(pontosDoGuerra, resultado);
    }
    
    
	
	
}
