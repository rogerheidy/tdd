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
       }
    

    
    
	
	
}
