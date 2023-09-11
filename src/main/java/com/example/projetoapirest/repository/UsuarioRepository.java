package com.example.projetoapirest.repository;

import com.example.projetoapirest.exception.BusinessException;
import com.example.projetoapirest.exception.CampoObrigatorioException;
import com.example.projetoapirest.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario){

        if(StringUtils.isEmpty(usuario.getLogin())){
            throw new CampoObrigatorioException("login");
        }

        if(StringUtils.isEmpty(usuario.getPassword())){
            throw new CampoObrigatorioException("password");
        }

        if(usuario.getId() == null){
            System.out.println("SAVE - Salvando usuário");
        }
        else {
            System.out.println("UPDATE - Atualizando usuário");
        }

        System.out.println(usuario);
    }

    public void delteById(Long id){
        System.out.println(String.format("DELETE - Recebendo o id: %d", id));
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("LIST - Listando todos os usuários do sistema");

        return Arrays.asList(new Usuario("Felipe", "pass")
            , new Usuario("Jose", "123"));
    }

    public Usuario findById(Long id){
        System.out.println(String.format("FIND/ID - Recebendo o id: %d", id));
        return new Usuario("Jose", "123");
    }

    public Usuario findByLogin(String login){
        System.out.println(String.format("FIND/LOGIN - Recebendo o login: %s", login));
        return new Usuario("Jose", "123");
    }
}
