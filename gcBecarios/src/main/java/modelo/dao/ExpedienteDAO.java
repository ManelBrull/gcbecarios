package modelo.dao;

import java.util.List;

import org.hibernate.Query;

import modelo.HibernateUtil;
import modelo.entidades.Becario;
import modelo.entidades.Departamento;
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

	public List <Expediente> getFiltro(String stringNombreFiltro) {
		List<Expediente> list = null;
		iniciaOperacion();
		Query myQuery = session.createQuery("from " + nameEntidad + " where centroEducativoInstitucion like '%" + stringNombreFiltro + "%'");
		list = myQuery.list();
		session.close();
		return list;
	}

}
