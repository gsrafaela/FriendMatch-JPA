package br.com.fiap.cp.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.fiap.cp.entities.Mensagem;
import br.com.fiap.cp.entities.Usuario;
import jakarta.persistence.EntityManager;

public class MensagemDaoImpl extends GenericDaoImpl<Mensagem, Integer> implements MensagemDao {

    public MensagemDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public MensagemDaoImpl(Session session) {
        super(session);
    }

	public void cadastrar(Mensagem mensagem1) {
		// TODO Auto-generated method stub
		
	}

	public void salvar() {
		// TODO Auto-generated method stub
		
	}

	public List<Mensagem> buscarPorUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}
}
