package modelo.dao;

import java.util.List;

import org.hibernate.Query;

import modelo.HibernateUtil;
import modelo.entidades.Expediente;
import modelo.entidades.TipoDeExpediente;
import modelo.entidades.TutorAcademico;
import at.modelo.dao.ATDAO;

public class TutorAcademicoDAO extends ATDAO<TutorAcademico> {

	public TutorAcademicoDAO(){
		setNameEntidad("tutoracademico");
	}
	
	@Override
	protected void iniciaOperacion() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();
	}

	@Override
	protected TutorAcademico sessionGet(int id) {
		return ((TutorAcademico) session.get(TutorAcademico.class, id));
	}

	public List<TutorAcademico> getFiltro(String stringNombreFiltro) {
		List<TutorAcademico> list = null;
		iniciaOperacion();
		Query myQuery = session.createQuery("from " + nameEntidad + " where apellidos like '%" + stringNombreFiltro + "%'");
		list = myQuery.list(); 
		session.close();
		return list;
	}

}
