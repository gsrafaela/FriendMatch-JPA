package br.com.fiap.cp.view;

import jakarta.persistence.EntityManager;

import br.com.fiap.cp.dao.InteresseDao;
import br.com.fiap.cp.dao.InteresseDaoImpl;
import br.com.fiap.cp.dao.NotificacaoDao;
import br.com.fiap.cp.dao.NotificacaoDaoImpl;
import br.com.fiap.cp.dao.UsuarioDao;
import br.com.fiap.cp.dao.UsuarioDaoImpl;
import br.com.fiap.cp.entities.Usuario;
import br.com.fiap.cp.entities.Interesse;
import br.com.fiap.cp.entities.Notificacao;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;

import java.time.LocalDate;
import java.util.List;

public class Pesquisa {
    
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        
        UsuarioDao usuarioDao = new UsuarioDaoImpl(em);
        
        //Listar todos os usuários
        List<Usuario> usuarios = usuarioDao.listar();
        for(Usuario u: usuarios) {
            System.out.println(u.getNome());
        }
       
     // Pesquisar interesses por usuário, filtrando por parte de uma string, ignorando maiúsculas e minúsculas, e ordenando o resultado
        InteresseDao interesseDao = new InteresseDaoImpl(em);
        System.out.println("Pesquisar interesses por usuário, filtrando por parte de uma string, ignorando maiúsculas e minúsculas, e ordenando o resultado");
        List<Usuario> usuarios1 = usuarioDao.listar();
        for (Usuario u : usuarios1) {
            List<Interesse> interesses = interesseDao.buscarPorUsuarioOrdenado(u, "interesse", "Esporte");
            System.out.println("Interesses do usuário " + u.getNome() + " relacionados a esportes:");
            for (Interesse i : interesses) {
                System.out.println(i.getDescricao());
            }
        }

        
     // Pesquisar interesses por usuário, filtrando por intervalo de datas, e retornando no máximo 50 resultados
        InteresseDao interesseDao1 = new InteresseDaoImpl(em);
        System.out.println("Pesquisar interesses por usuário, filtrando por intervalo de datas, e retornando no máximo 50 resultados");
        List<Usuario> usuarios2 = usuarioDao.listar();
        for (Usuario u : usuarios2) {
            List<Interesse> interesses = interesseDao1.buscarPorUsuarioEData(u, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 31), 50);
            System.out.println("Interesses do usuário " + u.getNome() + " entre 01/01/2021 e 31/12/2021:");
            for (Interesse i : interesses) {
                System.out.println(i.getDescricao());
            }
        }
        
     // Pesquisar interesses por usuário, filtrando utilizando dois parâmetros
        InteresseDao interesseDao2 = new InteresseDaoImpl(em);
        System.out.println("Pesquisar interesses por usuário, filtrando utilizando dois parâmetros");
        List<Usuario> usuarios11 = usuarioDao.listar();
        for (Usuario u : usuarios11) {
            List<Interesse> interesses = interesseDao2.buscarPorUsuarioEInteresse(u, "Música", "Esporte");
            System.out.println("Interesses do usuário " + u.getNome() + " relacionados a música e esportes:");
            for (Interesse i : interesses) {
                System.out.println(i.getDescricao());
            }
        }

        
        //Pesquisar notificações por usuário
        NotificacaoDao notificacaoDao = new NotificacaoDaoImpl(em);
        System.out.println("Buscar notificações por usuário");
        usuarios11 = usuarioDao.listar();
        for (Usuario u: usuarios11) {
            List<Notificacao> notificacoes = notificacaoDao.buscarPorUsuario(u);
            System.out.println("Notificações de " + u.getNome());
            for (Notificacao n: notificacoes) {
                System.out.println(n.getDescricao());
            }
        }
        
        
        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }
}
