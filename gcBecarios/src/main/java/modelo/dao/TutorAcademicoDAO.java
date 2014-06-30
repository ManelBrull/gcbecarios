package modelo.dao;

import modelo.HibernateUtil;
import modelo.entidades.Expediente;
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

}
