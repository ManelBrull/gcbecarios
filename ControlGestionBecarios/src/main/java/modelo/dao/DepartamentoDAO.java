package modelo.dao;

import modelo.HibernateUtil;
import modelo.entidades.Departamento;
import at.modelo.dao.ATDAO;

public class DepartamentoDAO extends ATDAO<Departamento> {

	public DepartamentoDAO(){
		setNameEntidad("departamento");
	}
	@Override
	protected void iniciaOperacion() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();		
	}

	@Override
	protected Departamento sessionGet(int id) {
		return ((Departamento) session.get(Departamento.class, id));
	}

}
