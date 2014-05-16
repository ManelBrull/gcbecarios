package modelo.dao;

import modelo.HibernateUtil;
import modelo.entidades.Becario;
import modelo.entidades.Expediente;
import at.modelo.dao.ATDAO;

public class ExpedienteDAO extends ATDAO<Expediente> {

	public ExpedienteDAO(){
		setNameEntidad("expediente");
	}
	
	@Override
	protected void iniciaOperacion() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();
	}

	@Override
	protected Expediente sessionGet(int id) {
		return ((Expediente) session.get(Expediente.class, id));
	}

}
