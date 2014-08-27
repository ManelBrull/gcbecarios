package modelo.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

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
	
	public List<Departamento> getFiltro(String stringNombreFiltro) {
		List<Departamento> list = null;
		iniciaOperacion();
		Query myQuery = session.createQuery("from " + nameEntidad + " where nombreDepartamento like '%" + stringNombreFiltro + "%'");
		list = myQuery.list();
		session.close();
		return list;
	}

}
