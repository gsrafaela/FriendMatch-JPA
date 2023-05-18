package br.com.fiap.cp.dao;

import java.util.List;

import br.com.fiap.cp.entities.Notificacao;
import br.com.fiap.cp.entities.Usuario;
import jakarta.persistence.EntityManager;

public class NotificacaoDaoImpl extends GenericDaoImpl<Notificacao, Integer> implements NotificacaoDao {

    public NotificacaoDaoImpl(EntityManager em) {
        super(em);
    }

	public void cadastrar(Notificacao notificacao1) {
		// TODO Auto-generated method stub
		
	}

	public void salvar() {
		// TODO Auto-generated method stub
		
	}

	public List<Notificacao> buscarPorUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}
}
