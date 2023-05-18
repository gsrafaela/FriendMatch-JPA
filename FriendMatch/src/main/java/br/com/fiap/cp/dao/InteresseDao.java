package br.com.fiap.cp.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.cp.entities.Interesse;
import br.com.fiap.cp.entities.Usuario;

public interface InteresseDao extends GenericDao<Interesse, Integer> {

	void cadastrar(Interesse interesse1);

	void salvar();

	List<Interesse> buscarPorUsuarioEData(Usuario u, LocalDate of, LocalDate of2, int i);

	List<Interesse> buscarPorUsuarioOrdenado(Usuario u, String string, String string2);

	List<Interesse> buscarPorUsuarioEInteresse(Usuario u, String string, String string2);


}
