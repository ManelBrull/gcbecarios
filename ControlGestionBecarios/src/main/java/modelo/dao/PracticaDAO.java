package modelo.dao;

import modelo.HibernateUtil;
import modelo.entidades.practica.Practica;
import at.modelo.dao.ATDAO;

public class PracticaDAO extends ATDAO<Practica> {
	
	public PracticaDAO(){
		setNameEntidad("practica");
	}
	
	@Override
	protected void iniciaOperacion() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();		
	}

	@Override
	protected Practica sessionGet(int id) {
		return ((Practica) session.get(Practica.class, id));
	}

}
