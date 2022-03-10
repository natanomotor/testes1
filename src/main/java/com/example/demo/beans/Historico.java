package com.example.demo.beans;

import com.example.demo.enums.Descricao;
import com.example.demo.enums.Status;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Historico {
    @Id
    @NonNull
    private String data;
    @NonNull
    private Status status;
    @NonNull
    private String login;
    @NonNull
    private String senha;
    @NonNull
    private Descricao descricao;
}
