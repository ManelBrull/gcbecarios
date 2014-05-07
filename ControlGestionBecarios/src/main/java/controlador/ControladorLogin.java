package controlador;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import modelo.entidades.usuario.Usuario;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import vista.interfaz.Login;
import at.controlador.GestionError;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorLogin {
	Login login;
	
	public ControladorLogin(Login myLogin){
		this.login = myLogin;
	}

	public void entrar() {
		String username = "atorrent\\" + login.getTextUsuari().getText().trim();
		String password = login.getTextContrasenya().getText();
		String base = "DC=DINS,DC=ATORRENT,DC=ES";
		String ldapURL = "LDAP://sr1:389/DC=DINS,DC=ATORRENT,DC=ES";

		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, ldapURL);
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.SECURITY_PRINCIPAL, username);
		environment.put(Context.SECURITY_CREDENTIALS, password);

		try {
			DirContext ctx = new InitialDirContext(environment);
			Usuario usr = new Usuario();
			usr.setNombreUsuario(login.getTextUsuari().getText().trim());
			boolean result = usr.validarUsuario();
			// validar usando hibernate
			if(result == true){
				login.setResult(true);
				login.getShell().dispose();
			}
			else {
				login.setResult(false);
				MessageBox dialog = new MessageBox(login.getShell(), SWT.ICON_ERROR);
				dialog.setText("Error");
				dialog.setMessage("El usuario es incorrecto, revise si ha escrito correctamente"
						+ " el nombre de usuario y la contraseña");
				dialog.open();
			}
		} catch (NamingException | CampoRequeridoException e) {
			login.setResult(false);
			new GestionError(login.getShell(), e);
		}
	}

	public void salir() {
		login.setResult(false);
		login.getShell().dispose();
	}
	
	
}
