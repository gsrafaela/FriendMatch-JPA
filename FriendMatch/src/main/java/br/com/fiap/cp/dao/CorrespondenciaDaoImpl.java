package br.com.fiap.cp.dao;

import java.util.List;

import br.com.fiap.cp.entities.Correspondencia;
import br.com.fiap.cp.entities.Usuario;
import jakarta.persistence.EntityManager;

public class CorrespondenciaDaoImpl extends GenericDaoImpl<Correspondencia, Integer> implements CorrespondenciaDao {

    public CorrespondenciaDaoImpl(EntityManager em) {
        super(em);
    }

	public void cadastrar(Correspondencia correspondencia1) {
		// TODO Auto-generated method stub
		
	}

	public void salvar() {
		// TODO Auto-generated method stub
		
	}

	public List<Correspondencia> buscarPorUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}


}
