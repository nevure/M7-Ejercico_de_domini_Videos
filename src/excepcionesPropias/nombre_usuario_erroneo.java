/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Clase nombre_usuario_erroneo
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
public class nombre_usuario_erroneo extends Exception {
	
	private static final long serialVersionUID = 234131L;
	
	public nombre_usuario_erroneo() {
		super();
		
	}
	
	public nombre_usuario_erroneo(String msj) {
		super(msj);
	}

}
