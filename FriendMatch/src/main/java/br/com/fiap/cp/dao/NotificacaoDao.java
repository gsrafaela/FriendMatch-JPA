package br.com.fiap.cp.dao;

import java.util.List;

import br.com.fiap.cp.entities.Notificacao;
import br.com.fiap.cp.entities.Usuario;

public interface NotificacaoDao extends GenericDao<Notificacao, Integer> {

	void cadastrar(Notificacao notificacao1);

	void salvar();

	List<Notificacao> buscarPorUsuario(Usuario u);

}
