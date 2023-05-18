package br.com.fiap.cp.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.fiap.cp.entities.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{

    public UsuarioDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public UsuarioDaoImpl(Session session) {
        super(session);
    }

	public void cadastrar(Usuario usuario1) {
		// TODO Auto-generated method stub
		
	}

	public void salvar() {
		// TODO Auto-generated method stub
		
	}

	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}