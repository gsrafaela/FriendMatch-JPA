package br.com.fiap.cp.banco;

import jakarta.persistence.EntityManager;

import br.com.fiap.cp.dao.CorrespondenciaDao;
import br.com.fiap.cp.dao.CorrespondenciaDaoImpl;
import br.com.fiap.cp.dao.InteresseDao;
import br.com.fiap.cp.dao.InteresseDaoImpl;
import br.com.fiap.cp.dao.NotificacaoDao;
import br.com.fiap.cp.dao.NotificacaoDaoImpl;
import br.com.fiap.cp.dao.MensagemDao;
import br.com.fiap.cp.dao.MensagemDaoImpl;
import br.com.fiap.cp.dao.UsuarioDao;
import br.com.fiap.cp.dao.UsuarioDaoImpl;
import br.com.fiap.cp.entities.Usuario;
import br.com.fiap.cp.entities.Correspondencia;
import br.com.fiap.cp.entities.Interesse;
import br.com.fiap.cp.entities.Notificacao;
import br.com.fiap.cp.entities.Mensagem;
import br.com.fiap.cp.exceptions.CommitErrorException;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;

public class PopulaBanco {

    public static void main(String[] args) throws CommitErrorException {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        /**
         * BEGIN persistence of 3 users
         */
        Usuario usuario1 = new Usuario("João", 0, "joao@gmail.com", "123456", null, null);
        Usuario usuario2 = new Usuario("Maria", 0, "maria@gmail.com", "654321", null, null);
        Usuario usuario3 = new Usuario("Pedro", 0, "pedro@gmail.com", "password", null, null);

        UsuarioDao usuarioDAO = new UsuarioDaoImpl(em);
        usuarioDAO.cadastrar(usuario1);
        usuarioDAO.cadastrar(usuario2);
        usuarioDAO.cadastrar(usuario3);
        usuarioDAO.salvar();
        /**
         * END persistence of 3 users
         */

        /**
         * BEGIN persistence of messages
         */
        Mensagem mensagem1 = new Mensagem("Hello, how are you?", usuario1, usuario2);
        Mensagem mensagem2 = new Mensagem("I'm fine, thank you! How about you?", usuario2, usuario1);
        Mensagem mensagem3 = new Mensagem("Can we meet tomorrow?", usuario1, usuario2);

        MensagemDao mensagemDAO = new MensagemDaoImpl(em);
        mensagemDAO.cadastrar(mensagem1);
        mensagemDAO.cadastrar(mensagem2);
        mensagemDAO.cadastrar(mensagem3);
        mensagemDAO.salvar();
        /**
         * END persistence of messages
         */

        /**
         * BEGIN persistence of correspondences
         */
        Correspondencia correspondencia1 = new Correspondencia("Rua A, 123", "São Paulo", "SP", "01234-567", usuario1);
        Correspondencia correspondencia2 = new Correspondencia("Rua B, 456", "São Paulo", "SP", "01234-890", usuario2);
        Correspondencia correspondencia3 = new Correspondencia("Rua C, 789", "Rio de Janeiro", "RJ", "12345-678", usuario3);

        CorrespondenciaDao correspondenciaDAO = new CorrespondenciaDaoImpl(em);
        correspondenciaDAO.cadastrar(correspondencia1);
        correspondenciaDAO.cadastrar(correspondencia2);
        correspondenciaDAO.cadastrar(correspondencia3);
        correspondenciaDAO.salvar();
        /**
         * END persistence of correspondences
         */

        /**
         * BEGIN persistence of notifications
         */
        Notificacao notificacao1 = new Notificacao("You have a new message from Maria", usuario1);
        Notificacao notificacao2 = new Notificacao("You have a new message from João", usuario2);
        Notificacao notificacao3 = new Notificacao("You have a new message from Pedro", usuario3);
        
        NotificacaoDao notificacaoDAO = new NotificacaoDaoImpl(em);
        notificacaoDAO.cadastrar(notificacao1);
        notificacaoDAO.cadastrar(notificacao2);
        notificacaoDAO.cadastrar(notificacao3);
        notificacaoDAO.salvar();
        /**
         * END persistence of notifications
         */

        /**
         * BEGIN persistence of interests
         */
        Interesse interesse1 = new Interesse("Sports", usuario1);
        Interesse interesse2 = new Interesse("Technology", usuario2);
        Interesse interesse3 = new Interesse("Music", usuario3);

        InteresseDao interesseDAO = new InteresseDaoImpl(em);
        interesseDAO.cadastrar(interesse1);
        interesseDAO.cadastrar(interesse2);
        interesseDAO.cadastrar(interesse3);
        interesseDAO.salvar();
        /**
         * END persistence of interests
         */

        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }
}
