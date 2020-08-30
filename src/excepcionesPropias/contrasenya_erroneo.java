/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Clase contrasenya_eroneo
 *
 */
package excepcionesPropias;

/**
 * Clase que hereda de Exception. 
 * Nuestra propia excepcion
 * 
 * @author Rubén Rodríguez
 *
 */
public class contrasenya_erroneo extends Exception {
	
	private static final long serialVersionUID = 2341214141345L;
	
	public contrasenya_erroneo() {
		super();
	}
	
	public contrasenya_erroneo(String msj) {
		super(msj);
	}

}
