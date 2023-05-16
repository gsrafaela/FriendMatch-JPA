package br.com.fiap.cp.dao;

import java.util.List;

import br.com.fiap.cp.entities.Correspondencia;
import br.com.fiap.cp.entities.Usuario;

public interface CorrespondenciaDao extends GenericDao<Correspondencia, Integer> {

	void cadastrar(Correspondencia correspondencia1);

	void salvar();

	List<Correspondencia> buscarPorUsuario(Usuario u);


}
