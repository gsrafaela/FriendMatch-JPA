package br.com.fiap.cp.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.cp.entities.Interesse;
import br.com.fiap.cp.entities.Usuario;
import jakarta.persistence.EntityManager;

public class InteresseDaoImpl extends GenericDaoImpl<Interesse, Integer> implements InteresseDao {

    public InteresseDaoImpl(EntityManager em) {
        super(em);
    }

	public void cadastrar(Interesse interesse1) {
		// TODO Auto-generated method stub
		
	}

	public void salvar() {
		// TODO Auto-generated method stub
		
	}

	public List<Interesse> buscarPorUsuarioOrdenado(Usuario u, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Interesse> buscarPorUsuarioEData(Usuario u, LocalDate of, LocalDate of2, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Interesse> buscarPorUsuarioEInteresse(Usuario u, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}
