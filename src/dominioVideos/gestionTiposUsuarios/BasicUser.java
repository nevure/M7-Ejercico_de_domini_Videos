/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Clase BasicUSer
 *
 */

package dominioVideos.gestionTiposUsuarios;

/**
 * Clase que implementa la interfaz User. implementa toda la operativa de la iterfaz User.
 * 
 * 
 * @author Rubén Rodríguez
 *
 */
public class BasicUser implements User {
	
	private String nombre;
	private String apellidos;
	private String passwd;
	private String email;
	public static final String PATRON_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$";

	public BasicUser() {
	}
	
	/**
	 * Constructor básico que recibe el identificador principal, mail, y la contraseña.
	 * @param email   email del usuario. identificador principal
	 * @param passwd  contraseña del usuario. 
	 */
	public BasicUser(String email, String passwd ) {
		this.email = email;
		this.passwd = passwd;
	}
	
	/**
	 * Constructor que recibe todos los datos del usuario.
	 * @param nombre nombre del usuario.
	 * @param apellidos  apellidos del usuario.
	 * @param email email del usuario. identificador principal
	 * @param passwd  contraseña del usuario
	 */
	public BasicUser(String nombre, String apellidos, String email, String passwd) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.passwd = passwd;
		this.email = email;
	}
	
	/**
	 * Si implementáramos permisos en función de accesos podríamos controlarlos desde este método
	 */
	@Override
	public byte permisos() {
		return 0;
	}

	/**
	 * Método que verifica si una cadena recibida coincide con la contraseña almacenada.
	 * @param passwd   cadena recibida para verificarla
	 * @return true si la cadena coincide con la contraseña
	 */
	@Override
	public boolean passCorrecto(String passwd) {
		return (this.passwd.equals(passwd));
	}

	/**
	 * Método que recibe una cadena y verifica si cumple los requisitos para ser contraseña
	 * @param passwd:  cadena recibida para su verificación
	 * @return true si cumple los requisitos.
	 */
	@Override
	public boolean requisitosPass(String passwd) {
		
		return (passwd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"));
	}
	
	/**
	 * Método que cambia el mail del usuario. En nuestra APP no lo utilizamos
	 */
	@Override
	public boolean cambioMail(String mail) {
		return false;
	}

	/*
	 * Getters y Setters definidos en lainterfaz
	 */
	public String getNombre() {
		return null;
	}

	@Override
	public String getMail() {
		
		return this.email;
	}
	
	@Override
	public String getPasswd() {
		return passwd;
	}
	@Override
	public  void setMail(String email) {
		this.email = email;
			}

	/**
	 * Sobreescribimos el método hashCode para utilizar el campo clave que deseamos. enn uestro caso emai.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}


	/**
	 * Sobreescribimos el método eqauls para utilizar el campo clave que deseamos. En nuestro caso emai.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicUser other = (BasicUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	/**
	 * Sobreescribimos el método toString de OBject
	 */
	@Override
	public String toString() {
		
		return ("Nombre: " + this.nombre +  " Apellidos: "+this.apellidos+ " con mail: " + this.email + " y contraseña: "+this.passwd);		
	}
	
	/**
	 * Método que devuelve en un arreglo los datos del usuario. cada posición del arreglo un campo de usuario.
	 * @return devuelve el arreglo.
	 */
	@Override
	public String[] toArray() {
		return (new String[] {this.nombre, this.apellidos, this.email, this.passwd});            
	}
}
