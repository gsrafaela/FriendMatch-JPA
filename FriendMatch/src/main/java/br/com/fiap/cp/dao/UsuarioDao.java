package br.com.fiap.cp.dao;

import java.util.List;

import br.com.fiap.cp.entities.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {

	void cadastrar(Usuario usuario1);

	void salvar();

	List<Usuario> listar();

   
}
