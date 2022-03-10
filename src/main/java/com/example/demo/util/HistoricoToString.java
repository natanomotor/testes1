package com.example.demo.util;

import com.example.demo.beans.Historico;
import com.example.demo.enums.Descricao;
import com.example.demo.enums.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/* Essa classe é responsavel por transformar um objeto Historico em uma String que pode ser escrita no console da aplicação
*
*
*/
public class HistoricoToString {
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private Date date = new Date();
    Historico historico = new Historico();

    public String historicoToString(Historico h){
        return "Login: "+ h.getLogin()+" Senha: "+ h.getSenha()+" Status: "+ h.getStatus()+" Data: "+h.getData()+" Descricao: "+h.getDescricao();
    }
    public  Historico getHistorico(String login, String senha, Status status, Descricao desc){
        historico = new Historico();
        historico.setLogin(login);
        historico.setSenha(senha);
        historico.setStatus(status);
        historico.setDescricao(desc);
        historico.setData(dateTimeFormatter.format(LocalDateTime.now()));
        return historico;
    }
}
