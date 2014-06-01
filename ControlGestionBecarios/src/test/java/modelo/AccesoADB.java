package modelo;

import junit.framework.TestCase;

import org.bouncycastle.util.AllTests;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

public class AccesoADB extends TestCase {

	@Test
	public void testAccesodb() {
		
		SessionFactory session = HibernateUtil.getSessionFactory();
		assertNotNull(session);
	}

}
