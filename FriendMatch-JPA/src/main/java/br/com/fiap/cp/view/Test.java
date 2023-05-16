package br.com.fiap.cp.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import br.com.fiap.cp.entities.Usuario;
import br.com.fiap.cp.entities.Correspondencia;
import br.com.fiap.cp.entities.Interesse;
import br.com.fiap.cp.entities.Notificacao;
import br.com.fiap.cp.entities.Mensagem;

public class Test {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    
	    tx.begin();
	    Usuario usuario1 = new Usuario("João", 30, "Masculino", "São Paulo", "Solteiro", new byte[0]);
	    Usuario usuario2 = new Usuario("Maria", 25, "Feminino", "Rio de Janeiro", "Casada", new byte[0]);
	    em.persist(usuario1);
	    em.persist(usuario2);

	    Interesse interesse1 = new Interesse("Esporte", "Futebol", usuario1.getId());
	    Interesse interesse2 = new Interesse("Viagem", "Conhecer novos lugares", usuario1.getId());
	    Interesse interesse3 = new Interesse("Música", "Rock", usuario2.getId());
	    em.persist(interesse1);
	    em.persist(interesse2);
	    em.persist(interesse3);

	    Correspondencia correspondencia1 = new Correspondencia(usuario1.getId(), usuario2.getId(), "Enviada", LocalDate.now());
	    Correspondencia correspondencia2 = new Correspondencia(usuario2.getId(), usuario1.getId(), "Recebida", LocalDate.now());
	    em.persist(correspondencia1);
	    em.persist(correspondencia2);

	    Mensagem mensagem1 = new Mensagem(usuario1.getId(), usuario2.getId(), "Olá Maria!", LocalDateTime.now());
	    Mensagem mensagem2 = new Mensagem(usuario2.getId(), usuario1.getId(), "Oi João!", LocalDateTime.now());
	    em.persist(mensagem1);
	    em.persist(mensagem2);

	    Notificacao notificacao1 = new Notificacao(usuario1.getId(), "Mensagem", "Nova mensagem recebida", LocalDateTime.now());
	    Notificacao notificacao2 = new Notificacao(usuario2.getId(), "Interesse", "Novo interesse em comum", LocalDateTime.now());
	    em.persist(notificacao1);
	    em.persist(notificacao2);
	    
	    TypedQuery<Usuario> queryUsuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
	    List<Usuario> usuarios = queryUsuarios.getResultList();
	    for (Usuario usuario : usuarios) {
	        System.out.println("Usuário: " + usuario.getNome() + ", Idade: " + usuario.getIdade() + ", Gênero: " + usuario.getGenero());
	        System.out.println("Interesses:");
	        for (Interesse interesse : usuario.getInteresses()) {
	            System.out.println(interesse.getNome() + ": " + interesse.getDescricao());
	        }
	        System.out.println("Correspondências enviadas:");
	        for (Correspondencia correspondencia : usuario.getCorrespondenciasEnviadas()) {
	            System.out.println("Destinatário: " + correspondencia.getDestinatario() + ", Status: " + correspondencia.getStatus());
	            System.out.println("Mensagens:");
	        for (Mensagem mensagem : correspondencia.getMensagens()) {
	            System.out.println(mensagem.getTexto() + " - " + mensagem.getDataEnvio());
	         }
	        System.out.println("Notificações:");
	        for (Notificacao notificacao : usuario.getNotificacoes()) {
	        System.out.println(notificacao.getTipo() + ": " + notificacao.getTexto() + " - " + notificacao.getData());
	        }
	        }
	        tx.commit();
	        em.close();
	        emf.close();
	    }
	}
}
	          
