/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 *
 *Clase MiColeccionWeb
 */
package dominioVideos;

import java.util.ArrayList;
import java.util.List;

import dominioVideos.ColeccionesWeb.ColeccionWeb;
import dominioVideos.gestionTiposUsuarios.User;

/**
 *
 * Clase MiColeccionWeb: Esta clase conforma el valor en el hashmap de lalista de usuarios.
 * Guarda un objeto User con los datos delusuario y otro objeto que es unalista de objetos "ColeccionWeb" que en nuestro caso será sencillament un vídeo. Por lo tanto unalista de videos
 * <br><br>
 * SE ha intentando un desacoplamiento para que esta clase pueda ser utilizada por otros objetos de clases que hereden tanto de User como de ColeccionWeb. En nuestro caso particular
 * utilizmaos objetos de tipo BasicUser y Vídeos. PEro tal y como está implementada puede utilizar otro tipo de objetos de otras clases que hereden de las superclases mencionadas.
 * 
 * Sus métodos manejan dichos objetos. desde agregar, o eliminar un elemento de la lista de videos. O modficar los datos del objeto User.
 * 
 * @author Rubén Rodríguez
 *
 */
public class MiColeccionWeb {
	
	private User usuario;
	private List<ColeccionWeb> miColeccion;
	
	
	/**
	 * Constructor.  REcibe unobjeto User para inicializar nel de la clase. La listase inicializa vacía.
	 *
	 * @param usuario: Objeto User queinicializa el objeto usuario de la clase.
	 */
	public MiColeccionWeb(User usuario) {
		this.usuario = usuario;
		this.miColeccion = new ArrayList<ColeccionWeb>();		
	}
	
	/**
	 * Constructor.  REcibe unobjeto User para inicializar nel de la clase. Recibe una lista de objetos ColeccionWeb que asignamos al objeto de nuestra instancia.
	 *
	 * @param usuario: Objeto User queinicializa el objeto usuario de la clase.
	 * @param miColecion: ArrayList de objetos de tipo ColeccionWeb que 
	 */
	public MiColeccionWeb(User usuario, ArrayList<ColeccionWeb> miColeccion) {
		this.usuario = usuario;
		this.miColeccion = miColeccion;
	}
	
	/**
	 * Método que devuelve un String con todos los objetos de la lista ColeccionWeb. Separados por saltos de linea.
	 * @return Devulve un String con los datos de la lista.
	 */
	public String returnMiColeccionString() {
		
		String texto = new String();
		
		for (ColeccionWeb elemento: miColeccion) {
			
			texto+= "\n - "+elemento.toString();
			
		}
		System.out.println(texto);
		return texto;
		
		
	}
	
	/**
	 * Este método recibe un objeto de tipo User y sobreescribe el de la instancia.
	 * @param usuario: Objeto de tipo User.
	 */	
	public void cambioDatosUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	
	/**
	 * Este método devuelve un objeto de tipo ColeccionWeb (en esta app un vídeo). PAra elloutiliza el método de la clase ColeccionWeb getItem() que recibe un objeto del mismo tipo
	 * y utiliza el método equals (sobreescrito) para la comparación.
	 * el objeto que recibimos y que queremos buscar solo tiene el campo que utiliza equals. Es por ello que lo buscamos de esta manera para obtener el objeto con todos los datos completo.
	 * 
	 * @param elementoABuscar: Objeto de tipo ColeccionWeb que queremos buscar.
	 * @return ColeccionWeb: Devuelve el objeto con todos los datos almacenados. devuelve null sino encuentra el objeto buscado
	 */
	public ColeccionWeb getItem(ColeccionWeb elmentoABuscar) {
		for (ColeccionWeb elementoColeccion: miColeccion) {
			if (elementoColeccion.equals(elmentoABuscar))
				return elementoColeccion;
		}
		return null;
	}
	
	/**
	 * Este método realiza lo mismo que {@link dominioVideos.MiColeccionWeb#getItem} <br><br>
	 * Pero en este caso utilizmaos un método propio de la clase ColeccionWeb que recibe un String que sabemos que es la clave/índice utilizada por la app para su 
	 * almacenaje. El método {@link dominioVideos.ColeccionesWeb#buscaPorCampoClave} realiza la búsqueda comparando variable de clase con el parámetro suministrado.
	 * 
	 * @param clave: Campo clave único en nuestra lista. Utilizados para verificar su existencia en lalista.
	 * @return ColeccionWeb: Devuelve el objeto ColeccionWeb que ha encontrado gracias a la clave. O null si no hay ningúnobjeto con ese campo clave.
	 */
	public ColeccionWeb getItemPorClave(String clave) {
		for (ColeccionWeb elementoColeccion: miColeccion) {
			if (elementoColeccion.buscarPorCampoClave(clave))
				return elementoColeccion;
		}
		return null;
	}
	
	/**
	 *Método que recibe un objeto a eliminar de la lista. Llama al método remove del tipo lista que utiliza el método equals() que hasido sobreescrito.
	 */
	public boolean eliminarItem (ColeccionWeb elmentoABuscar) {
		if (miColeccion.remove(elmentoABuscar))
			return true;
		return false;
		
	}
	
	/**
	 * Método que devuelve el objeto usuario de la instancia.
	 * @return User: usuario de la instancia
	 */
	public User returnUser() {
		return usuario;
	}
	
	/**
	 * método que recibe un objeto de tipo ColeccionWeb (en esta APP es un vídeo) y lo agrega a la lista de objetos de este tipo. Previa comprobación que no exista ya
	 * un objeto con el mismo campo index que en nuestro caso es el título. LA comprobación de si se repite o no se realiza llamando al método de esta misma clase 
	 * {@link dominioVideos.MiColeccionWeb#articuloRepetido}
	 * 
	 * @param articulo: Objeto de tipo ColeccionWeb. En nuestro caso un vídeo.
	 * @return true si ha sido agregado con éxito. 
	 */
	public boolean agregarArticulo (ColeccionWeb articulo) {
		
		if (articuloRepetido(articulo))
			return false;
		else {
			this.miColeccion.add(articulo);
			return true;
		}	
	}
	
	/**
	 * Método que recorre la lista y realiza comparacions utilizando equals() (sobreescrito en ColeccionWeb para que utilize el campo título como elemento de semejanza). Si encuentra el item con el ismo valor de clave devuelve true.
	 * 
	 * @param varArticulo ítem a buscar en la lista. 
	 * @return true si el item está repetido en la lista.
	 */
	public boolean articuloRepetido(ColeccionWeb varArticulo) {
		
		if (this.miColeccion.isEmpty())
			return false;
		else {
		for (ColeccionWeb articulo: this.miColeccion) {
			if (articulo.equals(varArticulo) )
				return true;
		}
		return false;
		}
	}
}
