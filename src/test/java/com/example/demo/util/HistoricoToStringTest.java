package com.example.demo.util;

import com.example.demo.beans.Historico;
import com.example.demo.enums.Descricao;
import com.example.demo.enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoToStringTest {
    private HistoricoToString historicoToString = new HistoricoToString();
    private Historico historico = new Historico();
    //Verifica se o meotodo está retornando uma String
    @Test
    void historicoToString() {
        assertEquals(true, historicoToString.historicoToString(historico).getClass() == String.class);
    }
    //Verifica se o metodo está retornando valores nulos
    @Test
    void getHistorico() {
        historico = historicoToString.getHistorico("Historico_TEST","senha_TEST", Status.SYSTEMFAIL, Descricao.SEARCH_MAIL);
        assertEquals(true, historico != null);
    }
}