package com.example.demo.controller;

import com.example.demo.beans.Historico;
import com.example.demo.beans.Usuario;
import com.example.demo.enums.Descricao;
import com.example.demo.enums.Status;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.util.HistoricoToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Controller
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    HistoricoController historicoController;
    Historico historico = new Historico();
    HistoricoToString historicoToString = new HistoricoToString();
    @RequestMapping(value = "/cadastrarUsuario")
    public String cadastroApp(){
        return "cadastrarUsuario";
    }
    @RequestMapping(value = "/cadastrarUsuario", method= RequestMethod.POST)
    public String cadastrar(Usuario user){
        usuarioRepository.save(user);
        System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(user.getLogin(),user.getSenha(), Status.SUCESS,Descricao.SINGIN )));
        historicoController.cadastroHistorico(historicoToString.getHistorico(user.getLogin(),user.getSenha(), Status.SUCESS,Descricao.SINGIN ));

        return "/index";
    }
    @RequestMapping(value = "/searchUsuario", method= RequestMethod.GET)
    public String searchUsuario(){
        return "searchUsuario";
    }
    @RequestMapping(value = "/getUsuario{emailpesquisa}", method= RequestMethod.GET)
    public ModelAndView getUser(@RequestParam("emailpesquisa") String email){
        ModelAndView mv = new ModelAndView("/getUsuario");
        Usuario user = new Usuario();
        try{
            if(usuarioRepository.findAll().size() >  0) {
                List<Usuario> list = usuarioRepository.findAll();
                for (int i = 0; i < list.size();i++){
                    if(list.get(i).getLogin().equalsIgnoreCase(email)){
                        System.out.println("TO AQUI ó: "+ list.get(i).getLogin());
                        System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(email,"00", Status.SUCESS,Descricao.SEARCH_MAIL )));
                        historicoController.cadastroHistorico(historicoToString.getHistorico(email,"00", Status.SUCESS, Descricao.SEARCH_MAIL ));
                        user = list.get(i);
                    }
                }
                mv.addObject("usuario", user);
                return mv;
            }else{
                System.out.println("não Existem cadastros");
                System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(email,"00", Status.SYSTEMFAIL,Descricao.SEARCH_MAIL )));
                historicoController.cadastroHistorico(historicoToString.getHistorico(email,"00", Status.SYSTEMFAIL,Descricao.SEARCH_MAIL  ));
                return new ModelAndView("index");
            }

        }catch(Exception e){
            System.out.println("DEU ERRO AI ó: "+e);
            return new ModelAndView("/");
        }
    }
    @RequestMapping(value = "/logar{login}{senha}")
    public String cadastroApp(@RequestParam("login") String login,@RequestParam("senha") String senha){
        try{
            if(usuarioRepository.findAll().size() >  0) {
                List<Usuario> list = usuarioRepository.findAll();
                for (int i = 0; i < list.size();i++){
                    if(list.get(i).getLogin().equalsIgnoreCase(login)){
                        if(list.get(i).getSenha().equals(senha)){
                            System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(login,senha, Status.SUCESS,Descricao.LOGIN )));
                            historicoController.cadastroHistorico(historicoToString.getHistorico(login,senha, Status.SUCESS,Descricao.LOGIN ));

                            return "Sucess";
                        }
                    }
                }
                System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(login,senha, Status.FAILED,Descricao.LOGIN )));
                historicoController.cadastroHistorico(historicoToString.getHistorico(login,senha, Status.FAILED,Descricao.LOGIN ));

                return "Failled";
            }else{
                System.out.println("não Existem cadastros");
                System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(login,senha, Status.FAILED,Descricao.LOGIN )));
                historicoController.cadastroHistorico(historicoToString.getHistorico(login,senha, Status.FAILED,Descricao.LOGIN ));

                return "Failled";
            }

        }catch(Exception e){
            System.out.println(historicoToString.historicoToString(historicoToString.getHistorico(login,senha, Status.FAILED,Descricao.LOGIN )));
            historicoController.cadastroHistorico(historicoToString.getHistorico(login,senha, Status.FAILED,Descricao.LOGIN ));

            return "Failled";
        }
    }



}
