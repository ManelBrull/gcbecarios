package modelo.dao;

import java.util.List;

import org.hibernate.Query;

import modelo.HibernateUtil;
import modelo.entidades.Expediente;
import modelo.entidades.TipoDeExpediente;
import at.modelo.dao.ATDAO;

public class TipoDeExpedienteDAO extends ATDAO<TipoDeExpediente> {

	public TipoDeExpedienteDAO(){
		setNameEntidad("tipoDeExpediente");
	}
	
	@Override
	protected void iniciaOperacion() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();
	}

	@Override
	protected TipoDeExpediente sessionGet(int id) {
		return ((TipoDeExpediente) session.get(TipoDeExpediente.class, id));
	}

	public List<TipoDeExpediente> getFiltro(String stringNombreFiltro) {
		List<TipoDeExpediente> list = null;
		iniciaOperacion();
		Query myQuery = session.createQuery("from " + nameEntidad + " where tipoDeExpediente like '%" + stringNombreFiltro + "%'");
		list = myQuery.list();
		session.close();
		return list;
	}

}
