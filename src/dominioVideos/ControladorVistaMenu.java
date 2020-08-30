/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Clase ControladorVistaMenu
 *
 */
package dominioVideos;


import javax.swing.JOptionPane;


import dominioVideos.ColeccionesWeb.ColeccionWeb;
import dominioVideos.ColeccionesWeb.Basicos.Video;
import dominioVideos.gestionTiposUsuarios.BasicUser;
import dominioVideos.gestionTiposUsuarios.User;
import excepcionesPropias.contrasenya_erroneo;
import excepcionesPropias.nombre_usuario_erroneo;
import utilidades.TrabajoConCadenasYColecciones;

/**
 * Clase Controlador de la APP.<br><br>
 * Responsable de la operativa de la APP. Hace uso de las clases de otros paquetes de la app en función de sus necesidades.
 * <br><br>
 * Utiliza la clase singleton ListaUsuarios para almacenar los datos que va recogiendo de las diferentes opciones seleccionadas.
 * <br><br>
 * <br> Otro aspecto interesante es que cuando lo necesitamos tenemos una copia de MiColeccionWeb del usuario logueado que nos ahorra accesos innecesarios posteriores a la colección
 * almacenada  en la lista de usuarios. 
 * -> LoguinUsuario: lanza una vista para solicitar las credenciales del usuario. Devuelve true si entra. En caso contrario devuelve false. 
 * -> menuUsuario: Lanza la vista del menú de usuario una vez logueado y devuelve la opción elegida del menú.
 * -> mostrarListado:  Muestra la lisa de videos en un joptionpane
 * -> agregarItemAUsuario: No lanza ninguna vista. Recoge las respuesta de vistas lanzadas por los métodos de esta misma clase de agregar un nuevo vídeo y modificarlo
 * -> menuNuevoItem: Lanza una vista con preguntas para crear unnuevo vídeo y luego utiliza el método agregarItemAUsuario para agregarlo si cumple las condiciones.
 * -> modificarItem: Lanza una vista para modificar datos del video. Si cumple llama al método agregarItemUsuario donde agregará o no el vídeo según si cumple sus propios requisitos.
 * -> EliminarItem: Elimina un vídeo de la lista.
 * -> modificarUser: Lanza una vista con preguntas para modificar los datos del usuario.
 * -> altaUsuario: Lanza unavista para dar de altaun usuario. Si cumple las condiciones y no existe se crea un nuevo objeto en lalista.
 * 
 * 
 * @author Rubén Rodríguez
 * 
 *
 */
public class ControladorVistaMenu {
	
	/**
	 * El objeto más importante es listaUsuariosyVideos. Es el objeto único de la clase singleton ListaUsuarios.
	 * Necesitamos un objeto de MiColeccionWeb ya que ésta clase singleton almacena a su vez objetos de este tipo.
	 * Este controlador se encarga de interactuar con las vistas. De ahí que necesitamos un objeto VistaMenu par lanzar esas vistas
	 * y recoger datos de sus formularios.
	 * 
	 * Declaramos dos objetos de las clases ColeccionWeb para los vídeos y User para los usuarios a fin de que sea este controlador quien
	 * trabaje con estas clases y no ListaUsuarios o MiColeccionWeb; intentando desacoplar un poco la app.
	 * 
	 * El arreglo respuestas recogerá las respuestas de los formularios de la vista.
	 * 
	 */
	private ListaUsuarios listaUsuariosyVideos = ListaUsuarios.getInstance(); 
	private VistaMenu menuVista = new VistaMenu();
	private MiColeccionWeb coleccionDelUsuario;
	
	private ColeccionWeb video;
	private User usuario;
	
	private String[] respuestas;

	/**
	 * Lanza la vista de Login y guarda los datos introducidos en el arreglo credencial. En la psoición 0 tenemos el mail y en la 1 la contraseña.
	 * Verificamos si el usuario existe o no en la lista de usuario llamando a "buscaUser" y pasando el mail (identificador del usuario).
	 * <br><br>
	 * En el objeto coleccionDelUsuario copiamos los datos del usuario verificado.<br> 
	 * El siguiente paso es verificar que la contraseña introducida es correcta.
	 * <br><br>
	 * Con los try catch y las excepciones personalizadas verificamos que la longitud de las cadenas introducidas cumplan un mínimo.
	 * <br>
	 * @return Devuelve  true si el login es correcto
	 */
	public boolean loginUsuario() {
		String[] credencial = new String[2];

		try {
			credencial = menuVista.menuLogin();
			
			if (!listaUsuariosyVideos.buscaUser(credencial[0]))
			{
				JOptionPane.showMessageDialog(
						   null,
						   "El usuario no existe. Escribe un mail de usuario registrado. O registra el usuario si es nuevo. " );
				
				return false;
			
			}else {
				
				coleccionDelUsuario = listaUsuariosyVideos.returnDatos(credencial[0]);
				
				if (coleccionDelUsuario.returnUser().passCorrecto(credencial[1])) 
					return true;
				else {
					JOptionPane.showMessageDialog(
							   null,
							   "Contraseña Errónea " );
					return false;
				}
			}
			
		} catch (nombre_usuario_erroneo e) {
			JOptionPane.showMessageDialog(
					   null,
					   "Nombre ususario (mail) entre 7 y 26 caracteres entre números y letras");
		} catch (contrasenya_erroneo e) {
			JOptionPane.showMessageDialog(
					   null,
					   "contraseña entre 8 y 16 caracteres " );
			
		}finally {
		}
		
		return false;
	}

	/**
	 *Lanza una vista de opciones. Éstas se le pasan como parámetro. Se recoge la opción tecleada que se devuelve al Main. Aquí tenemos las opciones de usuario de Agregar Vídeo,
	 *editarlo, etc.
	 *
	 * @param preguntas Texto de las preguntas u opciones que se pasan a la vista menuOpciones.
	 * @return Devuelve la opción escogida en el menú
	 */
	public int menuUsuario(String [] preguntas) {
		return menuVista.menuOpciones(preguntas);
		
		
	}
	
	/**
	 * Llamamos al método de MiColeccionWeb que devulve en un string la lista de vídeos.
	 */
	public void mostrarListado( ) {	
		JOptionPane.showMessageDialog(
				   null,
				   coleccionDelUsuario.returnMiColeccionString());
	}
	
	/**
	 * Este método es usado tanto para agregar un nuevo vídeo como para modificarlo.<br>
	 * Primero verificamos que se ha introducido una URL correcta. <br>br>
	 * Creamos el objeto Vídeo con los datos del formulario que previamente se ha lanzado por alguno de los métodos que han llamado a éste.<br>
	 * Agregamos el nuevo video a la lista con el método "agregarArticulo". Este método verifica que no esté repetido. <br>
	 * Si es nuevo agregamos la coleccion de nuevo a la lista con el nuevo vídeo.
	 * <br><br>
	 * La lista de tags, último parámetro, debe ser filtrado antes para adaptarlo al tipo declarado. para ello utilizamos los métodos de clase de 
	 * "TrabajoConCadenasYColecciones"
	 * 
	 * @return true si se ha agregad con éxito.
	 */
	private boolean agregaItemAUsuario() {
				
		if (respuestas[0].matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$")) {		
			// 
			video = new Video(respuestas[0], respuestas[1], respuestas[2], TrabajoConCadenasYColecciones.borrarRepetidosLista(TrabajoConCadenasYColecciones.borrarEspaciosyConvenirALista(respuestas[3])));
			
			if (coleccionDelUsuario.agregarArticulo(video))
				{
				listaUsuariosyVideos.setDatos(coleccionDelUsuario.returnUser().getMail(), coleccionDelUsuario);
				return true;				
					
				}else {
					JOptionPane.showMessageDialog(
							   null,
							   "El video ya está en tu lista" );
				}
		}else {
			JOptionPane.showMessageDialog(
					   null,
					   "URL incorrecta" );
		}
		return false;		
	}

	/**
	 * Lanza el menú para agregar un nuevo vídeo con las preguntas recibidas por parámetros. Con las respuestas recibidaas llama a agregarItemAUsuario para verificar que todo 
	 * es correcto y guardar el nuevo vídeo.
	 * <br><br>
	 * @param preguntas Arreglo con las preguntas a realizar.
	 * @return Devuelve un tipo de dato lógico. True si el vídeo ha sido agregado con éxito.
	 * 
	 */
	public boolean menuNuevoItem(String[] preguntas) {
		respuestas = new String[preguntas.length];
		respuestas = menuVista.menuConPreguntas(preguntas);
		
		if (agregaItemAUsuario())
			return true;
		else 
			return false;				
	}	
	/**
	 *Método para modificar un vídeo. En este caso guardamos una copia del video a modificar. Se lanza la modificación d elos campos. Si todo va bien se agrega el nuevo vídeo. 
	 *Si va mal, se mantiene el que se quería modificar.
	 *<br><br>
	 * En este caso, para buscar el video utilizamos un método propio (getItemPorClave). Al contrario que en otros apartados donde hemos utilizado el método equals() junto con hashcode() sobreescritos.
	 * <br><br>
	 * Luego eliminamos el video a modificar ya que sino, al buscar el video una vez modificado, si coincide el campo de identificación devolverá false y no podremos 
	 * realizar el cambio. Por ello eliminamos previo almacenamiento del video. Luego lanzamos la edición del video llamando a menuEdicion. LE pasamos no solo las preguntassino que copiamso también 
	 * para que aparezca en el propio cuadro de respuesta el contenido actual del campo.
	 * 
	 * <br><br>LLámamos a agregarITemUsuario que verifica la URL introducida y que el título (identificador principal) no esté ya en la lista actual.
	 * 
	 * En caso que falle la modificación, volvemos a agregar en la colección el vídeo anterior y luego actualizamos la lista de usuarios con esta colección. REcuperando el estado original.
	 * 
	 * @param itemAModificar String con el título de vídeo a buscar. 
	 * @param preguntas:  Arreglo con las preguntas a realizar en la vista.
	 * 
	 */
	public void modificarItem(String itemAModificar, String[] preguntas) {
		
		ColeccionWeb videoAModificar;
		respuestas = new String[preguntas.length];
		
		if ((videoAModificar = coleccionDelUsuario.getItemPorClave(itemAModificar)) != null) {
			
			coleccionDelUsuario.eliminarItem(videoAModificar);
			respuestas = menuVista.menuEdicion(preguntas, videoAModificar.toArray());
			
			if (agregaItemAUsuario())
				JOptionPane.showMessageDialog(
					   null,
					   "Vídeo modificado correctamente" );
			else {
				JOptionPane.showMessageDialog(
						   null,
						   "Video no modificado" );
				coleccionDelUsuario.agregarArticulo(videoAModificar);
				//listaUsuariosyVideos.setDatos(coleccionDelUsuario.returnUser().getMail(), coleccionDelUsuario);

			}
		}
		else 
			JOptionPane.showMessageDialog(
					   null,
					   "El video no existe" );		
	}
	
	/**
	 * Este método elimina un vídeo del objeto de coleccion de vídeos si encuentra el título. En caso contrario no hace nada.
	 * Si encuentra el vídeo y lo elimina de la colección de video del usuario, asignamos esta nuevacolección resultante a la lista global.
	 * 
	 * @param item Titulo del video a eliminar.
	 */
	public void eliminarItem(String item) {
	
		if (coleccionDelUsuario.eliminarItem(coleccionDelUsuario.getItemPorClave(item))) {
			listaUsuariosyVideos.setDatos(coleccionDelUsuario.returnUser().getMail(), coleccionDelUsuario);		
			menuVista.mensajeSimple("Vídeo Eliminado con éxito");
		}else 
			menuVista.mensajeSimple("El vídeo no existe");	
	}
	
	/**
	 * Este método nos cambia varios campos del objeto de usuario. No se cambia el mail por ser el identificador principal
	 * @param preguntas  Arreglo cn las preguntas a pasar a la vista.
	 */
		
	public void modificarUser (String [] preguntas) {
		respuestas = new String[preguntas.length];		
		respuestas = menuVista.menuConPreguntas(preguntas);
		
		if (respuestas[2].equals(respuestas[3])) {   //Estos campos son la contraseña y la verificación de la contraseña. Deben ser iguales
			
				usuario = coleccionDelUsuario.returnUser();				
				usuario = new BasicUser(respuestas[0], respuestas[1], usuario.getMail(), respuestas[3]);
				
				/*
				 * si cumple los requisitos de contraseña modificamos los datos del usuario en la colección y luego sobreescribimos ésta en la listade usuarios y videos.
				 */
				if (usuario.requisitosPass(respuestas[2])) {			
					
					coleccionDelUsuario.cambioDatosUsuario(usuario);
					listaUsuariosyVideos.setDatos(usuario.getMail(), coleccionDelUsuario);
					
					
				}else {
					JOptionPane.showMessageDialog(
							   null,
							   "contraseña no cumple requisitos: Debe tener al menos un número, una minúscula y mayúscula y un carácter especial entre: @#$%^&+= " );	
				}
			}
			else {
				
				JOptionPane.showMessageDialog(
						   null,
						   "cLas contraseñas no coinciden" );
			}		
			
		}
		
	 /**
	  * Método para agregar un nuevo usuario a la lista de usuarios y videos.
	  * Verificamos que el mail sea correcto y que el usuario no exista ya (el mail es el identificador principal).
	  * 
	  * @param preguntas  Arreglo con las preguntas a pasar a la vista.
	  */
	
	public void altaUsuario(String [] preguntas) {
		
		respuestas = new String[preguntas.length];
		respuestas = menuVista.menuConPreguntas(preguntas);

		if (!respuestas[2].matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
			JOptionPane.showMessageDialog(
					   null,
					   "El mail es incorrecto");
		}
		else {
		
			if (listaUsuariosyVideos.buscaUser(respuestas[2]))
				JOptionPane.showMessageDialog(
					   null,
					   "El usuario ya existe. Puedes hacer login.");
			else {
					
				if (respuestas[3].equals(respuestas[4])) {  //Los campos contraseña y repite/confirma contraseña deben ser iguales
				
					usuario = new BasicUser(respuestas[0], respuestas[1], respuestas[2], respuestas[3]);  //Creamos el objeto del nuevo usuario
				
					if (usuario.requisitosPass(respuestas[3])) {  //verificamos que la contraseña del objeto usuario cumple los requisitos de su clase.
					
						System.out.println("usuario creado: "+usuario.toString());
						
						/*Creamos el objeto colección con los datos del usuario y se agrega un nuevo usuario a a lista con esta colección
						*<br><br>
						*Con setDatos agregamos un nuevo item al hashmap. respuestas[2] es el key, que es el maildel usuario. 
						*<br><br>
						*ColecciondelUsuario es el valor dels hashmap asociado al key. Este valor es un objeto de tipo MiColeccionWeb.						*
						*/
						coleccionDelUsuario = new MiColeccionWeb(usuario);
						listaUsuariosyVideos.setDatos(respuestas[2], coleccionDelUsuario);
						
					
					}else {
						JOptionPane.showMessageDialog(
							   null,
							   "contraseña no cumple requisitos: Debe tener al menos un número, una minúscula y mayúscula y un carácter especial entre: @#$%^&+= " );
					
					}
				}
				else {
				
					JOptionPane.showMessageDialog(
						   null,
						   "Las contraseñas no coinciden" );
				}	
			}
		
		}
	}
}//Fin clase
	
