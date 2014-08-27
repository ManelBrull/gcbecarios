package modelo;

import java.util.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Expediente;
import modelo.entidades.TipoDeExpediente;
import modelo.entidades.TutorAcademico;
import modelo.entidades.usuario.Permisos;
import modelo.entidades.usuario.Usuario;
import at.modelo.entidades.excepciones.CampoRequeridoException;


public class InicializarBaseDatos {
	public InicializarBaseDatos(){
		inicializarUsuarios();
		incializarDepartamentos();
		inicializarExpediente();
		inicializarTutorAcademico();
	}

	private void inicializarUsuarios(){
		Usuario developer = new Usuario();
		try {
			developer.setNombreUsuario("brullp");
			developer.setPermisos(Permisos.Administrador);
			developer.save();
		} catch (CampoRequeridoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void incializarDepartamentos(){
		Departamento dep1 = new Departamento();
		dep1.setNombreDepartamento("Informática");
		dep1.save();
		Departamento dep2 = new Departamento();
		dep2.setNombreDepartamento("Retosa");
		dep2.save();
		Departamento dep3 = new Departamento();
		dep3.setNombreDepartamento("Contabilidad");
		dep3.save();
		Departamento dep4 = new Departamento();
		dep4.setNombreDepartamento("Prensa");
		dep4.save();
	}
	
	private void inicializarExpediente(){
		TipoDeExpediente t1 = new TipoDeExpediente();
		t1.setTipoDeExpediente("Acuerdo con entidad educativa");
		t1.save();
		
		TipoDeExpediente t2 = new TipoDeExpediente();
		t2.setTipoDeExpediente("Acuerdo con institución");
		t2.save();

		TipoDeExpediente t3 = new TipoDeExpediente();
		t3.setTipoDeExpediente("La Dipu te beca");
		t3.save();
		
		Expediente e1 = new Expediente();
		e1.setTipoDeExpediente(t1);
		e1.setAcuerdoDecreto("01/2014");
		e1.setCentroEducativoInstitucion("IES Mare de deu de la Candelera");
		e1.setFechaExpediente(new Date());
		e1.setRefClica("XE/01/2014");
		e1.save();
		
		Expediente e2 = new Expediente();
		e2.setTipoDeExpediente(t2);
		e2.setAcuerdoDecreto("05/2014");
		e2.setCentroEducativoInstitucion("Institucion muy importante");
		e2.setFechaExpediente(new Date());
		e2.setRefClica("XK/05/2014");
		e2.save();
	}
	
	private void inicializarTutorAcademico() {
		TutorAcademico t1 = new TutorAcademico();
		t1.setApellidos("Sancho Sancho");
		t1.setNombre("Agustí");
		t1.setEmail("agusti@gmail.com");
		t1.setTelefono("669852147");
		t1.save();
		
		TutorAcademico t2 = new TutorAcademico();
		t2.setApellidos("Martínez Surroca");
		t2.setNombre("Salvador");
		t2.setEmail("mSurroca@gmail.com");
		t2.setTelefono("635874158");
		t2.save();
	}
}
