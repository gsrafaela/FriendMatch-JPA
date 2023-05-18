package br.com.fiap.cp.dao;

import java.util.List;

import br.com.fiap.cp.entities.Mensagem;
import br.com.fiap.cp.entities.Usuario;

public interface MensagemDao extends GenericDao<Mensagem, Integer> {

	void cadastrar(Mensagem mensagem1);

	void salvar();

	List<Mensagem> buscarPorUsuario(Usuario u);


}
