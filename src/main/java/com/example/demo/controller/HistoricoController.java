package com.example.demo.controller;

import com.example.demo.beans.Historico;
import com.example.demo.repositories.HistoricoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@RestController
public class HistoricoController {
    @Autowired
    HistoricoRepository historicoRepository;
    public String cadastroHistorico(Historico historico){
        historicoRepository.save(historico);
        return "/";
    }

}
