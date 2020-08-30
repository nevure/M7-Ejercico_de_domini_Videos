/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Clase ControladorVistaMenu
 *
 */

package dominioVideos;

import java.util.HashMap;


/**
 * 
 * Clase singleton que mantiene un hashmap donde el key es un string que es el mail delusuario (identificador principal) y como valor un objeto de la clase
 * MiColeccionWeb .
 * <br><br>
 *
 * -> uscaUser: Método que devuelve true si el usuario existe en la lista
 * -> returnDatos: Devuelve el valor de clave pasada si existe. El valor es un objeto MiColeccionWeb
 * -> setDatos: Crea o modifica una entrada del Map con una clave y valor que recibe por parámetros.
 * 
 * @author Rubén Rodríguez
 *
 */
public class ListaUsuarios {
	
	private static ListaUsuarios objetoLista;
	private HashMap<String, MiColeccionWeb> usuariosListaColeccion;	
	
	
	/**
	 * Constructor privado que inicializa el hashmap.
	 */
	private  ListaUsuarios() {
		usuariosListaColeccion = new HashMap<String, MiColeccionWeb>();
		
	}
	
	
	/**
	 * Método que devulve la instancia única de la clase.
	 */
	
	public static ListaUsuarios getInstance ()
	{
		if (objetoLista == null )
			objetoLista = new ListaUsuarios();
		
		return objetoLista;	
	}
	
	/**
	 * Método que busca una clave igual al parametro pasado. Busca un mail para devolver true si lo encuentra.
	 * @param login: mail a buscar entre las claves.
	 * @return boolean: true si encuentra la clave.
	 */	
	public boolean buscaUser(String login ) {
		System.out.println("usuario pasado: "+ login);
		return (usuariosListaColeccion.containsKey(login));	
	}
	
	/**
	 * Método que busca una clave y devuelve el valor, que es un objeto de la clase MicoleccionWeb
	 * @param login:  mail a buscar entre las claves.
	 * @return MiColeccionWeb: objeto que almacena la parte del valor.
	 */	
	public MiColeccionWeb returnDatos( String login) {
		return usuariosListaColeccion.get(login);
	}
	
	/**
	 * Método que recibe una clave y un valor. Si la clave existe sobreescribirá el valor. Sino existe crearáuna nueva entrada con dicha clave y valor.
	 * @param keu: clave del hashmap
	 * @param datos: objeto para almacenar en la parte de valor.
	 * 
	 */
	public void setDatos(String key, MiColeccionWeb datos) {
		usuariosListaColeccion.put(key, datos);
	}
	
	/**
	public void setNuevo(String key, MiColeccionWeb datos) {
		usuariosListaColeccion.put(key, datos);
	}*/

	/**
	 * Método que imprime por consola la lista de usuarios.
	 */
	public void listaUsuarios() {
		System.out.println("lista de usuarios oficial: ");
		for (String usuario: usuariosListaColeccion.keySet()) {
			System.out.println("usuario: " + usuario.toString());
		}		
	}	
}


