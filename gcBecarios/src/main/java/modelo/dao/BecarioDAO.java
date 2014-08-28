package modelo.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import modelo.HibernateUtil;
import modelo.entidades.Becario;
import modelo.entidades.Departamento;
import modelo.entidades.practica.Practica;
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
	public List<Becario> getFiltro(String stringNombreFiltro) {
		List<Becario> list = null;
		iniciaOperacion();
		Query myQuery = session.createQuery("from " + nameEntidad + " where apellidos like '%" + stringNombreFiltro + "%'");
		list = myQuery.list();
		session.close();
		return list;
	}
	
}


