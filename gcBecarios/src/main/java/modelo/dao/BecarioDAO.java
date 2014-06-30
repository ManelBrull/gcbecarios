package modelo.dao;

import org.hibernate.Query;

import modelo.HibernateUtil;
import modelo.entidades.Becario;
import modelo.entidades.usuario.Usuario;
import at.modelo.dao.ATDAO;

public class BecarioDAO extends ATDAO<Becario> {
	
	public BecarioDAO(){
		this.setNameEntidad("becario");
	}
	@Override
	protected void iniciaOperacion() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();
	}
	@Override
	protected Becario sessionGet(int id) {
		return ((Becario) session.get(Becario.class, id));
	}
	
}


